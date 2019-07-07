package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
public interface DepartmentService {
    List<DepartmentDTO> getAll();
    DepartmentDTO getDepartment(Long id);
}
