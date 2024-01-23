package org.example;

public class ValidateText implements Validator {
    public boolean execute(String input) {
        return input.isBlank();
    }
}
