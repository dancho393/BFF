package com.example.bff.api.operation.fullitemstorage.get;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFullItemStorageResponse implements OperationResponse {
    private UUID id;
    private UUID itemId;
    private String title;
    private int quantity;
    private Float price;
    private String description;
    private String vendorName;
    private Set<String> links;
    private Set<String> tags;
}
