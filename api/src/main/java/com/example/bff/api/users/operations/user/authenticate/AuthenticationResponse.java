package com.example.bff.api.users.operations.user.authenticate;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse implements OperationResponse {
    private String token;
}
