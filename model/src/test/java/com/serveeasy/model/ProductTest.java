package com.serveeasy.model;

import com.serveeasy.model.bar.Table;
import com.serveeasy.model.product.Amount;
import com.serveeasy.model.product.DefaultProduct;
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

        table.addProduct(getProduct());
        table.addProduct(getProduct());

        table.deactivate();
    }

    private Product getProduct() {
        Amount sellPrice = Amount.newAmount(10);
        Amount entryPrice = Amount.newAmount(10);
        Product product = new DefaultProduct("Timisoreana", "Bere locala", null, sellPrice, entryPrice);
        return product;
    }
}
