package com.bit.mybatis.mapper;

import com.bit.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    //查询所有用户
    @Select("select username,`password`,age,gender,phone from userinfo")
    public List<UserInfo> selectAllUser();

    //查询id = 4的用户
    @Select("select username,`password`,age,gender,phone from userinfo where id = ${userid}")
    public UserInfo selectById(@Param("userid") Integer id);

    /*
    测试SQL注入的危险模式，UserService and UserController 和这个注解测试
    * */

    @Select("select username,`password`,age,gender,phone from userinfo where username ='${username}' " +
            "and password = '${password}'")
    List<UserInfo> selectTest(String username,String password);

    @Select("select username,`password`,age,gender,phone from userinfo where username ='${username}'")
    public UserInfo selectByName(String username);

    //查
    //查多条结果，起别名、结果映射、开启驼峰命名
    @Select("select username,`password`,age,gender,phone,delete_flag as deleteFlag," +
            "create_time as createTime,update_time as updateTime from userinfo")
    List<UserInfo> selectAllUser2();

    //结果映射
    @Select("select username,`password`,age,gender,phone,delete_flag ,create_time,update_time from userinfo")
    @Results({
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    List<UserInfo> selectAllUser3();

    //驼峰命名
    @Select("select username,`password`,age,gender,phone,delete_flag ,create_time,update_time from userinfo")
    List<UserInfo> selectAllUser4();

    //新增一条记录
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into userinfo (username,`password`,age,gender,phone) " +
            "values(#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);



    //删除语句
    @Delete("delete from userinfo where id = #{id}")
    void deleteById(Integer id);

    //改
    @Update("update userinfo set username = #{username} where id = #{id}")
    void update(UserInfo userInfo);


    //排序
    @Select("select username,`password`,age,gender,phone,delete_flag ,create_time,update_time " +
            "from userinfo order by id ${sort}")
    List<UserInfo> selectAllUserBySort(String sort);

    //模糊排序，只能用$
    @Select("select username,`password`,age,gender,phone,delete_flag ,create_time,update_time " +
            "from userinfo where username like '%${key}%'")
    List<UserInfo> selectAllUserByLike(String key);

    //模糊排序,使用内置函数,可以用#
    @Select("select username,`password`,age,gender,phone,delete_flag ,create_time,update_time " +
            "from userinfo where username like concat('%',#{key},'%')")
    List<UserInfo> selectAllUserByConcat(String key);


}
