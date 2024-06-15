package com.dipanjal.bs23;

import java.util.regex.Pattern;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class UsernameValidation {

    public static boolean validate(String username){
        final String USERNAME_PATTERN = "^[a-zA-Z0-9]([_](?![_])|[a-zA-Z0-9]){3,}$";
        final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        return pattern.matcher(username).matches();
    }
}
