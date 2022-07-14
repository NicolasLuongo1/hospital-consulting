package com.example.demo.service.impl;


import com.example.demo.dto.DiseaseDTO;
import com.example.demo.entity.Disease;
import com.example.demo.mapper.DiseaseMapper;
import com.example.demo.repository.DiseaseRepository;
import com.example.demo.service.DiseaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("DiseaseServiceImpl")
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    @Override
    public DiseaseDTO addDisease(DiseaseDTO diseaseDTO) {
        diseaseRepository.save(INSTANCE.toEntity(diseaseDTO));
        return diseaseDTO;
    }

    @Override
    public List<DiseaseDTO> getDiseaseList() {
        List<Disease> diseases = diseaseRepository.findAll();
        List<DiseaseDTO> diseaseDTOS = new ArrayList<>();
        diseases.forEach(x -> diseaseDTOS.add(INSTANCE.toModel(x)));

        return diseaseDTOS;
    }

    @Override
    public DiseaseDTO findById(String id) {


        Optional<Disease> optionalDisease = diseaseRepository.findById(id);

        return optionalDisease.isPresent() ? INSTANCE.toModel(optionalDisease.get()) : new DiseaseDTO();
    }
}
