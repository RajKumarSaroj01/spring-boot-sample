package com.example.demo.mapper;

import com.example.demo.dao.Gender;
import com.example.demo.dto.GenderDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderDTO toDTO(Gender gender);
    List<GenderDTO> toGenders(List<Gender> genders);
}
