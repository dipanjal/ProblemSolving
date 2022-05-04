package com.dipanjal.oneit;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class ArraySum {

    public static Double addValues (Double[] values) {
        /*Double sum = 0.0;
        for(Double d : values){
            if(d == null) return null;
            sum += d;
        }
        return sum;*/

        return Arrays
                .stream(values)
                .filter(Objects::nonNull)
                .reduce(0.0, Double::sum);

    }

    public static void main(String[] args) {
        System.out.println(
                addValues(new Double[]{1.5, 3.5, .5})
        );
    }
}
