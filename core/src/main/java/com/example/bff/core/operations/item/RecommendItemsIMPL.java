package com.example.bff.core.operations.item;

import com.example.bff.api.domainoperation.item.recommend.RecommendItemsOperation;
import com.example.bff.api.domainoperation.item.recommend.RecommendItemsRequest;
import com.example.bff.api.domainoperation.item.recommend.RecommendItemsResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RecommendItemsIMPL implements RecommendItemsOperation {
    private final StorageServiceRestClient storageServiceRestClient;
    private final UserRepository userRepository;
    @Override
    public RecommendItemsResponse process(RecommendItemsRequest request) {
      User user= userRepository
                .findByEmail(SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()).orElseThrow(()->new UserNotFoundException("User Not Found"));
        return RecommendItemsResponse.builder()
                .items(
                        storageServiceRestClient.recommend(user.getId().toString(),
                        request.getPage())
                        .getPurchases()
                )
                .build();
    }
}
