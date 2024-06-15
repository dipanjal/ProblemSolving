package com.dipanjal.test;

public class LowerDigitCounter {

    public static String MathChallenge(String str) {
        if(str.length() <= 1 )
            return "0";

        int count = 0;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i - 1) > str.charAt(i)){
                count++;
            }
        }

        count = count > 0 ? count - 1 : count;
        return ""+count;
    }

    public static void main(String[] args) {
        System.out.println(MathChallenge("5655984"));
        System.out.println(MathChallenge("56"));
        System.out.println(MathChallenge("9876541110"));
    }
}
