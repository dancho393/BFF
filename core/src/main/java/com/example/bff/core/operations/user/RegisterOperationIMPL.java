package com.example.bff.core.operations.user;


import com.example.bff.api.users.operations.user.register.RegisterOperation;
import com.example.bff.api.users.operations.user.register.RegisterRequest;
import com.example.bff.api.users.operations.user.register.RegisterResponse;
import com.example.bff.core.operations.jwt.JwtService;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.enums.Role;
import com.example.bff.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterOperationIMPL implements RegisterOperation {
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public RegisterResponse process(RegisterRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//To be Deleted and should be autowired
        User user= User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();
        userRepository.save(user);
        var jwtToken =jwtService.generateToken(user);
        return RegisterResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
