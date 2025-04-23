package com.gyarsilalsolanki011.expense.mapper;

import com.gyarsilalsolanki011.expense.model.dto.ExpenseDto;
import com.gyarsilalsolanki011.expense.model.entity.Category;
import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;

import java.util.Date;

public class ExpenseMapper {
    public static ExpenseDto mapToDto(Expense expense) {
        return new ExpenseDto(
                expense.getTitle(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory().getName()
        );
    }

    public static Expense mapToEntity(ExpenseDto dto, Category category, User user) {
        return new Expense(
             dto.getTitle(),
             dto.getDescription(),
             dto.getAmount(),
             new Date(),
             user,
             category
        );
    }
}
