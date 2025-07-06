package com.example.promotion_engine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.promotion_engine.config.SkuConfig;
import com.example.promotion_engine.model.CartItem;
import com.example.promotion_engine.model.CartRequest;
import com.example.promotion_engine.promotion.PromotionFactory;

public class PromotionEngineServiceTest {
    private PromotionEngineService promotionEngineService;

    @BeforeEach
    void setup() {
        SkuConfig skuConfig = new SkuConfig();
        skuConfig.setPrices(Map.of("A", 50, "B", 30, "C", 20, "D", 15));
        PromotionFactory factory = new PromotionFactory(skuConfig);
        promotionEngineService = new PromotionEngineService(skuConfig, factory);
    }

    @Test
    void testScenarioA() {
        CartRequest request = new CartRequest(List.of(
                new CartItem("A", 1),
                new CartItem("B", 1),
                new CartItem("C", 1)));
        int total = promotionEngineService.calculateTotal(request);
        assertEquals(100, total);
    }

    @Test
    void testScenarioB() {
        CartRequest request = new CartRequest(List.of(
                new CartItem("A", 5),
                new CartItem("B", 5),
                new CartItem("C", 1)));
        int total = promotionEngineService.calculateTotal(request);
        assertEquals(370, total);
    }

    @Test
    void testScenarioC() {
        CartRequest request = new CartRequest(List.of(
                new CartItem("A", 3),
                new CartItem("B", 5),
                new CartItem("C", 1),
                new CartItem("D", 1)));
        int total = promotionEngineService.calculateTotal(request);
        assertEquals(280, total);
    }

    @Test
    void testEmptyCart() {
        CartRequest request = new CartRequest(List.of());
        int total = promotionEngineService.calculateTotal(request);
        assertEquals(0, total);
    }

    @Test
    void testNullCartItems() {
        CartRequest request = new CartRequest(null);
        int total = promotionEngineService.calculateTotal(request);
        assertEquals(0, total);
    }
}
