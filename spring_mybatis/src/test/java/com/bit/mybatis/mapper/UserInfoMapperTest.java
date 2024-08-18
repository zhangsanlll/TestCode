package com.bit.mybatis.mapper;

import com.bit.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void selectAllUser() {
        List<UserInfo> userInfoList = userInfoMapper.selectAllUser();
        System.out.println(userInfoList);
    }



    @Test
    void selectById() {
        UserInfo userInfo = userInfoMapper.selectById(4);
        System.out.println(userInfo);
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(22);
        userInfo.setGender(2);
        userInfo.setPhone("1234567879");
        Integer count = userInfoMapper.insert(userInfo);
        System.out.println("count: "+count+",id:"+userInfo.getId());
    }

   /* @Test
    void insertId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu11");
        userInfo.setPassword("zhaoliu11");
        userInfo.setAge(22);
        userInfo.setGender(2);
        userInfo.setPhone("1234567879");
        System.out.println("添加数据条款"+userInfoMapper.insert(userInfo)+" ,数据ID："+userInfo.getId());
    }*/

    @Test
    void deleteById() {
        userInfoMapper.deleteById(5);
    }

    @Test
    void selectByName() {
        userInfoMapper.selectByName("' or 1= '1");
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(4);
        userInfo.setUsername("lll");
        userInfoMapper.update(userInfo);
    }

    @Test
    void selectAllUser2() {
        List<UserInfo> userInfoList = userInfoMapper.selectAllUser2();
        System.out.println(userInfoList);
    }

    @Test
    void selectAllUser3() {
        List<UserInfo> userInfoList = userInfoMapper.selectAllUser3();
        System.out.println(userInfoList);
    }

    @Test
    void selectAllUser4() {
        List<UserInfo> userInfoList = userInfoMapper.selectAllUser4();
        System.out.println(userInfoList);
    }


    @Test
    void selectTest() {
        List<UserInfo> userInfoList = userInfoMapper.selectTest("admin","admin");
    }

    @Test
    void selectAllUserBySort() {
        userInfoMapper.selectAllUserBySort("desc");
    }

    @Test
    void selectAllUserByLike() {
        userInfoMapper.selectAllUserByLike("zhaoliu");

    }

    @Test
    void selectAllUserByConcat() {
        userInfoMapper.selectAllUserByConcat("z");

    }


}