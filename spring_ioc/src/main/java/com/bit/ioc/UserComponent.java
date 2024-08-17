package com.bit.ioc;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("hi,UserComponent");
    }
}
