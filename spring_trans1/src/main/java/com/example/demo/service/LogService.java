package com.example.demo.service;

import com.example.demo.mapper.LogInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional(propagation = Propagation.NESTED)

    public void insertLog(String name,String op){
        int a = 10 / 0;
        //记录用户操作
        logInfoMapper.insert(name, op);
    }
}
