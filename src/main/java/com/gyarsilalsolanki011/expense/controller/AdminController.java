package com.gyarsilalsolanki011.expense.controller;

import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.model.enums.Role;
import com.gyarsilalsolanki011.expense.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/role")
    public ResponseEntity<User> changeUserRole(@RequestParam Long userId, @RequestParam Role role) {
        return ResponseEntity.ok(userService.changeUserRole(userId, role));
    }
}
