package com.example.afnspringstudy.api.v1.service;

import com.example.afnspringstudy.api.v1.entity.Department;
import com.example.afnspringstudy.api.v1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public  List<Department> getDepartments();
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    public Department getDepartmentByName(String departmentName);
}
