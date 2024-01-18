package org.example;

public class ValidatePhone implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
