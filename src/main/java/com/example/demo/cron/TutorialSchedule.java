package com.example.demo.cron;

import com.example.demo.dto.PatientDTO;
import com.example.demo.service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TutorialSchedule {

    @Autowired
    PatientService patientService;

    private final static Log LOG = LogFactory.getLog(TutorialSchedule.class);

    @Scheduled(cron = "  0 0/5 * * * ? ")
    public void scheduleUsingExpression(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LOG.info("LOCAL TIME : "+localDateTime);
    }

    @Scheduled(cron = "@daily")
    ///  0 0/5 * * * ? cada 5 min
    ///  */5 * * * * * cada 5 seg
    public void resetdoItTaksAndAddToIncompleteTask(){
        LOG.info("Traigo la lista del repo");
        List<PatientDTO> patientModels = patientService.getPatientList();
//        LocalDate date = LocalDate.now();
        patientModels.forEach(x -> {
            if (x.getDisease()!=null){
                x.getDisease().getTreatment().getActionList().forEach( y -> {
                    if (!y.isDoIt()){
                        LOG.info("Entro al if METHOD y.isDoIt");
                        if (x.getIncompleteTaskList()==null){
                            LOG.info("Creo la lista IncompleteTask porque esta nula");
                            x.setIncompleteTaskList(new ArrayList<>());
                        }
                        x.getIncompleteTaskList().add(y);
//                    int index = x.getIncompleteTaskList().indexOf(y);
//                    x.getIncompleteTaskList().get(index).setInit(date);
                    }
                    LOG.info("cambio el " + y.isDoIt() + " por false");
                    y.setDoIt(false);
                });
            }
            LOG.info("El patient a guardar es " + x);
            patientService.addPatient(x);
        });
        LOG.info("termino todo el ciclo");
    }



}
