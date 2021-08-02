package com.dipanjal.leetcode.easy;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/valid-palindrome/
 * 125. Valid Palindrome
 * Difficulty: Easy
 */
public class Palindrome {

    /** Two Pointer Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1) Constant Time
     * */

    private static String getTrimmedLower(String str){
        String palindrome = "";
        for(int i=0; i<str.length(); i++){
            if(Character.isLetterOrDigit(str.charAt(i))) palindrome += str.charAt(i);
        }
        return palindrome.toLowerCase();
    }

    public static boolean isPalindrome(String str){
        str = getTrimmedLower(str);
        if(str.length() == 0) return true;
        int lastIndex = str.length()-1;
        int end = lastIndex / 2;
        for(int i=0; i<=end; i++)
            if(str.charAt(i) != str.charAt(lastIndex - i))
                return false ;
        return true;
    }

    /** TWO POINTER APPROACH (Optimized) */
    public static boolean isPalindromeOptimal(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(isPalindromeOptimal("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeOptimal("race a car"));
        System.out.println(isPalindromeOptimal("  "));
        System.out.println(isPalindromeOptimal("."));
        System.out.println(isPalindromeOptimal("1-12"));
    }
}
