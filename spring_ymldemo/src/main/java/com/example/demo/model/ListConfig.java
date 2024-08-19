package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

//和配置对象一样
@Data
@ConfigurationProperties("dbtypes")
@Component
public class ListConfig {
    private List<String> name;
}
