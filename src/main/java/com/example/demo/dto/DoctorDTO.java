package com.example.demo.dto;

import lombok.*;

import java.util.HashMap;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO extends PersonDTO {

    private String idDoctor;
    ///Todo revisar sobre el Hashmap
    private HashMap<String, PatientDTO> patients;
}