package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/*
* 用户注册，在注册时在日志表中插入一条操作记录
* */
/*
手动实现事务
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //JDBC事务管理器，手动操作事务，需要用到SpringBoot内置的两个对象实现
    @Autowired
    //事务管理器，用来获取事务，提交或回滚的
    private DataSourceTransactionManager dataSourceTransactionManager;

    //定义事务的属性
    @Autowired
    //事务属性，在获取事务时将TransactionDefinition传递进去从而获得一个事务TransactionStatus
    private TransactionDefinition transactionDefinition;


    @RequestMapping("/registry")
    public String registry(String name,String password){

        //开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        //用户注册
        userService.registryUser(name,password);
        //提交事务
        //dataSourceTransactionManager.commit(transactionStatus);
        //回滚事务
        dataSourceTransactionManager.rollback(transactionStatus);
        return "注册成功";
    }

}
*/


//使用注解，只需要在方法前面加上Transactional注解即可
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name,String password){
        userService.registryUser(name,password);
        log.info("用户插入数据成功");
        //强制程序抛出异常，并且没有被捕获，事务就会进行回滚
        try{
            int a = 10/0;
        }catch (Exception e){
            //重新抛出异常
           // throw  e;
            //或者手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "注册成功";
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/r2")
    public String r2(String name,String password) throws IOException{
        userService.registryUser(name,password);
        log.info("用户插入数据成功");
        if(true){
            throw new IOException();
        }
        return "r2";
    }
}

