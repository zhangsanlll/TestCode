package com.bit.demo.ioccar;

public class Bottom {
    private Tire tire;
    public  Bottom(Tire tire){
        this.tire = tire;
        System.out.println("bottom init...");
    }
}
