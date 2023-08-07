package com.example.bff.api.operation.user.changebalance;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangeBalanceRequest implements OperationRequest {
    private Float balance;

}
