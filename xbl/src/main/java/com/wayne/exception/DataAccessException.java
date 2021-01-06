package com.wayne.exception;

/**
 * 自定义异常类，用于转化sql异常
 * @author Wayne
 * @date 2019/5/24
 */
public class DataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataAccessException() {

    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(Throwable th) {
        super(th);
    }

    public DataAccessException(String message, Throwable th) {
        super(message, th);
    }

}
