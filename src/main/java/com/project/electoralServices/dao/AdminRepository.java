package com.project.electoralServices.dao;


import com.project.electoralServices.entities.AdminEntity;
import com.project.electoralServices.entities.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {
    @Query(value = "SELECT * FROM admin WHERE user_name =:username AND pasw =:pasw", nativeQuery = true)
    AdminEntity findByUsernameAndPasw(@Param("username") String username, @Param("pasw")String pasw);
}
