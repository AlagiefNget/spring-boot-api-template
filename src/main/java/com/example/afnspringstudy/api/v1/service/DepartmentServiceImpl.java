package com.example.afnspringstudy.api.v1.service;

import com.example.afnspringstudy.api.v1.entity.Department;
import com.example.afnspringstudy.api.v1.error.DepartmentNotFoundException;
import com.example.afnspringstudy.api.v1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw  new DepartmentNotFoundException("Department not available");
        }else{
            return department.get();
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dept = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(dept.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dept.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(dept.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(dept.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dept.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dept);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
//        return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName); //jpql query
    }
}