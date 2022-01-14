package com.dipanjal.test;

public class Child extends Person {

    private String test(){
        bed = "Queen Size Bed";
        return bed;
    }

    public static void main(String[] args) {
/*        Child c = new Child();
        System.out.println(c.test());
        System.out.println(c.bed);*/
        System.out.println(new Child().bed);
        System.out.println(new Child().table);

    }

}
