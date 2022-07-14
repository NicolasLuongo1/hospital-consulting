package com.example.demo.mapper;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toEntity(DoctorDTO doctorDTO);
    DoctorDTO toModel(Doctor doctor);
}
