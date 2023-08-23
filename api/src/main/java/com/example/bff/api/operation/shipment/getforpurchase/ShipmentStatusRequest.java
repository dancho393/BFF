package com.example.bff.api.operation.shipment.getforpurchase;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class ShipmentStatusRequest implements OperationRequest {
    private UUID purchaseId;
}
