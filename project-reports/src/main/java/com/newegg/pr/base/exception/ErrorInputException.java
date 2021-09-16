package com.newegg.pr.base.exception;

/**
 * @author vic
 * @date 8/20/2021 9:12 AM
 * @description 手动参数校验异常
 */
public class ErrorInputException extends RuntimeException{

    public ErrorInputException() {
    }

    public ErrorInputException(String message) {
        super(message);
    }

    public ErrorInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorInputException(Throwable cause) {
        super(cause);
    }

    public ErrorInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
