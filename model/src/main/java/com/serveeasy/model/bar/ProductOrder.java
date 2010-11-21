package com.serveeasy.model.bar;

import com.serveeasy.model.product.Product;

/**
 * User: cristian.popovici
 * Date: Nov 12, 2010
 * Time: 11:57:07 AM
 */
final class ProductOrder {

    private final Product product;
    private State state;

    ProductOrder(final Product product) {
        this.product = product;
        state = State.ACTIVE;
    }


    private enum State {
        ACTIVE,
        PAYED
    }

    public Product getProduct() {
        return product;
    }

    public boolean isPayed() {
        return State.PAYED.equals(state);
    }

    void setPayed() {
        if (State.PAYED.equals(state)) {
            throw new IllegalStateException("Order already payed");
        }

        state = State.PAYED;
    }

}
