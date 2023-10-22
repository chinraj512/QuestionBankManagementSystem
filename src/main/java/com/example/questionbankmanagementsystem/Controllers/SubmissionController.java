package com.example.questionbankmanagementsystem.Controllers;

import com.example.questionbankmanagementsystem.Modals.Submission;
import com.example.questionbankmanagementsystem.Services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/apis/v1/submissions")
public class SubmissionController{

    @Autowired
    SubmissionService submissionService;

    @GetMapping("/problemId")
    public ResponseEntity<List<Submission>> getProblemSubmissions(@PathVariable("problemId")long id){
        return ResponseEntity.ok(submissionService.getProblemSubmissions(id));
    }
}
