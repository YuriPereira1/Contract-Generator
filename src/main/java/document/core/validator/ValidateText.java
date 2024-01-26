package document.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateText implements Validator<Boolean, String> {
    public Result<Boolean, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O texto não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z].+\\p{L}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Result.success(true);
        };
        return Result.error("Texto inválido! (Deve inciar e finalizar com letras)");
    }
}
