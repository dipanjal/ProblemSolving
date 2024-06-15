package com.dipanjal.batch1.currencyconverter;

public class Random {
    int x, y;
    boolean flag;


    {
        this.x = 0;
        this.y = 0;
        this.flag = false;
        System.out.println("Initializer called");
    }

    public Random() {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {
        Random r = new Random();
//        r = new Random(5, 10);
        System.out.println(r.x);
        System.out.println(r.y);
        System.out.println(r.flag);

//        int x,y;
//        boolean flag;

//        System.out.println(flag);

//        System.out.println(x);
//        System.out.println(y);
    }
}
