package com.github.mohanbiradar.departmentservice.service;

import com.github.mohanbiradar.departmentservice.model.Department;

import java.util.Optional;

public interface DepartmentService {
    Department save(Department department);

    Optional<Department> findDepartmentById(Long departmentId);
}
