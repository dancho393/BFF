package com.example.bff.core.operations.cart;

import com.example.bff.api.operation.cart.deletecart.DeleteCartOperation;
import com.example.bff.api.operation.cart.deletecart.DeleteCartRequest;
import com.example.bff.api.operation.cart.deletecart.DeleteCartResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.CartRepository;
import com.example.bff.persistence.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCartIMPL implements DeleteCartOperation {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final EntityManager entityManager;
    @Override
    @Transactional
    public DeleteCartResponse process(DeleteCartRequest request) {
        User user = userRepository.findByEmail(request.getUserName())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        user.getCart().getItems().clear();
        user.getCart().setTotalPrice(0.0f);
        userRepository.save(user);


        return DeleteCartResponse.builder()
                .response("Cart Cleaned")
                .build();
    }



}
