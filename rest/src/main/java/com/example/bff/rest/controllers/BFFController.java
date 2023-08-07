package com.example.bff.rest.controllers;

import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemsByTagResponse;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesOperation;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesRequest;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesResponse;
import com.example.bff.core.operations.item.GetAllItemsByTagIMPL;
import com.example.bff.core.operations.itemstorage.GetFullItemStorageIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bff")
public class BFFController {

    private final GetFullItemStorageIMPL getFullItemStorage;
    private final GetAllItemsByTagIMPL getAllItemsByTagOperation;
    private final GetAllPurchasesOperation getAllPurchases;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id){


        return ResponseEntity.ok(getFullItemStorage.process(GetFullItemStorageRequest.builder()
                .itemStorageId(UUID.fromString(id))
                .build()));
    }
    @GetMapping("/FullItembyTag")
    public ResponseEntity<GetAllItemsByTagResponse> getByTag(@RequestBody GetAllItemByTagRequest tag){

        return ResponseEntity.ok(getAllItemsByTagOperation.process(tag));
    }
    @GetMapping("/purchases")
    public ResponseEntity<GetAllPurchasesResponse> allPurchases(@RequestBody GetAllPurchasesRequest request){
        return ResponseEntity.ok(getAllPurchases.process(request));
    }
}
