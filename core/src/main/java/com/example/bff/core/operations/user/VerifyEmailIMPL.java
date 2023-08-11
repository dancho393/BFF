package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.verifyemail.VerifyEmailOperation;
import com.example.bff.api.operation.user.verifyemail.VerifyEmailRequest;
import com.example.bff.api.operation.user.verifyemail.VerifyEmailResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerifyEmailIMPL implements VerifyEmailOperation {
    private final UserRepository userRepository;
    @Override
    public VerifyEmailResponse process(VerifyEmailRequest request) {
        User user = userRepository.findByVerificationCode(request.getVerifyCode())
                .orElseThrow(()->new UserNotFoundException("Verification Code Not Found"));
        user.setIsEmailVerified(true);
        userRepository.save(user);
        return VerifyEmailResponse.builder()
                .response("Email Verified")
                .build();
    }
}
