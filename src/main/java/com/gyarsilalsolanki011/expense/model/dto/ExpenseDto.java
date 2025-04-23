package com.gyarsilalsolanki011.expense.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private String title;
    private String description;
    private BigDecimal amount;
    private String categoryName; // For display (e.g., "Food")
}

