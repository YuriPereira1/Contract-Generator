package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCep implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O cep não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("CEP inválido! (Deve conter exatos 8 números)");
    }
}
