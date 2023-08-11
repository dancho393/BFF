package com.example.bff.api.operation.user.verifyemail;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VerifyEmailResponse implements OperationResponse {
    private String response;
}
