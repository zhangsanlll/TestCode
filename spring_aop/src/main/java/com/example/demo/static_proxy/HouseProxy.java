package com.example.demo.static_proxy;

public class HouseProxy implements HouseSubject{

    //将被代理对象声明为成员变量
    private HouseSubject houseSubject;

    public HouseProxy(HouseSubject houseSubject) {
        this.houseSubject = houseSubject;
    }

    @Override
    public void rentHouse() {
        System.out.println("我是中介，开始代理");
        houseSubject.rentHouse();
        System.out.println("我是中介，结束代理");
    }
}
