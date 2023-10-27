package com.project.electoralServices.services;

import com.project.electoralServices.dao.CandidateRepository;
import com.project.electoralServices.dao.VoterRepository;
import com.project.electoralServices.entities.CandidateEntity;
import com.project.electoralServices.entities.VoterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    public void addVoter(VoterEntity voter) {
        voter.setVoteCasted(false);
        try {
            voterRepository.save(voter);
        }
        catch (Exception e){
            throw new NullPointerException();
        }
    }

    public List<VoterEntity> voterList() {
        return voterRepository.findAll();
    }

    public VoterEntity searchVoter(Integer voterId) {
        try {
            VoterEntity voter=voterRepository.findByVoterId(voterId);
            return voter;
        }catch (Exception e){
            throw  new NullPointerException();
        }
    }

    public void deleteVoter(Integer voterId) {
        try {
            voterRepository.deleteById(voterId);
        }
        catch (Exception e){
            System.out.println("Voter doesn't exists");
            throw new NullPointerException();
        }
    }

    public List<CandidateEntity> candidateList() {
        try {
            return candidateRepository.findAll();
        }
        catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void addCandidate(CandidateEntity candidate) {
        try {
            candidate.setVoteCount(0);
            candidateRepository.save(candidate);
        }catch (Exception e){
            throw  new NullPointerException();
        }
    }

    public CandidateEntity searchCandidate(Integer candidateId) {
        try {
            CandidateEntity candidate=candidateRepository.findByCandidateId(candidateId);
            return candidate;
        }catch (Exception e){
            throw  new NullPointerException();
        }
    }

    public void deleteCandidate(Integer candidateId) {
        try {
            candidateRepository.deleteById(candidateId);
        }
        catch (Exception e){
            System.out.println("Candidate doesn't exists");
            throw new NullPointerException();
        }
    }
}
