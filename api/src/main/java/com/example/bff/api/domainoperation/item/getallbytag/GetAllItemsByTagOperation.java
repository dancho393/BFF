package com.example.bff.api.domainoperation.item.getallbytag;

import com.example.bff.api.base.Operation;

public interface GetAllItemsByTagOperation extends Operation<GetAllItemByTagRequest, GetAllItemsByTagResponse> {
    public GetAllItemsByTagResponse process(GetAllItemByTagRequest input);
}
