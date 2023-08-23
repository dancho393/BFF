package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.addwishitem.AddWishItemOperation;
import com.example.bff.api.operation.user.addwishitem.AddWishItemRequest;
import com.example.bff.api.operation.user.addwishitem.AddWishItemResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddWishItemIMPL implements AddWishItemOperation {
    private final ZooStoreRestClient zooStoreRestClient;
    private final UserRepository userRepository;

    @Override
    public AddWishItemResponse process(AddWishItemRequest request) {
        zooStoreRestClient.getItemById(request.getItemId().toString());

        User user =userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new UserNotFoundException("User error"));
        user.getWishItems().add(request.getItemId());
        userRepository.save(user);



        return AddWishItemResponse.builder()
                .withItems(user.getWishItems())
                .build();
    }
}
