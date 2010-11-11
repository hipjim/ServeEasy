package com.serveeasy.model.product;

import com.serveeasy.model.AbstractTestCase;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class AmmountTest extends AbstractTestCase {

    private Currency currency = Currency.getInstance(Locale.UK);

    public void testAddAmmount() throws Exception {

        Amount actualAmount = Amount.newAmount(12.2);
        actualAmount.add(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(22.2);

        assertEquals(actualAmount, expectedAmount);
    }

    public void testSubstrcatAmmount() throws Exception {
        Amount actualAmount = Amount.newAmount(12.2);
        actualAmount.substract(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(2.2);

        assertEquals(actualAmount, expectedAmount);
    }

}
