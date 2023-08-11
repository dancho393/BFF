package com.example.bff.api.operation.user.verifyemail;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VerifyEmailRequest implements OperationRequest {
    private String verifyCode;
}
