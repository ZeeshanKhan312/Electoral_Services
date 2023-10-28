package com.project.electoralServices.services;

import com.project.electoralServices.dao.CandidateRepository;
import com.project.electoralServices.dao.VoterRepository;
import com.project.electoralServices.entities.VoterEntity;
import com.project.electoralServices.entities.VotingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoterServices {
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    public VoterEntity voterLogin(int voterId, String pasw) {
        VoterEntity voter=voterRepository.findByVoterIdAndPasw(voterId,pasw);
        if(voter==null)
            throw new NullPointerException();
        return voter;
    }

    public List<VotingResult> getVotingResult() {
        try{
            List<Object[]> list=candidateRepository.getVotingResult();
            List<VotingResult> votingResults=new ArrayList<>();
            for(Object[] result:list){
                VotingResult votingResult=new VotingResult();
                votingResult.setCandidateName((String) result[0]);
                votingResult.setPartyImage((String) result[1]);
                votingResult.setVoteCount((Integer) result[2]);
                votingResults.add(votingResult);
            }
            return votingResults;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }
}
