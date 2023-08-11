package com.example.bff.api.operation.user.verifyemail;

import com.example.bff.api.base.Operation;

public interface VerifyEmailOperation extends Operation<VerifyEmailRequest,VerifyEmailResponse> {
    public VerifyEmailResponse process(VerifyEmailRequest request);
}
