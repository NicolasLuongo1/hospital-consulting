package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(value = "treatment")
public class Treatment {

    @Id
    private String idTreatment;

    private String name;

    private Date init;

    private Date end;

    private List<Action> actionList;
}
