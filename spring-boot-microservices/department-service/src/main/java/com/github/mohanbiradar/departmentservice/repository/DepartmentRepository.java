package com.github.mohanbiradar.departmentservice.repository;

import com.github.mohanbiradar.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
