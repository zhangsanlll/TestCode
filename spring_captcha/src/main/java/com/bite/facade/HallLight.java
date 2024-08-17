package com.bite.facade;

/*走廊灯
* */
public class HallLight implements Light{

    @Override
    public void on() {
        System.out.println("打开走廊灯");
    }

    @Override
    public void off() {
        System.out.println("关闭走廊灯");
    }
}
