package com.example.bff.api.operation.user.addwishitem;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AddWishItemRequest implements OperationRequest {
    private String email;
    private UUID itemId;
}
