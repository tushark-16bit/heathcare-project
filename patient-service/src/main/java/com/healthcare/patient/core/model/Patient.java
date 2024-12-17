package com.healthcare.patient.core.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Patient {

    private String id;
    private String name;
    private int age;
}
