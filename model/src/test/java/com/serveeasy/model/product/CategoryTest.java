package com.serveeasy.model.product;

import com.serveeasy.model.AbstractTestCase;

import java.util.Currency;
import java.util.Locale;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 10:04:18 AM
 */
public class CategoryTest extends AbstractTestCase {

    Currency currency = Currency.getInstance(Locale.UK);

    public void testCategory() throws Exception {
        Category endCategory = new DefaultCategory("Drinks");
        Category middleCategory = new DefaultCategory("Alcoholic", endCategory);
        Category someCategory = new DefaultCategory("Beer", middleCategory);


        Amount sellPrice = Amount.newAmount(10);
        Amount entryPrice = Amount.newAmount(10);
        Product product = new DefaultProduct("Timisoreana", "Bere locala", someCategory, sellPrice, entryPrice);


        assertEquals(someCategory, product.getCategory());
        assertEquals(middleCategory, product.getCategory().getParent());
        assertEquals(endCategory, product.getCategory().getParent().getParent());
        assertNull(product.getCategory().getParent().getParent().getParent());
    }

}
