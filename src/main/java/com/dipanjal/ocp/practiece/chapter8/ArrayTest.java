package com.dipanjal.ocp.practiece.chapter8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author dipanjal
 * @since 4/19/2021
 */

public class ArrayTest {

    private void declaration(){
        //WAY 1 (convenient)
        int[] arr1;
        arr1 = new int[4];

        //WAY 2 not really recommended
        int arr2[];
        arr2 = new int[4];
    }

    private void combined(){
        final int[] arr = new int[3];
        arr[0] = 8; //allowed
//        arr = new int[] {3,4,5}; //not allowed

        final int[] arr1 = new int[] {1,3,4};
        final int[] arr2 = {1,2,3};
    }

    private static void copyArray(){
        int[] source = {1,3,5};
        int[] destination = {9,7,0,0,0};
        System.arraycopy(
                source, 0,
                destination, 2, source.length);


        int[] destCopy = Arrays.copyOf(destination, 10);
        System.out.println(destCopy instanceof Object);
    }

    private static void loopingExample(){
        String[][] arr = {
                {"A","B","C","D"},
                {"E","F","G","H"},
                {"I","J","K","L"},
                {"M","N","O","P"},
                {"Q","R","S","T"},
        };

        StringBuilder builder = new StringBuilder();

        outerLoop1: for (String[] letters : arr){
            innerLoop: for (String letter:letters){
                if(letter.equals("C"))
                    continue ;
                if(letter.equals("H"))
                    continue outerLoop1;
                if(letter.equals("N"))
                    break ;
                if(letter.equals("S"))
                    break outerLoop1;
                builder.append(letter);
            }
            builder.append("\n -------------------- \n");
        }
        System.out.println(builder.toString());
    }

    private static void arraySorting(){
        /*String[] arr = {"Jhon", "Rob", "Martinus", "Edward"};

        Arrays.sort(arr);

        //Traditional approach
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() > str2.length() ? 1 : -1;
            }
        });

        //Functional Approach
        Arrays.sort(arr, (str1, str2) -> str1.length() > str2.length() ? 1 : -1);
        System.out.println("ashdkashd");*/

//        String[] names = {"Mary","Jane","Ann","Tom"};
//        Arrays.sort(names, (str1, str2) -> str2.length() - str1.length());
        String[] names = {"Mary","Jane","Elizabeth","Jo"};
        Arrays.sort(names, (str1, str2) -> str2.length() - str1.length());
        for (String name: names) {
            System.out.println(name);
        }
//        int x = Arrays.binarySearch(names,"Ann");
//        System.out.println(x);
    }

    public static void main(String[] args) {
//        copyArray();
//        arraySorting();
//        loopingExample();

        String[] arr = {"Tea","Cake"};
        List<String> texts = Arrays.asList(arr);
        texts.set(0, "Coffee");
        texts.set(1, "Biscuit");
        texts.add("Chocolate");

    }
}
