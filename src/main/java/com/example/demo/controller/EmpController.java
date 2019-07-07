package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.GenderDTO;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmpService;
import com.example.demo.service.GenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/emp", produces = MediaType.APPLICATION_JSON_VALUE)

public class EmpController {

    private GenderService genderService;
    private DepartmentService departmentService;
    private EmpService empService;

    public EmpController(GenderService genderService,DepartmentService departmentService,EmpService empService){
     this.genderService=genderService;
     this.departmentService=departmentService;
     this.empService=empService;
    }

    @GetMapping(value = "/genders")
    public ResponseEntity<?> getGender() {
        List<GenderDTO> genders=new ArrayList<>();
       try{
           genders=genderService.getAll();
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
       }finally {

       }
        return ResponseEntity.ok().body(genders);
    }
    @GetMapping(value = "/departments")
    public ResponseEntity<?> getDepartments() {
        List<DepartmentDTO> departmentDTOS=new ArrayList<>();
        try{
            departmentDTOS=departmentService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
        }finally {

        }
        return ResponseEntity.ok().body(departmentDTOS);
    }
    @GetMapping(value = "/emps")
    public ResponseEntity<?> getEmps() {
        List<EmpDTO> empDTOS=new ArrayList<>();
        try{
            empDTOS=empService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
        }finally {

        }
        return ResponseEntity.ok().body(empDTOS);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmps(@RequestBody EmpDTO empDTO) {

        try{
            empDTO=empService.createEmp(empDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
        }finally {

        }
        return ResponseEntity.ok().body(empDTO);
    }
}
