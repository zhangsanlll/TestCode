package com.bit.mybatis.mapper;

import com.bit.mybatis.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {
    List<UserInfo> selectUserAll();

    List<UserInfo> selectUserAll2();

    Integer insertUser(UserInfo userInfo);

    Integer deleteUser(Integer id);

    Integer updateUser(UserInfo userInfo);


    /*
    以下是动态SQL的一些测试,用xml方式
    * */

    Integer insertUserByCondition(UserInfo userInfo);

    Integer insertUserByTrim(UserInfo userInfo);

    List<UserInfo> selectUserByWhere(UserInfo userInfo);

    Integer updateUserBySet(UserInfo userInfo);

    void deleteById(List<Integer> ids);
}
