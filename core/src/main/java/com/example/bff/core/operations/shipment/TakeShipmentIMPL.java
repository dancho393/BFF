package com.example.bff.core.operations.shipment;

import com.example.bff.api.operation.shipment.take.TakeShipmentOperation;
import com.example.bff.api.operation.shipment.take.TakeShipmentRequest;
import com.example.bff.api.operation.shipment.take.TakeShipmentResponse;
import com.example.bff.core.operations.exceptions.UserNotFoundException;
import com.example.bff.persistence.entities.User;
import com.example.bff.persistence.repositories.UserRepository;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TakeShipmentIMPL implements TakeShipmentOperation {
    private final UserRepository userRepository;
    private final StorageServiceRestClient storageServiceRestClient;

    @Override
    public TakeShipmentResponse process(TakeShipmentRequest request) {
        User user = userRepository.findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));

        com.example.storageservice.api.api.operations.shipment.take
                .TakeShipmentResponse response=
                storageServiceRestClient.takeShipment(request.getShipmentId().toString(),
                user.getId().toString());
        user.setCardBalance(user.getCardBalance()+ response.getRefundedMoney());
        userRepository.save(user);
        return TakeShipmentResponse.builder()
                .shipmentStatus(response.getShipmentStatus())
                .refundedMoney(response.getRefundedMoney())
                .build();
    }
}
