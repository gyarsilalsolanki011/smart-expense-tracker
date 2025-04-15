package com.gyarsilalsolanki011.expense.repository;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
}
