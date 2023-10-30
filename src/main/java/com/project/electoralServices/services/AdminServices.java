package com.project.electoralServices.services;

import com.project.electoralServices.dao.AdminRepository;
import com.project.electoralServices.dao.CandidateRepository;
import com.project.electoralServices.dao.VoterRepository;
import com.project.electoralServices.entities.AdminEntity;
import com.project.electoralServices.entities.CandidateEntity;
import com.project.electoralServices.entities.VoterEntity;
import com.project.electoralServices.entities.VotingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServices {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    public AdminEntity adminLogin(String userName, String pasw) {
        AdminEntity admin=adminRepository.findByUsernameAndPasw(userName, pasw);
        if(admin==null)
            throw new NullPointerException();
        return admin;
    }
    public void addAdmin(AdminEntity admin) {
        adminRepository.save(admin);
    }
    public List<AdminEntity> adminList() {
        try{
            return adminRepository.findAll();
        }catch (Exception e){
            throw new NullPointerException();
        }
    }
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

    public List<VotingResult> votingCount() {
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

    public void nextElection() {
        List<CandidateEntity> candidates=candidateRepository.findAll();
        for(CandidateEntity candidate:candidates){
            candidate.setVoteCount(0);
            candidateRepository.save(candidate);
        }

        List<VoterEntity> voters=voterRepository.findAll();
        for(VoterEntity voter: voters){
            voter.setVoteCasted(false);
            voterRepository.save(voter);
        }
    }
}
