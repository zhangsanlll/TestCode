package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class IndexController {
    @RequestMapping("/index")
    public Object index(){
        //返回index.html
        return "/calc.html";
    }

}
