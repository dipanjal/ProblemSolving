package com.dipanjal.ocp.practiece.chapter10;

import java.util.*;

/**
 * @author dipanjal
 * @since 4/21/2021
 */

public class LambdaPlayground {

    private static <T extends Comparable<? super T>> List<T> neutralOrderSorting(List<T> list){
        list.sort(Comparator.naturalOrder());
        return list;
    }

    private static <E> Set<E> test(Set<? extends E> s1, Set<? extends E> s2){
        return null;
    }

    private static void thenComparingTest() {
        List<String> names = Arrays.asList("Shamar", "Sayfullah", "Mahatab", "Dip");

//        Collections.sort(names, String::compareToIgnoreCase);

        Comparator<String> asc = (o1, o2) -> o1.length() > o2.length() ? 1 : -1;
        Comparator<String> compHashCode = (o1, o2) -> {
            System.out.println("Comparing HashCode");
            return o1.hashCode() < o2.hashCode() ? 1 : -1;
        };
        Comparator<String> compositeComparator = asc.thenComparing(compHashCode).reversed();

        Collections.sort(names, compositeComparator);

        names.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        thenComparingTest();

//        neutralOrderSorting(List.of("s1","s1","s1","s1","s1"));
        Set<Integer> ints = Set.of(1,2,3,4);
        Set<Double> doubles = Set.of(1.1,2.3,3.0,4.5);
//        test(ints, doubles);


    }
}
