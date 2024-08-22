package com.meizu.x;

import java.io.IOException;
import java.io.InterruptedIOException;

public class n {

    /* renamed from: c  reason: collision with root package name */
    public static final n f5394c = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f5395a;

    /* renamed from: b  reason: collision with root package name */
    private long f5396b;

    class a extends n {
        a() {
        }

        public void a() {
        }
    }

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f5395a && this.f5396b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
