package com.example.bff.rest.controllers;

import com.example.bff.api.operation.user.addwishitem.AddWishItemOperation;
import com.example.bff.api.operation.user.addwishitem.AddWishItemRequest;
import com.example.bff.api.operation.user.addwishitem.AddWishItemResponse;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceOperation;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceRequest;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceResponse;
import com.example.bff.api.operation.user.showwishlist.ShowWishListOperation;
import com.example.bff.api.operation.user.showwishlist.ShowWishListRequest;
import com.example.bff.api.operation.user.showwishlist.ShowWishListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final ChangeBalanceOperation changeBalance;
    private final AddWishItemOperation addWishItem;
    private final ShowWishListOperation showWishList;
    @PostMapping("/balance")
    public ResponseEntity<ChangeBalanceResponse> balance(@RequestBody ChangeBalanceRequest request){
        return ResponseEntity.ok(changeBalance.process(request));
    }
    @PostMapping("/wish/{itemId}")
    public ResponseEntity<AddWishItemResponse> addWishItem(@PathVariable UUID itemId){
        AddWishItemRequest request =AddWishItemRequest.builder()
                .itemId(itemId)
                .email(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();
        return ResponseEntity.ok(addWishItem.process(request));
    }
    @PostMapping("wish-list")
    public ResponseEntity<ShowWishListResponse> showWishListResponse(){
        ShowWishListRequest request=ShowWishListRequest.builder()
                .email(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();
        return ResponseEntity.ok(showWishList.process(request));
    }
}
