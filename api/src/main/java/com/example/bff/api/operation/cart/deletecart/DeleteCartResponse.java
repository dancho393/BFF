package com.example.bff.api.operation.cart.deletecart;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class DeleteCartResponse implements OperationResponse {
   private String response;
}
