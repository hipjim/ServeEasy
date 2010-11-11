package com.serveeasy.model.product;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Nov 11, 2010
 * Time: 9:56:25 AM
 */
public interface Category {

    Category getParent();

    String getName();
}
