package com.project.electoralServices.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VotingResult {
    private String candidateName;
    private String partyImage;
    private int voteCount;
}
