package com.example.bff.api.operation.shipment.getforpurchase;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class ShipmentStatusResponse implements OperationResponse {
   private List shipemnts;
}
