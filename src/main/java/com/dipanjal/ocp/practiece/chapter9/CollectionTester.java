package com.dipanjal.ocp.practiece.chapter9;

import javax.swing.*;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author dipanjal
 * @since 4/20/2021
 */

public class CollectionTester {

    private static void listAddTest(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(3, 10);
        System.out.println(list.size());
    }

    private static void immutableListTest(){
        List<String> names = List.of("Dip", "Prottay", "Romman", "Tanzim");
        names.add("Shamar");
        System.out.println(names.size());
    }

    private static void dequeTest(){
        Deque<String> names = new ArrayDeque<>();
        names.add("Dip");
        names.add("Prottay");
        names.add("Shamar");
        names.add("Romman");
        names.add("Tanzim");

        System.out.println("pollFirst: "+ names.pollFirst());
        System.out.println(names.size());
    }

    private static void hashMapTest(){

        /** Readonly Map */
        /* Map<String, Integer> map = Map.ofEntries(
                Map.entry("Jhon", 26),
                Map.entry("Sammy", 26),
                Map.entry("Edward", 27),
                Map.entry("Ruddy", 29)
        );*/

        Map<String, Integer> map = new HashMap<>(){{
            put("Jhon", 26);
            put("Sammy", 26);
            put("Edward", 27);
            put("Ruddy", 29);
        }};
        Integer age = map.getOrDefault("Sammy", 0);
        System.out.println(age);
    }

    private static void listTest2(){
        Product p1 = new Product("Tea", 10.00);
        Product p2 = new Product("Coffee", 15.00);
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);

        Product [] products = new Product[1];
        products = productList.toArray(products);
        System.out.println(productList.size());
        System.out.println(products.length);
    }

    private static void removeIfTest(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Tea", 10.00));
        productList.add(new Product("Coffee", 15.00));
        System.out.println(productList.size());

        productList.removeIf(
                product -> product.getName().equalsIgnoreCase("Tea")
        );
        System.out.println(productList.size());
    }

    private static void collectionSortingTest(SortOrder sortOrder){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coffee", 25.00));
        productList.add(new Product("Tea", 10.00));
        productList.add(new Product("Lemoned", 20.00));

        Comparator<Product> asc = (o1, o2) -> o1.getPrice() > o2.getPrice() ? 1 : -1;
        Comparator<Product> desc = (o1, o2) -> o1.getPrice() < o2.getPrice() ? 1 : -1;
        Comparator<String> comparator = String::compareToIgnoreCase; //method reference

        Collections.sort(
                productList,
                sortOrder.equals(SortOrder.ASCENDING) ? asc : desc
        );
        System.out.println(productList.size());
    }

    private static void setsTest(){
        Set<String> names = new HashSet<>();
        names.add("Xyz");
        names.add(null);
        System.out.println(names.size());
    }

    public static void main(String[] args) {
//        listAddTest();
//        immutableListTest();
//        dequeTest();
//        hashMapTest();
//        listTest2();
//        removeIfTest();
        collectionSortingTest(SortOrder.DESCENDING);
//        setsTest();
    }


}
