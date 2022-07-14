package com.example.demo.service.impl;

import com.example.demo.dto.TreatmentDTO;
import com.example.demo.entity.Treatment;
import com.example.demo.mapper.TreatmentMapper;
import com.example.demo.repository.TreatmentRepository;
import com.example.demo.service.TreatmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("TreatmentServiceImpl")
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    @Override
    public TreatmentDTO addTreatment(TreatmentDTO treatmentDTO) {
        treatmentRepository.save(INSTANCE.toEntity(treatmentDTO));
        return treatmentDTO;
    }

    @Override
    public List<TreatmentDTO> getTreatmentList() {
        List<Treatment> treatments = treatmentRepository.findAll();
        List<TreatmentDTO> treatmentDTOS = new ArrayList<>();
        treatments.forEach(x -> treatmentDTOS.add(INSTANCE.toModel(x)));
        return treatmentDTOS;
    }

    @Override
    public TreatmentDTO findById(String id) {
        Optional<Treatment> opt = treatmentRepository.findById(id);
        if (opt.isPresent()){
            return INSTANCE.toModel(opt.get());
        }else return new TreatmentDTO();
    }
}