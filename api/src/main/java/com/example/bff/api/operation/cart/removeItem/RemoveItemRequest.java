package com.example.bff.api.operation.cart.removeItem;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveItemRequest implements OperationRequest {
    private UUID itemId;
}
