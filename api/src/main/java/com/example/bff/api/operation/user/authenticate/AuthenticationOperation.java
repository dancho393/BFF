package com.example.bff.api.operation.user.authenticate;

import com.example.bff.api.base.Operation;

public interface AuthenticationOperation extends Operation<AuthenticationRequest,AuthenticationResponse> {
    public AuthenticationResponse process(AuthenticationRequest request);
}
