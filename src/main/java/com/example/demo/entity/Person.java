package com.example.demo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "person")
public class Person {

    private String name;

    private String lastname;
}
