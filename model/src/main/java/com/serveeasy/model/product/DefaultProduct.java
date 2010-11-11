package com.serveeasy.model.product;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 12:26:42 PM
 */
public final class DefaultProduct implements Product {

    private final String name;
    private final String description;
    private final Category category;
    private final Amount sellPrice;
    private final Amount entryPrice;

    public DefaultProduct(String name, String description, Category category, Amount sellPrice, Amount entryPrice) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.sellPrice = sellPrice;
        this.entryPrice = entryPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Amount getSellPrice() {
        return sellPrice;
    }

    public Amount getEntryPrice() {
        return entryPrice;
    }
}
