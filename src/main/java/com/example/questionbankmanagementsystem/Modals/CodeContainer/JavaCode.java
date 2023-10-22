package com.example.questionbankmanagementsystem.Modals.CodeContainer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@DiscriminatorValue("java")
public class JavaCode extends Code{
    private double javaVersion;

    private List<String> dependecies;
}
