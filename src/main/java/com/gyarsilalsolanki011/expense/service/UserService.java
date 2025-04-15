package com.gyarsilalsolanki011.expense.service;

import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        // Handle registration logic here (password encoding, etc.)
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NullPointerException("User Not found with this Username "+username));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("User Not found with email "+email));
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void deleteUser(Long id) {

    }

    public User changeRole(User user) {
        return null;
    }
}
