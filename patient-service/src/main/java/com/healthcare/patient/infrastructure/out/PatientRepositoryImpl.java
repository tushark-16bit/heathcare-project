package com.healthcare.patient.infrastructure.out;

import com.healthcare.patient.application.port.out.PatientRepository;
import com.healthcare.patient.core.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    @Override
    public Patient findById(String id) {
        return new Patient("1", "Tushar", 28);
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public void deletePatient(String id) {

    }

    @Override
    public void updatePatient(String id, Patient patient) {

    }
}
