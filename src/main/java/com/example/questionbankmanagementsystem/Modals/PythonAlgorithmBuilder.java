package com.example.questionbankmanagementsystem.Modals;

public class PythonAlgorithmBuilder implements AlgorithmBuilder{
    private Algorithm algorithm;

    public PythonAlgorithmBuilder() {
        algorithm = new Algorithm();
        algorithm.setLanguage("Python");
    }

    @Override
    public Algorithm build() {
        return algorithm;
    }


    @Override
    public AlgorithmBuilder setCode(String code) {
        algorithm.setCode(code);
        return this;
    }
}
