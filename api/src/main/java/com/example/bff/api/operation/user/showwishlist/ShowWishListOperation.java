package com.example.bff.api.operation.user.showwishlist;

import com.example.bff.api.base.Operation;

public interface ShowWishListOperation extends Operation<ShowWishListRequest,ShowWishListResponse> {
    ShowWishListResponse process(ShowWishListRequest request);
}
