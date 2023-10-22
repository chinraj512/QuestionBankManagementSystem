package com.example.questionbankmanagementsystem.Modals.CodeContainer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cpp")
public class CppCode extends Code{
    private double cVersion;
}
