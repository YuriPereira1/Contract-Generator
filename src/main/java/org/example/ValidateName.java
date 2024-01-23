package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName implements Validator{
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[\\p{L} ]*$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
