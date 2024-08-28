package com.example.demo.static_proxy;

public class StaticMain {
    public static void main(String[] args) {
        HouseProxy proxy = new HouseProxy(new RealHouseSubject());
        proxy.rentHouse();
    }
}
