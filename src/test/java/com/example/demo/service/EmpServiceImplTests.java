package com.example.demo.service;

import com.example.demo.dao.Department;
import com.example.demo.dao.EmpEntity;
import com.example.demo.dao.Gender;
import com.example.demo.dao.repo.EmpRepository;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.GenderDTO;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.impl.DepartmentServiceImpl;
import com.example.demo.service.impl.EmpServiceImpl;
import com.example.demo.service.impl.GenderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceImplTests {

    @InjectMocks
    EmpServiceImpl empServiceImpl;
    @Mock
    private EmpRepository empRepository;
    @Mock
    private EmpMapper empMapper;
    @Mock
    private DepartmentServiceImpl departmentService;
    @Mock
    private GenderServiceImpl genderService;

    @Test
    public void getAll() {
        List<EmpEntity> empEntities=new ArrayList<>();
        empEntities.add(getEmpEntity());

        List<EmpDTO> empDTOS=new ArrayList<>();
        empDTOS.add(getEmpDTO());

        when(empRepository.findAll()).thenReturn(empEntities);
        when(empMapper.toDTOs(empEntities)).thenReturn(empDTOS);
        assertEquals(empDTOS,empServiceImpl.getAll());
    }

    @Test
    public void createEmp(){
        EmpEntity empEntity=getEmpEntity();
        EmpDTO empDTO=getEmpDTO();

        when(empMapper.toEntity(any(EmpDTO.class))).thenReturn(empEntity);
        when(empRepository.save(any(EmpEntity.class))).thenReturn(empEntity);
        when(empMapper.toDTO(any(EmpEntity.class))).thenReturn(empDTO);
    }

    private EmpEntity getEmpEntity(){
        EmpEntity emp=new EmpEntity();
        emp.setId(1l);
        emp.setFName("Raj");
        emp.setLName("Kumar");
        emp.setDob( Date.valueOf("1988-11-11"));
        Department sales=new Department();
        sales.setId(1l);
        sales.setName("Sales");
        emp.setDepartment(sales);
        Gender male=new Gender();
        male.setId(1l);
        male.setName("Male");
        emp.setGender(male);
        return emp;
    }
    private EmpDTO getEmpDTO(){
        EmpDTO empDTO=new EmpDTO();
        empDTO.setId(1l);
        empDTO.setFName("Raj");
        empDTO.setLName("Kumar");
        empDTO.setDob( Date.valueOf("1988-11-11"));
        DepartmentDTO salesDTO=new DepartmentDTO();
        salesDTO.setId(1l);
        salesDTO.setName("Sales");
        empDTO.setDepartment(salesDTO);
        GenderDTO maleDTO=new GenderDTO();
        maleDTO.setId(1l);
        maleDTO.setName("Male");
        empDTO.setGender(maleDTO);
        return empDTO;
    }
}
