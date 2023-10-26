package com.example.questionbankmanagementsystem.Modals;

public class JavaAlgorithmBuilder implements AlgorithmBuilder{
    private Algorithm algorithm;

    public JavaAlgorithmBuilder() {
        algorithm = new Algorithm();
        algorithm.setLanguage("Java");
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
