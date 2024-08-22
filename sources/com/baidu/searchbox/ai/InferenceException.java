package com.baidu.searchbox.ai;

public class InferenceException extends Exception {
    public static final int ERR_CONVERT_RESULT = 2;
    public static final int ERR_NO_RESULT = 1;
    public static final int ERR_UNKNOWN = 1000;
    private int status = 1000;

    public InferenceException(int status2) {
        this.status = status2;
    }

    public InferenceException(String message) {
        super(message);
    }

    public InferenceException(int status2, String message) {
        super(message);
        this.status = status2;
    }

    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return this.status + ":" + (message != null ? s + ": " + message : s);
    }
}
