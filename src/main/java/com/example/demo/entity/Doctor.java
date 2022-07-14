package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "doctor")
public class Doctor extends Person{

    @Id
    private String idDoctor;
    private HashMap<String, Patient> patients;
}
