package com.example.bff.api.operation.cart.buyout;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BuyOutResponse implements OperationResponse {
    private String response;
}
