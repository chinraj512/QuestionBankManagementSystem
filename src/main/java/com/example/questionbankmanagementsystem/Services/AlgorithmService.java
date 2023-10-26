package com.example.questionbankmanagementsystem.Services;

import com.example.questionbankmanagementsystem.Mappers.AlgorithmsDTO;
import com.example.questionbankmanagementsystem.Modals.*;
import com.example.questionbankmanagementsystem.Modals.CodeContainer.Code;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlgorithmService{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EditorialService editorialService;

    private AlgorithmService(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    public Editorial addAlgorithmsForEditorial(AlgorithmsDTO algorithms){
        Editorial editorial=editorialService.getEditorialById(algorithms.getEditorialId( )).get( );
        List<Algorithm> algorithmList=algorithms.getAlgorithmList( );
        editorial.getAlgorithms().addAll(algorithmList);
        for(Algorithm algorithm:algorithmList){
            algorithm.setEditorial(editorial);
        }
        return editorialService.updateEditorial(editorial);
    }

    public Algorithm addCodeToAlgorithm(Code code){
        AlgorithmBuilder algorithmBuilder = getAlgorithmBuilder(language);
        if (algorithmBuilder != null) {
            return algorithmBuilder.setCode(code.getCode()).build();
        }
        return null; // Unsupported language
    }

    private AlgorithmBuilder getAlgorithmBuilder(String language) {
        switch (language) {
            case "Java":
                return new JavaAlgorithmBuilder();
            case "Python":
                return new PythonAlgorithmBuilder();
            // Add support for other languages as needed
            default:
                return null; // Unsupported language
        }
    }
}
