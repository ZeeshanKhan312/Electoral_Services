package com.project.electoralServices.controllers;


import com.project.electoralServices.services.VoterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoterController {
    @Autowired
    private VoterServices voterServices;
}
