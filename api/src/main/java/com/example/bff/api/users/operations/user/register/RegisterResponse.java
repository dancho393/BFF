package com.example.bff.api.users.operations.user.register;

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
