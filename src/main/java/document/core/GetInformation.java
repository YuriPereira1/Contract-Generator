package document.core;

import document.core.parse.ParseCep;
import document.core.utils.CurrencyWriter;
import document.core.utils.Result;
import document.core.validator.*;
import jakarta.annotation.Nonnull;
import org.javatuples.Triplet;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.lang.System.err;
import static java.lang.System.in;

public class GetInformation {
    HashMap<String,String> inputMap = new HashMap<>();
    public HashMap<String, String> getInputValues() {
        return inputMap;
    }

    public GetInformation() {
        LinkedHashMap<String, Triplet<String, String, Validator<Boolean, String>>> data = new LinkedHashMap<>();
        data.put("name", new Triplet<>("nome", "Digite um NOME", new ValidateName()));
        data.put("rg", new Triplet<>("RG", "123456789", new ValidateRg()));
        data.put("cpf", new Triplet<>("CPF", "12312312311", new ValidateCpf()));
        data.put("location", new Triplet<>("Endereço", "Rua endereço , n° 000, Bairro, Cidade / Estado", new ValidateText()));
        data.put("cep", new Triplet<>("CEP", "12345678", new ValidateCep()));
        data.put("phoneNumber", new Triplet<>("Telefone", "55912345678", new ValidatePhone()));
        data.put("houseDescription", new Triplet<>("Descrição da casa", "Casa com dois quartos, sala, cozinha, banheiro, garagem coberta", new ValidateText()));
        data.put("houseLocation", new Triplet<>("Endereço da casa", "Rua endereço da casa, nº 999, Bairro, Cidade / Estado", new ValidateText()));
        data.put("dateInn", new Triplet<>("Data de entrada", "01/01/2024", new ValidateDate()));
        data.put("dateOut", new Triplet<>("Data de saída", "31/01/2024", new ValidateDate()));
        data.put("price", new Triplet<>("Valor", "10000", new ValidateNumber()));
        data.put("maxPerson", new Triplet<>("Número de pessoas", "5", new ValidateNumber()));

        Scanner scanner = new Scanner(in);
        for (Map.Entry<String, Triplet<String, String, Validator<Boolean, String>>> entry : data.entrySet()) {
            Validator<Boolean, String> validator = entry.getValue().getValue2();

            System.out.println("Digite o " + entry.getValue().getValue0() + ": ");

            while (true){
                String userInput;
                if (true) {
                    userInput = entry.getValue().getValue1();
                } else {
                    userInput = scanner.nextLine();
                }
                if (entry.getKey().equals("cep")) {
                    Result<String, String> inputResult = new ParseCep().execute(userInput);
                    if (inputResult.isSuccess()) {
                        System.out.println(inputResult.getSuccessValue());
                        inputMap.put(entry.getKey(), inputResult.getSuccessValue());
                        break;
                    } else {
                        String errorMsg = inputResult.getErrorValue();
                        err.println(errorMsg);
                    }

                } else {
                    Result<Boolean, String> inputResult = validator.execute(userInput);
                    if (inputResult.isSuccess()) {
                        System.out.println(userInput);
                        inputMap.put(entry.getKey(), userInput);
                        break;
                    } else {
                        String errorMsg = inputResult.getErrorValue();
                        err.println(errorMsg);
                    }
                }
            }
        }

        String today = GetTodayDate();
        inputMap.put("contractDate", today);

        String totalDays = GetDaysBetween(inputMap.get("dateInn"), inputMap.get("dateOut"));
        inputMap.put("totalDays", totalDays);

        double price = Double.parseDouble(inputMap.get("price"));
        inputMap.put("price", AsPrice(price));
        inputMap.put("signalPrice", AsPrice(price / 2));
    }

    private @Nonnull String GetDaysBetween(String startDate, String endDate) throws DateTimeException {
        LocalDate initialDate = ParseAsDate(startDate);
        LocalDate finalDate = ParseAsDate(endDate);

        long daysBetween = ChronoUnit.DAYS.between(initialDate,finalDate);
        return String.valueOf(daysBetween);
    }

    private LocalDate ParseAsDate(String input) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(input, dtf);
        } catch (DateTimeException e) {
            System.err.println("Are you sure de dates are in correct format? (dd MM yyyy)");
            throw e;
        }
        return date;
    }

    private @Nonnull String GetTodayDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }

    private @Nonnull String AsPrice(double price) {
        String amount = PriceFormatter(price);

        CurrencyWriter cw = CurrencyWriter.getInstance();

        return amount + " (" + cw.write(new BigDecimal(price)) + ")";
    }

    private String PriceFormatter(double input) {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return currencyFormatter.format(input);
    }
}
