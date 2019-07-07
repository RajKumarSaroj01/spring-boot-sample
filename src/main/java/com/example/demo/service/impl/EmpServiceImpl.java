package com.example.demo.service.impl;

import com.example.demo.dao.EmpEntity;
import com.example.demo.dao.repo.EmpRepository;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.GenderDTO;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    private EmpRepository empRepository;
    private EmpMapper empMapper;
    private DepartmentServiceImpl departmentService;
    private GenderServiceImpl genderService;

    public EmpServiceImpl( EmpRepository empRepository,EmpMapper empMapper,DepartmentServiceImpl departmentService,GenderServiceImpl genderService){
        this.empRepository=empRepository;
        this.empMapper=empMapper;
        this.departmentService=departmentService;
        this.genderService=genderService;
    }

    @Override
    public List<EmpDTO> getAll() {
        List<EmpDTO> empDTOS=new ArrayList<>() ;
        try{
            List<EmpEntity> empEntities=empRepository.findAll();
            empDTOS=empMapper.toDTOs(empEntities);
        }catch (Exception e){
            log.error("");
        }finally {
            log.error("");
        }
        return empDTOS;
    }

    @Override
    public EmpDTO createEmp(EmpDTO empDTO) {
        // validations
        if(StringUtils.isEmpty(empDTO.getFName()) || empDTO.getDob()==null || empDTO.getDepartment().getId()==null
                || empDTO.getGender().getId()==null)
        {
            log.error("Missing required information");
            // TODO
            // throw some exception

        }
        if(!isValidDepartment(empDTO.getDepartment().getId())) {
            log.error("Not a valid department");
            // break the execution and throw Exception
        }
        if(!isValidGender(empDTO.getGender().getId())){
            log.error("Not a valid gender");
            // break the execution and  throw Exception
        }
      EmpEntity empEntity=  empMapper.toEntity(empDTO);
        empEntity=  empRepository.save(empEntity);
        return empMapper.toDTO(empEntity);
    }

    private Boolean isValidDepartment(Long id){
        DepartmentDTO department=departmentService.getDepartment(id);
        if(department==null )
            return Boolean.FALSE;
       return Boolean.TRUE ;
    }
    private Boolean isValidGender(Long id){
        GenderDTO gender=genderService.getGender(id);
        if(gender==null )
            return Boolean.FALSE;
        return Boolean.TRUE ;
    }
}
