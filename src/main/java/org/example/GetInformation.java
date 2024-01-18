package org.example;

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

import static java.lang.System.in;

public class GetInformation {
    HashMap<String,String> inputMap = new HashMap<>();
    public HashMap<String, String> getInputValues() {
        return inputMap;
    }

    public GetInformation() {
        LinkedHashMap<String, Triplet<String, String, Validator>> data = new LinkedHashMap<>();
        data.put("name", new Triplet<>("nome", "Nome completo do individuo", new ValidateText()));
        data.put("rg", new Triplet<>("RG", "000000000", new ValidateRg()));
        data.put("cpf", new Triplet<>("CPF", "000.000.000-00", new ValidateCpf()));
        data.put("location", new Triplet<>("Endereço", "Rua endereço , n° 000, Bairro, Cidade / Estado", new ValidateText()));
        data.put("cep", new Triplet<>("CEP", "80000-000", new ValidateCep()));
        data.put("phoneNumber", new Triplet<>("Telefone", "(99) 9 9999-9999", new ValidatePhone()));
        data.put("houseDescription", new Triplet<>("Descrição da casa", "Casa com dois quartos, sala, cozinha, banheiro, garagem coberta", new ValidateText()));
        data.put("houseLocation", new Triplet<>("Endereço da casa", "Rua endereço da casa, nº 999, Bairro, Cidade / Estado", new ValidateText()));
        data.put("dateInn", new Triplet<>("Data de entrada", "01/01/2024", new ValidateDate()));
        data.put("dateOut", new Triplet<>("Data de saída", "31/01/2024", new ValidateDate()));
        data.put("price", new Triplet<>("Valor", "10000", new ValidateNumber()));
        data.put("maxPerson", new Triplet<>("Número de pessoas", "5", new ValidateNumber()));

        Scanner scanner = new Scanner(in);
        for (Map.Entry<String, Triplet<String, String, Validator>> entry : data.entrySet()) {
            System.out.println("Digite o " + entry.getValue().getValue0() + ": ");

            Validator validator = entry.getValue().getValue2();
            if (true) {
                if (!validator.execute(entry.getValue().getValue1())) {
                    System.out.println(entry.getValue().getValue1());
                    inputMap.put(entry.getKey(), entry.getValue().getValue1());
                }
            } else {
                String userInput = scanner.nextLine();
                if (!validator.execute(userInput)) {
                    System.out.println(userInput);
                    inputMap.put(entry.getKey(), userInput);
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
