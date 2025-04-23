package com.gyarsilalsolanki011.expense.scheduler;

import com.gyarsilalsolanki011.expense.model.entity.Expense;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.repository.ExpenseRepository;
import com.gyarsilalsolanki011.expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final JavaMailSender mailSender;
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    @Scheduled(cron = "0 0 8 * * MON") // Every Monday at 8 AM
    public void sendWeeklySummary() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, -7); // 7 days ago
            Date oneWeekAgo = cal.getTime();
            List<Expense> expenses = expenseRepository.findExpensesInLastWeek(user, oneWeekAgo);
            if (!expenses.isEmpty()) {
                String body = buildSummaryBody(expenses);
                sendEmail(user.getEmail(), "Your Weekly Expense Summary", body);
            }
        }
    }

    private String buildSummaryBody(List<Expense> expenses) {
        BigDecimal total = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        StringBuilder sb = new StringBuilder();
        sb.append("Weekly Expense Summary\n\n");
        expenses.forEach(e -> sb.append(String.format("- %s | %s | ₹%s\n",
                e.getDate(), e.getCategory(), e.getAmount())));
        sb.append("\nTotal: ₹").append(total);
        return sb.toString();
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
