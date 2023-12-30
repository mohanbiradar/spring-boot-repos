package com.github.mohanbiradar.departmentservice.controller;

import com.github.mohanbiradar.departmentservice.model.Department;
import com.github.mohanbiradar.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside save method of DepartmentController");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById Method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

}
