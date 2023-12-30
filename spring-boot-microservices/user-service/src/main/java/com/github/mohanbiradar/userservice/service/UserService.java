package com.github.mohanbiradar.userservice.service;

import com.github.mohanbiradar.userservice.model.Users;
import com.github.mohanbiradar.userservice.vo.UserDepartment;

import java.util.Optional;

public interface UserService {
    Users save(Users users);

    Optional<Users> findUserById(Long userId);

    UserDepartment getUserWithDepartment(Long userId);
}
