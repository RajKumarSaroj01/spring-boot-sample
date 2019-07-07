package com.example.demo.service;

import com.example.demo.dao.Gender;
import com.example.demo.dao.repo.GenderRepository;
import com.example.demo.dto.GenderDTO;
import com.example.demo.mapper.GenderMapper;
import com.example.demo.service.impl.GenderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenderServiceImplTests {

    @InjectMocks
    private GenderServiceImpl genderServiceImpl;
    @Mock
    private GenderRepository genderRepository;
    @Mock
    private GenderMapper genderMapper;

    @Test
    public void getAll() {
        List<Gender> genders=new ArrayList<>() ;
        Gender male=new Gender();
        male.setId(1l);
        male.setName("Male");
        Gender female=new Gender();
        female.setId(2l);
        female.setName("Female");
        genders.add(male);
        genders.add(female);

        List<GenderDTO> genderDTOS=new ArrayList<>() ;
        GenderDTO maleDTO=new GenderDTO();
        maleDTO.setId(1l);
        maleDTO.setName("Male");
        GenderDTO femaleDTO=new GenderDTO();
        femaleDTO.setId(2l);
        femaleDTO.setName("Female");
        genderDTOS.add(maleDTO);
        genderDTOS.add(femaleDTO);

        when(genderRepository.findAll()).thenReturn(genders);
        when(genderMapper.toGenders(genders)).thenReturn(genderDTOS);
        assertEquals(genderDTOS,genderServiceImpl. getAll());
    }
    @Test
    public void getGender() {
        Gender gender=new Gender();
        gender.setId(1l);
        gender.setName("Male");

        GenderDTO genderDTO=new GenderDTO();
        genderDTO.setId(1l);
        genderDTO.setName("Male");

        when(genderRepository.findById(anyLong())).thenReturn(Optional.of(gender));
        when(genderMapper.toDTO(any(Gender.class))).thenReturn(genderDTO);
        assertEquals(genderDTO,genderServiceImpl.getGender(anyLong()));
    }
}
