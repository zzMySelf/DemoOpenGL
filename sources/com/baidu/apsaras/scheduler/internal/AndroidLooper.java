package com.baidu.apsaras.scheduler.internal;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H J\u0006\u0010\u0017\u001a\u00020\u0013J&\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/AndroidLooper;", "", "mainLooper", "", "nativeLooperPtr", "", "(ZJ)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "workThread", "Landroid/os/HandlerThread;", "getWorkThread", "()Landroid/os/HandlerThread;", "workThread$delegate", "handleNativeMessage", "", "entry_ptr", "arg0_ptr", "arg1_ptr", "init", "post", "delay", "postFront", "MessageRunnable", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidLooper.kt */
public final class AndroidLooper {
    private final Lazy handler$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AndroidLooper$handler$2(this));
    /* access modifiers changed from: private */
    public final boolean mainLooper;
    /* access modifiers changed from: private */
    public final long nativeLooperPtr;
    private final Lazy workThread$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AndroidLooper$workThread$2.INSTANCE);

    public final native void handleNativeMessage(long j2, long j3, long j4, long j5);

    public AndroidLooper(boolean mainLooper2, long nativeLooperPtr2) {
        this.mainLooper = mainLooper2;
        this.nativeLooperPtr = nativeLooperPtr2;
    }

    /* access modifiers changed from: private */
    public final HandlerThread getWorkThread() {
        return (HandlerThread) this.workThread$delegate.getValue();
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    public final void init() {
        if (!this.mainLooper) {
            getWorkThread();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/AndroidLooper$MessageRunnable;", "Ljava/lang/Runnable;", "()V", "androidLooper", "Lcom/baidu/apsaras/scheduler/internal/AndroidLooper;", "getAndroidLooper$lib_apsaras_release", "()Lcom/baidu/apsaras/scheduler/internal/AndroidLooper;", "setAndroidLooper$lib_apsaras_release", "(Lcom/baidu/apsaras/scheduler/internal/AndroidLooper;)V", "arg0", "", "getArg0$lib_apsaras_release", "()J", "setArg0$lib_apsaras_release", "(J)V", "arg1", "getArg1$lib_apsaras_release", "setArg1$lib_apsaras_release", "entryPtr", "getEntryPtr$lib_apsaras_release", "setEntryPtr$lib_apsaras_release", "next", "recycle", "", "run", "Companion", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidLooper.kt */
    public static final class MessageRunnable implements Runnable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int MAX_POOL_SIZE = 50;
        /* access modifiers changed from: private */
        public static MessageRunnable sPool;
        /* access modifiers changed from: private */
        public static int sPoolSize;
        /* access modifiers changed from: private */
        public static final Object sPoolSync = new Object();
        private AndroidLooper androidLooper;
        private long arg0;
        private long arg1;
        private long entryPtr;
        /* access modifiers changed from: private */
        public MessageRunnable next;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J&\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/AndroidLooper$MessageRunnable$Companion;", "", "()V", "MAX_POOL_SIZE", "", "sPool", "Lcom/baidu/apsaras/scheduler/internal/AndroidLooper$MessageRunnable;", "sPoolSize", "sPoolSync", "getSPoolSync", "()Ljava/lang/Object;", "obtain", "looper", "Lcom/baidu/apsaras/scheduler/internal/AndroidLooper;", "entryPtr", "", "arg0", "arg1", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AndroidLooper.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getSPoolSync() {
                return MessageRunnable.sPoolSync;
            }

            public final MessageRunnable obtain() {
                synchronized (getSPoolSync()) {
                    if (MessageRunnable.sPool != null) {
                        MessageRunnable m = MessageRunnable.sPool;
                        Intrinsics.checkNotNull(m);
                        Companion companion = MessageRunnable.Companion;
                        MessageRunnable.sPool = m.next;
                        m.next = null;
                        Companion companion2 = MessageRunnable.Companion;
                        MessageRunnable.sPoolSize = MessageRunnable.sPoolSize - 1;
                        return m;
                    }
                    Unit unit = Unit.INSTANCE;
                    return new MessageRunnable();
                }
            }

            public final MessageRunnable obtain(AndroidLooper looper, long entryPtr, long arg0, long arg1) {
                Intrinsics.checkNotNullParameter(looper, "looper");
                MessageRunnable mr = obtain();
                mr.setAndroidLooper$lib_apsaras_release(looper);
                mr.setEntryPtr$lib_apsaras_release(entryPtr);
                mr.setArg0$lib_apsaras_release(arg0);
                mr.setArg1$lib_apsaras_release(arg1);
                return mr;
            }
        }

        public final long getEntryPtr$lib_apsaras_release() {
            return this.entryPtr;
        }

        public final void setEntryPtr$lib_apsaras_release(long j2) {
            this.entryPtr = j2;
        }

        public final long getArg0$lib_apsaras_release() {
            return this.arg0;
        }

        public final void setArg0$lib_apsaras_release(long j2) {
            this.arg0 = j2;
        }

        public final long getArg1$lib_apsaras_release() {
            return this.arg1;
        }

        public final void setArg1$lib_apsaras_release(long j2) {
            this.arg1 = j2;
        }

        public final AndroidLooper getAndroidLooper$lib_apsaras_release() {
            return this.androidLooper;
        }

        public final void setAndroidLooper$lib_apsaras_release(AndroidLooper androidLooper2) {
            this.androidLooper = androidLooper2;
        }

        public final void recycle() {
            this.arg0 = 0;
            this.arg1 = 0;
            this.entryPtr = 0;
            this.androidLooper = null;
            synchronized (sPoolSync) {
                int i2 = sPoolSize;
                if (i2 < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize = i2 + 1;
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public void run() {
            try {
                AndroidLooper androidLooper2 = this.androidLooper;
                Intrinsics.checkNotNull(androidLooper2);
                AndroidLooper androidLooper3 = this.androidLooper;
                Intrinsics.checkNotNull(androidLooper3);
                androidLooper2.handleNativeMessage(androidLooper3.nativeLooperPtr, this.entryPtr, this.arg0, this.arg1);
            } catch (UnsatisfiedLinkError e2) {
            } catch (Throwable th2) {
                recycle();
                throw th2;
            }
            recycle();
        }
    }

    public final void post(long delay, long entry_ptr, long arg0_ptr, long arg1_ptr) {
        long j2 = delay;
        getHandler().postDelayed(MessageRunnable.Companion.obtain(this, entry_ptr, arg0_ptr, arg1_ptr), delay);
    }

    public final void postFront(long entry_ptr, long arg0_ptr, long arg1_ptr) {
        getHandler().postAtFrontOfQueue(MessageRunnable.Companion.obtain(this, entry_ptr, arg0_ptr, arg1_ptr));
    }
}
