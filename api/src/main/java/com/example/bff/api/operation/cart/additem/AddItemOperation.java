package com.example.bff.api.operation.cart.additem;

import com.example.bff.api.base.Operation;

public interface AddItemOperation extends Operation<AddItemRequest,AddItemResponse> {
    AddItemResponse process (AddItemRequest request);

}
