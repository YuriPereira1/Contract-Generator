package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCpf implements Validator{
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d{11}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
