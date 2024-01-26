package document.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O nome não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\p{L}+ \\p{L}+[\\p{L} ]*\\p{L}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Nome inválido! (digite apenas letras e espaços)");
    }
}
