package com.example.bff.api.operation.cart.removeItem;

import com.example.bff.api.base.Operation;

public interface RemoveItemOperation extends Operation<RemoveItemRequest,RemoveItemResponse> {
    public RemoveItemResponse process(RemoveItemRequest request);

}
