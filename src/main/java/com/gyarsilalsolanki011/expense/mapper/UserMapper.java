package com.gyarsilalsolanki011.expense.mapper;

import com.gyarsilalsolanki011.expense.model.dto.UserDto;
import com.gyarsilalsolanki011.expense.model.entity.User;
import com.gyarsilalsolanki011.expense.model.enums.Role;

public class UserMapper {
    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getEmail(),
                userDto.getUsername(),
                userDto.getPassword(),
                Role.USER //Default Role
        );
    }
}
