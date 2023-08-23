package com.example.bff.core.operations.user;


import com.example.bff.api.operation.user.emailsender.EmailSenderOperation;
import com.example.bff.api.operation.user.emailsender.EmailSenderRequest;
import com.example.bff.api.operation.user.register.RegisterOperation;
import com.example.bff.api.operation.user.register.RegisterRequest;
import com.example.bff.api.operation.user.register.RegisterResponse;
import com.example.bff.core.operations.jwt.JwtService;
import com.example.bff.persistence.entities.Cart;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.enums.roles.Role;
import com.example.bff.persistence.repositories.CartRepository;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterOperationIMPL implements RegisterOperation {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final CartRepository cartRepository;
    private final EmailSenderOperation emailSender;
    @Override
    public RegisterResponse process(RegisterRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//To be Deleted and should be autowired
        Cart cart = Cart
                .builder()
                .items(new HashMap<>())
                .totalPrice(0.0f)
                .build();

        cartRepository.save(cart);
        String verCode= UUID.randomUUID().toString();
        User user= User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .cart(cart)
                .isEmailVerified(false)
                .verificationCode(verCode)
                .cardBalance(0.0f)
                .discountPoints(0)
                .wishItems(new HashSet<>())
                .city(request.getCity())
                .country(request.getCountry())
                .continent(request.getContinent())
                .build();
        userRepository.save(user);


        emailSender.process(EmailSenderRequest.builder()
                .toEmail(request.getEmail())
                .subject("Verify Your Email In ZooStore")
                .body("Your Verification Code Is:"+verCode)
                .build());

        var jwtToken =jwtService.generateToken(user);
        return RegisterResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
