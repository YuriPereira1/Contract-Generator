package document.core.validator;

import document.core.utils.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRg implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O rg não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Rg inválido! (Rg deve conter exatos 9 números)");
    }
}
