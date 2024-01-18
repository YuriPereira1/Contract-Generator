package org.example;

import jakarta.annotation.Nonnull;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

import static java.lang.System.in;

public class GetInformation {
    HashMap<String,String> inputMap = new HashMap<>();
    public HashMap<String, String> getInputValues() {
        return inputMap;
    }

    public GetInformation() {
        LinkedHashMap<String, SimpleEntry<String, String>> data = new LinkedHashMap<>();
        data.put("name", new SimpleEntry<>("nome", "Nome completo do individuo"));
        data.put("rg", new SimpleEntry<>("RG", "000000000"));
        data.put("cpf", new SimpleEntry<>("CPF", "000.000.000-00"));
        data.put("location", new SimpleEntry<>("Endereço", "Rua endereço , n° 000, Bairro, Cidade / Estado"));
        data.put("cep", new SimpleEntry<>("CEP", "80000-000"));
        data.put("phoneNumber", new SimpleEntry<>("Telefone", "(99) 9 9999-9999"));
        data.put("houseDescription", new SimpleEntry<>("Descrição da casa", "Casa com dois quartos, sala, cozinha, banheiro, garagem coberta"));
        data.put("houseLocation", new SimpleEntry<>("Endereço da casa", "Rua endereço da casa, nº 999, Bairro, Cidade / Estado"));
        data.put("dateInn", new SimpleEntry<>("Data de entrada", "01/01/2024"));
        data.put("dateOut", new SimpleEntry<>("Data de saída", "31/01/2024"));
        data.put("price", new SimpleEntry<>("Valor", "10000"));
        data.put("maxPerson", new SimpleEntry<>("Número de pessoas", "5"));

        Scanner scanner = new Scanner(in);
        for (Map.Entry<String, SimpleEntry<String, String>> entry : data.entrySet()) {
            System.out.println("Digite o " + entry.getValue().getKey() + ": ");
            if (true) {
                System.out.println(entry.getValue().getValue());
                inputMap.put(entry.getKey(), entry.getValue().getValue());
            } else {
                String userInput = scanner.nextLine();
                System.out.println(userInput);
                inputMap.put(entry.getKey(), userInput);
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
