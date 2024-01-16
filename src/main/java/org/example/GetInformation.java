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
        data.put("name", new SimpleEntry<>("nome", "Ana Paula Martins"));
        data.put("rg", new SimpleEntry<>("RG", "127651817"));
        data.put("cpf", new SimpleEntry<>("CPF", "012.077.479-80"));
        data.put("location", new SimpleEntry<>("Endereço", "R Luiz Fernando Pinheiro Lima de Abreu, n° 291, Md 1 Ant 1325 - Sitio Cercado, Curitiba / Paraná"));
        data.put("cep", new SimpleEntry<>("CEP", "81925-187"));
        data.put("phoneNumber", new SimpleEntry<>("Telefone", "(41) 9 9997-4463"));
        data.put("houseDescription", new SimpleEntry<>("Descrição da casa", "Casa com dois quartos, sala, cozinha, banheiro, garagem coberta"));
        data.put("houseLocation", new SimpleEntry<>("Endereço da casa", "Travessa particular grandes lagos, nº 177, Jacaranda, Pontal do Paraná / Paraná"));
        data.put("dateInn", new SimpleEntry<>("Data de entrada", "13/01/2024"));
        data.put("dateOut", new SimpleEntry<>("Data de saída", "14/01/2024"));
        data.put("price", new SimpleEntry<>("Valor", "R$480,00 (Quatrocentos e oitenta reais)"));
        data.put("contractDate", new SimpleEntry<>("Dia de hoje", "12/01/2024"));
        data.put("maxPerson", new SimpleEntry<>("Número de pessoas", "6"));

        for (Map.Entry<String, SimpleEntry<String, String>> entry : data.entrySet()) {
            System.out.println("Digite o " + entry.getValue().getKey() + ": ");

            System.out.println(entry.getValue().getValue());
            inputMap.put(entry.getKey(), entry.getValue().getValue());
        }
    }
}
