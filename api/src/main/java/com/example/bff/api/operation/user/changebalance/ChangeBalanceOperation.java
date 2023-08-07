package com.example.bff.api.operation.user.changebalance;

import com.example.bff.api.base.Operation;

public interface ChangeBalanceOperation extends Operation<ChangeBalanceRequest,ChangeBalanceResponse> {
    public ChangeBalanceResponse process(ChangeBalanceRequest request);
}
