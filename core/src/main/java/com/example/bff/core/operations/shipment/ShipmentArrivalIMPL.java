package com.example.bff.core.operations.shipment;

import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalOperation;
import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalRequest;
import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShipmentArrivalIMPL implements ShipmentArrivalOperation {
    private final  StorageServiceRestClient storageServiceRestClient;

    @Override
    public ShipmentArrivalResponse process(ShipmentArrivalRequest request) {
        com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalResponse response=
                storageServiceRestClient.shipmentArrival(request.getShipmentId().toString());

        return ShipmentArrivalResponse.builder()
                .shipmentStatus(response.getStatus())
                .build();
    }
}
