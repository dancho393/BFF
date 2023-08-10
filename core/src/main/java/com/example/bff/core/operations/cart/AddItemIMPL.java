package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.additem.AddItemOperation;
import com.example.bff.api.operation.cart.additem.AddItemRequest;
import com.example.bff.api.operation.cart.additem.AddItemResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.CartRepository;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddItemIMPL implements AddItemOperation {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final StorageServiceRestClient storageServiceRestClient;
    @Override
    public AddItemResponse process(AddItemRequest request) {

          GetByItemResponse response=  storageServiceRestClient.getStorageById(request.getItemId().toString());
          if(response.getPrice()==0&& response.getQuantity()==0)
           throw new RuntimeException("Item Not Found");
          if(response.getQuantity()-response.getQuantity()<0)
             throw new RuntimeException("Quantity in storage is not enough");
        User userEntity=userRepository.findByEmail(SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName())
                .orElseThrow(()-> new UserNotFoundException("User Not Found"));
        userEntity.getCart().getItems().entrySet().stream()
                .filter(entry -> entry.getKey().equals(request.getItemId()))
                .findFirst()
                .ifPresentOrElse(
                        entry -> {
                            entry.setValue(entry.getValue()+request.getQuantity());
                        },
                        () -> {
                            userEntity.getCart().getItems().put(request.getItemId(),request.getQuantity());
                        }
                );

        userEntity.getCart().setTotalPrice(userEntity
                .getCart()
                .getTotalPrice()+(response.getPrice() * request.getQuantity()));

        cartRepository.save(userEntity.getCart());

        userRepository.save(userEntity);
        return AddItemResponse
                .builder()
                .fullName(userEntity.getFirstName()+" "+userEntity.getLastName())
                .items(userEntity.getCart().getItems())
                .totalPrice(userEntity.getCart().getTotalPrice())
                .build();
    }
}
