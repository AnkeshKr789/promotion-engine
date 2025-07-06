package com.example.promotion_engine.promotion;

import com.example.promotion_engine.config.SkuConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PromotionFactory {

    private final SkuConfig skuConfig;
    
    public List<Promotion> getActivePromotions() {
        List<Promotion> promotions = new ArrayList<>();

        int priceA = skuConfig.getPrices().getOrDefault("A", 0);
        int priceB = skuConfig.getPrices().getOrDefault("B", 0);
        int priceC = skuConfig.getPrices().getOrDefault("C", 0);
        int priceD = skuConfig.getPrices().getOrDefault("D", 0);

        promotions.add(new BulkPromotion("A", 3, 130, priceA));
        promotions.add(new BulkPromotion("B", 2, 45, priceB));
        promotions.add(new ComboPromotion("C", "D", 30, priceC, priceD));

        return promotions;
    }
}
