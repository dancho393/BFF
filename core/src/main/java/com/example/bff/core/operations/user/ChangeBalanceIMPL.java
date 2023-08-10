package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.changebalance.ChangeBalanceOperation;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceRequest;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChangeBalanceIMPL implements ChangeBalanceOperation {
    private final UserRepository userRepository;
    @Override
    public ChangeBalanceResponse process(ChangeBalanceRequest request) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        user.setCardBalance(user.getCardBalance()+request.getBalance());
        userRepository.save(user);
        return ChangeBalanceResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .cardBalance(user.getCardBalance())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
