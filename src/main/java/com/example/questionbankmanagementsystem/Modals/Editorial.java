package com.example.questionbankmanagementsystem.Modals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Editorial{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="rating")
    private float editorialRating;

    @Column(name="votes")
    private long editorialTotalVotes;

    @JsonManagedReference
    @OneToMany(mappedBy="editorial",cascade= CascadeType.PERSIST,orphanRemoval=false)
    private List<Algorithm> algorithms;
}
