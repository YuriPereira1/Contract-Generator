package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O telefone não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d{11}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Telefone inválido! (O telefone deve conter 11 números)");
    }
}
