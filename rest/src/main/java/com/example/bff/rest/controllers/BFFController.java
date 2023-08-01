package com.example.bff.rest.controllers;

import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.core.operations.item.GetAllItemsByTagIMPL;
import com.example.bff.core.operations.itemstorage.GetFullItemStorageIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fullItemStorages")
public class BFFController {

    private final GetFullItemStorageIMPL getFullItemStorage;
    private final GetAllItemsByTagIMPL getAllItemsByTagOperation;
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id){


        return ResponseEntity.ok(getFullItemStorage.process(GetFullItemStorageRequest.builder()
                .itemStorageId(UUID.fromString(id))
                .build()));
    }
    @GetMapping("/FullItembyTag")
    public ResponseEntity getByTag(@RequestBody GetAllItemByTagRequest tag){

        return ResponseEntity.ok(getAllItemsByTagOperation.process(tag));
    }
}
