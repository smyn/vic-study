package com.newegg.pr.base.exception;

/**
 * @author vic
 * @date 8/21/2021 10:46 AM
 * @description 系统异常
 */
public class NsSystemException extends RuntimeException{
    public NsSystemException() {
    }

    public NsSystemException(String message) {
        super(message);
    }

    public NsSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NsSystemException(Throwable cause) {
        super(cause);
    }

    public NsSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
