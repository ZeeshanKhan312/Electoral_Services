package com.project.electoralServices.controllers;

import com.project.electoralServices.entities.VoterEntity;
import com.project.electoralServices.entities.VotingResult;
import com.project.electoralServices.services.VoterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/voter")
public class VoterController {
    @Autowired
    private VoterServices voterServices;

    @GetMapping("/voter-login")
    public VoterEntity voterLogin(@RequestParam int voterId, @RequestParam String pasw){
        return voterServices.voterLogin(voterId,pasw);
    }
    @PutMapping("/cast-vote")
    public void castVote(@RequestParam int voterId, @RequestParam int candidateId){
        voterServices.castVote(voterId,candidateId);
    }
    @PutMapping("/update-details")
    public void updateVoterDetails(@RequestParam int voterId, @RequestParam String updateType, @RequestParam String update){
        voterServices.updateVoterDetails(voterId,updateType, update);
    }
    @GetMapping("/voting-result")
    public List<VotingResult> getVotingResult(){
        return voterServices.getVotingResult();
    }

}
