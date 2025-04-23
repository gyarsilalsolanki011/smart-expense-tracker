package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.mapper.ExpenseMapper;
import com.gyarsilalsolanki011.expense.model.dto.ExpenseDto;
import com.gyarsilalsolanki011.expense.model.entity.Category;
import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.repository.CategoryRepository;
import com.gyarsilalsolanki011.expense.repository.ExpenseRepository;
import com.gyarsilalsolanki011.expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense addExpense(String userEmail, ExpenseDto expenseDto) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Category category = categoryRepository.findByName(expenseDto.getCategoryName())
                .orElseThrow(() -> new UsernameNotFoundException("Please Enter Valid Category !"));
        Expense expense = ExpenseMapper.mapToEntity(expenseDto, category, user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(String userEmail) {
        return expenseRepository.findByUserEmail(userEmail);
    }

    public Expense updateExpense(String username, ExpenseDto newData, Long id) {
        Expense expense = expenseRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("You do not have Expense"));
        Expense newExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        Category category = categoryRepository.findByName(newData.getCategoryName())
                .orElseThrow(() -> new UsernameNotFoundException("Please Enter Valid Category !"));
        newExpense.setAmount(newData.getAmount());
        newExpense.setCategory(category);
        newExpense.setDescription(newData.getDescription());
        newExpense.setDate(new Date());
        return expenseRepository.save(newExpense);
    }

    public void deleteExpense(String username, Long id) {
        Expense expense = expenseRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseRepository.deleteById(id);
    }
}
