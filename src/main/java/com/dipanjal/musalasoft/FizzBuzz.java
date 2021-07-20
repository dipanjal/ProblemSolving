package com.dipanjal.musalasoft;

/**
 * @author dipanjal
 * @since 5/15/2021
 */

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        for(int i=1; i<=n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        fizzBuzz(15);
    }
}
