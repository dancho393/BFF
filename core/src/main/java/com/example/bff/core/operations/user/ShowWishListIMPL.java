package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.showwishlist.ShowWishListOperation;
import com.example.bff.api.operation.user.showwishlist.ShowWishListRequest;
import com.example.bff.api.operation.user.showwishlist.ShowWishListResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.zoostore.api.operations.item.get.GetItemResponse;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ShowWishListIMPL implements ShowWishListOperation {
    private UserRepository userRepository;
    private ZooStoreRestClient zooStoreRestClient;

    @Override
    public ShowWishListResponse process(ShowWishListRequest request) {
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        Set<GetItemResponse> wishItems=new HashSet<>();
        user.getWishItems().forEach(itemId->{
            wishItems.add(zooStoreRestClient.getItemById(itemId.toString()));
        });
        return ShowWishListResponse.builder()
                .withItems(wishItems)
                .build();
    }
}
