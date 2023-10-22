package com.example.questionbankmanagementsystem.Services;

import com.example.questionbankmanagementsystem.Modals.Problem;
import com.example.questionbankmanagementsystem.Modals.TestCases;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemService{
    @PersistenceContext
    private final EntityManager entityManager;

    ProblemService(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public Problem saveProblem(Problem problem){
        if (problem.getTestCasesList()!=null) {
            for (TestCases testCase : problem.getTestCasesList()) {
                testCase.setProblem(problem);
            }
        }
        entityManager.persist(problem);
        return entityManager.find(Problem.class,problem.getProblemId( ));
    }

    @Transactional
    public List<Problem> getProblemList(){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder( );
        CriteriaQuery<Problem> criteriaQuery=criteriaBuilder.createQuery(Problem.class);
        Root<Problem> root=criteriaQuery.from(Problem.class);
        return entityManager.createQuery(criteriaQuery).getResultList( );
    }

    @Transactional
    public Optional<Problem> getProblemById(long problemId){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder( );
        CriteriaQuery<Problem> criteriaQuery=criteriaBuilder.createQuery(Problem.class);
        Root<Problem> root=criteriaQuery.from(Problem.class);
        Predicate problemIdPredicate=criteriaBuilder.equal(root.get("id"),problemId);
        criteriaQuery.where(problemIdPredicate);
        List<Problem> problems=entityManager.createQuery(criteriaQuery).getResultList( );
        return problems.size( )==1?Optional.ofNullable(problems.get(0)):Optional.empty( );
    }
}
