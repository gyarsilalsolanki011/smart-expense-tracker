package com.gyarsilalsolanki011.expense.controller;

import com.gyarsilalsolanki011.expense.model.dto.ExpenseDto;
import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@AuthenticationPrincipal UserDetails userDetails,
                                              @RequestBody ExpenseDto expense) {
        return ResponseEntity.ok(expenseService.addExpense(userDetails.getUsername(), expense));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(expenseService.getAllExpenses(userDetails.getUsername()));
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails,
                                                 @RequestBody ExpenseDto updated) {
        return ResponseEntity.ok(expenseService.updateExpense(userDetails.getUsername(), updated, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        expenseService.deleteExpense(userDetails.getUsername(), id);
        return ResponseEntity.noContent().build();
    }
}
