package document.core;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String fisFile = "Template.docx";
        GetInformation getInformation = new GetInformation();
        UpdateDocument updateDocument = new UpdateDocument(getInformation.getInputValues());

        XWPFDocument doc;
        try {
            doc = new XWPFDocument(Files.newInputStream(Paths.get(fisFile)));
            updateDocument.updateAllInfo(doc);
        } catch (RuntimeException e) {
            System.err.println("Are you sure the file exist?");
            throw e;
        }

        try {
            FileOutputStream out = new FileOutputStream("output/document.docx");
            doc.write(out);
        } catch (Exception e) {
            System.err.println("Are you sure the folder exist or permission to write?");
            throw e;
        }

        System.out.println("File Saved");
    }
}