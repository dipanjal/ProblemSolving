package com.dipanjal.ocp.practiece;

/**
 * @author dipanjal
 * @since 4/17/2021
 */

public class ArithmeticOp {

    public static byte add(byte x, byte y){
        return (byte)(x + y);
    }

    public static char add(char x, char y){
        return (char) (x + y);
    }

    public static float div(byte x, byte y){
        /*
        casting any one, operation with an promoted type will automatically promote the value
         */
        return (float)x / y;
    }

    public static int toInt(float x){
        return Math.round(x); //32 bit float to 32 bit int conversion
//        return Math.round((double)x); //36 bit double to 32 bit int conversion is impossible to round;
    }

    public static void print(Object x){
        System.out.println(x);
    }

    public static void printAtoZToInt(){
        char ch = 'A';
        int sum = ch;
        while(ch<='Z'){
            print(String.format("char: %s ==> int: %s ==> toCharOfSum(%s) = %s",
                    ch,
                    (int)ch,
                    sum,
                    (char)sum
            ));
            ch++;
            sum += ch;
        }
    }

    public static void main(String[] args) {
        /*System.out.println("Add:"+ add((byte)2, (byte)3));
        System.out.println("Div:"+div((byte)2, (byte)3));
        System.out.println("Round: "+
                toInt(div((byte)2, (byte)3))
        );*/

//        print("Round: "+ toInt(0.49F));
        /*print("Char Add: "+add('a','B'));
        print("Char as Int: "+(int)add('a','B'));
        print("Int as Char: "+(char)90);*/

        printAtoZToInt();

        Integer i = 50;
        int b = i; //auto unboxing;
        b = i.intValue(); //auto unboxing;

        Integer c = b; //auto boxing
        c = Integer.valueOf(b); //auto boxing;
    }
}
