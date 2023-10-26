package com.example.questionbankmanagementsystem.Modals.CodeBuilder;

import com.example.questionbankmanagementsystem.Modals.CodeContainer.Code;

public interface CodeBuilder{
    Code build();
    CodeBuilder setCode(String code);
    CodeBuilder setTimeComplexity(String timeComplexity);
    CodeBuilder setSpaceComplexity(String spaceComplexity);
    CodeBuilder setLanguage(String language);

}
