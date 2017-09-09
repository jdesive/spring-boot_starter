package com.desive.starter.controllers;

import com.desive.starter.repositories.StarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class StarterController {

    @Autowired
    private StarterRepository starterRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "Works!";
    }

}
