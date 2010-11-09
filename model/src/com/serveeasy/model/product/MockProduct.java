package com.serveeasy.model.product;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 12:26:42 PM
 */
public final class MockProduct implements Product {

    private final String name;
    private final Amount amount;

    public MockProduct(String name, Amount amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return null;
    }

    public Amount getPrice() {
        return null;
    }
}
