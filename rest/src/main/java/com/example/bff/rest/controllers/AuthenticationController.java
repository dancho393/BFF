package com.example.bff.rest.controllers;
import com.example.bff.api.operation.user.authenticate.AuthenticationRequest;
import com.example.bff.api.operation.user.authenticate.AuthenticationResponse;
import com.example.bff.api.operation.user.register.RegisterRequest;
import com.example.bff.api.operation.user.register.RegisterResponse;
import com.example.bff.core.operations.user.AuthenticationOperationIMPL;
import com.example.bff.core.operations.user.RegisterOperationIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationOperationIMPL authenticationOperation;
    private final RegisterOperationIMPL registerOperation;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(registerOperation.process(request));
    }
    @GetMapping("/info")
    public ResponseEntity<String> rr(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationOperation.process(request));
    }

}
