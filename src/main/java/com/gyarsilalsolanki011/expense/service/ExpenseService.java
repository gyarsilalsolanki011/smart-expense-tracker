package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.repository.ExpenseRepository;
import com.gyarsilalsolanki011.expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense addExpense(String userEmail, Expense expense) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(String userEmail) {
        return expenseRepository.findByUserEmail(userEmail);
    }

    public Expense updateExpense(Long id, Expense newData) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setAmount(newData.getAmount());
        expense.setCategory(newData.getCategory());
        expense.setDescription(newData.getDescription());
        expense.setDate(newData.getDate());
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
