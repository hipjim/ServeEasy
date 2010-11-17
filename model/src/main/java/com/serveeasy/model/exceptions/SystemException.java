package com.serveeasy.model.exceptions;

/**
 * 
 * Date: Nov 17, 2010
 * Time: 7:51:56 PM
 */
public class SystemException extends RuntimeException {

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
