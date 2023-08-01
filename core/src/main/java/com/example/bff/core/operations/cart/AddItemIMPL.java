package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.addItem.AddItemOperation;
import com.example.bff.api.operation.cart.addItem.AddItemRequest;
import com.example.bff.api.operation.cart.addItem.AddItemResponse;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class AddItemIMPL implements AddItemOperation {
    @Override
    public AddItemResponse process(AddItemRequest request) {

        return null;
    }
}
