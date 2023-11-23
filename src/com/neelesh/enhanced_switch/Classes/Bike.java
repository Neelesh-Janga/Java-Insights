package com.neelesh.enhanced_switch.Classes;

public class Bike extends Vehicle{

    @Override
    public void drive() {
        System.out.println("Driving a Bike");
    }

    public String getColor(){
        return "white";
    }
}
