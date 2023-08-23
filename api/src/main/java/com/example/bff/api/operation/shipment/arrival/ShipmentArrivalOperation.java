package com.example.bff.api.operation.shipment.arrival;

import com.example.bff.api.base.Operation;

public interface ShipmentArrivalOperation extends Operation<ShipmentArrivalRequest,ShipmentArrivalResponse> {
    ShipmentArrivalResponse process(ShipmentArrivalRequest request);
}
