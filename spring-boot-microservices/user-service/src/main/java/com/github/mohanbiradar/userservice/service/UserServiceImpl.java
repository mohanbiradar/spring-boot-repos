package com.github.mohanbiradar.userservice.service;

import com.github.mohanbiradar.userservice.model.Users;
import com.github.mohanbiradar.userservice.repository.UserRepository;
import com.github.mohanbiradar.userservice.vo.Department;
import com.github.mohanbiradar.userservice.vo.UserDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Value("${department.service.url}")
    private String departmentServiceUrl;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public Users save(Users users) {
        log.info("Inside save user of UserServiceImpl");
        return userRepository.save(users);
    }

    public Optional<Users> findUserById(Long userId) {
        log.info("Inside findUserById of UserServiceImpl");
        return userRepository.findById(userId);
    }

    public UserDepartment getUserWithDepartment(Long userId) {
        UserDepartment userDepartment = new UserDepartment();

        Optional<Users> user = Optional.ofNullable(userRepository.findById(userId).orElseThrow(IllegalArgumentException::new));
        Department department = restTemplate.getForObject(departmentServiceUrl + user.get().getDepartmentId(), Department.class);

        userDepartment.setDepartment(department);
        userDepartment.setUsers(user.get());
        return userDepartment;
    }
}
