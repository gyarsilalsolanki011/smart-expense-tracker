package com.gyarsilalsolanki011.expense.contoller;

import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();  // Assume a method exists to get all users
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.deleteUser(id);  // Assume a delete method in UserService
    }

    @PutMapping("/users/role")
    public User changeUserRole(@RequestBody User user) {
        return userService.changeRole(user);  // Assume role-changing logic
    }
}
