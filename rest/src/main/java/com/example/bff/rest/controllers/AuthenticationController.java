package com.example.bff.rest.controllers;

import com.example.bff.api.users.operations.user.authenticate.AuthenticationRequest;
import com.example.bff.api.users.operations.user.register.RegisterRequest;
import com.example.bff.core.operations.user.AuthenticationOperationIMPL;
import com.example.bff.core.operations.user.RegisterOperationIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationOperationIMPL authenticationOperation;
    private final RegisterOperationIMPL registerOperation;
    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(registerOperation.process(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationOperation.process(request));
    }
}
