package com.example.demo.mapper;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toEntity(AdminDTO adminDTO);
    AdminDTO toModel(Admin admin);
}