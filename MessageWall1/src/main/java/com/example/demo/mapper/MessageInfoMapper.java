package com.example.demo.mapper;

import com.example.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageInfoMapper {
    //需要两个方法，一个获取留言，即选择，一个发布留言，即插入

    //获取留言
    @Select("select `id`,`from`,`to`,`message` from message_info where delete_flag = 0")
    List<MessageInfo> selectAll();

    //发布留言
    @Insert("insert into message_info (`from`,`to`,`message`)values (#{from},#{to},#{message})")
    Integer addMessage(MessageInfo messageInfo);

}
