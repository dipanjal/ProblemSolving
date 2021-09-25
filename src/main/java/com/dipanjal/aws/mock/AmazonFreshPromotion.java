package com.dipanjal.aws.mock;

import java.util.ArrayList;
import java.util.List;

public class AmazonFreshPromotion {

    public static int foo(List<String> codeList, List<String> shoppingCart) {

        if(codeList == null || codeList.isEmpty())
            return 1;

        if(shoppingCart == null || shoppingCart.isEmpty())
            return 0;

        int p1 = 0, p2=0;

        List<String> codeListMod = new ArrayList<>();
        for(String code : codeList){
            String[] strs = code.split(" ");
            if(strs.length > 1 ) {
                for(String s : strs) codeListMod.add(s);
            }else {
                codeListMod.add(code);
            }
        }

        while (p1 < codeListMod.size() && p2<shoppingCart.size()) {
            String code = codeListMod.get(p1);
            if(code.equals("anything") || code.equals(shoppingCart.get(p2))) {
                p1++;
                p2++;
            } else {
                p2++;
            }
        }

        if(p1 == codeListMod.size())
            return 1;
        return 0;

    }

    public static void main(String[] args) {
        List<String> codeList = List.of("orange", "apple apple", "banana orange apple", "banana");
//        List<String> codeList = List.of("orange", "apple apple", "banana orange apple", "banana");
    }
}
