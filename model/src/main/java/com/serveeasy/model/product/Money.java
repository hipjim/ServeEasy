package com.serveeasy.model.product;

import com.serveeasy.model.context.Context;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * We opperate with Money object to represent amounts of money.
 * Money object holds also the currency. Operations should be
 * possible only for same currency.
 */
public final class Money implements Serializable, Comparable {

    private final Currency currency;
    private BigDecimal amount;

    private Money(final Currency currency) {
        this.currency = currency;
        this.amount = BigDecimal.ZERO;
    }

    private Money(final Currency currency, final BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money newAmount() {
        return new Money(Context.get().getCurrency());
    }

    public static Money newAmount(final Integer initialAmount) {
        return newAmount(Double.valueOf(initialAmount));
    }

    public static Money newAmount(final Double initialAmount) {
        return new Money(Context.get().getCurrency(), BigDecimal.valueOf(initialAmount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void add(Money money) {
        if (!this.currency.equals(money.getCurrency())) {
            throw new IllegalStateException("Cannot add amounts with different currencyies");
        }

        this.amount = this.amount.add(money.getAmount());
    }

    public void substract(Money money) {
        if (!this.currency.equals(money.getCurrency())) {
            throw new IllegalStateException("Cannot add amounts with different currencyies");
        }

        this.amount = this.amount.subtract(money.getAmount());
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

        if (!(o instanceof Money)) {
            return -1;
        }

        if (!currency.equals(o)) {
            return -1;
        }

        return amount.compareTo(((Money) o).getAmount());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money amount1 = (Money) o;

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

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }


}
