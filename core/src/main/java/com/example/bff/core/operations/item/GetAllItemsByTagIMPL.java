package com.example.bff.core.operations.item;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemsByTagOperation;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemsByTagResponse;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import com.example.zoostore.api.operations.item.findbytag.FindItemsByTagResponse;
import com.example.zoostore.api.operations.item.findbytag.ItemByTagRequest;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllItemsByTagIMPL implements GetAllItemsByTagOperation {
    private final ZooStoreRestClient zooStoreRestClient;
    private final StorageServiceRestClient storageServiceRestClient;

    @Override
    public GetAllItemsByTagResponse process(GetAllItemByTagRequest input) {

        FindItemsByTagResponse response= zooStoreRestClient.getItemsByTag(input.getTagId().toString(),input.getPage());
        List<ItemByTagRequest> items = response.getItems();
        items.parallelStream().forEach(item -> {
            GetByItemResponse getByItemResponse = storageServiceRestClient.getStorageById(item.getId().toString());
            item.setPrice(getByItemResponse.getPrice());
            item.setQuantity(getByItemResponse.getQuantity());
        });

        return GetAllItemsByTagResponse.builder()
                .tagName(highlight(response.getTagName()))
                .items(items)
                .build();
    }
    private String highlight(String text) {
        return "<span style=\\\"background-color: yellow; font-weight: bold;\\\">" + text + "</span>";
    }


}

