package com.example.bff.rest.controllers;

import com.example.bff.api.operation.user.changebalance.ChangeBalanceOperation;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceRequest;
import com.example.bff.api.operation.user.changebalance.ChangeBalanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final ChangeBalanceOperation changeBalance;
    @PostMapping("/balance")
    public ResponseEntity<ChangeBalanceResponse> balance(@RequestBody ChangeBalanceRequest request){
        return ResponseEntity.ok(changeBalance.process(request));
    }
}
