package com.example.demo.mapper;

import com.example.demo.dto.TreatmentDTO;
import com.example.demo.entity.Treatment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TreatmentMapper {
    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    Treatment toEntity(TreatmentDTO treatmentDTO);
    TreatmentDTO toModel(Treatment treatment);
}