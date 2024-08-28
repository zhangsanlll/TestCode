package com.bit.demo.ioccar;

public class Car {
    private FrameWork frameWork;

    //构造函数
    public Car(FrameWork frameWork){
        this.frameWork = frameWork;
        System.out.println("Car init....");
    }
    public void run(){
        System.out.println("car run...");
    }

}
