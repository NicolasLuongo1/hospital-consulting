package com.example.demo.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDTO {
    private String idTreatment;
    private String name;
    private List<ActionDTO> actionList;
    private Date init;
    private Date end;
}
