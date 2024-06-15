package com.dipanjal.oneit.round2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class AssSubtract {
    public static int addSubtractPairwise (int[] arg) {
        //1, 2, 3
        List<Integer> ints = Arrays.stream(arg).boxed().collect(Collectors.toList());
        if(ints.size() % 2 != 0){
            ints.add(1);
        }
        int windowSize=2;
        int sum = 0;
        int multiplier=1;
        int toggle = -1;

        for (int num : ints){
            windowSize--;
            multiplier *= num;
            if(windowSize == 0){
                windowSize=2;
                toggle = toggle*-1; // (+/-) toggle
                if(toggle > 0){
                    sum += multiplier;
                } else {
                    sum -= multiplier;
                }
                multiplier=1; //reseting the multiplier
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(
                addSubtractPairwise(arr)
        );
    }
}
