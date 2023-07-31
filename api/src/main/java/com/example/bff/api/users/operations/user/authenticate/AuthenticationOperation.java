package com.example.bff.api.users.operations.user.authenticate;

import com.example.bff.api.base.Operation;

public interface AuthenticationOperation extends Operation<AuthenticationRequest,AuthenticationResponse> {
    public AuthenticationResponse process(AuthenticationRequest request);
}
