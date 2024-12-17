package com.healthcare.patient.core.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ContactDetails {
    private String email;
    private String phoneNumber;
}
