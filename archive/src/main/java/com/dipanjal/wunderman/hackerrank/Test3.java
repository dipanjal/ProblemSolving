package com.dipanjal.wunderman.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dipanjal
 * @since 5/29/2021
 */

public class Test3 {


    private static class Pair {
        public Long unit;
        public Long nBox;

        public Pair(Long unit, Long nBox) {
            this.unit = unit;
            this.nBox = nBox;
        }
    }

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // Write your code here
        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i<boxes.size(); i++){
            pairs.add(new Pair(unitsPerBox.get(i), boxes.get(i)));
        }

        //sort descending
        Collections.sort(pairs, (p1, p2) -> (int) (p2.unit - p1.unit));

        long result = 0;
        for(Pair p : pairs) {
            if(truckSize == 0)
                break;
            if(truckSize >= p.nBox){
                result += (p.nBox * p.unit);
                truckSize -= p.nBox;
            }else{
                result += (truckSize * p.unit);
                truckSize = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Long> boxes = List.of(1L,2L,3L);
        List<Long> units = List.of(3L,2L,1L);
        System.out.println(getMaxUnits(boxes, units, 3L));
    }
}
