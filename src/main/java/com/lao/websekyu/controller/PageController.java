package com.lao.websekyu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class PageController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "oauth2-login";
    }

    @GetMapping("/access-denied")
    public String getFailedLoginPage(){
        return "access-denied";
    }

    @GetMapping("/login-success")
    public String getSuccessLoginPage(){
        return "login-success";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public ResponseEntity<String> getRequesterInfo(Principal principal) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return new ResponseEntity<>(gson.toJson(principal), HttpStatus.ACCEPTED);
    }
}
