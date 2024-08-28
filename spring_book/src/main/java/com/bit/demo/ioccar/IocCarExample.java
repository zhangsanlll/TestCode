package com.bit.demo.ioccar;


/*
传统对象创建顺序：car->Framework->bottom->tire
ioc解耦后：tire->bottom->Framework->car
* */
//使用IOC创建车的程序
public class IocCarExample {

    public static void main(String[] args) {
        Tire tire = new Tire(20);
        Bottom bottom = new Bottom(tire);
        FrameWork framework = new FrameWork(bottom);
        Car car = new Car(framework);
        car.run();
    }

}
