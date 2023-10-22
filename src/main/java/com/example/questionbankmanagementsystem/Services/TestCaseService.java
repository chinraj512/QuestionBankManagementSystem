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
public class TestCaseService{
    @PersistenceContext
    private final EntityManager entityManager;

    TestCaseService(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public List<TestCases> getTestCasesByProblemId(long problemId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TestCases> criteriaQuery = criteriaBuilder.createQuery(TestCases.class);
        Root<TestCases> root = criteriaQuery.from(TestCases.class);
        Predicate problemIdPredicate = criteriaBuilder.equal(root.get("problem").get("id"), problemId);
        criteriaQuery.where(problemIdPredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public Problem addTestCase(TestCases testCases){
        entityManager.persist(testCases);
        return entityManager.find(Problem.class,testCases.getId());
    }
}
