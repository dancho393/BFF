package com.example.bff.api.operation.cart.buyout;

import com.example.bff.api.base.Operation;
import com.example.bff.api.base.OperationRequest;

public interface BuyOutOperation extends Operation<BuyOutRequest,BuyOutResponse> {
    public BuyOutResponse process(BuyOutRequest request);
}
