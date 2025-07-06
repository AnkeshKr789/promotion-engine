package com.example.promotion_engine.promotion;

import com.example.promotion_engine.model.CartItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulkPromotionTest {

    @Test
    void applyBulkPromotionOnA() {
        BulkPromotion promo = new BulkPromotion("A", 3, 130, 50);
        List<CartItem> items = List.of(new CartItem("A", 5));

        List<CartItem> mutable = items.stream()
            .map(item -> new CartItem(item.getSkuId(), item.getQuantity()))
            .toList();

        int result = promo.apply(mutable);
        assertEquals(130 + 2 * 50, result);
    }
}
