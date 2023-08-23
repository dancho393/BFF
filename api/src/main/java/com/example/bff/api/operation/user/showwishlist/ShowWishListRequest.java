package com.example.bff.api.operation.user.showwishlist;

import com.example.bff.api.base.OperationRequest;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ShowWishListRequest implements OperationRequest {
    private String email;
}
