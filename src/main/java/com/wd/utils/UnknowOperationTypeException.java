package com.wd.utils;

/**
 * Created by Zhipeng on 2016/6/2.
 */
public class UnknowOperationTypeException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public UnknowOperationTypeException() {
        super("未知的操作类型");
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UnknowOperationTypeException(String message) {
        super(message);
    }
}
