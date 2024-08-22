package com.baidu.searchbox.anr.impl;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.horae.TraceConfig;
import com.baidu.horae.TraceEvent;
import com.baidu.horae.TraceSession;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.strace.core.FrameVisitor;
import com.baidu.strace.core.STrace;
import com.baidu.strace.perfetto.BasePerfettoFrameVisitor;
import java.io.File;

public class ANRSampleTracer {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String DEFAULT_TRACER_NAME = "anr_strace.trace";
    private static final String TAG = "ANRSampleTracer";
    private BasePerfettoFrameVisitor basePerfettoFrameVisitor;
    private int mBufferSize;
    private STrace mSTrace;
    private TraceConfig mTraceConfig;

    public ANRSampleTracer() {
        this.mBufferSize = 200;
        this.mTraceConfig = null;
        this.mSTrace = new STrace(AppRuntime.getAppContext());
        this.basePerfettoFrameVisitor = new BasePerfettoFrameVisitor(AppRuntime.getAppContext(), BasePerfettoFrameVisitor.getNextCagetory());
        this.mTraceConfig = TraceConfig.build().setFillPolicy(1).setBufferSize(this.mBufferSize).setEnableCategories(new String[]{this.basePerfettoFrameVisitor.getCategory()});
    }

    public void start(int samplePeriod) {
        if (this.mSTrace != null) {
            if (DEBUG) {
                Log.i(TAG, "start, sample period: " + samplePeriod);
            }
            this.mSTrace.start(Looper.getMainLooper().getThread(), samplePeriod, this.mBufferSize, STrace.Mode.RING);
        }
    }

    public void stop() {
        if (this.mSTrace != null) {
            if (DEBUG) {
                Log.i(TAG, "stop");
            }
            this.mSTrace.stop();
        }
    }

    public void dump() {
        dump(getSampleTracePath());
    }

    public void dump(String path) {
        if (this.mSTrace != null) {
            FileUtils.createFileSafely(new File(path));
            TraceSession session = new TraceSession();
            session.start(this.mTraceConfig);
            TraceEvent.beginSection(this.basePerfettoFrameVisitor.getCategory(), "ANRMonitor.dump", System.currentTimeMillis() * 1000000, Thread.currentThread().getId());
            TraceEvent.endSection(this.basePerfettoFrameVisitor.getCategory(), System.currentTimeMillis() * 1000000, Thread.currentThread().getId());
            if (this.mSTrace.dump((FrameVisitor) this.basePerfettoFrameVisitor)) {
                session.stop();
                session.dumpTrace(getSampleTracePath());
                Log.d(TAG, "dump trace file to: " + getSampleTracePath() + " " + SystemClock.currentThreadTimeMillis());
            }
            session.release();
        }
    }

    public static String getSampleTracePath() {
        if (DEBUG) {
            Log.i(TAG, "getSampleTracePath: " + AppRuntime.getAppContext().getFilesDir() + "/" + DEFAULT_TRACER_NAME);
        }
        return AppRuntime.getAppContext().getFilesDir() + "/" + DEFAULT_TRACER_NAME;
    }
}
