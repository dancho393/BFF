package com.example.bff.api.operation.shipment.take;

import com.example.bff.api.base.Operation;

public interface TakeShipmentOperation extends Operation<TakeShipmentRequest,TakeShipmentResponse> {
    TakeShipmentResponse process(TakeShipmentRequest request);
}
