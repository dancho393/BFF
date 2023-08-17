package com.example.bff.api.operation.purchases.getallexcel;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAllExcelRequest implements OperationRequest {
    private UUID userid;
}
