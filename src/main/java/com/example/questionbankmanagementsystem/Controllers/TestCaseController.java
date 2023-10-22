package com.example.questionbankmanagementsystem.Controllers;

import com.example.questionbankmanagementsystem.Modals.Problem;
import com.example.questionbankmanagementsystem.Modals.TestCases;
import com.example.questionbankmanagementsystem.Services.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("apis/v1/testCases")
public class TestCaseController{

    @Autowired
    TestCaseService testCaseService;

    @GetMapping("/{problemId}")
    public ResponseEntity<List<TestCases>> getTestCasesByProblemId(@PathVariable("problemId") long id){
        return ResponseEntity.ok(testCaseService.getTestCasesByProblemId(id));
    }

    @PostMapping
    public ResponseEntity<Problem> addTestCase(@RequestBody TestCases testCase){
        return ResponseEntity.ok(testCaseService.addTestCase(testCase));
    }
}
