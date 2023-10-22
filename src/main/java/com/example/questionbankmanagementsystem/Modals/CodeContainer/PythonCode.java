package com.example.questionbankmanagementsystem.Modals.CodeContainer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("python")
public class PythonCode extends Code{
    private int pythonVersion;
}
