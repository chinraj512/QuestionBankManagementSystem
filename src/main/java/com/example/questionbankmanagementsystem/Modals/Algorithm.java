package com.example.questionbankmanagementsystem.Modals;

import jakarta.persistence.*;

@Entity
public class Algorithm{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    @Lob
    private String intution;

    @Lob
    private String alogorithm;

    private String language;

    @Lob
    private String code;
}
