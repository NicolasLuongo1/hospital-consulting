package com.example.demo.service;

import com.example.demo.dto.ActionDTO;

import java.util.List;

public interface ActionService {

    ActionDTO addAction(ActionDTO actionDTO);
    List<ActionDTO> getActionList();
    ActionDTO findById(String id);


}
