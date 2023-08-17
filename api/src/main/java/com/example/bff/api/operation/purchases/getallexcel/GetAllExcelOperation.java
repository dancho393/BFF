package com.example.bff.api.operation.purchases.getallexcel;

import com.example.bff.api.base.Operation;

public interface GetAllExcelOperation extends Operation<GetAllExcelRequest,GetAllExcelResponse> {
    GetAllExcelResponse process(GetAllExcelRequest request);

}
