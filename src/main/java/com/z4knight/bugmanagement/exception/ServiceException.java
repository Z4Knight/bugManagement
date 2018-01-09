package com.z4knight.bugmanagement.exception;

/**
 * @Author Z4knight
 * @Date 2017/12/27 14:55
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
