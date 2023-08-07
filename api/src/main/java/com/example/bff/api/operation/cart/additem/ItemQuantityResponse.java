package com.example.bff.api.operation.cart.additem;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemQuantityResponse {
    private UUID itemId;
    private int quantity;
    private Float price;
    private Float totalPrice;
}
