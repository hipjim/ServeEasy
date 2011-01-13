package com.serveeasy.model.bar;

import com.serveeasy.model.product.Money;
import com.serveeasy.model.product.Product;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 */
class TableCalculator {

    private final TableProductHolder inventory;

    TableCalculator(Table table) {
        this.inventory = table.getProductHolder();
    }

    public Money getPendingMoney() {
        final Money money = Money.newAmount();

        for (ProductOrder order : inventory.listProducts()) {
            if (order.isPayed()) {
                continue;
            }

            money.add(order.getProduct().getSellPrice());
        }

        return money;
    }

    public void pay(Product product) {
        for (ProductOrder order : inventory.listProducts()) {
            if (product.equals(order.getProduct())) {
                order.setPayed();
                return;
            }
        }
    }

}
