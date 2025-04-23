package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.model.enums.Role;
import com.gyarsilalsolanki011.expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NullPointerException("User Not found with this Username "+username));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User changeUserRole(Long userId, String role) {
        Role userRole;
        try {
            userRole = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid User role! Choose: USER, ADMIN, or MANAGER.");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setRole(userRole);
        return userRepository.save(user);
    }

    public User getProfile(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User updateProfile(String email, User updatedUser) {
        User user = getProfile(email);
        user.setUsername(updatedUser.getUsername());
        return userRepository.save(user);
    }
}
