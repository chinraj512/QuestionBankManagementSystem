package com.example.questionbankmanagementsystem.Services;

import com.example.questionbankmanagementsystem.Modals.Problem;
import com.example.questionbankmanagementsystem.Modals.TestCases;
import jakarta.persistence.EntityManager;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemService{
    private final EntityManager entityManager;

    ProblemService(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public Problem saveProblem(Problem problem){
        // Ensure that the TestCases have a reference to the parent Problem
        if (problem.getTestCasesList() != null) {
            for (TestCases testCase : problem.getTestCasesList()) {
                testCase.setProblem(problem);
            }
        }
        entityManager.persist(problem);
        return  problem;
    }
}
