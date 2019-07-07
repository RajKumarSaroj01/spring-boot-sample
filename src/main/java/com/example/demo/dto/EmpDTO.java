package com.example.demo.dto;

import lombok.Data;

import java.sql.Date;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Data
public class EmpDTO {
    private Long id;
    private String fName;
    private String lName;
    private GenderDTO gender;
    private Date dob;
    private DepartmentDTO department;
}
