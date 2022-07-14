package com.example.demo.service.impl;


import com.example.demo.dto.ActionDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PatientServiceImpl")
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorService doctorService;

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    private static final Log LOG = LogFactory.getLog(PatientServiceImpl.class);

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {
        patientRepository.save(INSTANCE.toEntity(patientDTO));
        return patientDTO;
    }

    @Override
    public List<PatientDTO> getPatientList() {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(x-> patientDTOS.add(INSTANCE.toModel(x)));
        return patientDTOS;
    }

    public PatientDTO findById(String id){
        Optional<Patient> opt = patientRepository.findById(id);
        return INSTANCE.toModel(opt.get());

    }

    @Override
    public void deletePatient(String id) {

        doctorService.deletePatient(id);
        patientRepository.deleteById(id);

    }


    @Override
    public List<PatientDTO> findAllByServe(boolean choice) {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        patientRepository.findAllByServe(false).forEach(x-> patientDTOS.add(INSTANCE.toModel(x)));
        return patientDTOS;
    }

    @Override
    public List<ActionDTO> findTasksById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patient = INSTANCE.toModel(opt.get());
        if (patient.getDisease() != null){
            return patient.getDisease().getTreatment().getActionList();
        }
        return new ArrayList<ActionDTO>();
    }

    @Override
    public PatientDTO findByDni(long dni) {
        Patient patient = patientRepository.findByDni(dni);
        return INSTANCE.toModel(patient);
    }

    @Override
    public List<ActionDTO> findIncompleteTaskById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patientDTO = INSTANCE.toModel(opt.get());
        List<ActionDTO> tasks = patientDTO.getDisease().getTreatment().getActionList();
        List<ActionDTO> incompleteTask = new ArrayList<>();
        tasks.forEach(x -> {
            if (!x.isDoIt()){
                incompleteTask.add(x);
            }
        });
        return incompleteTask;
    }

    @Override
    public List<ActionDTO> findCompleteTaskById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patientDTO = INSTANCE.toModel(opt.get());
        List<ActionDTO> tasks = patientDTO.getDisease().getTreatment().getActionList();
        List<ActionDTO> completeTask = new ArrayList<>();
        tasks.forEach(x -> {
            if (x.isDoIt()){
                completeTask.add(x);
            }
        });
        return completeTask;
    }


}
