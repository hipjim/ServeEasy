package com.serveeasy.model.product;

import com.serveeasy.model.AbstractTestCase;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class AmmountTest extends AbstractTestCase {

    private Currency currency = Currency.getInstance(Locale.UK);

    public void testAddAmmount() throws Exception {

        Money actualMoney = Money.newAmount(12.2);
        actualMoney.add(BigDecimal.valueOf(10));

        Money expectedMoney = Money.newAmount(22.2);

        assertEquals(actualMoney, expectedMoney);
    }

    public void testSubstrcatAmmount() throws Exception {
        Money actualMoney = Money.newAmount(12.2);
        actualMoney.substract(BigDecimal.valueOf(10));

        Money expectedMoney = Money.newAmount(2.2);

        assertEquals(actualMoney, expectedMoney);
    }

}
