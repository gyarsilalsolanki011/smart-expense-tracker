package com.gyarsilalsolanki011.expense.util;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    public static ByteArrayInputStream generateExcel(List<Expense> expenses) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Expenses");

            Row headerRow = sheet.createRow(0);
            String[] headers = {"Date", "Category", "Amount", "Description"};
            for (int col = 0; col < headers.length; col++) {
                headerRow.createCell(col).setCellValue(headers[col]);
            }

            int rowIdx = 1;
            for (Expense expense : expenses) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(expense.getDate().toString());
                row.createCell(1).setCellValue((RichTextString) expense.getCategory());
                row.createCell(2).setCellValue(expense.getAmount().doubleValue());
                row.createCell(3).setCellValue(expense.getDescription());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
