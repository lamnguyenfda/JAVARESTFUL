package com.demolambda.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Boolean gender;
    private Double marks;
    private Contact contacts;
    private List<String> subjects;
}
