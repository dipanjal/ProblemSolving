package com.dipanjal.batch1;

public abstract class Car {
    int speedLimit = 125;

    public void setSpeedLimit(int speedLimit){
        this.speedLimit = speedLimit;
    }

//    public abstract void setSpeedLimit(int speedLimit);
}

class Innova extends Car {

    int speedLimit;

    @Override
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public static void main(String args[]) {
        Car obj = new Innova();
        System.out.println(obj.speedLimit);
    }


}
