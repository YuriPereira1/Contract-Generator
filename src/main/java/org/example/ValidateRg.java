package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRg implements Validator{
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }

        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
