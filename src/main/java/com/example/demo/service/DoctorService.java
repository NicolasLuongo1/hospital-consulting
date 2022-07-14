package com.example.demo.service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;

import java.util.HashMap;
import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorDTO addDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getDoctorList();
    DoctorDTO findById(String id);

    HashMap<String, PatientDTO> getAllPatientsFalse(String id);
    HashMap<String,PatientDTO> getAllPatientsTrue(String id);
    void deletePatient(String id);
}