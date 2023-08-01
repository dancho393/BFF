package com.example.bff.api.operation.user.authenticate;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements OperationRequest {
    private String email;
    private String password;
}
