package com.serveeasy.model.product;

import java.util.HashSet;
import java.util.Set;

/**
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 10:02:15 AM
 */
public final class DefaultCategory implements Category {

    private final String name;
    private final Category parent;
    private Set<Product> productSet;

    public DefaultCategory(String name, Category parent) {
        if (this.equals(parent)) {
            throw new IllegalStateException("Parent cannot be the same category");
        }

        this.name = name;
        this.parent = parent;
        productSet = new HashSet<Product>();
    }

    public DefaultCategory(String name) {
        this(name, null);
    }

    public Category getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        productSet.add(product);
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultCategory that = (DefaultCategory) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
