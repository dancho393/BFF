package com.example.bff.core.operations.comment;

import com.example.bff.api.operation.comment.CreateCommentOperation;
import com.example.bff.api.operation.comment.CreateCommentRequest;
import com.example.bff.api.operation.comment.CreateCommentResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.zoostore.api.operations.comment.CreateCommentsRequest;
import com.example.zoostore.restexport.ZooStoreRestClient;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class CreateCommentIMPL implements CreateCommentOperation {
    private final ZooStoreRestClient zooStoreRestClient;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public CreateCommentResponse process(CreateCommentRequest request) {
        User user=userRepository.findByEmail(SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        CreateCommentsRequest createCommentRequest= CreateCommentsRequest
                .builder()
                .itemId(request.getItemId())
                .comment(request.getComment())
                .rating(request.getRating())
                .userId(request.getUserId())
                .build();

        com.example.zoostore.api.operations.comment.CreateCommentsResponse response =
                zooStoreRestClient.createComment(createCommentRequest);

        return CreateCommentResponse.builder()
                .fullName(user.getFirstName()+" "+user.getLastName())
                .itemName(response.getItemName())
                .rating(request.getRating())
                .comment(request.getComment())
                .build();
    }
}
