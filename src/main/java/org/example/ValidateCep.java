package org.example;

public class ValidateCep implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
