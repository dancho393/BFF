package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.getitems.GItemResponse;
import com.example.bff.api.operation.cart.getitems.GetItemsOperation;
import com.example.bff.api.operation.cart.getitems.GetItemsRequest;
import com.example.bff.api.operation.cart.getitems.GetItemsResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import com.example.zoostore.api.operations.item.get.GetItemResponse;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class GetItemsIMPL implements GetItemsOperation {
    private final UserRepository userRepository;
    private final ZooStoreRestClient zooStoreRestClient;
    private StorageServiceRestClient storageServiceRestClient;
    @Override
    public GetItemsResponse process(GetItemsRequest request) {
        User userEntity =userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()->new UserNotFoundException("Not Found User"));
        ArrayList<GItemResponse> items =new ArrayList<>();

        userEntity.getCart().getItems().forEach((key, value) -> {
            GetItemResponse zooResponse = zooStoreRestClient.getItemById(key.toString());
            GetByItemResponse storageResponse = storageServiceRestClient.getStorageById(key.toString());
            items.add(GItemResponse.builder()
                    .name(zooResponse.getTitle())
                    .vendor(zooResponse.getVendorName())
                    .price(storageResponse.getPrice() * value)
                    .quantity(storageResponse.getQuantity())
                    .build());

        });
        Float totalPrice=items.stream()
                .map(GItemResponse::getPrice)
                .reduce(0f,Float::sum);
        return GetItemsResponse
                .builder()
                .items(items)
                .totalPrice(totalPrice)
                .build();
    }
}
