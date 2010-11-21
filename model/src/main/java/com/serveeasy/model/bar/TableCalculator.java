package com.serveeasy.model.bar;

import com.serveeasy.model.product.Amount;

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

    public Amount getPendingMoney() {
        final Amount amount = Amount.newAmount();

        for (ProductOrder order : inventory.listProducts()) {
            if (order.isPayed()) {
                continue;
            }

            amount.add(order.getProduct().getSellPrice());
        }

        return amount;
    }

}
