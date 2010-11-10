package com.serveeasy.model.product;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class AmmountTest extends TestCase {

    private Currency currency = Currency.getInstance(Locale.UK);

    public void testAddAmmount() throws Exception {

        Amount actualAmount = Amount.newAmount(currency, 12.2);
        actualAmount.add(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(currency, 22.2);

        assertEquals(actualAmount, expectedAmount);
    }

    public void testSubstrcatAmmount() throws Exception {
        Amount actualAmount = Amount.newAmount(currency, 12.2);
        actualAmount.substract(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(currency, 2.2);

        assertEquals(actualAmount, expectedAmount);
    }

    @Test
    public void tesAddAmountWithDifferentCurrencies() throws Exception {

    }

}
