package com.example.bff.api.operation.user.showwishlist;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ShowWishListResponse implements OperationResponse {
    private Set withItems;
}
