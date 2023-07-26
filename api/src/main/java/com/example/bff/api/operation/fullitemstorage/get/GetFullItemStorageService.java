package com.example.bff.api.operation.fullitemstorage.get;


import com.example.bff.api.base.Operation;


public interface GetFullItemStorageService extends Operation<GetFullItemStorageRequest, GetFullItemStorageResponse> {
    public GetFullItemStorageResponse process(GetFullItemStorageRequest storageItem);
}
