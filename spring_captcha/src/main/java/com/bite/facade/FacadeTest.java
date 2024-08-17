package com.bite.facade;

//测试类
public class FacadeTest {
    public static void main(String[] args) {
        LightFacade lightFacade = new LightFacade();
        lightFacade.lightOn();
        lightFacade.lightOff();

    }
}
