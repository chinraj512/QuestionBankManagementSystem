package com.example.questionbankmanagementsystem.Modals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @OneToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(name = "problem_id", insertable = false, updatable = false)
    private Long problemId;
}
