package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseDTO {
    private String idDisease;
    private String name;
    private TreatmentDTO treatment;
}
