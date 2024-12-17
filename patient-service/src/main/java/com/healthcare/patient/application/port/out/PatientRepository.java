package com.healthcare.patient.application.port.out;

import com.healthcare.patient.core.model.Patient;

import java.util.List;

public interface PatientRepository {

    Patient findById(String id);

    List<Patient> getAllPatients();

    void addPatient(Patient patient);

    void deletePatient(String id);

    void updatePatient(String id, Patient patient);
}
