package com.example.bff.api.base;

public interface Operation <O extends OperationRequest,I extends OperationResponse>{
    public I process(O input);
}
