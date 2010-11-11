package com.serveeasy.model.product;

import com.serveeasy.model.Context;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * We opperate with Amount object to represent amounts of money.
 * Amount object holds also the currency. Operations should be
 * possible only for same currency.
 */
public final class Amount {

    private final String currency;
    private BigDecimal amount;

    private Amount(final Currency currency) {
        this.currency = currency.toString();
        this.amount = BigDecimal.ZERO;
    }

    private Amount(final Currency currency, final BigDecimal amount) {
        this.currency = currency.toString();
        this.amount = amount;
    }

    public static Amount newAmount() {
        return new Amount(Context.get().getCurrency());
    }

    public static Amount newAmount(final Integer initialAmount) {
        return newAmount(Double.valueOf(initialAmount));
    }

    public static Amount newAmount(final Double initialAmount) {
        return new Amount(Context.get().getCurrency(), BigDecimal.valueOf(initialAmount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return Currency.getInstance(this.currency);
    }

    public void add(Amount amount) {
        if (!this.currency.equals(amount.getCurrency())) {
            throw new IllegalStateException("Cannot add amounts with different currencyies");
        }

        this.amount = this.amount.add(amount.getAmount());
    }

    public void substract(Amount amount) {
        if (!this.currency.equals(amount.getCurrency())) {
            throw new IllegalStateException("Cannot add amounts with different currencyies");
        }

        this.amount = this.amount.subtract(amount.getAmount());
    }

    public void multiplyBy(int nr) {
        this.amount = this.amount.multiply(BigDecimal.valueOf(nr));
    }

    public void add(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void substract(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }


    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }

        if (!(o instanceof Amount)) {
            return -1;
        }

        if (!currency.equals(o)) {
            return -1;
        }

        return amount.compareTo(((Amount) o).getAmount());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount1 = (Amount) o;

        if (amount != null ? !amount.equals(amount1.amount) : amount1.amount != null) return false;
        if (currency != null ? !currency.equals(amount1.currency) : amount1.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
