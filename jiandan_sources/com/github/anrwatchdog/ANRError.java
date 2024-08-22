package com.github.anrwatchdog;

import android.os.Looper;
import com.github.anrwatchdog.ANRError$$;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ANRError extends Error {
    public static final long serialVersionUID = 1;
    public final long duration;
    public ANRError$$._Thread st;

    public static class qw implements Comparator<Thread> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Thread f4386ad;

        public qw(Thread thread) {
            this.f4386ad = thread;
        }

        /* renamed from: qw */
        public int compare(Thread thread, Thread thread2) {
            if (thread == thread2) {
                return 0;
            }
            Thread thread3 = this.f4386ad;
            if (thread == thread3) {
                return 1;
            }
            if (thread2 == thread3) {
                return -1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
    }

    public ANRError(ANRError$$._Thread _thread, long j) {
        super("Application Not Responding for at least " + j + " ms.", _thread);
        this.duration = j;
        this.st = _thread;
    }

    public static ANRError New(long j, String str, boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new qw(thread));
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            if (next.getKey() == thread || (((Thread) next.getKey()).getName().startsWith(str) && (z || ((StackTraceElement[]) next.getValue()).length > 0))) {
                treeMap.put(next.getKey(), next.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        ANRError$$._Thread _thread = null;
        for (Map.Entry entry : treeMap.entrySet()) {
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle((Thread) entry.getKey()), (StackTraceElement[]) entry.getValue(), (qw) null);
            aNRError$$.getClass();
            _thread = new ANRError$$._Thread(aNRError$$, _thread, (qw) null);
        }
        return new ANRError(_thread, j);
    }

    public static ANRError NewMainAllStackTrace(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap, long j) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(Looper.getMainLooper().getThread()), (LinkedHashMap) linkedHashMap, (qw) null);
        aNRError$$.getClass();
        return new ANRError(new ANRError$$._Thread(aNRError$$, (ANRError$$._Thread) null, (qw) null), j);
    }

    public static ANRError NewMainOnly(long j) {
        Thread thread = Looper.getMainLooper().getThread();
        ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(thread), thread.getStackTrace(), (qw) null);
        aNRError$$.getClass();
        return new ANRError(new ANRError$$._Thread(aNRError$$, (ANRError$$._Thread) null, (qw) null), j);
    }

    public static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public LinkedHashMap<Long, StackTraceElement[]> getSTStackMap() {
        ANRError$$._Thread _thread = this.st;
        if (_thread != null) {
            return _thread.getStackMap();
        }
        return null;
    }

    public StackTraceElement[] getSTStackTrace() {
        ANRError$$._Thread _thread = this.st;
        if (_thread != null) {
            return _thread.getStackTrace();
        }
        return null;
    }
}
