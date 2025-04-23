package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService {
    private final ExpenseRepository expenseRepository;
    public Map<String, BigDecimal> getCategoryWiseExpenses(String email) {
        List<Expense> expenses = expenseRepository.findByUserEmail(email);

        return expenses.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getCategory().getName(), // assuming Category has a getName() method
                        Collectors.mapping(
                                Expense::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));
    }

    public Map<String, BigDecimal> getMonthlyTrend(String email) {
        List<Expense> expenses = expenseRepository.findByUserEmail(email);
        return expenses.stream()
                .collect(Collectors.groupingBy(
                        expense -> {
                            // Convert java.util.Date to java.time.LocalDate
                            LocalDate localDate = expense.getDate().toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate();

                            // Group by full month name like "January"
                            return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                        },
                        Collectors.mapping(
                                Expense::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));
    }
}
