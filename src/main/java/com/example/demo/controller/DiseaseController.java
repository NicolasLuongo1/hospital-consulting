package com.example.demo.controller;


import com.example.demo.dto.DiseaseDTO;
import com.example.demo.dto.TreatmentDTO;
import com.example.demo.service.DiseaseService;
import com.example.demo.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/diseaseController")
public class DiseaseController {

    @PostMapping("/addJson")
    public void addDisease(DiseaseDTO diseaseDTO){

        diseaseService.addDisease(diseaseDTO);

    }

    @Autowired
    DiseaseService diseaseService;

    @Autowired
    TreatmentService treatmentService;



    @GetMapping("/addDisease")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addDisease");
        mav.addObject("disease", new DiseaseDTO());
        mav.addObject("treatment",new TreatmentDTO());
        mav.addObject("treatmentList",treatmentService.getTreatmentList());
        return mav;
    }


    @PostMapping("/add")
    public RedirectView addDisease(@ModelAttribute("disease") DiseaseDTO diseaseDTO, @ModelAttribute("treatment") TreatmentDTO treatmentDTO){
        RedirectView redirectView = new RedirectView("/diseaseController/findAll");
//        DiseaseModel disease = diseaseService.findById(diseaseModel.getIdDisease());
        diseaseDTO.setTreatment(treatmentService.findById(treatmentDTO.getIdTreatment()));
        diseaseService.addDisease(diseaseDTO);
        return redirectView;
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listDisease");
        modelAndView.addObject("listDisease", diseaseService.getDiseaseList());

        return modelAndView;
    }




}
