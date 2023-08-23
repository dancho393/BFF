package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.buyout.BuyOutOperation;
import com.example.bff.api.operation.cart.buyout.BuyOutRequest;
import com.example.bff.api.operation.cart.buyout.BuyOutResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.Cart;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyOutIMPL implements BuyOutOperation {
    private final UserRepository userRepository;
    private final StorageServiceRestClient storageServiceRestClient;
    @Override
    public BuyOutResponse process(BuyOutRequest request) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));

        CreatePurchaseRequest createPurchaseRequest= CreatePurchaseRequest.builder()
                .items(user.getCart().getItems())
                .userId(user.getId())
                .userBalance(user.getCardBalance())
                .totalPrice(user.getCart().getTotalPrice())
                .discountPoints(user.getDiscountPoints())
                .userCity(user.getCity())
                .userCountry(user.getCountry())
                .userContinent(user.getContinent())
                .build();

        CreatePurchaseResponse createPurchaseResponse = storageServiceRestClient
                .createPurchase(createPurchaseRequest);
        if(createPurchaseResponse.getSuccessful()){
            user.getCart().getItems().clear();
            user.getCart().setTotalPrice(0.0f);
            user.setCardBalance(user.getCardBalance()- createPurchaseResponse.getDiscountedPrice());
            user.setDiscountPoints(getPointAfterPurchase(user, createPurchaseResponse.getDiscountedPrice()));
            userRepository.save(user);
        }

        return BuyOutResponse.builder()
                .response("Purchased:"+createPurchaseResponse.getSuccessful())
                .build();
    }

    private Integer getPointAfterPurchase(User user,Float discountedPrice){
        user.setDiscountPoints(user.getDiscountPoints()+ discountedPrice.intValue());
        return user.getDiscountPoints();
    }

}
