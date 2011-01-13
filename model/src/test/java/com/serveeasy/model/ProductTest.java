package com.serveeasy.model;

import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCalculator;
import com.serveeasy.model.product.DefaultProduct;
import com.serveeasy.model.product.Money;
import com.serveeasy.model.product.Product;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 11:02:17 AM
 */
public class ProductTest extends AbstractTestCase {

    public void testTableInventory() throws Exception {

        Table table = new Table(5);
        table.activate();

        assertTrue("Table should be active", table.isActive());

        Money sellPrice = Money.newAmount(10);
        Money entryPrice = Money.newAmount(10);

        Product product_1 = new DefaultProduct("Timisoreana", "Bere din Timisoara", null, sellPrice, entryPrice);
        Product product_2 = new DefaultProduct("Ursus", "Bere din Cluj", null, sellPrice, entryPrice);

        table.addProduct(product_1);
        table.addProduct(product_2);

        TableCalculator calculator = table.getCalucaltor();

        assertTrue("20 gbp pending", calculator.getPendingMoney().equals(Money.newAmount(20)));

        calculator.pay(product_1);

        assertTrue("10 gbp pending", calculator.getPendingMoney().equals(Money.newAmount(10)));

        calculator.pay(product_2);

        assertTrue("0 gbp pending", calculator.getPendingMoney().equals(Money.newAmount()));

        table.deactivate();
        assertFalse("Table should not be active", table.isActive());
    }
}
