package com.healthcare.patient.application.port.in;

import com.healthcare.patient.core.model.Patient;

import java.util.List;

public interface PatientUseCase {

    Patient getPatientById(String id);

    void registerPatient(Patient patient);

    void updatePatient(String id, Patient updatedPatient);

    void deletePatient(String id);

    List<Patient> getAllPatients();
}
