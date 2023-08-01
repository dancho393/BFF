package com.example.bff.api.operation.cart.addItem;

import com.example.bff.api.base.OperationRequest;

import java.util.UUID;

public class AddItemRequest implements OperationRequest {
    private UUID itemId;

    private int quantity;
}
