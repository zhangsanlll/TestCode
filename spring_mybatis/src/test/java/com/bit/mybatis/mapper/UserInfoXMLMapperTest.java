package com.bit.mybatis.mapper;

import com.bit.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoXMLMapperTest {

    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void selectUserAll() {
        List<UserInfo> userInfoList = userInfoXMLMapper.selectUserAll();
        System.out.println(userInfoList);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lulilin");
        userInfo.setPassword("lulilin");
        userInfo.setAge(18);
        userInfo.setGender(2);
        userInfo.setPhone("11111111");
        Integer count = userInfoXMLMapper.insertUser(userInfo);
        System.out.println("count: "+count+",id:"+userInfo.getId());
    }

    @Test
    void deleteUser() {
        userInfoXMLMapper.deleteUser(13);
    }

    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(12);
        userInfo.setUsername("lll");
        userInfo.setPassword("66666");
        userInfoXMLMapper.updateUser(userInfo);
    }

    @Test
    void selectUserAll2() {
        List<UserInfo> userInfoList = userInfoXMLMapper.selectUserAll2();
        System.out.println(userInfoList);
    }

    @Test
    void insertUserByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhouxinji22");
        userInfo.setPassword("22222211");
        userInfo.setAge(18);
       // userInfo.setGender(2);
        userInfo.setPhone("11111111888");
        userInfoXMLMapper.insertUserByCondition(userInfo);
    }

    @Test
    void insertUserByTrim() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lulilin");
        userInfo.setPassword("88888");
        userInfo.setAge(18);
        userInfo.setGender(2);
        userInfo.setPhone("888888");
        userInfoXMLMapper.insertUserByTrim(userInfo);
    }

    @Test
    void selectUserByWhere() {
       UserInfo userInfo = new UserInfo();
       userInfo.setAge(22);
      // userInfo.setGender(2);
      // userInfo.setDeleteFlag(1);
       System.out.println(userInfoXMLMapper.selectUserByWhere(userInfo));
    }

    @Test
    void updateUserBySet() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(18);
        userInfo.setUsername("lll");
        userInfo.setPassword("66666");
        userInfoXMLMapper.updateUser(userInfo);
    }

    @Test
    void deleteById() {
        List<Integer> listId = new ArrayList();
        listId.add(1);
        listId.add(2);
        listId.add(4);
        listId.add(10);
        userInfoXMLMapper.deleteById(listId);
    }
}