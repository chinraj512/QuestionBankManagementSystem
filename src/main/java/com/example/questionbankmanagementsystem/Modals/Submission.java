package com.example.questionbankmanagementsystem.Modals;

import com.example.questionbankmanagementsystem.Modals.Utils.SubmissionStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Submission{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    SubmissionStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String runTime;

    private String memory;

    @Lob
    private String language;
}
