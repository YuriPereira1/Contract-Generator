package org.example;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

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
        data.put("dateInn", new SimpleEntry<>("Data de entrada", "00/00/0000"));
        data.put("dateOut", new SimpleEntry<>("Data de saída", "99/99/9999"));
        data.put("price", new SimpleEntry<>("Valor", "R$999,00 (Novecentos e noventa e nove reais)"));
        data.put("contractDate", new SimpleEntry<>("Dia de hoje", "55/55/5555"));
        data.put("maxPerson", new SimpleEntry<>("Número de pessoas", "5"));

        for (Map.Entry<String, SimpleEntry<String, String>> entry : data.entrySet()) {
            System.out.println("Digite o " + entry.getValue().getKey() + ": ");

            System.out.println(entry.getValue().getValue());
            inputMap.put(entry.getKey(), entry.getValue().getValue());
        }
    }
}
