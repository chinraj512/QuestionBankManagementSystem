package com.example.questionbankmanagementsystem.Modals.CodeContainer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Code{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String language;

    @Lob
    private String Code;

    private String timeComplexity;

    private String spaceComplexity;
}
