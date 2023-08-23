package com.example.bff.api.operation.shipment.take;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class TakeShipmentResponse implements OperationResponse {
    private String shipmentStatus;
    private Float refundedMoney;
}
