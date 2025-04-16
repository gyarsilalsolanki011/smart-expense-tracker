package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.repository.ExpenseRepository;
import com.gyarsilalsolanki011.expense.util.ExcelUtil;
import com.gyarsilalsolanki011.expense.util.PdfUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportService {
    private final ExpenseRepository expenseRepository;

    public ByteArrayInputStream exportToExcel(String email) throws IOException {
        List<Expense> expenses = expenseRepository.findByUserEmail(email);
        // Use Apache POI to generate Excel file
        return ExcelUtil.generateExcel(expenses);
    }

    public ByteArrayInputStream exportToPDF(String email) throws IOException {
        List<Expense> expenses = expenseRepository.findByUserEmail(email);
        return PdfUtil.generatePdf(expenses); // Use OpenPDF or iText
    }
}

