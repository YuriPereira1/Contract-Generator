package document.core.parse;

import document.core.utils.Result;
import jakarta.annotation.Nonnull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCep implements Parse<String>{
    public @Nonnull Result<String, String> execute(String input) {
        if (input.isBlank()) {
            return Result.error("O cep não pode ser vazio!");
        }
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            StringBuilder sb = new StringBuilder(input);
            sb.insert(5,"-");
            return Result.success(sb.toString());
        };
        return Result.error("CEP inválido! (Deve conter exatos 8 números)");
    }
}
