package org.example;

public class ValidateNumber implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
