package com.example.bff.api.domainoperation.fullitemstorage.get;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFullItemStorageRequest implements OperationRequest {
    private UUID itemStorageId;
}
