package com.serveeasy.model.product;

/**
 * Interface definition for a product
 */
public interface Product {

    String getName();

    String getDescription();

    Category getCategory();

    Money getSellPrice();

    Money getEntryPrice();
}
