package com.example.questionbankmanagementsystem.Modals;

import com.example.questionbankmanagementsystem.Modals.Utils.ProblemCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Problems")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long problemId;

    private String title;

    private ProblemCategory category;

    @Lob
    private String problemStatement;

    private String problemConstraints;

    private int likeCount;

    private int disLikeCount;

    @JsonManagedReference
    @OneToMany(mappedBy="problem",cascade= CascadeType.PERSIST,orphanRemoval=true)
    private List<TestCases> testCasesList;

}
