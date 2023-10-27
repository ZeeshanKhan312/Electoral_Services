package com.project.electoralServices.dao;


import com.project.electoralServices.entities.CandidateEntity;
import com.project.electoralServices.entities.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer>{
    @Query(value = "SELECT * FROM candidate WHERE candidate_id =:candidateId", nativeQuery = true)
    public CandidateEntity findByCandidateId(@Param("candidateId") Integer candidateId);
}
