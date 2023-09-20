package com.demolambda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class Student {
    private String name  ; 
    private Boolean Gender;
    private Double Gpa;
}
