package com.lao.websekyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class PageController {

    @GetMapping("/login")
    public String getLoginPage(){
        System.out.println("This happened!");
        return "oauth2-login";
    }

    @GetMapping("/login-failed")
    public String getFailedLoginPage(){
        System.out.println("This happened!");
        return "login-failed";
    }

    @GetMapping("/login-success")
    public String getSuccessLoginPage(){
        System.out.println("This happened!");
        return "login-success";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public Principal getRequestorInfo(Principal principal){
        System.out.println("INFO: " + principal);
        return principal;
    }
}
