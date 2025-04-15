package com.gyarsilalsolanki011.expense.repository;

import com.gyarsilalsolanki011.expense.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
