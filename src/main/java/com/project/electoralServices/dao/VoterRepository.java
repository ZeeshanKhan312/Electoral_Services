package com.project.electoralServices.dao;


import com.project.electoralServices.entities.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<VoterEntity, Integer> {
    @Query(value = "SELECT * FROM voter WHERE voter_id =:voterId", nativeQuery = true)
    public VoterEntity findByVoterId(@Param("voterId") Integer voterId);
    @Query(value = "SELECT * FROM voter WHERE voter_id =:voterId AND pasw =:pasw", nativeQuery = true)
    VoterEntity findByVoterIdAndPasw(@Param("voterId") Integer voterId, @Param("pasw")String pasw);
}
