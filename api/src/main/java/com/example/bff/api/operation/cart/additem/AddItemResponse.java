package com.example.bff.api.operation.cart.additem;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddItemResponse implements OperationResponse {
    private String fullName;
    private Map<UUID,Integer> items;
    private Float totalPrice;
}
