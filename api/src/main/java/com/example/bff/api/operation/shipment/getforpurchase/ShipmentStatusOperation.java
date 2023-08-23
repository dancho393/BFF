package com.example.bff.api.operation.shipment.getforpurchase;

import com.example.bff.api.base.Operation;

public interface ShipmentStatusOperation extends Operation<ShipmentStatusRequest, ShipmentStatusResponse> {
    ShipmentStatusResponse process(ShipmentStatusRequest request);
}
