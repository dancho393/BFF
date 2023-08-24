package com.example.bff.core.operations.purchases;

import com.example.bff.api.operation.purchases.getall.GetAllPurchasesOperation;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesRequest;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAllPurchasesIMPL implements GetAllPurchasesOperation {
    private final  StorageServiceRestClient storageServiceRestClient;
    @Override
    public GetAllPurchasesResponse process(GetAllPurchasesRequest request) {
        GetAllResponse response=storageServiceRestClient.getAllPurchase(
                request.getPage());


        return GetAllPurchasesResponse.builder()
                .purchases(response.getPurchaseList())
                .build();
    }
}
