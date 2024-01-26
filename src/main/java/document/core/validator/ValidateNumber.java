package document.core.validator;

import document.core.utils.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumber implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O número não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Digite apenas números!");
    }
}
