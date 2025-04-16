package com.gyarsilalsolanki011.expense.repository;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserEmail(String email);
    @Query("SELECT e FROM Expense e WHERE e.user = :user AND e.date >= :startDate")
    List<Expense> findExpensesInLastWeek(User user, LocalDate startDate);
}
