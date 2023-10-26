package com.example.questionbankmanagementsystem.Services;

import com.example.questionbankmanagementsystem.Modals.Problem;
import com.example.questionbankmanagementsystem.Modals.Submission;
import com.example.questionbankmanagementsystem.Modals.TestCases;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubmissionService{

    @PersistenceContext
    private final EntityManager entityManager;

    SubmissionService(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public List<Submission> getProblemSubmissions(long problemId){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder( );
        CriteriaQuery<Submission> criteriaQuery=criteriaBuilder.createQuery(Submission.class);
        Root<Submission> root=criteriaQuery.from(Submission.class);
        return entityManager.createQuery(criteriaQuery).getResultList( );
    }

    @Transactional
    public Submission addSubmissionForProblem(Submission submission){
        entityManager.persist(submission);
        return entityManager.find(Submission.class,submission.getId());
    }
}
