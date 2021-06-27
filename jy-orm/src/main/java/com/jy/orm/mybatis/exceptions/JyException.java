package com.jy.orm.mybatis.exceptions;

/**
 * 自定义异常处理
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-27 14:22
 */
public class JyException extends RuntimeException {

    public JyException() {}

    public JyException(String message) {
        super(message);
    }

    public JyException(String message, Throwable cause) {
        super(message, cause);
    }

    public JyException(Throwable cause) {
        super(cause);
    }
}
