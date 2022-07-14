package com.example.demo.controller;


import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.service.AdminService;
import com.example.demo.service.DiseaseService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    DiseaseService diseaseService;

    private static final Log LOG = LogFactory.getLog(AdminController.class);


    @GetMapping("/addAdmin")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addAdmin");
        modelAndView.addObject("admin",new AdminDTO());

        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addAdmin(@ModelAttribute("admin") AdminDTO adminDTO){
        RedirectView redirectView = new RedirectView("/adminController/addAdmin");
        adminService.addAdmin(adminDTO);

        return redirectView;
    }



    @GetMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("listAction");
        modelAndView.addObject("listAction1", adminService.getAdminList());
        return modelAndView;
    }

    @GetMapping("/{doctorId}")
    public ModelAndView addPatientDoctor(@PathVariable(value = "doctorId") String id){
        ModelAndView mav = new ModelAndView("addPatientToDoctor");
        mav.addObject("doctor",doctorService.findById(id));
        LOG.info(doctorService.findById(id).getPatients());
        mav.addObject("patientsList",patientService.getPatientList());
        mav.addObject("patient",new PatientDTO());
        LOG.info(id + "  ID : addPatientDoctor ");
        return mav;
    }

    @PostMapping("/addPatientToDoctor")
    public RedirectView addPatient(@ModelAttribute("doctor") DoctorDTO doctorDTO, @ModelAttribute("patient") PatientDTO idPatient){
        LOG.info("ID DOCTOR : "+ doctorDTO.getIdDoctor());
        DoctorDTO doc = doctorService.findById(doctorDTO.getIdDoctor());
        LOG.info("El id del paciente es "+ idPatient.getIdPatient());
        PatientDTO patient = patientService.findById(idPatient.getIdPatient());
        doc.getPatients().put(patient.getIdPatient(),patient);
        doctorService.addDoctor(doc);
        return new RedirectView("/doctorController/doctor/" + doctorDTO.getIdDoctor());
    }



}

