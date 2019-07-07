package com.example.demo.service;

import com.example.demo.dao.Department;
import com.example.demo.dao.Gender;
import com.example.demo.dao.repo.DepartmentRepository;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.GenderDTO;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTests {

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private DepartmentMapper departmentMapper;

    @Test
    public void getAll() {
        List<Department> departments=new ArrayList<>() ;
        Department sales=new Department();
        sales.setId(1l);
        sales.setName("Sales");
        Department finance=new Department();
        finance.setId(2l);
        finance.setName("Finance");
        departments.add(sales);
        departments.add(finance);

        List<DepartmentDTO> departmentDTOS=new ArrayList<>() ;
        DepartmentDTO salesDTO=new DepartmentDTO();
        salesDTO.setId(1l);
        salesDTO.setName("Sales");
        DepartmentDTO financeDTO=new DepartmentDTO();
        financeDTO.setId(2l);
        financeDTO.setName("Finance");
        departmentDTOS.add(salesDTO);
        departmentDTOS.add(financeDTO);

        when(departmentRepository.findAll()).thenReturn(departments);
        when(departmentMapper.toDTOs(departments)).thenReturn(departmentDTOS);
        assertEquals(departmentDTOS,departmentServiceImpl.getAll());
    }
    @Test
    public void getDepartment() {
        Department sales=new Department();
        sales.setId(1l);
        sales.setName("Sales");

        DepartmentDTO salesDTO=new DepartmentDTO();
        salesDTO.setId(1l);
        salesDTO.setName("Sales");

        when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(sales));
        when(departmentMapper.toDTO(any(Department.class))).thenReturn(salesDTO);
        assertEquals(salesDTO,departmentServiceImpl.getDepartment(anyLong()));
    }
}
