package com.example.demo.service;

import com.example.demo.dto.EmpDTO;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
public interface  EmpService {

    List<EmpDTO> getAll();
    EmpDTO createEmp(EmpDTO empDTO);
}
