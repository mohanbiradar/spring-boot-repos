package com.github.mohanbiradar.userservice.vo;

import com.github.mohanbiradar.userservice.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartment {
    private Users users;
    private Department department;
}
