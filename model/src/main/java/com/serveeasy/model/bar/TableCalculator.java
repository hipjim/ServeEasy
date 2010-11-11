package com.serveeasy.model.bar;

import com.serveeasy.model.product.Amount;
import com.serveeasy.model.product.Product;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 11:28:52 AM
 */
public class TableCalculator {

    private final Table table;
    private final TableProductInventory inventory;

    public TableCalculator(Table table) {
        this.table = table;
        this.inventory = table.getInventory();
    }

    public Amount getPendingMoney() {
        Amount amount = Amount.newAmount();

        for (Product product : inventory.listProducts().keySet()) {
            final TableProductInventory.ProductCount count = inventory.listProducts().get(product);
            final Amount price = product.getSellPrice();
            price.multiplyBy(count.getCount());
            amount.add(price);
        }

        return amount;
    }

    public void pay(Amount amount) {

    }
}
