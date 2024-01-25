package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateText implements Validator {
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z].+\\p{L}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
