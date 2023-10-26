package com.example.questionbankmanagementsystem.Modals;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
}
