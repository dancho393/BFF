package com.example.bff.api.operation.user.register;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse implements OperationResponse {
    private String token;
}
