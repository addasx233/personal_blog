package com.yamlapkei.exception;

/**
 * 自定义预期的异常
 */
public class GlobalException extends Exception{
    private static final long serialVersionUID = 7403691834562752994L;
    private String message;

    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
