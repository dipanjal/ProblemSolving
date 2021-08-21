package com.dipanjal.oneit;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class Test3 {

    // DO NOT write a main method

    public static String getUserName (String firstName, String lastName) {
        // return the user name as LastName, FirstName e.g. Smith, John
        if(lastName == null)
            return capitaliseFirstLetter(firstName);
        return capitaliseFirstLetter(lastName) + ", "+capitaliseFirstLetter(firstName);
    }


    public static String capitaliseFirstLetter (String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        chars[0] = Character.toUpperCase(chars[0]);

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(getUserName("John", "Smith"));
    }
}
