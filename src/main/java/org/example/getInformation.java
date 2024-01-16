package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getInformation {
    List<String> listOfValues = new ArrayList<>();
    public List<String> getListOfValues() {
        return listOfValues;
    }
    public getInformation() {
        Scanner scanner = new Scanner(System.in);
        String[] listOfText = new String[]{
                "nome",
                "rg",
                "cpf",
                "endereço",
                "cep",
                "telefone",
                "descrição da casa",
                "endereço da casa",
                "dia de entrada",
                "dia de saída",
                "valor",
                "dia de hoje",
                "quantidade de pessoas",
        };

        String[] fakeInfo = new String[]{
                "Ana Paula Martins",
                "127651817",
                "012.077.479-80",
                "R Luiz Fernando Pinheiro Lima de Abreu, n° 291, Md 1 Ant 1325 - Sitio Cercado, Curitiba / Paraná",
                "81925-187",
                "(41) 9 9997-4463",
                "Casa com dois quartos, sala, cozinha, banheiro, garagem coberta",
                "Travessa particular grandes lagos, nº 177, Jacaranda, Pontal do Paraná / Paraná",
                "13/01/2024",
                "14/01/2024",
                "R$480,00 (Quatrocentos e oitenta reais)",
                "12/01/2024",
                "6"
        };

        for (int i = 0; i < listOfText.length; i++) {
            System.out.println("Digite o " + listOfText[i] + ": ");

            String text = fakeInfo[i];
            System.out.println(text);
            listOfValues.add(text);
        }
    }


}
