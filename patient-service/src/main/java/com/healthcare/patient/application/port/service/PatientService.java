package com.healthcare.patient.application.port.service;

import com.healthcare.patient.application.port.in.PatientUseCase;
import com.healthcare.patient.application.port.out.PatientRepository;
import com.healthcare.patient.core.model.Patient;
import com.healthcare.patient.core.service.PatientDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientUseCase {

    private final PatientRepository repository;
    private final PatientDomainService domainService;

    public PatientService(PatientRepository repository, PatientDomainService domainService) {
        this.repository = repository;
        this.domainService = domainService;
    }


    @Override
    public Patient getPatientById(String id) {
        // if not found, return not found exception;
        return repository.findById(id);
    }

    @Override
    public void registerPatient(Patient patient) {
        if (domainService.isValidPatient(patient)) {
            repository.addPatient(patient);
        } else throw new IllegalArgumentException("Invalid");
    }

    @Override
    public void updatePatient(String id, Patient updatedPatient) {
        if (domainService.isValidPatient(updatedPatient)) {
            repository.updatePatient(id, updatedPatient);
        } else throw new IllegalArgumentException("Invalid");
    }

    @Override
    public void deletePatient(String id) {
        repository.deletePatient(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return repository.getAllPatients();
    }
}
