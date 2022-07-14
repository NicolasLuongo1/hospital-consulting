package com.example.demo.mapper;

import com.example.demo.dto.ActionDTO;
import com.example.demo.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    Action toEntity(ActionDTO actionDTO);

    ActionDTO toModel(Action action);
}