package com.example.bff.rest.controllers;

import com.example.bff.api.operation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.operation.fullitemstorage.get.GetFullItemStorageOperation;
import com.example.bff.api.operation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.api.operation.item.getallbytag.GetAllItemsByTagOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fullItemStorages")
public class FullItemStorageController {

    private final GetFullItemStorageOperation getFullItemStorage;
    private final GetAllItemsByTagOperation getAllItemsByTagOperation;
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id){


        return ResponseEntity.ok(getFullItemStorage.process(GetFullItemStorageRequest.builder()
                .itemStorageId(UUID.fromString(id))
                .build()));
    }
    @GetMapping("/byTag")
    public ResponseEntity getByTag(@RequestBody GetAllItemByTagRequest tag){

        return ResponseEntity.ok(getAllItemsByTagOperation.process(tag));
    }
}
