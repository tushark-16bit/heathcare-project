package com.healthcare.patient.infrastructure.in;

import com.healthcare.patient.application.port.in.PatientUseCase;
import com.healthcare.patient.core.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientUseCase patientUseCase;

    public PatientController(PatientUseCase patientUseCase) {
        this.patientUseCase = patientUseCase;
    }


    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") String id) {
        return patientUseCase.getPatientById(id);
    }
}
