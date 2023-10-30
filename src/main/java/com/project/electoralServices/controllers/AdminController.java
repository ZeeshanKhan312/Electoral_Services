package com.project.electoralServices.controllers;

import com.project.electoralServices.entities.AdminEntity;
import com.project.electoralServices.entities.CandidateEntity;
import com.project.electoralServices.entities.VoterEntity;
import com.project.electoralServices.entities.VotingResult;
import com.project.electoralServices.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("/add-admin")
    public void addAdmin(@RequestBody AdminEntity admin){
        adminServices.addAdmin(admin);
    }
    @GetMapping("/admin-list")
    public List<AdminEntity> adminList(){
        return adminServices.adminList();
    }

    @GetMapping("/admin-login")
    public AdminEntity adminLogin(@RequestParam String userName, @RequestParam String pasw){
        return adminServices.adminLogin(userName, pasw);
    }

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

    @GetMapping("/voting-count")
    public List<VotingResult> votingCount(){
        return adminServices.votingCount();
    }

    @PutMapping("/next-election")
    public void nextElection(){
        adminServices.nextElection();
    }
}
