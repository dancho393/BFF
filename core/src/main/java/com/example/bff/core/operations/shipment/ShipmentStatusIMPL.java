package com.example.bff.core.operations.shipment;

import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusOperation;
import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusRequest;
import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusResponse;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseRequest;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShipmentStatusIMPL implements ShipmentStatusOperation {
    private final StorageServiceRestClient storageServiceRestClient;
    @Override
    public ShipmentStatusResponse process(ShipmentStatusRequest request) {
        ShipmentForPurchaseRequest shipment = ShipmentForPurchaseRequest.builder()
                .purchaseId(request.getPurchaseId())
                .build();
        ShipmentForPurchaseResponse response=storageServiceRestClient.shipmentForPurchase(shipment);
        return ShipmentStatusResponse.builder()
                .shipemnts(response.getShipments())
                .build();
    }
}
