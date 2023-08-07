package com.example.bff.api.operation.cart.removeItem;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveItemResponse implements OperationResponse {
    private Map<String,Integer> items;
    private Float totalPrice;
}
