package com.example.questionbankmanagementsystem.Controllers;

import com.example.questionbankmanagementsystem.Modals.Editorial;
import com.example.questionbankmanagementsystem.Services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/apis/v1/editorials")
public class EditorialController{

    @Autowired
    EditorialService editorialService;


    @GetMapping("/{problemId}")
    public ResponseEntity<Optional<Editorial>> getEditorialByProblemId(@PathVariable("problemId") long problemId){
        return ResponseEntity.ok(editorialService.getEditorialByProblemId(problemId));
    }

    @PostMapping
    public ResponseEntity<Editorial> addEditorial(@RequestBody Editorial requestedEditorial){
        return ResponseEntity.ok(editorialService.addEditorial(requestedEditorial));
    }
}
