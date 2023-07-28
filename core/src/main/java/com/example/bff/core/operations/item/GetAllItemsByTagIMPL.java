package com.example.bff.core.operations.item;

import com.example.bff.api.operation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.api.operation.item.getallbytag.GetAllItemsByTagOperation;
import com.example.bff.api.operation.item.getallbytag.GetAllItemsByTagResponse;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import com.example.zoostore.api.operations.item.findbytag.FindItemsByTagResponse;
import com.example.zoostore.api.operations.item.findbytag.ItemByTagRequest;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllItemsByTagIMPL implements GetAllItemsByTagOperation {
    private final ZooStoreRestClient zooStoreRestClient;
    private final StorageServiceRestClient storageServiceRestClient;

    @Override
    public GetAllItemsByTagResponse process(GetAllItemByTagRequest input) {

        FindItemsByTagResponse response= zooStoreRestClient.getItemsByTag(input.getTagId().toString(),input.getPage());
        List<ItemByTagRequest> items = response.getItems();
        items.forEach(item -> {
            GetByItemResponse getByItemResponse = storageServiceRestClient.getStorageById(item.getId().toString());
            item.setPrice(getByItemResponse.getPrice());
            item.setQuantity(getByItemResponse.getQuantity());
        });
        //storageServiceRestClient.getStorageById()
        return GetAllItemsByTagResponse.builder()
                .items(items)
                .build();
    }


}

