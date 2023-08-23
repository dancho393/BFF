package com.example.bff.api.operation.shipment.take;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class TakeShipmentRequest implements OperationRequest {
    private UUID shipmentId;
}
