package com.serveeasy.model.bar;

import com.serveeasy.model.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Represnts an active table inventory.
 * The inventory keeps the current products added to a table.
 * The inventory is active when the table get activated and
 * becomes inactive when the table get deactivated.
 * <p/>
 * Date: Nov 9, 2010
 */
final class TableProductHolder {

    private final List<ProductOrder> cache;
    private State state;

    TableProductHolder() {
        state = State.ACTIVE;

        cache = new ArrayList<ProductOrder>();
    }

    void addProduct(final Product product) {
        if (State.FINISHED.equals(state)) {
            throw new IllegalStateException("Inventory is in finished state");
        }

        cache.add(new ProductOrder(product));
    }

    List<ProductOrder> listProducts() {
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

        public int getCount() {
            return count;
        }
    }

    enum State {
        ACTIVE,
        FINISHED
    }
}
