package com.example.afnspringstudy.api.v1.service;

import com.example.afnspringstudy.api.v1.entity.Department;
import com.example.afnspringstudy.api.v1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Banjul")
                .departmentCode("IT-092")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Department data based on the given department name")
//    @Disabled
    public void whenValidDepartmentNameThenDepartmentNameShouldBeFound(){
        String departmentName = "IT";
        Department department = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, department.getDepartmentName());
    }
}