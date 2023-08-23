package com.example.bff.api.operation.shipment.arrival;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class ShipmentArrivalResponse implements OperationResponse {
    private String shipmentStatus;
}
