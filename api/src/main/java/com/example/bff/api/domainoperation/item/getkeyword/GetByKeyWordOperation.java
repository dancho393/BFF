package com.example.bff.api.domainoperation.item.getkeyword;

import com.example.bff.api.base.Operation;

public interface GetByKeyWordOperation extends Operation<GetByKeyWordRequest,GetByKeyWordResponse> {
    public GetByKeyWordResponse process(GetByKeyWordRequest request);
}
