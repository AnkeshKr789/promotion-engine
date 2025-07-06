package com.example.promotion_engine.promotion;

import com.example.promotion_engine.model.CartItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboPromotionTest {

    @Test
    void applyComboPromotionCD() {
        ComboPromotion promo = new ComboPromotion("C", "D", 30, 20, 15);

        List<CartItem> items = List.of(
            new CartItem("C", 2),
            new CartItem("D", 1)
        );

        List<CartItem> mutable = items.stream()
            .map(item -> new CartItem(item.getSkuId(), item.getQuantity()))
            .toList();

        int result = promo.apply(mutable);
        assertEquals(30 + 20, result);
    }
}
