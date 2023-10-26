package com.example.questionbankmanagementsystem.Modals.CodeBuilder;

import com.example.questionbankmanagementsystem.Modals.CodeContainer.Code;

public class PythonCodeBuilder implements CodeBuilder{
    private Code code = new Code();

    public PythonCodeBuilder() {
        code.setLanguage("Java");
    }

    @Override
    public Code build() {
        return code;
    }

    @Override
    public CodeBuilder setCode(String code) {
        this.code.setCode(code);
        return this;
    }

    @Override
    public CodeBuilder setTimeComplexity(String timeComplexity) {
        this.code.setTimeComplexity(timeComplexity);
        return this;
    }

    @Override
    public CodeBuilder setSpaceComplexity(String spaceComplexity) {
        this.code.setSpaceComplexity(spaceComplexity);
        return this;
    }

    @Override
    public CodeBuilder setLanguage(String language) {
        this.code.setLanguage(language);
        return this;
    }
}
