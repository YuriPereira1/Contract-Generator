package org.example;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String fisFile = "Template.docx";
        getInformation getInformation = new getInformation();
        UpdateDocument updateDocument = new UpdateDocument(getInformation.getListOfValues());

        try (XWPFDocument doc = new XWPFDocument(
                    Files.newInputStream(Paths.get(fisFile)))) {
            updateDocument.updateAllInfo(doc);

            try (FileOutputStream out = new FileOutputStream("output/document.docx")) {
                doc.write(out);
                System.out.println("File Saved");
            }
        }
    }
}