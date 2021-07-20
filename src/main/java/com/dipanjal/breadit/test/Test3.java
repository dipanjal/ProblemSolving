package com.dipanjal.breadit.test;

/**
 * @author dipanjal
 * @since 6/2/2021
 */

public class Test3 {

    public static String convertAngleToTimeString(float angle) {
        if(angle == 0)
            return "00:00";

        String time = "";
        float decimalValue = (1.0f/30.0f) * (angle % 360);
        if (decimalValue < 0)
            decimalValue += 12.0f;

        int hours = (int)decimalValue;
        if (hours == 0)
            hours = 12;
        time += (hours < 10 ? "0" + hours: hours) + ":";
        int minutes = (int)(decimalValue * 60) % 60;
        time += minutes < 10 ? "0" + minutes: minutes;
        return time;
    }

    public static void main(String[] args) {
        System.out.println(convertAngleToTimeString(0));
        System.out.println(convertAngleToTimeString(360));
        System.out.println(convertAngleToTimeString(90));
        System.out.println(convertAngleToTimeString(45));
        System.out.println(convertAngleToTimeString(250));
    }
}
