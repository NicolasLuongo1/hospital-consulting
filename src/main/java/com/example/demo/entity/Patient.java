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
@Document(value = "patient")
public class Patient extends Person{

    @Id
    private String idPatient;

    private long dni;

    private Date entry;

    private List<Action> incompleteTaskList;

    private boolean serve;

    private Disease disease;
}
