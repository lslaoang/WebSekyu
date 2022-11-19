package com.lao.websekyu.controller;

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
    public Principal getRequestorInfo(Principal principal){
        return principal;
    }
}
