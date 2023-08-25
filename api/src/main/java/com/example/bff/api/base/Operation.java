package com.example.bff.api.base;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Operation <O extends OperationRequest,I extends OperationResponse>{
    public I process(O input) throws IOException;
}
