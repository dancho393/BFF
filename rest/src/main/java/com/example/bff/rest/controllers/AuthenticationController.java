package com.example.bff.rest.controllers;

import com.example.bff.api.operation.user.authenticate.AuthenticationRequest;
import com.example.bff.api.operation.user.register.RegisterRequest;
import com.example.bff.core.operations.user.AuthenticationOperationIMPL;
import com.example.bff.core.operations.user.RegisterOperationIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationOperation.process(request));
    }

}
