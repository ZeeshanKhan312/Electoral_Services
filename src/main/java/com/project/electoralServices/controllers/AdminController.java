package com.project.electoralServices.controllers;

import com.project.electoralServices.entities.CandidateEntity;
import com.project.electoralServices.entities.VoterEntity;
import com.project.electoralServices.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/voter-list")
    public List<VoterEntity> voterList(){
        return adminServices.voterList();
    }
    @PostMapping("/add-voter")
    public void addVoter(@RequestBody VoterEntity voter){
        adminServices.addVoter(voter);
    }

    @GetMapping("/search-voter")
    public VoterEntity searchVoter(@RequestParam Integer voterId){
        return adminServices.searchVoter(voterId);
    }

    @DeleteMapping("/delete-voter")
    public void deleteVoter(@RequestParam Integer voterId){
        adminServices.deleteVoter(voterId);
    }

    @GetMapping("/candidate-list")
    public List<CandidateEntity> candidateList(){
        return adminServices.candidateList();
    }
    @PostMapping("/add-candidate")
    public void addCandidate(@RequestBody CandidateEntity candidate){
        adminServices.addCandidate(candidate);
    }

    @GetMapping("/search-candidate")
    public CandidateEntity searchCandidate(@RequestParam Integer candidateId){
        return adminServices.searchCandidate(candidateId);
    }

    @DeleteMapping("/delete-candidate")
    public void deleteCandidate(@RequestParam Integer candidateId){
        adminServices.deleteCandidate(candidateId);
    }

//    @GetMapping("/voting-count")
//    public List<> votingCount(){
//        return adminServices.votingCount();
//    }
}
