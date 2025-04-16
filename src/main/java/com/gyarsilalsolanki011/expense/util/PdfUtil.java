package com.gyarsilalsolanki011.expense.util;

import com.gyarsilalsolanki011.expense.model.entity.Expense;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfUtil {
    public static ByteArrayInputStream generatePdf(List<Expense> expenses) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Paragraph title = new Paragraph("Expense Report", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Spacer

            PdfPTable table = new PdfPTable(4);
            Stream.of("Date", "Category", "Amount", "Description")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell();
                        cell.setPhrase(new Phrase(header));
                        table.addCell(cell);
                    });

            for (Expense e : expenses) {
                table.addCell(e.getDate().toString());
                table.addCell(String.valueOf(e.getCategory()));
                table.addCell("₹" + e.getAmount().toString());
                table.addCell(e.getDescription());
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
