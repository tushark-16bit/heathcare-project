package com.healthcare.patient.core.service;

import com.healthcare.patient.core.model.Patient;

// All buisness validations interacting with just the Domain Object or Rule Decision for Domain object
public class PatientDomainService {

    public boolean isValidPatient(Patient patient) {
        return patient.getName()!=null && !patient.getName().isEmpty() && patient.getAge()>0;
    }
}
