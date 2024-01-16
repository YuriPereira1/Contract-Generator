package org.example;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.*;

public class UpdateDocument {
    String[] listOfVariables = new String[]{
            "name",
            "rg",
            "cpf",
            "location",
            "cep",
            "phoneNumber",
            "houseDescription",
            "houseLocation",
            "dateInn",
            "dateOut",
            "price",
            "contractDate",
            "maxPerson",
    };
    Map<String, String> mapOfValues = new HashMap<>();
    public UpdateDocument(List<String> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            mapOfValues.put(listOfVariables[i],listOfValues.get(i));
        }
    }
    public void updateAllInfo(XWPFDocument doc) {
        {
            List<XWPFParagraph> xwpfParagraphsList = doc.getParagraphs();

            for (XWPFParagraph xwpfParagraph : xwpfParagraphsList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);
                    for (String listOfVariable : listOfVariables) {
                        String newText = "${" + listOfVariable + "}";
                        if (docText != null) {
                            docText = docText.replace(newText, mapOfValues.get(listOfVariable));
                            xwpfRun.setText(docText, 0);
                        }
                    }
                }
            }
        }
    }
}
