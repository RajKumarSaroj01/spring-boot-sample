package com.example.demo.service.impl;

import com.example.demo.dao.Gender;
import com.example.demo.dao.repo.GenderRepository;
import com.example.demo.dto.GenderDTO;
import com.example.demo.mapper.GenderMapper;
import com.example.demo.service.GenderService;
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
public class GenderServiceImpl implements GenderService{

    private GenderRepository genderRepository;
    private GenderMapper genderMapper;
    public GenderServiceImpl( GenderRepository genderRepository,GenderMapper genderMapper){
        this.genderRepository=genderRepository;
        this.genderMapper=genderMapper;
    }
    @Override
    public List<GenderDTO> getAll() {
        List<GenderDTO> genderDTOS=new ArrayList<>() ;
        try{
            List<Gender> genders=genderRepository.findAll();
            genderDTOS=genderMapper.toGenders(genders);
        }catch (Exception e){
            log.error("");
        }finally {
            log.error("");
        }
        return genderDTOS;
    }

    @Override
    public GenderDTO getGender(Long id) {
        if(id!=null) {
            Optional<Gender> result = genderRepository.findById(id);
            if (result.isPresent())
                return genderMapper.toDTO(result.get());
        }
        return null;
    }
}
