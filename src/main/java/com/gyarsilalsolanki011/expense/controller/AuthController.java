package com.gyarsilalsolanki011.expense.controller;

import com.gyarsilalsolanki011.expense.model.AuthRequest;
import com.gyarsilalsolanki011.expense.model.AuthResponse;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        // Handle JWT authentication logic
        return ResponseEntity.ok(new AuthResponse("JWT token here"));
    }
}
