package com.example.bff.api.operation.purchases.getallexcel;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllExcelResponse implements OperationResponse {
    List list;
}
