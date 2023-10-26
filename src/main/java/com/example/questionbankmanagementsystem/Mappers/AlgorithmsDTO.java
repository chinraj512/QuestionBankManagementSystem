package com.example.questionbankmanagementsystem.Mappers;

import com.example.questionbankmanagementsystem.Modals.Algorithm;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class AlgorithmsDTO{

    private long editorialId;

    private List<Algorithm> algorithmList;
}
