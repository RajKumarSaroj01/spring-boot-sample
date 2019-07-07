package com.example.demo.mapper;

import com.example.demo.dao.EmpEntity;
import com.example.demo.dto.EmpDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Mapper(componentModel = "spring")
public interface EmpMapper {

    EmpDTO toDTO(EmpEntity empEntity);

    @InheritInverseConfiguration
    EmpEntity toEntity(EmpDTO empDTO);

    List<EmpDTO> toDTOs(List<EmpEntity> empEntities);

}
