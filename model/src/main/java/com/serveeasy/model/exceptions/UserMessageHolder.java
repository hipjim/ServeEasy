package com.serveeasy.model.exceptions;

/**
 * Interface definign a holder object for a user message
 * <p/>
 * Date: Nov 17, 2010
 * Time: 7:53:29 PM
 */
public interface UserMessageHolder {

    /**
     * The key for the i18n message
     *
     * @param key
     * @return
     */
    String getMessageKey(String key);

    /**
     * A colection of message properties
     *
     * @return
     */
    Object[] getMessageProperties();
}
