package com.example.bff.api.operation.cart.getitems;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemsResponse implements OperationResponse {
    private ArrayList<GItemResponse> items;
    private Float totalPrice;
}
