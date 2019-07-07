package com.example.demo.service.impl;

import com.example.demo.dao.Department;
import com.example.demo.dao.repo.DepartmentRepository;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,DepartmentMapper departmentMapper){
        this.departmentRepository=departmentRepository;
        this.departmentMapper=departmentMapper;
    }
    @Override
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> departmentDTOS=new ArrayList<>() ;
        try{
            List<Department> departments=departmentRepository.findAll();
            departmentDTOS=departmentMapper.toDTOs(departments);
        }catch (Exception e){
            log.error("");
        }finally {
            log.error("");
        }
        return departmentDTOS;
    }

    @Override
    public DepartmentDTO getDepartment(Long id) {
        if(id!=null) {
            Optional<Department> result = departmentRepository.findById(id);
            if (result.isPresent())
                return departmentMapper.toDTO(result.get());
        }
        return null;
    }
}
