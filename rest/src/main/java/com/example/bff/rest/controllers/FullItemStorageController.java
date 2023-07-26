package com.example.bff.rest.controllers;

import com.example.bff.api.operation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.operation.fullitemstorage.get.GetFullItemStorageService;
import com.example.bff.core.operations.itemstorage.GetFullItemStorageIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fullItemStorages")
public class FullItemStorageController {

    private final GetFullItemStorageService getFullItemStorage;
    @GetMapping("/{id}")
    public ResponseEntity random(@PathVariable String id){


        return ResponseEntity.ok(getFullItemStorage.process(GetFullItemStorageRequest.builder()
                .itemStorageId(UUID.fromString(id))
                .build()));
    }
}
