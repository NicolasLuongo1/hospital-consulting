package com.example.demo.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActionDTO {
    private String idAction;
    private String nameAction;
    private Date init;
    private Date end;
    private boolean doIt;
}
