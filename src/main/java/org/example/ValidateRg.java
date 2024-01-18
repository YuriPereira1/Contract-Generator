package org.example;

public class ValidateRg implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
