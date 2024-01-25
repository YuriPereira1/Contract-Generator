package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDate implements Validator{
    public boolean execute(String input) {
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
