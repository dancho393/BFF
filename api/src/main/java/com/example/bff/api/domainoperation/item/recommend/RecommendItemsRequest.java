package com.example.bff.api.domainoperation.item.recommend;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class RecommendItemsRequest implements OperationRequest {

    private int page;
}
