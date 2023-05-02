package com.cicd.controller;

import com.cicd.auth.AuthenticationRequest;
import com.cicd.auth.AuthenticationResponse;
import com.cicd.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private  final AuthenticationService authenticationService;

    @GetMapping ("/test")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Authentication and Authorrization is succeded");
    }
}
