package com.example.bff.api.operation.cart.deletecart;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCartRequest implements OperationRequest {
    private String userName;
}
