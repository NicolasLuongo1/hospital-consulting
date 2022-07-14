package com.example.demo.mapper;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toModel(Patient patient);

}