package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.authenticate.AuthenticationOperation;
import com.example.bff.api.operation.user.authenticate.AuthenticationRequest;
import com.example.bff.api.operation.user.authenticate.AuthenticationResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.core.operations.jwt.JwtService;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationOperationIMPL implements AuthenticationOperation {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse process(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
