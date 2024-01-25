package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCep implements Validator{
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
