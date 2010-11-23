package com.serveeasy.model.bar;

import com.serveeasy.model.product.Money;
import com.serveeasy.model.product.Product;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 11:28:52 AM
 */
public class TableCalculator {

    private final Table table;
    private final TableProductHolder inventory;

    public TableCalculator(Table table) {
        this.table = table;
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
