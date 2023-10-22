package com.example.questionbankmanagementsystem.Controllers;

import com.example.questionbankmanagementsystem.Modals.Problem;
import com.example.questionbankmanagementsystem.Services.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/apis/v1/problems")
public class ProblemController{


    @Autowired
    private ProblemService problemService;

    @GetMapping
    public ResponseEntity<List<Problem>> getProblemList(){
        return ResponseEntity.ok( null );
    }

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem){
        return ResponseEntity.ok(problemService.saveProblem(problem));
    }
}
