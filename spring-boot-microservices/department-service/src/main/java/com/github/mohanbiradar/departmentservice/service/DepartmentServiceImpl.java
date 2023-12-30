package com.github.mohanbiradar.departmentservice.service;

import com.github.mohanbiradar.departmentservice.model.Department;
import com.github.mohanbiradar.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Inside save department of DepartmentServiceImpl");
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById of DepartmentServiceImpl");
        return departmentRepository.findById(departmentId);
    }
}
