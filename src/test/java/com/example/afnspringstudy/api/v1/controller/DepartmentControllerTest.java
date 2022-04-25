package com.example.afnspringstudy.api.v1.controller;

import com.example.afnspringstudy.api.v1.entity.Department;
import com.example.afnspringstudy.api.v1.error.DepartmentNotFoundException;
import com.example.afnspringstudy.api.v1.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

     // Mock the service layer
    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Consulting")
                .departmentId(1L)
                .departmentCode("Co-983")
                .departmentAddress("Banjul")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department departmentInput = Department.builder()
                .departmentName("Consulting")
                .departmentId(1L)
                .departmentCode("Co-983")
                .departmentAddress("Banjul")
                .build();

        Mockito.when(departmentService.saveDepartment(departmentInput)).thenReturn(department);
        //mock the post request
//        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"Consulting\",\n" +
                        "    \"departmentAddress\": \"Banjul\",\n" +
                        "    \"departmentCode\": \"Co-983\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(
                get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}