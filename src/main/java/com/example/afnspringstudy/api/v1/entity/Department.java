package com.example.afnspringstudy.api.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data // Added to replace constructor, getters, setters, equals, hashcode etc.
@NoArgsConstructor // default constructor added
@AllArgsConstructor
@Builder //Implements an entire builder pattern
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Department name required")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
