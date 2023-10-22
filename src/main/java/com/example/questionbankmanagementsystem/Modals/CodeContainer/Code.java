package com.example.questionbankmanagementsystem.Modals.CodeContainer;

import jakarta.persistence.*;

@Entity
public class Code{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Lob
    private String Code;

    private String timeComplexity;

    private String spaceComplexity;
}
