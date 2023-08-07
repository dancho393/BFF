package com.example.bff.api.operation.cart.deletecart;

import com.example.bff.api.base.Operation;


public interface DeleteCartOperation extends Operation<DeleteCartRequest, DeleteCartResponse> {
    public DeleteCartResponse process(DeleteCartRequest request);
}
