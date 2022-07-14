package com.example.demo.service;


import com.example.demo.dto.ActionDTO;
import com.example.demo.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO addPatient(PatientDTO patientDTO);
    List<PatientDTO> getPatientList();
    PatientDTO findById(String id);

    void deletePatient(String id);
    List<PatientDTO> findAllByServe(boolean choice);

    List<ActionDTO> findTasksById(String id);
    PatientDTO findByDni(long dni);

    List<ActionDTO> findIncompleteTaskById(String id);

    List<ActionDTO> findCompleteTaskById(String id);

}