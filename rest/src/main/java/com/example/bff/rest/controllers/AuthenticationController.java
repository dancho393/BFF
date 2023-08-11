package com.example.bff.rest.controllers;
import com.example.bff.api.operation.user.authenticate.AuthenticationOperation;
import com.example.bff.api.operation.user.authenticate.AuthenticationRequest;
import com.example.bff.api.operation.user.authenticate.AuthenticationResponse;
import com.example.bff.api.operation.user.register.RegisterOperation;
import com.example.bff.api.operation.user.register.RegisterRequest;
import com.example.bff.api.operation.user.register.RegisterResponse;
import com.example.bff.api.operation.user.verifyemail.VerifyEmailOperation;
import com.example.bff.api.operation.user.verifyemail.VerifyEmailRequest;
import com.example.bff.api.operation.user.verifyemail.VerifyEmailResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationOperation authenticationOperation;
    private final RegisterOperation registerOperation;
    private final VerifyEmailOperation verifyEmailOperation;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(registerOperation.process(request));
    }
    @PatchMapping("/{verCode}")
    public  ResponseEntity<VerifyEmailResponse> verifyEmail(@PathVariable String verCode){
         VerifyEmailRequest request = VerifyEmailRequest.builder()
                .verifyCode(verCode)
                .build();
        return ResponseEntity.ok(verifyEmailOperation.process(request));
    }
    @PostMapping("/info")
    public ResponseEntity<String> rr(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationOperation.process(request));
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
