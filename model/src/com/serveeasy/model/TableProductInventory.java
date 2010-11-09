package com.serveeasy.model;

import com.serveeasy.model.product.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 4:18:01 PM
 */
class TableProductInventory {

    private final Map<Product, ProductCount> cache;
    private State state;

    TableProductInventory() {
        state = State.ACTIVE;

        cache = new HashMap<Product, ProductCount>();
    }

    void addProduct(final Product product) {
        if (State.FINISHED.equals(state)) {
            throw new IllegalStateException("Inventory is in finished state");
        }

        ProductCount count = cache.get(product);
        if (count == null) {
            cache.put(product, new ProductCount());
            return;
        }

        count.increse();
    }

    Map<Product, ProductCount> listProducts() {
        return cache;
    }

    void close() {
        state = State.FINISHED;
    }

    class ProductCount {

        private int count;

        ProductCount() {
            this.count = 0;
        }

        void increse() {
            count++;
        }

        void decrese() {
            count--;
        }
    }

    enum State {
        ACTIVE,
        FINISHED
    }

}
