package com.example.bff.api.operation.user.changebalance;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class ChangeBalanceResponse implements OperationResponse {
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;
    private Float cardBalance;
}
