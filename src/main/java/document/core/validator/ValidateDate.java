package document.core.validator;

import document.core.utils.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDate implements Validator<Boolean, String>{
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("A data não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Data inválida! (Data deve conter apenas numeros)");
    }
}
