package com.example.bff.api.operation.purchases.getall;

import com.example.bff.api.base.Operation;

public interface GetAllPurchasesOperation extends Operation<GetAllPurchasesRequest,GetAllPurchasesResponse> {
    GetAllPurchasesResponse process(GetAllPurchasesRequest request);
}
