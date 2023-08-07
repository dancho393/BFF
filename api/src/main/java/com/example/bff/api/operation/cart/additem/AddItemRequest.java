package com.example.bff.api.operation.cart.additem;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class
AddItemRequest implements OperationRequest {
    private UUID itemId;
    private int quantity;
}
