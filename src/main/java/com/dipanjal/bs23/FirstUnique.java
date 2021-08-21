package com.dipanjal.bs23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class FirstUnique {

    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String product : products){
            Integer count = countMap.getOrDefault(product, 0) + 1;
            countMap.put(product, count);
        }

        for (String product : products){
            if(countMap.get(product) == 1)
                return product;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}
