package com.healthcare.patient.core.service;

import com.healthcare.patient.core.model.ContactDetails;
import com.healthcare.patient.core.model.Patient;
import org.springframework.stereotype.Service;

// All buisness validations interacting with just the Domain Object or Rule Decision for Domain object
@Service
public class PatientDomainService {

    public boolean isValidPatient(Patient patient) {
        return patient.getName() != null && !patient.getName().isEmpty() && isValidAge(patient.getAge())
                && validateContactDetails(patient.getContactDetails());
    }

    public boolean validateContactDetails(ContactDetails contactDetails) {
        return contactDetails != null
                && contactDetails.getEmail() != null && !contactDetails.getEmail().isEmpty() && validEmailAddress(contactDetails.getEmail())
                && contactDetails.getPhoneNumber() != null && !contactDetails.getPhoneNumber().isEmpty() && validPhoneNumber(contactDetails.getPhoneNumber());
    }

    public boolean validEmailAddress(String emailAddress) {
        return emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[0-9]{1,15}$");
    }

    public boolean isValidAge(int age) {
        return age > 0 && age <= 150;
    }
}
