package com.visma.serveeasy.model.exceptions;

/**
 * User: cristian.popovici
 * Date: Nov 17, 2010
 * Time: 7:53:29 PM
 */
public interface UserMessageHolder {

    String getMessageKey(String key);

    Object[] getMessageProperties();
}
