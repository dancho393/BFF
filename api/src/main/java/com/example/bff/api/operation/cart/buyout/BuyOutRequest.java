package com.example.bff.api.operation.cart.buyout;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BuyOutRequest implements OperationRequest {
    private UUID userId;
}
