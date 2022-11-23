package com.lao.websekyu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.logging.Logger;

@Controller
public class PageController {

    private static final Logger LOGGER = Logger.getLogger(PageController.class.getName());

    @GetMapping("/login")
    public String getLoginPage(){
        LOGGER.info("Authenticating request ...");
        return "oauth2-login";
    }

    @GetMapping("/access-denied")
    public String getFailedLoginPage(){
        LOGGER.info("Access to this resource denied.");
        return "access-denied";
    }

    @GetMapping("/login-success")
    public String getSuccessLoginPage(){
        LOGGER.info("Login via OAuth2 successful!");
        return "login-success";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public ResponseEntity getRequesterInfo(Principal principal) {
        LOGGER.info("Fetching user's information.");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return new ResponseEntity<>(gson.toJson(principal), HttpStatus.ACCEPTED);
    }
}
