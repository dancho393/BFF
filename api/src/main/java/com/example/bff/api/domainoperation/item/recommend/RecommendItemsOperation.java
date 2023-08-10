package com.example.bff.api.domainoperation.item.recommend;

import com.example.bff.api.base.Operation;

public interface RecommendItemsOperation extends Operation<RecommendItemsRequest,RecommendItemsResponse> {
    public RecommendItemsResponse process(RecommendItemsRequest request);
}
