package com.healthcare.patient.infrastructure.in;

import com.healthcare.patient.application.port.in.PatientUseCase;
import com.healthcare.patient.core.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientUseCase.getAllPatients();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientUseCase.registerPatient(patient);
    }

    @PutMapping("/patients")
    public void updatePatient(@RequestBody Patient patient) {
        patientUseCase.updatePatient(patient.getId(), patient);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable("id") String id) {
        patientUseCase.deletePatient(id);
    }
}
