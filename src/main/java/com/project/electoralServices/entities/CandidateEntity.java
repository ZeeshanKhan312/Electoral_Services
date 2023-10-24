package com.project.electoralServices.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "candidate")
@DynamicUpdate
@Data
@NoArgsConstructor
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "candidate_id_generator")
    @SequenceGenerator(name = "candidate_id_generator",initialValue = 5000,allocationSize = 100,sequenceName = "candidate_table_sequence")
    private int candidateId;
    @NonNull
    private String candidateName;
    @NonNull
    private String pasw;
    @NonNull
    private String DOB;
    @NonNull
    private int candidateAge;
    @NonNull
    private String aadharNo;
    private String partyImage;
    private int voteCount;
}
