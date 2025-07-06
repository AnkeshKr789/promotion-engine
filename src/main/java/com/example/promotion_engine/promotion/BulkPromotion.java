package com.example.promotion_engine.promotion;

import com.example.promotion_engine.model.CartItem;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BulkPromotion implements Promotion {
    private String skuId;
    private int requiredQuantity;
    private int promoPrice;
    private int unitPrice;

    @Override
    public int apply(List<CartItem> items) {
        for (CartItem item : items) {
            if (item.getSkuId().equalsIgnoreCase(skuId)) {
                int quantity = item.getQuantity();
                int promoCount = quantity / requiredQuantity;
                int remainder = quantity % requiredQuantity;
                int total = promoCount * promoPrice + remainder * unitPrice;

                item.setQuantity(0);
                return total;
            }
        }
        return 0;
    }
}
