package com.project.electoralServices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "admin")
@DynamicUpdate
@Data
@NoArgsConstructor
public class AdminEntity {
        @Id
        private String userName;
        @NonNull
        private String pasw;

}
