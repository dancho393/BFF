package com.example.bff.api.operation.cart.getitems;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemsRequest implements OperationRequest {
    private UUID userId;
}
