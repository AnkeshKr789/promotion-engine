package com.example.promotion_engine.promotion;

import java.util.List;

import com.example.promotion_engine.model.CartItem;

public interface Promotion {
    int apply(List<CartItem> items);
}
