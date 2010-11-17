package com.serveeasy.model.exceptions;

/**
 * Abstract checked exception 
 * <p/>
 * User: cristian.popovici
 * Date: Nov 17, 2010
 * Time: 7:50:37 PM
 */
abstract class ApplicationException extends Exception {

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
