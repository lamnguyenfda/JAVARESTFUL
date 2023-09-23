package com.demolambda.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class staff {
    private String name ;
    private Double Marks;
    private Boolean Gender;
    private Contact contracts;
    private List<String> subjects;
}
