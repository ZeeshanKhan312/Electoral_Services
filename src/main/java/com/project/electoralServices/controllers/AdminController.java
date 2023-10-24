package com.project.electoralServices.controllers;

import com.project.electoralServices.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;
}
