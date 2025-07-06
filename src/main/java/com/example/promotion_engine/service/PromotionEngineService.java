package com.example.promotion_engine.service;

import com.example.promotion_engine.config.SkuConfig;
import com.example.promotion_engine.model.CartItem;
import com.example.promotion_engine.model.CartRequest;
import com.example.promotion_engine.promotion.Promotion;
import com.example.promotion_engine.promotion.PromotionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PromotionEngineService {

    private final SkuConfig skuConfig;
    private final PromotionFactory promotionFactory;

    public int calculateTotal(CartRequest cartRequest) {
    if (cartRequest == null || cartRequest.getItems() == null || cartRequest.getItems().isEmpty()) {
        return 0;
    }

    List<CartItem> items = deepCopy(cartRequest.getItems());
    int total = 0;

    List<Promotion> promotions = promotionFactory.getActivePromotions();
    for (Promotion promo : promotions) {
        total += promo.apply(items);
    }

    for (CartItem item : items) {
        int quantity = item.getQuantity();
        if (quantity > 0) {
            int unitPrice = skuConfig.getPrices().getOrDefault(item.getSkuId(), 0);
            total += quantity * unitPrice;
        }
    }

    return total;
}


    private List<CartItem> deepCopy(List<CartItem> original) {
        List<CartItem> copy = new ArrayList<>();
        for (CartItem item : original) {
            copy.add(new CartItem(item.getSkuId(), item.getQuantity()));
        }
        return copy;
    }
}
