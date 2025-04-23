package com.gyarsilalsolanki011.expense.controller;

import com.gyarsilalsolanki011.expense.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;

    @GetMapping("/category")
    public ResponseEntity<?> getCategoryWise(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(analyticsService.getCategoryWiseExpenses(user.getUsername()));
    }

    @GetMapping("/monthly")
    public ResponseEntity<?> getMonthlyTrend(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(analyticsService.getMonthlyTrend(user.getUsername()));
    }
}

