package com.gyarsilalsolanki011.expense.mapper;

import com.gyarsilalsolanki011.expense.model.dto.RegisterRequest;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.model.enums.Role;

public class UserMapper {
    public static User mapToUser(RegisterRequest request) {
        return new User(
                request.getEmail(),
                request.getUsername(),
                request.getPassword(),
                Role.USER //Default Role
        );
    }
}
