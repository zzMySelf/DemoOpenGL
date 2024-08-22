package com.baidu.strace.perfetto;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class PerfettoFrameVisitor extends BasePerfettoFrameVisitor {
    public static native long nCreate(String str, long j2, String str2);

    public PerfettoFrameVisitor(Context ctx, String dumpPath) {
        this(ctx, dumpPath, 0, getNextCagetory());
    }

    public PerfettoFrameVisitor(Context ctx, String dumpPath, long sessionId, String category) {
        super(ctx, category);
        if (sIsLoaded && !TextUtils.isEmpty(dumpPath) && sessionId >= 0) {
            try {
                if (this.mNativePtr != 0) {
                    nDestroy(this.mNativePtr);
                }
                this.mNativePtr = nCreate(dumpPath, sessionId, category);
            } catch (Throwable unused) {
                Log.e("PerfettoFrameVisitor", "strace perfetto visitor nCreate failed.", unused);
            }
        }
    }

    public synchronized void visitBegin() {
        if (sIsLoaded && !this.mRecycled) {
            try {
                nVisitBegin(this.mNativePtr);
            } catch (Throwable unused) {
                Log.e("PerfettoFrameVisitor", "strace perfetto visitor nVisitBegin failed.", unused);
            }
        }
        return;
    }

    public synchronized void visitEnd() {
        if (sIsLoaded && !this.mRecycled) {
            try {
                nVisitEnd(this.mNativePtr);
            } catch (Throwable unused) {
                Log.e("PerfettoFrameVisitor", "strace perfetto visitor nVisitEnd failed.", unused);
            }
        }
        return;
    }
}
