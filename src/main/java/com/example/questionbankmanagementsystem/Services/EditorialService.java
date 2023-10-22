package com.example.questionbankmanagementsystem.Services;

import com.example.questionbankmanagementsystem.Modals.Editorial;
import com.example.questionbankmanagementsystem.Modals.Problem;
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
public class EditorialService{

    @PersistenceContext
    private final EntityManager entityManager;

    EditorialService(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public Optional<Editorial> getEditorialByProblemId(long problemId){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder( );
        CriteriaQuery<Editorial> criteriaQuery=criteriaBuilder.createQuery(Editorial.class);
        Root<Editorial> root=criteriaQuery.from(Editorial.class);
        Predicate problemIdPredicate=criteriaBuilder.equal(root.get("id"),problemId);
        criteriaQuery.where(problemIdPredicate);
        List<Editorial> editorials=entityManager.createQuery(criteriaQuery).getResultList();
        return editorials.size( )==1?Optional.ofNullable(editorials.get(0)):Optional.empty();
    }

    @Transactional
    public Editorial addEditorial (Editorial requestedEditorial){
        entityManager.persist(requestedEditorial);
        return entityManager.find(Editorial.class,requestedEditorial.getId());
    }
}
