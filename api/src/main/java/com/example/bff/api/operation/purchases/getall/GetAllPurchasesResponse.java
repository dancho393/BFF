package com.example.bff.api.operation.purchases.getall;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllPurchasesResponse implements OperationResponse {
    private List purchases;
}
