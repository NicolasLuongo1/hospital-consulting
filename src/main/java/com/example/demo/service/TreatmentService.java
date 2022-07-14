package com.example.demo.service;

import com.example.demo.dto.TreatmentDTO;

import java.util.List;

public interface TreatmentService {

    TreatmentDTO addTreatment(TreatmentDTO treatmentDTO);
    List<TreatmentDTO> getTreatmentList();
    TreatmentDTO findById(String id);
}