package com.gyarsilalsolanki011.expense.repository;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserEmail(String email);
    Optional<Expense> findByUserUsername(String username);
    @Query("SELECT e FROM Expense e WHERE e.user = :user AND e.date >= :startDate")
    List<Expense> findExpensesInLastWeek(@Param("user") User user, @Param("startDate") Date startDate);
}
