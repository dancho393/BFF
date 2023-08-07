package com.example.bff.api.operation.cart.getitems;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GItemResponse {
    private String name;
    private String vendor;
    private Float price;
    private Integer quantity;

}
