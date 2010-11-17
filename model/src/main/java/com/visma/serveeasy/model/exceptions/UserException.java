package com.visma.serveeasy.model.exceptions;

/**
 * User: cristian.popovici
 * Date: Nov 17, 2010
 * Time: 7:54:40 PM
 */
public final class UserException extends ApplicationException implements UserMessageHolder {

    private final String messageKey;
    private final Object[] params;

    public UserException(String message, String messageKey, Object[] params) {
        super(message);
        this.messageKey = messageKey;
        this.params = params;
    }

    public UserException(String message, Throwable cause, String messageKey, Object[] params) {
        super(message, cause);
        this.messageKey = messageKey;
        this.params = params;
    }

    public String getMessageKey(String key) {
        return null;
    }

    public Object[] getMessageProperties() {
        return new Object[0];
    }
}
