package com.example.bff.api.operation.user.addwishitem;

import com.example.bff.api.base.Operation;
import com.example.bff.api.base.OperationRequest;

public interface AddWishItemOperation extends Operation<AddWishItemRequest,AddWishItemResponse> {
    AddWishItemResponse process(AddWishItemRequest request);
}
