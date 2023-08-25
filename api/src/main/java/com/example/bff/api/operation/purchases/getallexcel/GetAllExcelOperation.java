package com.example.bff.api.operation.purchases.getallexcel;

import com.example.bff.api.base.Operation;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface GetAllExcelOperation extends Operation<GetAllExcelRequest,GetAllExcelResponse> {
    GetAllExcelResponse process(GetAllExcelRequest request) throws IOException;

}
