package com.example.demo.mapper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntity(PersonDTO personDTO);
    PersonDTO toModel(Person person);
}
