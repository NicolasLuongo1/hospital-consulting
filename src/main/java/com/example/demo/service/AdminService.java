package com.example.demo.service;

import com.example.demo.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO addAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAdminList();

}

