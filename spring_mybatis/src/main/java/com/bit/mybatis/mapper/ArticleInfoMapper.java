package com.bit.mybatis.mapper;

import com.bit.mybatis.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {
    @Select("select ta.id,ta.title,ta.uid,tb.username,tb.age,tb.gender from articleinfo ta" +
            " left join userinfo tb on ta.uid = tb.id where ta.id = #{id}")
    List<ArticleInfo> selectAllUserById(Integer id);
}
