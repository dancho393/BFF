package com.example.bff.core.operations.itemstorage;
import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageResponse;
import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import com.example.zoostore.api.operations.item.get.GetItemResponse;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFullItemStorageIMPL implements GetFullItemStorageOperation {

    private final StorageServiceRestClient storageServiceRestClient;
    private final ZooStoreRestClient zooStoreRestClient;
    @Override
    public GetFullItemStorageResponse process(GetFullItemStorageRequest storageItem) {
        //GetFullItemStorageResponse response;
        GetItemStorageResponse getItemStorageResponse;
        GetItemResponse getItemResponse;
        try {
            getItemStorageResponse = storageServiceRestClient.getItemStorage(storageItem.getItemStorageId().toString());
            getItemResponse = zooStoreRestClient.getItemById(getItemStorageResponse.getItemId().toString());
        }
        catch (Exception e) {
            throw new RuntimeException("Resource not found");
        }
        return GetFullItemStorageResponse.builder()
                .id(getItemStorageResponse.getId())
                .itemId(getItemStorageResponse.getItemId())
                .title(getItemResponse.getTitle())
                .description(getItemResponse.getDescription())
                .price(getItemStorageResponse.getPrice())
                .quantity(getItemStorageResponse.getQuantity())
                .vendorName(getItemResponse.getVendorName())
                .links(getItemResponse.getLinks())
                .tags(getItemResponse.getTags())
                .build();
    }
}
