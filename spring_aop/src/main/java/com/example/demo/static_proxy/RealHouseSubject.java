package com.example.demo.static_proxy;


/*
* 具体的业务实现，房东
* */
public class RealHouseSubject implements HouseSubject{
    @Override
    public void rentHouse() {
        System.out.println("我是房东，我出租房子...");
    }
}
