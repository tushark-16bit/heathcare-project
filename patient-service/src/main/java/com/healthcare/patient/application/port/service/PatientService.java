package com.healthcare.patient.application.port.service;

import com.healthcare.patient.application.port.in.PatientUseCase;
import com.healthcare.patient.application.port.out.PatientRepository;
import com.healthcare.patient.core.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientUseCase {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }


    @Override
    public Patient getPatientById(String id) {
        return repository.findById(id);
    }

    @Override
    public void registerPatient(Patient patient) {

    }

    @Override
    public void updatePatient(String id, Patient updatedPatient) {

    }

    @Override
    public void deletePatient(String id) {

    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }
}
