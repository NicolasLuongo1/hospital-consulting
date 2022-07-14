package com.example.demo.service.impl;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        adminRepository.save(INSTANCE.toEntity(adminDTO));
        return adminDTO;
    }

    @Override
    public List<AdminDTO> getAdminList() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDTO> adminDTOS = new ArrayList<>();
        admins.forEach(x-> adminDTOS.add(INSTANCE.toModel(x)));
        return adminDTOS;
    }
}
