package com.bite.facade;

/*
* 客厅灯
* */
public  class LivingRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("打开客厅灯");
    }

    @Override
    public void off() {
        System.out.println("关闭客厅灯");
    }
}
