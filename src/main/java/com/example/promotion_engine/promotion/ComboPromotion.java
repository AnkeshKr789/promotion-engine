package com.example.promotion_engine.promotion;

import com.example.promotion_engine.model.CartItem;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ComboPromotion implements Promotion {
    private String skuId1;
    private String skuId2;
    private int comboPrice;
    private int unitPrice1;
    private int unitPrice2;

    @Override
    public int apply(List<CartItem> items) {
        CartItem item1 = null, item2 = null;
        for (CartItem item : items) {
            if (item.getSkuId().equalsIgnoreCase(skuId1)) {
                item1 = item;
            } else if (item.getSkuId().equalsIgnoreCase(skuId2)) {
                item2 = item;
            }
        }

        if (item1 == null || item2 == null) return 0;

        int comboCount = Math.min(item1.getQuantity(), item2.getQuantity());
        int remaining1 = item1.getQuantity() - comboCount;
        int remaining2 = item2.getQuantity() - comboCount;

        int total = comboCount * comboPrice +
                    remaining1 * unitPrice1 +
                    remaining2 * unitPrice2;

        item1.setQuantity(0);
        item2.setQuantity(0);
        return total;
    }
}
