package com.serveeasy.model;

import java.util.Currency;
import java.util.Locale;

/**
 * Context holds the constant attributes for a session - locale, currency, maybe time zone etc.
 * The context is always bounded to the current thread using a thread local cache.
 * In this way we achieve easy access to the context variables without passing them to method calls
 * <p/>
 * Date: Nov 11, 2010
 * Time: 11:08:35 AM
 */
public final class Context {

    private final Locale locale;
    private final Currency currency;

    private static final ThreadLocal<Context> threadLocalCache = new ThreadLocal<Context>();

    private Context(final Locale locale, final Currency currency) {
        this.locale = locale;
        this.currency = currency;
    }

    public static Context create(Locale locale, Currency currency) {
        final Context context = new Context(locale, currency);
        threadLocalCache.set(context);

        return context;
    }

    public static Context get() {
        return threadLocalCache.get();
    }

    public static void bind(Context context) {
        threadLocalCache.set(context);
    }

    public Locale getLocale() {
        return locale;
    }

    public Currency getCurrency() {
        return currency;
    }
}
