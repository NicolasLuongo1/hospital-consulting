package com.example.demo.mapper;

import com.example.demo.dto.DiseaseDTO;
import com.example.demo.entity.Disease;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiseaseMapper {
    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    Disease toEntity(DiseaseDTO diseaseDTO);
    DiseaseDTO toModel(Disease disease);
}