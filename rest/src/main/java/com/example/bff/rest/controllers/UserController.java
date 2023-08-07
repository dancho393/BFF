package com.example.bff.rest.controllers;

import com.example.bff.api.operation.user.changebalance.ChangeBalanceRequest;
import com.example.bff.core.operations.user.ChangeBalanceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final ChangeBalanceIMPL changeBalance;
    @PostMapping("/balance")
    public ResponseEntity balance(@RequestBody ChangeBalanceRequest request){
        return ResponseEntity.ok(changeBalance.process(request));
    }
}
