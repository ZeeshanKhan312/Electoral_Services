package com.project.electoralServices.dao;


import com.project.electoralServices.entities.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<VoterEntity, Integer> {
}
