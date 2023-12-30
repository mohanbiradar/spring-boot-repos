package com.github.mohanbiradar.userservice.controller;

import com.github.mohanbiradar.userservice.model.Users;
import com.github.mohanbiradar.userservice.service.UserService;
import com.github.mohanbiradar.userservice.vo.UserDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public Users save(@RequestBody Users users) {
        log.info("Inside save user of UserController");
        return userService.save(users);
    }

    @GetMapping("/{userId}")
    public UserDepartment getUserWithDepartment(@PathVariable("userId") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return  userService.getUserWithDepartment(userId);
    }
}
