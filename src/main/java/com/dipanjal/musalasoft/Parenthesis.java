package com.dipanjal.musalasoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dipanjal
 * @since 5/15/2021
 */

public class Parenthesis {
    public static int getMin(String s) {
        int balance = 0;
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {

            balance += s.charAt(i) == '(' ? 1 : -1;

            // It is guaranteed balance >= -1
            if (balance == -1) {
                count += 1;
                balance += 1;
            }
        }
        return balance + count;
    }

    public static int soln2(String s){
        Deque<Character> stack = new ArrayDeque<>();
        int counter = 0;
        for(Character c : s.toCharArray()){
            if(c == '(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    counter++;
                else {
                    Character top = stack.peek();
                    if(top == '(' && c == ')'){
                        stack.pop();
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(getMin("()))"));
        System.out.println(soln2("()))"));
//        System.out.println(getMin("()()"));
        System.out.println(soln2("()()"));
        System.out.println(soln2(")))"));
    }
}
