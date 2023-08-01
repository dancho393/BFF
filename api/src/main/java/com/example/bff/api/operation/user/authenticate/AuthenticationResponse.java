package com.example.bff.api.operation.user.authenticate;

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
