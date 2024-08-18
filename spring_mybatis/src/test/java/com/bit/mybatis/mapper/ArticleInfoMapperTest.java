package com.bit.mybatis.mapper;

import com.bit.mybatis.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Test
    void selectAllUserById() {
        List<ArticleInfo> articleInfoList = articleInfoMapper.selectAllUserById(1);
        System.out.println(articleInfoList);
    }
}