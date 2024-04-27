package com.codeaddiction.controller;

import com.codeaddiction.model.CandidateModel;
import com.codeaddiction.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    Logger logger = LoggerFactory.getLogger(CandidateController.class);
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CandidateModel> getCandidateById(@PathVariable Long id){
        return new ResponseEntity<>(candidateService.getCandidateById(id),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addCandidate(@RequestBody CandidateModel model){
        return new ResponseEntity<>(candidateService.saveNewCandidate(model),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCandidate(@PathVariable Long id,@RequestBody CandidateModel model){
        return new ResponseEntity<>(candidateService.updateCandidate(id,model), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateModel>> getAllCandidates(){
        return new ResponseEntity<>(this.candidateService.getAllCandidateList(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCandidtateById(@PathVariable Long id){
        return new ResponseEntity<>(this.candidateService.deleteCandidtateById(id),HttpStatus.OK);
    }








}
