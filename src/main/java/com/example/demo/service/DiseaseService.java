package com.example.demo.service;

import com.example.demo.dto.DiseaseDTO;

import java.util.List;

public interface DiseaseService {
    DiseaseDTO addDisease(DiseaseDTO diseaseDTO);
    List<DiseaseDTO> getDiseaseList();
    DiseaseDTO findById(String id);
}
