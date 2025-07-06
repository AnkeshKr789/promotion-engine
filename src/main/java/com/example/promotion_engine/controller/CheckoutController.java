package com.example.promotion_engine.controller;

import com.example.promotion_engine.model.CartRequest;
import com.example.promotion_engine.model.CartResponse;
import com.example.promotion_engine.service.PromotionEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class CheckoutController {

    private final PromotionEngineService promotionEngineService;

    @PostMapping
    public ResponseEntity<CartResponse> checkout(@RequestBody CartRequest cartRequest) {
        int total = promotionEngineService.calculateTotal(cartRequest);
        return ResponseEntity.ok(new CartResponse(total));
    }
}
