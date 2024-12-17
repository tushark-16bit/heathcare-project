package com.healthcare.patient.infrastructure.out;

import com.healthcare.patient.application.port.out.PatientRepository;
import com.healthcare.patient.core.model.ContactDetails;
import com.healthcare.patient.core.model.Patient;
import com.healthcare.patient.infrastructure.out.entity.PatientEntity;
import com.healthcare.patient.infrastructure.repository.PatientJPARepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    final PatientJPARepository repository;

    public PatientRepositoryImpl(PatientJPARepository repository) {
        this.repository = repository;
    }


    @Override
    public Patient findById(String id) {
        var patient = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        return toPatient(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return repository.findAll().stream()
                .map(this::toPatient)
                .collect(Collectors.toList());
    }

    @Override
    public void addPatient(Patient patient) {
        var patientEntity = toPatientEntity(patient);
        if (repository.existsById(patientEntity.getId())) {
            throw new IllegalArgumentException("Patient already exists");
        }
        repository.save(patientEntity);
    }

    @Override
    public void deletePatient(String id) {
        repository.deleteById(id);
    }

    @Override
    public void updatePatient(String id, Patient patient) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Not found");
        var patientEntity = toPatientEntity(patient);
        patientEntity.setId(id);
        repository.save(patientEntity);
    }

    private Patient toPatient(PatientEntity patientEntity) {
        return new Patient(patientEntity.getId(), patientEntity.getName(), patientEntity.getAge(),
                new ContactDetails(patientEntity.getEmailAddress(), patientEntity.getPhoneNumber()));
    }

    private PatientEntity toPatientEntity(Patient patient) {
        return new PatientEntity(patient.getId(), patient.getName(), patient.getAge(),
                patient.getContactDetails().getEmail(), patient.getContactDetails().getPhoneNumber()
        );
    }
}
