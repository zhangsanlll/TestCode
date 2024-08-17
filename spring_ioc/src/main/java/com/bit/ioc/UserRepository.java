package com.bit.ioc;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void sayHi(){
        System.out.println("hi,UserRepository");
    }
}
