package com.example.bff.rest.controllers;

import com.example.bff.api.operation.cart.additem.AddItemRequest;
import com.example.bff.api.operation.cart.additem.AddItemResponse;
import com.example.bff.api.operation.cart.buyout.BuyOutRequest;
import com.example.bff.api.operation.cart.buyout.BuyOutResponse;
import com.example.bff.api.operation.cart.deletecart.DeleteCartRequest;
import com.example.bff.api.operation.cart.deletecart.DeleteCartResponse;
import com.example.bff.api.operation.cart.getitems.GetItemsRequest;
import com.example.bff.api.operation.cart.getitems.GetItemsResponse;
import com.example.bff.api.operation.cart.removeItem.RemoveItemRequest;
import com.example.bff.api.operation.cart.removeItem.RemoveItemResponse;
import com.example.bff.core.operations.cart.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/carts")
@AllArgsConstructor
public class CartController {
    private final AddItemIMPL addItem;
    private final GetItemsIMPL getItems;
    private final RemoveItemIMPL removeItem;
    private final DeleteCartIMPL deleteCart;
    private final BuyOutIMPL buyOut;
    @PostMapping("/new-item")
    public ResponseEntity<AddItemResponse> random(@RequestBody AddItemRequest request){
        return ResponseEntity.ok(addItem.process(request));
    }
    @GetMapping("/all")
    public ResponseEntity<GetItemsResponse> getAll(GetItemsRequest request){

        return ResponseEntity.ok(getItems.process(request));
    }
    @PostMapping("/{itemId}")
    public ResponseEntity<RemoveItemResponse> removeItem(@PathVariable UUID itemId){
        return ResponseEntity.ok(removeItem.process(RemoveItemRequest
                .builder()
                .itemId(itemId)
                .build()));
    }
    @PatchMapping("/renew")
    public ResponseEntity<DeleteCartResponse> renew(@RequestBody DeleteCartRequest request){
        return ResponseEntity.ok(deleteCart.process(request));
    }
    @PostMapping("/purchase")
    public ResponseEntity<BuyOutResponse> purchase(@RequestBody BuyOutRequest request){
        return ResponseEntity.ok(buyOut.process(request));
    }

}
