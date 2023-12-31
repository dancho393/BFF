package com.example.bff.api.domainoperation.fullitemstorage.get;


import com.example.bff.api.base.Operation;


public interface GetFullItemStorageOperation extends Operation<GetFullItemStorageRequest, GetFullItemStorageResponse> {
    public GetFullItemStorageResponse process(GetFullItemStorageRequest storageItem);
}
