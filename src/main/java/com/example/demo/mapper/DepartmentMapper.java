package com.example.demo.mapper;

import com.example.demo.dao.Department;
import com.example.demo.dto.DepartmentDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    List<DepartmentDTO> toDTOs(List<Department> departments);
}
