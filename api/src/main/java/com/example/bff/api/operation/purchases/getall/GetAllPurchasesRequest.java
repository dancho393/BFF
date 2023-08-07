package com.example.bff.api.operation.purchases.getall;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllPurchasesRequest implements OperationRequest {
    private int page;
}
