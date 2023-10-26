package com.example.questionbankmanagementsystem.Controllers;

import com.example.questionbankmanagementsystem.Mappers.AlgorithmsDTO;
import com.example.questionbankmanagementsystem.Modals.Algorithm;
import com.example.questionbankmanagementsystem.Modals.CodeContainer.Code;
import com.example.questionbankmanagementsystem.Modals.Editorial;
import com.example.questionbankmanagementsystem.Services.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/apis/v1/algorithms")
public class AlgorithmController{

    @Autowired
    AlgorithmService algorithmService;

    @PostMapping("/{editorialId}")
    public ResponseEntity<Editorial> addAlgorithmsForEditorial(@RequestBody AlgorithmsDTO algorithms){
        return ResponseEntity.ok(algorithmService.addAlgorithmsForEditorial(algorithms));
    }

    @PostMapping("/addCode/{algorithmId}")
    public ResponseEntity<Algorithm> addCodeToAlgorithm(Code code){
        return null;
    }
}
