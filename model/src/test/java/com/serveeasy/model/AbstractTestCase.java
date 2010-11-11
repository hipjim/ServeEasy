package com.serveeasy.model;

import junit.framework.TestCase;

import java.util.Currency;
import java.util.Locale;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 11:19:33 AM
 */
public abstract class AbstractTestCase extends TestCase {

    protected Context ctx;

    @Override
    public final void setUp() throws Exception {
        super.setUp();
        ctx = getContext();
    }

    @Override
    public final void tearDown() throws Exception {
        super.tearDown();
    }

    private Context getContext() {
        Locale locale = Locale.UK;
        Currency currency = Currency.getInstance(locale);

        return Context.create(locale, currency);
    }
}
