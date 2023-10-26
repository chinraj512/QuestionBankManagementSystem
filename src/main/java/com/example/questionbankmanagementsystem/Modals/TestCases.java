package com.example.questionbankmanagementsystem.Modals;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Entity
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCases{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="problem_id")
    private Problem problem;

    private String input;

    private String output;

    @Lob
    private String explanation;

    private boolean isDescriptionTestcase;

}
