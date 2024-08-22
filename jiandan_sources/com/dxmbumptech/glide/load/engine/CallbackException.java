package com.dxmbumptech.glide.load.engine;

public final class CallbackException extends RuntimeException {
    public static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(Throwable th2) {
        super("Unexpected exception thrown by non-Glide code", th2);
    }
}
