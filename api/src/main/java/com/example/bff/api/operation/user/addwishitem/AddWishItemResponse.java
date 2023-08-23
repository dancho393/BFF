package com.example.bff.api.operation.user.addwishitem;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AddWishItemResponse implements OperationResponse {
    private Set<UUID> withItems;
}
