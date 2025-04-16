package com.gyarsilalsolanki011.expense.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final JavaMailSender mailSender;

    public void sendBudgetExceededEmail(String to, BigDecimal budget, BigDecimal spent) {
        String subject = "Budget Limit Exceeded";
        String body = String.format("You’ve exceeded your budget of ₹%.2f. Total spent: ₹%.2f", budget, spent);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
