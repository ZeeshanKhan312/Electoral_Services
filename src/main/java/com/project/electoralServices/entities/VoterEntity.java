package com.project.electoralServices.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "voter")
@DynamicUpdate
@Data
@NoArgsConstructor
public class VoterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "voter_id_generator")
    @SequenceGenerator(name = "voter_id_generator",initialValue = 2000,allocationSize = 2,sequenceName = "voter_table_sequence")
    private int voterId;
    @NonNull
    private String voterName;
    @NonNull
    private String  pasw;
    @NonNull
    private String DOB;
    @NonNull
    private int voterAge;
    @NonNull
    @Column(unique = true)
    private String aadharNo;
    @NonNull
    private String address;
    private Boolean voteCasted;
}
