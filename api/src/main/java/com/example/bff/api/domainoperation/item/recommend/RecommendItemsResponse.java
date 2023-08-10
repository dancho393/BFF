package com.example.bff.api.domainoperation.item.recommend;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class RecommendItemsResponse implements OperationResponse {
    private List items;
}
