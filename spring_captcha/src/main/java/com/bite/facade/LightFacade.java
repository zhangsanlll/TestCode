package com.bite.facade;

//所有灯的总开关，
public class LightFacade {
    Light livingRoomLight = new LivingRoomLight();
    Light diningLight = new DiningLight();
    Light  hallLight= new HallLight();
    public void lightOn(){
        livingRoomLight.on();
        diningLight.on();
        hallLight.on();
    }
    public void lightOff(){
        livingRoomLight.off();
        diningLight.off();
        hallLight.off();
    }
}
