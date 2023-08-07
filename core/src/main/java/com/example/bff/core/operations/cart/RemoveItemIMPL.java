package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.removeItem.RemoveItemOperation;
import com.example.bff.api.operation.cart.removeItem.RemoveItemRequest;
import com.example.bff.api.operation.cart.removeItem.RemoveItemResponse;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.CartRepository;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.restexport.StorageServiceRestClient;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemoveItemIMPL implements RemoveItemOperation {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public RemoveItemResponse process(RemoveItemRequest request) {
       User userEntity = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
               .orElseThrow(()->new RuntimeException("User Not Found"));

       userEntity.getCart().getItems().remove(request.getItemId());


       cartRepository.save(userEntity.getCart());
        return null;
    }
}
