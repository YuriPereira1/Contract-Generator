package org.example;

public class ValidateDate implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
