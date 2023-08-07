package com.example.bff.api.operation.cart.getitems;

import com.example.bff.api.base.Operation;

public interface GetItemsOperation extends Operation<GetItemsRequest,GetItemsResponse> {
    public GetItemsResponse process(GetItemsRequest request);
}
