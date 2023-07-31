package com.example.bff.api.users.operations.user.register;

import com.example.bff.api.base.Operation;

public interface RegisterOperation extends Operation<RegisterRequest,RegisterResponse> {
    public RegisterResponse process(RegisterRequest request);
}
