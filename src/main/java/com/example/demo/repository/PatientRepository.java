package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findAllByServe(boolean choice);
    Patient findByDni(long dni);
}

