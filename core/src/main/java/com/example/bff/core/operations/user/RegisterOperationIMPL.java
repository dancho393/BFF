package com.example.bff.core.operations.user;


import com.example.bff.api.operation.user.register.RegisterOperation;
import com.example.bff.api.operation.user.register.RegisterRequest;
import com.example.bff.api.operation.user.register.RegisterResponse;
import com.example.bff.core.operations.jwt.JwtService;
import com.example.bff.persistence.entities.Cart;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.enums.Role;
import com.example.bff.persistence.repositories.CartRepository;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class RegisterOperationIMPL implements RegisterOperation {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final CartRepository cartRepository;
    @Override
    public RegisterResponse process(RegisterRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//To be Deleted and should be autowired
        Cart cart = Cart
                .builder()
                .items(new HashMap<>())
                .totalPrice(0.0f)
                .build();
        cartRepository.save(cart);
        User user= User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .cart( cart)
                .build();

        userRepository.save(user);

        var jwtToken =jwtService.generateToken(user);
        return RegisterResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
