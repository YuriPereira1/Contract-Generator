package org.example;

import java.util.*;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class UpdateDocument {
    Map<String, String> inputMap;
    public UpdateDocument(HashMap<String, String> map) {
        inputMap = map;
    }
    public void updateAllInfo(XWPFDocument doc) {
        {
            List<XWPFParagraph> xwpfParagraphsList = doc.getParagraphs();

            for (XWPFParagraph xwpfParagraph : xwpfParagraphsList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);
                    if (docText == null) {
                        continue;
                    }

                    for (Map.Entry<String, String> entry : inputMap.entrySet() ) {
                        String placeHolder = "${" + entry.getKey() + "}";
                        docText = docText.replace(placeHolder, entry.getValue());
                        xwpfRun.setText(docText, 0);
                    }
                }
            }
        }
    }
}
