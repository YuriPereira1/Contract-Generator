package org.example;

public class ValidateCpf implements Validator{
    public boolean execute(String input) {
        return input.isEmpty();
    }
}
