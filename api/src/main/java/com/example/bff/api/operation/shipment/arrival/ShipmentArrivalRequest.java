package com.example.bff.api.operation.shipment.arrival;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class ShipmentArrivalRequest implements OperationRequest {
    private UUID shipmentId;
}
