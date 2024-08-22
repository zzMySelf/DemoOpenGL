package com.baidu.searchbox.danmakulib.controller;

import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.baidu.searchbox.danmakulib.controller.IDrawTask;
import com.baidu.searchbox.danmakulib.danmaku.data.IDanmakuDataProvider;
import com.baidu.searchbox.danmakulib.danmaku.model.AbsDanmakuSync;
import com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer;
import com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus;
import com.baidu.searchbox.danmakulib.danmaku.model.IDisplayer;
import com.baidu.searchbox.danmakulib.danmaku.parser.BaseDanmakuParser;
import com.baidu.searchbox.danmakulib.danmaku.renderer.IRenderer;
import com.baidu.searchbox.danmakulib.danmaku.util.DeviceUtils;
import com.baidu.searchbox.danmakulib.danmaku.util.SystemClock;
import com.baidu.searchbox.danmakulib.util.BdDmkLog;
import java.util.LinkedList;

public class DrawHandler extends Handler {
    private static final int ADD_DANMAKUS = 16;
    private static final int BATCH_ADD_DANMAKUS = 15;
    private static final int CLEAR_DANMAKUS_ON_SCREEN = 13;
    private static final int FORCE_RENDER = 14;
    private static final int HIDE_DANMAKUS = 9;
    private static final long INDEFINITE_TIME = 10000000;
    private static final int MAX_RECORD_SIZE = 500;
    private static final int NOTIFY_DISP_SIZE_CHANGED = 10;
    private static final int NOTIFY_RENDERING = 11;
    private static final int PAUSE = 7;
    public static final int PREPARE = 5;
    private static final int QUIT = 6;
    public static final int RESUME = 3;
    public static final int SEEK_POS = 4;
    private static final int SHOW_DANMAKUS = 8;
    public static final int START = 1;
    private static final int SYNC_TIME = 17;
    private static final long SYNC_UPDATE_TIME = 20000;
    private static final String TAG = "DrawHandler";
    public static final int UPDATE = 2;
    private static final int UPDATE_WHEN_PAUSED = 12;
    private IDanmakuDataProvider dataProvider;
    private boolean isUsedNewFramework = false;
    /* access modifiers changed from: private */
    public Callback mCallback;
    /* access modifiers changed from: private */
    public DanmakuContext mContext;
    private long mCordonTime = 30;
    /* access modifiers changed from: private */
    public long mCordonTime2 = 60;
    /* access modifiers changed from: private */
    public IDanmakuViewController mDanmakuView;
    /* access modifiers changed from: private */
    public boolean mDanmakusVisible = true;
    private long mDesireSeekingTime;
    private AbsDisplayer mDisp;
    public IDrawTask mDrawTask;
    /* access modifiers changed from: private */
    public LinkedList<Long> mDrawTimes = new LinkedList<>();
    private boolean mFirstUpdateCalled;
    private FrameCallback mFrameCallback;
    /* access modifiers changed from: private */
    public long mFrameUpdateRate = 16;
    /* access modifiers changed from: private */
    public boolean mIdleSleep;
    private boolean mInSeekingAction;
    private boolean mInSyncAction;
    /* access modifiers changed from: private */
    public boolean mInWaitingState;
    private long mLastDeltaTime;
    /* access modifiers changed from: private */
    public boolean mNonBlockModeEnable;
    private BaseDanmakuParser mParser;
    /* access modifiers changed from: private */
    public long mPausedPosition = 0;
    /* access modifiers changed from: private */
    public boolean mQuitFlag = true;
    /* access modifiers changed from: private */
    public boolean mReady;
    private long mRemainingTime;
    /* access modifiers changed from: private */
    public final IRenderer.RenderingState mRenderingState = new IRenderer.RenderingState();
    private UpdateThread mThread;
    private long mThresholdTime;
    private long mTimeBase;
    /* access modifiers changed from: private */
    public DanmakuTimer mTimer = new DanmakuTimer();
    private boolean mUpdateInSeparateThread;

    public interface Callback {
        void commandBarragePause(BaseDanmaku baseDanmaku);

        void danmakuInvisible(BaseDanmaku baseDanmaku, int i2);

        void danmakuPrepare(BaseDanmaku baseDanmaku);

        void danmakuShown(BaseDanmaku baseDanmaku);

        void danmakuTranslate(BaseDanmaku baseDanmaku);

        void drawingFinished();

        void firstUpdateCalled();

        void prepared();

        void syncTime(DanmakuTimer danmakuTimer);

        void updateTimer(DanmakuTimer danmakuTimer);
    }

    public DrawHandler(Looper looper, IDanmakuViewController view2, boolean danmakuVisibile, IDanmakuDataProvider dataProvider2, boolean isUsedNewFramework2) {
        super(looper);
        this.dataProvider = dataProvider2;
        this.isUsedNewFramework = isUsedNewFramework2;
        this.mIdleSleep = true ^ DeviceUtils.isProblemBoxDevice();
        bindView(view2);
        if (danmakuVisibile) {
            showDanmakus((Long) null);
        } else {
            hideDanmakus(false);
        }
        this.mDanmakusVisible = danmakuVisibile;
    }

    private void bindView(IDanmakuViewController view2) {
        this.mDanmakuView = view2;
    }

    public void setIdleSleep(boolean enable) {
        this.mIdleSleep = enable;
    }

    public void enableNonBlockMode(boolean enable) {
        this.mNonBlockModeEnable = enable;
    }

    public void setConfig(DanmakuContext config) {
        this.mContext = config;
    }

    public void setParser(BaseDanmakuParser parser) {
        DanmakuTimer timer;
        this.mParser = parser;
        if (parser != null && (timer = parser.getTimer()) != null) {
            this.mTimer = timer;
        }
    }

    public void setCallback(Callback cb) {
        this.mCallback = cb;
    }

    public void quit() {
        this.mQuitFlag = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.mQuitFlag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020f, code lost:
        com.baidu.searchbox.danmakulib.util.BdDmkLog.d(TAG, "START ");
        r4 = (java.lang.Long) r2.obj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021a, code lost:
        if (r4 == null) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x021c, code lost:
        r1.mPausedPosition = r4.longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0223, code lost:
        r1.mPausedPosition = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0228, code lost:
        if (r3 != 4) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x022a, code lost:
        r1.mQuitFlag = true;
        quitUpdateThread();
        r4 = (java.lang.Long) r2.obj;
        r1.mTimeBase -= r4.longValue() - r1.mTimer.mCurrMillisecond;
        r1.mTimer.update(r4.longValue());
        r1.mContext.mGlobalFlagValues.updateMeasureFlag();
        r7 = r1.mDrawTask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0253, code lost:
        if (r7 == null) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0255, code lost:
        r7.seek(r4.longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x025c, code lost:
        r1.mPausedPosition = r4.longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0262, code lost:
        removeMessages(7);
        r1.mQuitFlag = false;
        com.baidu.searchbox.danmakulib.util.BdDmkLog.d(TAG, "RESUME mReady:" + r1.mReady);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0284, code lost:
        if (r1.mReady == false) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0286, code lost:
        r1.mFirstUpdateCalled = false;
        r1.mRenderingState.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028d, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r1.mDrawTimes.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0293, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0294, code lost:
        r4 = com.baidu.searchbox.danmakulib.danmaku.util.SystemClock.uptimeMillis();
        r6 = r1.mPausedPosition;
        r1.mTimeBase = r4 - r6;
        r1.mTimer.update(r6);
        removeMessages(3);
        sendEmptyMessage(2);
        removeMessages(17);
        sendEmptyMessageDelayed(17, 20000);
        r0 = r1.mDrawTask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02b2, code lost:
        if (r0 == null) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b4, code lost:
        r0.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b7, code lost:
        notifyRendering();
        r1.mInSeekingAction = false;
        r0 = r1.mDrawTask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02be, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c0, code lost:
        r0.onPlayStateChanged(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02c7, code lost:
        sendEmptyMessageDelayed(3, 100);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010a, code lost:
        removeMessages(3);
        removeMessages(2);
        r0 = r1.mDrawTask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0112, code lost:
        if (r0 == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0114, code lost:
        r0.onPlayStateChanged(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0117, code lost:
        com.baidu.searchbox.danmakulib.util.BdDmkLog.d(TAG, "QUIT ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011f, code lost:
        if (r3 != 6) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0121, code lost:
        removeCallbacksAndMessages((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0125, code lost:
        r1.mQuitFlag = true;
        syncTimerIfNeeded();
        r1.mPausedPosition = r1.mTimer.mCurrMillisecond;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0132, code lost:
        if (r1.mUpdateInSeparateThread == false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0134, code lost:
        notifyRendering();
        quitUpdateThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013e, code lost:
        if (r1.mContext.mUpdateMethod != 0) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0142, code lost:
        if (r1.mFrameCallback == null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
        if (android.os.Build.VERSION.SDK_INT < 16) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014a, code lost:
        android.view.Choreographer.getInstance().removeFrameCallback(r1.mFrameCallback);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0153, code lost:
        if (r3 != 6) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0155, code lost:
        r0 = r1.mDrawTask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0157, code lost:
        if (r0 == null) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0159, code lost:
        r0.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x015c, code lost:
        r0 = r1.mParser;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015e, code lost:
        if (r0 == null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0160, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x016b, code lost:
        if (getLooper() == android.os.Looper.getMainLooper()) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016d, code lost:
        getLooper().quit();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r16) {
        /*
            r15 = this;
            r1 = r15
            r2 = r16
            int r3 = r2.what
            r4 = 20000(0x4e20, double:9.8813E-320)
            r0 = 3
            r8 = 17
            r9 = 2
            r10 = 0
            r11 = 1
            switch(r3) {
                case 1: goto L_0x020f;
                case 2: goto L_0x01dc;
                case 3: goto L_0x0262;
                case 4: goto L_0x0227;
                case 5: goto L_0x0176;
                case 6: goto L_0x0117;
                case 7: goto L_0x010a;
                case 8: goto L_0x00ca;
                case 9: goto L_0x009c;
                case 10: goto L_0x0070;
                case 11: goto L_0x0064;
                case 12: goto L_0x004b;
                case 13: goto L_0x003e;
                case 14: goto L_0x0035;
                case 15: goto L_0x002c;
                case 16: goto L_0x0023;
                case 17: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x02cd
        L_0x0012:
            com.baidu.searchbox.danmakulib.controller.DrawHandler$Callback r0 = r1.mCallback
            if (r0 == 0) goto L_0x001b
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r6 = r1.mTimer
            r0.syncTime(r6)
        L_0x001b:
            r15.removeMessages(r8)
            r15.sendEmptyMessageDelayed(r8, r4)
            goto L_0x02cd
        L_0x0023:
            java.lang.Object r0 = r2.obj
            com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku r0 = (com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku) r0
            r15.addDanmaku(r0)
            goto L_0x02cd
        L_0x002c:
            java.lang.Object r0 = r2.obj
            com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus r0 = (com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus) r0
            r15.batchAddDanmaku(r0)
            goto L_0x02cd
        L_0x0035:
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x02cd
            r0.requestRender()
            goto L_0x02cd
        L_0x003e:
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x02cd
            long r4 = r15.getCurrentTime()
            r0.clearDanmakusOnScreen(r4)
            goto L_0x02cd
        L_0x004b:
            boolean r0 = r1.mQuitFlag
            if (r0 == 0) goto L_0x02cd
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r0 = r1.mDanmakuView
            if (r0 == 0) goto L_0x02cd
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x005a
            r0.requestClear()
        L_0x005a:
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r0 = r1.mDanmakuView
            r0.drawDanmakus()
            r15.notifyRendering()
            goto L_0x02cd
        L_0x0064:
            java.lang.String r0 = "DrawHandler"
            java.lang.String r4 = "NOTIFY_RENDERING "
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            r15.notifyRendering()
            goto L_0x02cd
        L_0x0070:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r0 = r1.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuFactory r0 = r0.mDanmakuFactory
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r4 = r1.mContext
            r0.notifyDispSizeChanged(r4)
            java.lang.Object r0 = r2.obj
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L_0x02cd
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x02cd
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r4 = r1.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.GlobalFlagValues r4 = r4.mGlobalFlagValues
            r4.updateMeasureFlag()
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r4 = r1.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.GlobalFlagValues r4 = r4.mGlobalFlagValues
            r4.updateVisibleFlag()
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            if (r4 == 0) goto L_0x02cd
            r4.requestClearRetainer()
            goto L_0x02cd
        L_0x009c:
            r1.mDanmakusVisible = r10
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r4 = r1.mDanmakuView
            if (r4 == 0) goto L_0x00a5
            r4.clear()
        L_0x00a5:
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            if (r4 == 0) goto L_0x00b1
            r4.requestClear()
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            r4.requestHide()
        L_0x00b1:
            java.lang.Object r4 = r2.obj
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r5 = r4.booleanValue()
            if (r5 == 0) goto L_0x00c2
            com.baidu.searchbox.danmakulib.controller.IDrawTask r5 = r1.mDrawTask
            if (r5 == 0) goto L_0x00c2
            r5.quit()
        L_0x00c2:
            boolean r5 = r4.booleanValue()
            if (r5 != 0) goto L_0x010a
            goto L_0x02cd
        L_0x00ca:
            r1.mDanmakusVisible = r11
            java.lang.Object r12 = r2.obj
            java.lang.Long r12 = (java.lang.Long) r12
            r13 = 0
            com.baidu.searchbox.danmakulib.controller.IDrawTask r14 = r1.mDrawTask
            if (r14 == 0) goto L_0x00f8
            if (r12 != 0) goto L_0x00e6
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r14 = r1.mTimer
            long r4 = r15.getCurrentTime()
            r14.update(r4)
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            r4.requestClear()
            goto L_0x00f8
        L_0x00e6:
            r14.start()
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            long r6 = r12.longValue()
            r4.seek(r6)
            com.baidu.searchbox.danmakulib.controller.IDrawTask r4 = r1.mDrawTask
            r4.requestClear()
            r13 = 1
        L_0x00f8:
            boolean r4 = r1.mQuitFlag
            if (r4 == 0) goto L_0x0103
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r4 = r1.mDanmakuView
            if (r4 == 0) goto L_0x0103
            r4.drawDanmakus()
        L_0x0103:
            r15.notifyRendering()
            if (r13 != 0) goto L_0x020f
            goto L_0x02cd
        L_0x010a:
            r15.removeMessages(r0)
            r15.removeMessages(r9)
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x0117
            r0.onPlayStateChanged(r9)
        L_0x0117:
            java.lang.String r0 = "DrawHandler"
            java.lang.String r4 = "QUIT "
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            r0 = 6
            if (r3 != r0) goto L_0x0125
            r4 = 0
            r15.removeCallbacksAndMessages(r4)
        L_0x0125:
            r1.mQuitFlag = r11
            r15.syncTimerIfNeeded()
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r4 = r1.mTimer
            long r4 = r4.mCurrMillisecond
            r1.mPausedPosition = r4
            boolean r4 = r1.mUpdateInSeparateThread
            if (r4 == 0) goto L_0x013a
            r15.notifyRendering()
            r15.quitUpdateThread()
        L_0x013a:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r4 = r1.mContext
            byte r4 = r4.mUpdateMethod
            if (r4 != 0) goto L_0x0153
            com.baidu.searchbox.danmakulib.controller.DrawHandler$FrameCallback r4 = r1.mFrameCallback
            if (r4 == 0) goto L_0x0153
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 16
            if (r4 < r5) goto L_0x0153
            android.view.Choreographer r4 = android.view.Choreographer.getInstance()
            com.baidu.searchbox.danmakulib.controller.DrawHandler$FrameCallback r5 = r1.mFrameCallback
            r4.removeFrameCallback(r5)
        L_0x0153:
            if (r3 != r0) goto L_0x02cd
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x015c
            r0.quit()
        L_0x015c:
            com.baidu.searchbox.danmakulib.danmaku.parser.BaseDanmakuParser r0 = r1.mParser
            if (r0 == 0) goto L_0x0163
            r0.release()
        L_0x0163:
            android.os.Looper r0 = r15.getLooper()
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            if (r0 == r4) goto L_0x02cd
            android.os.Looper r0 = r15.getLooper()
            r0.quit()
            goto L_0x02cd
        L_0x0176:
            java.lang.String r0 = "DrawHandler"
            java.lang.String r4 = "PREPARE "
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            long r4 = com.baidu.searchbox.danmakulib.danmaku.util.SystemClock.uptimeMillis()
            r1.mTimeBase = r4
            com.baidu.searchbox.danmakulib.danmaku.parser.BaseDanmakuParser r0 = r1.mParser
            if (r0 != 0) goto L_0x018b
            boolean r0 = r1.isUsedNewFramework
            if (r0 == 0) goto L_0x0193
        L_0x018b:
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r0 = r1.mDanmakuView
            boolean r0 = r0.isViewReady()
            if (r0 != 0) goto L_0x01c8
        L_0x0193:
            java.lang.String r0 = "DrawHandler"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "PREPARE mParser："
            java.lang.StringBuilder r4 = r4.append(r5)
            com.baidu.searchbox.danmakulib.danmaku.parser.BaseDanmakuParser r5 = r1.mParser
            if (r5 != 0) goto L_0x01a5
            r10 = r11
        L_0x01a5:
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = " mDanmakuView.isViewReady():"
            java.lang.StringBuilder r4 = r4.append(r5)
            com.baidu.searchbox.danmakulib.controller.IDanmakuViewController r5 = r1.mDanmakuView
            boolean r5 = r5.isViewReady()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            r0 = 5
            r4 = 100
            r15.sendEmptyMessageDelayed(r0, r4)
            goto L_0x02cd
        L_0x01c8:
            java.lang.String r0 = "DrawHandler"
            java.lang.String r4 = "PREPARE validateUpdateMethod"
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            r15.validateUpdateMethod()
            com.baidu.searchbox.danmakulib.controller.DrawHandler$1 r0 = new com.baidu.searchbox.danmakulib.controller.DrawHandler$1
            r0.<init>()
            r15.prepare(r0)
            goto L_0x02cd
        L_0x01dc:
            java.lang.String r0 = "DrawHandler"
            java.lang.String r4 = "UPDATE "
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r0, (java.lang.String) r4)
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r0 = r1.mContext
            byte r0 = r0.mUpdateMethod
            if (r0 != 0) goto L_0x01ed
            r15.updateInChoreographer()
            goto L_0x0200
        L_0x01ed:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r0 = r1.mContext
            byte r0 = r0.mUpdateMethod
            if (r0 != r11) goto L_0x01f7
            r15.updateInNewThread()
            goto L_0x0200
        L_0x01f7:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r0 = r1.mContext
            byte r0 = r0.mUpdateMethod
            if (r0 != r9) goto L_0x0200
            r15.updateInCurrentThread()
        L_0x0200:
            boolean r0 = r1.mFirstUpdateCalled
            if (r0 != 0) goto L_0x02cd
            r1.mFirstUpdateCalled = r11
            com.baidu.searchbox.danmakulib.controller.DrawHandler$Callback r0 = r1.mCallback
            if (r0 == 0) goto L_0x02cd
            r0.firstUpdateCalled()
            goto L_0x02cd
        L_0x020f:
            java.lang.String r4 = "DrawHandler"
            java.lang.String r5 = "START "
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r4, (java.lang.String) r5)
            java.lang.Object r4 = r2.obj
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0223
            long r5 = r4.longValue()
            r1.mPausedPosition = r5
            goto L_0x0227
        L_0x0223:
            r5 = 0
            r1.mPausedPosition = r5
        L_0x0227:
            r4 = 4
            if (r3 != r4) goto L_0x0262
            r1.mQuitFlag = r11
            r15.quitUpdateThread()
            java.lang.Object r4 = r2.obj
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r4.longValue()
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r7 = r1.mTimer
            long r12 = r7.mCurrMillisecond
            long r5 = r5 - r12
            long r12 = r1.mTimeBase
            long r12 = r12 - r5
            r1.mTimeBase = r12
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r7 = r1.mTimer
            long r12 = r4.longValue()
            r7.update(r12)
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r7 = r1.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.GlobalFlagValues r7 = r7.mGlobalFlagValues
            r7.updateMeasureFlag()
            com.baidu.searchbox.danmakulib.controller.IDrawTask r7 = r1.mDrawTask
            if (r7 == 0) goto L_0x025c
            long r12 = r4.longValue()
            r7.seek(r12)
        L_0x025c:
            long r12 = r4.longValue()
            r1.mPausedPosition = r12
        L_0x0262:
            r4 = 7
            r15.removeMessages(r4)
            r1.mQuitFlag = r10
            java.lang.String r4 = "DrawHandler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "RESUME mReady:"
            java.lang.StringBuilder r5 = r5.append(r6)
            boolean r6 = r1.mReady
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.baidu.searchbox.danmakulib.util.BdDmkLog.d((java.lang.String) r4, (java.lang.String) r5)
            boolean r4 = r1.mReady
            if (r4 == 0) goto L_0x02c7
            r1.mFirstUpdateCalled = r10
            com.baidu.searchbox.danmakulib.danmaku.renderer.IRenderer$RenderingState r4 = r1.mRenderingState
            r4.reset()
            monitor-enter(r15)
            java.util.LinkedList<java.lang.Long> r4 = r1.mDrawTimes     // Catch:{ all -> 0x02c4 }
            r4.clear()     // Catch:{ all -> 0x02c4 }
            monitor-exit(r15)     // Catch:{ all -> 0x02c4 }
            long r4 = com.baidu.searchbox.danmakulib.danmaku.util.SystemClock.uptimeMillis()
            long r6 = r1.mPausedPosition
            long r4 = r4 - r6
            r1.mTimeBase = r4
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r4 = r1.mTimer
            r4.update(r6)
            r15.removeMessages(r0)
            r15.sendEmptyMessage(r9)
            r15.removeMessages(r8)
            r4 = 20000(0x4e20, double:9.8813E-320)
            r15.sendEmptyMessageDelayed(r8, r4)
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x02b7
            r0.start()
        L_0x02b7:
            r15.notifyRendering()
            r1.mInSeekingAction = r10
            com.baidu.searchbox.danmakulib.controller.IDrawTask r0 = r1.mDrawTask
            if (r0 == 0) goto L_0x02cd
            r0.onPlayStateChanged(r11)
            goto L_0x02cd
        L_0x02c4:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x02c4 }
            throw r0
        L_0x02c7:
            r4 = 100
            r15.sendEmptyMessageDelayed(r0, r4)
        L_0x02cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.danmakulib.controller.DrawHandler.handleMessage(android.os.Message):void");
    }

    private synchronized void quitUpdateThread() {
        UpdateThread thread = this.mThread;
        this.mThread = null;
        if (thread != null) {
            synchronized (this.mDrawTask) {
                this.mDrawTask.notifyAll();
            }
            thread.quit();
            try {
                thread.join(2000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return;
    }

    private void updateInCurrentThread() {
        if (!this.mQuitFlag) {
            long d2 = syncTimer(SystemClock.uptimeMillis());
            if (d2 >= 0 || this.mNonBlockModeEnable) {
                IDanmakuViewController iDanmakuViewController = this.mDanmakuView;
                if (iDanmakuViewController != null) {
                    d2 = iDanmakuViewController.drawDanmakus();
                }
                removeMessages(2);
                if (d2 > this.mCordonTime2) {
                    this.mTimer.add(d2);
                    synchronized (this) {
                        this.mDrawTimes.clear();
                    }
                }
                if (!this.mDanmakusVisible) {
                    waitRendering(10000000);
                    return;
                }
                if (this.mRenderingState.mNothingRendered && this.mIdleSleep) {
                    long dTime = this.mRenderingState.mEndTime - this.mTimer.mCurrMillisecond;
                    if (dTime > 500) {
                        IDanmakuViewController iDanmakuViewController2 = this.mDanmakuView;
                        if (iDanmakuViewController2 != null) {
                            iDanmakuViewController2.clear();
                        }
                        waitRendering(dTime - 10);
                        return;
                    }
                }
                long dTime2 = this.mFrameUpdateRate;
                if (d2 < dTime2) {
                    sendEmptyMessageDelayed(2, dTime2 - d2);
                } else {
                    sendEmptyMessage(2);
                }
            } else {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - d2);
            }
        }
    }

    private void updateInNewThread() {
        if (this.mThread == null) {
            AnonymousClass2 r0 = new UpdateThread("DFM Update") {
                public void run() {
                    long lastTime = SystemClock.uptimeMillis();
                    while (!isQuited() && !DrawHandler.this.mQuitFlag) {
                        long startMS = SystemClock.uptimeMillis();
                        if (DrawHandler.this.mFrameUpdateRate - (SystemClock.uptimeMillis() - lastTime) <= 1 || DrawHandler.this.mNonBlockModeEnable) {
                            lastTime = startMS;
                            long d2 = DrawHandler.this.syncTimer(startMS);
                            if (d2 >= 0 || DrawHandler.this.mNonBlockModeEnable) {
                                if (DrawHandler.this.mDanmakuView != null) {
                                    d2 = DrawHandler.this.mDanmakuView.drawDanmakus();
                                }
                                if (d2 > DrawHandler.this.mCordonTime2) {
                                    DrawHandler.this.mTimer.add(d2);
                                    synchronized (this) {
                                        DrawHandler.this.mDrawTimes.clear();
                                    }
                                }
                                if (!DrawHandler.this.mDanmakusVisible) {
                                    DrawHandler.this.waitRendering(10000000);
                                } else if (DrawHandler.this.mRenderingState.mNothingRendered && DrawHandler.this.mIdleSleep) {
                                    long dTime = DrawHandler.this.mRenderingState.mEndTime - DrawHandler.this.mTimer.mCurrMillisecond;
                                    if (dTime > 500) {
                                        if (DrawHandler.this.mDanmakuView != null) {
                                            DrawHandler.this.mDanmakuView.clear();
                                        }
                                        DrawHandler.this.notifyRendering();
                                        DrawHandler.this.waitRendering(dTime - 10);
                                    }
                                    long j2 = dTime;
                                }
                            } else {
                                SystemClock.sleep(60 - d2);
                            }
                        } else {
                            SystemClock.sleep(1);
                        }
                    }
                }
            };
            this.mThread = r0;
            r0.start();
        }
    }

    private class FrameCallback implements Choreographer.FrameCallback {
        private FrameCallback() {
        }

        public void doFrame(long frameTimeNanos) {
            DrawHandler.this.sendEmptyMessage(2);
        }
    }

    private void updateInChoreographer() {
        if (!this.mQuitFlag) {
            long d2 = syncTimer(SystemClock.uptimeMillis());
            if (d2 < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - d2);
                return;
            }
            IDanmakuViewController iDanmakuViewController = this.mDanmakuView;
            if (iDanmakuViewController != null) {
                d2 = iDanmakuViewController.drawDanmakus();
            }
            removeMessages(2);
            if (d2 > this.mCordonTime2) {
                this.mTimer.add(d2);
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
            }
            if (!this.mDanmakusVisible) {
                waitRendering(10000000);
                return;
            }
            if (this.mRenderingState.mNothingRendered && this.mIdleSleep) {
                long dTime = this.mRenderingState.mEndTime - this.mTimer.mCurrMillisecond;
                if (dTime > 500) {
                    IDanmakuViewController iDanmakuViewController2 = this.mDanmakuView;
                    if (iDanmakuViewController2 != null) {
                        iDanmakuViewController2.clear();
                    }
                    waitRendering(dTime - 10);
                    return;
                }
            }
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long syncTimer(long r17) {
        /*
            r16 = this;
            r0 = r16
            boolean r1 = r0.mInSeekingAction
            r2 = 0
            if (r1 != 0) goto L_0x00bc
            boolean r1 = r0.mInSyncAction
            if (r1 == 0) goto L_0x000e
            goto L_0x00bc
        L_0x000e:
            r1 = 1
            r0.mInSyncAction = r1
            r4 = 0
            long r6 = r0.mTimeBase
            long r6 = r17 - r6
            boolean r1 = r0.mNonBlockModeEnable
            if (r1 == 0) goto L_0x002c
            com.baidu.searchbox.danmakulib.controller.DrawHandler$Callback r1 = r0.mCallback
            if (r1 == 0) goto L_0x00b8
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r2 = r0.mTimer
            r1.updateTimer(r2)
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r1 = r0.mTimer
            long r4 = r1.lastInterval()
            goto L_0x00b8
        L_0x002c:
            boolean r1 = r0.mDanmakusVisible
            if (r1 == 0) goto L_0x00a8
            com.baidu.searchbox.danmakulib.danmaku.renderer.IRenderer$RenderingState r1 = r0.mRenderingState
            boolean r1 = r1.mNothingRendered
            if (r1 != 0) goto L_0x00a8
            boolean r1 = r0.mInWaitingState
            if (r1 == 0) goto L_0x003c
            goto L_0x00a8
        L_0x003c:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r1 = r0.mTimer
            long r1 = r1.mCurrMillisecond
            long r1 = r6 - r1
            long r8 = r0.mFrameUpdateRate
            long r10 = r16.getAverageRenderingTime()
            long r8 = java.lang.Math.max(r8, r10)
            r10 = 2000(0x7d0, double:9.88E-321)
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            com.baidu.searchbox.danmakulib.danmaku.renderer.IRenderer$RenderingState r3 = r0.mRenderingState
            long r10 = r3.mConsumingTime
            long r12 = r0.mCordonTime
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            int r3 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0061
            goto L_0x0093
        L_0x0061:
            long r10 = r0.mFrameUpdateRate
            long r12 = r1 / r10
            long r12 = r12 + r8
            long r3 = java.lang.Math.max(r10, r12)
            long r10 = r0.mCordonTime
            long r3 = java.lang.Math.min(r10, r3)
            long r10 = r0.mLastDeltaTime
            long r12 = r3 - r10
            r14 = 3
            int r5 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x008e
            r14 = 8
            int r5 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x008e
            long r14 = r0.mFrameUpdateRate
            int r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r5 < 0) goto L_0x008e
            long r14 = r0.mCordonTime
            int r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r5 > 0) goto L_0x008e
            long r3 = r0.mLastDeltaTime
        L_0x008e:
            long r1 = r1 - r3
            r0.mLastDeltaTime = r3
            r4 = r3
            goto L_0x0097
        L_0x0093:
            r3 = r1
            r1 = 0
            r4 = r3
        L_0x0097:
            r0.mRemainingTime = r1
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r3 = r0.mTimer
            r3.add(r4)
            com.baidu.searchbox.danmakulib.controller.DrawHandler$Callback r3 = r0.mCallback
            if (r3 == 0) goto L_0x00b8
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r10 = r0.mTimer
            r3.updateTimer(r10)
            goto L_0x00b8
        L_0x00a8:
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r1 = r0.mTimer
            r1.update(r6)
            r0.mRemainingTime = r2
            com.baidu.searchbox.danmakulib.controller.DrawHandler$Callback r1 = r0.mCallback
            if (r1 == 0) goto L_0x00b8
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r2 = r0.mTimer
            r1.updateTimer(r2)
        L_0x00b8:
            r1 = 0
            r0.mInSyncAction = r1
            return r4
        L_0x00bc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.danmakulib.controller.DrawHandler.syncTimer(long):long");
    }

    private void syncTimerIfNeeded() {
        if (this.mInWaitingState) {
            syncTimer(SystemClock.uptimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public void initRenderingConfigs() {
        long max = Math.max(33, (long) (((float) 16) * 2.5f));
        this.mCordonTime = max;
        this.mCordonTime2 = (long) (((float) max) * 2.5f);
        long max2 = Math.max(16, (16 / 15) * 15);
        this.mFrameUpdateRate = max2;
        this.mThresholdTime = max2 + 3;
    }

    private void prepare(final Runnable runnable) {
        if (this.mDrawTask == null) {
            this.mDrawTask = createDrawTask(this.mDanmakuView.isDanmakuDrawingCacheEnabled(), this.mTimer, this.mDanmakuView.getContext(), this.mDanmakuView.getViewWidth(), this.mDanmakuView.getViewHeight(), this.mDanmakuView.isHardwareAccelerated(), new IDrawTask.TaskListener() {
                public void ready() {
                    DrawHandler.this.initRenderingConfigs();
                    runnable.run();
                }

                public void onDanmakuAdd(BaseDanmaku danmaku) {
                    if (danmaku != null && !danmaku.isTimeOut()) {
                        long delay = danmaku.getActualTime() - DrawHandler.this.getCurrentTime();
                        if (delay < DrawHandler.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION && (DrawHandler.this.mInWaitingState || DrawHandler.this.mRenderingState.mNothingRendered)) {
                            DrawHandler.this.notifyRendering();
                        } else if (delay > 0 && delay <= DrawHandler.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) {
                            DrawHandler.this.sendEmptyMessageDelayed(11, delay);
                        }
                    }
                }

                public void onDanmakuShown(BaseDanmaku danmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.danmakuShown(danmaku);
                    }
                }

                public void onDanmakusDrawingFinished() {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.drawingFinished();
                    }
                }

                public void onCommandDanmakuPause(BaseDanmaku danmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.commandBarragePause(danmaku);
                    }
                }

                public void onDanmakuTranslate(BaseDanmaku danmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        try {
                            DrawHandler.this.mCallback.danmakuTranslate(danmaku);
                        } catch (Exception e2) {
                            BdDmkLog.d(e2.getMessage());
                        }
                    }
                }

                public void onDanmakuPrepare(BaseDanmaku danmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        try {
                            DrawHandler.this.mCallback.danmakuPrepare(danmaku);
                        } catch (Exception e2) {
                            BdDmkLog.d(e2.getMessage());
                        }
                    }
                }

                public void onDanmakuInvisible(BaseDanmaku danmaku, int action) {
                    if (DrawHandler.this.mCallback != null) {
                        try {
                            DrawHandler.this.mCallback.danmakuInvisible(danmaku, action);
                        } catch (Exception e2) {
                            BdDmkLog.d(e2.getMessage());
                        }
                    }
                }

                public void onDanmakuConfigChanged() {
                    DrawHandler.this.redrawIfNeeded();
                }
            });
            return;
        }
        runnable.run();
    }

    public boolean isPrepared() {
        return this.mReady;
    }

    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r15v1, types: [com.baidu.searchbox.danmakulib.controller.DrawTask] */
    /* JADX WARNING: type inference failed for: r8v5, types: [com.baidu.searchbox.danmakulib.controller.CacheManagingDrawTask] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.searchbox.danmakulib.controller.IDrawTask createDrawTask(boolean r22, com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer r23, android.content.Context r24, int r25, int r26, boolean r27, com.baidu.searchbox.danmakulib.controller.IDrawTask.TaskListener r28) {
        /*
            r21 = this;
            r0 = r21
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r1 = r0.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r1 = r1.getDisplayer()
            r0.mDisp = r1
            r2 = r25
            r3 = r26
            r1.setSize(r2, r3)
            android.content.res.Resources r1 = r24.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r4 = r0.mDisp
            float r5 = r1.density
            int r6 = r1.densityDpi
            float r7 = r1.scaledDensity
            r4.setDensities(r5, r6, r7)
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r4 = r0.mDisp
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r5 = r0.mContext
            float r5 = r5.mScaleTextSize
            r4.resetSlopPixel(r5)
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r4 = r0.mDisp
            r5 = r27
            r4.setHardwareAccelerated(r5)
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r4 = r0.mDisp
            int r4 = r4.getWidth()
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r6 = r0.mDisp
            int r6 = r6.getHeight()
            com.baidu.searchbox.danmakulib.danmaku.model.AbsDisplayer r7 = r0.mDisp
            float r7 = r7.getViewportSizeFactor()
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r8 = r0.mContext
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuFactory r8 = r8.mDanmakuFactory
            float r9 = (float) r4
            float r10 = (float) r6
            r8.updateViewportState(r9, r10, r7)
            if (r22 == 0) goto L_0x0062
            com.baidu.searchbox.danmakulib.controller.CacheManagingDrawTask r14 = new com.baidu.searchbox.danmakulib.controller.CacheManagingDrawTask
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r10 = r0.mContext
            com.baidu.searchbox.danmakulib.danmaku.data.IDanmakuDataProvider r12 = r0.dataProvider
            boolean r13 = r0.isUsedNewFramework
            r8 = r14
            r9 = r23
            r11 = r28
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x0078
        L_0x0062:
            com.baidu.searchbox.danmakulib.controller.DrawTask r14 = new com.baidu.searchbox.danmakulib.controller.DrawTask
            com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext r8 = r0.mContext
            com.baidu.searchbox.danmakulib.danmaku.data.IDanmakuDataProvider r9 = r0.dataProvider
            boolean r10 = r0.isUsedNewFramework
            r15 = r14
            r16 = r23
            r17 = r8
            r18 = r28
            r19 = r9
            r20 = r10
            r15.<init>(r16, r17, r18, r19, r20)
        L_0x0078:
            r8 = r14
            com.baidu.searchbox.danmakulib.danmaku.parser.BaseDanmakuParser r9 = r0.mParser
            r8.setParser(r9)
            r8.prepare()
            r9 = 10
            r10 = 0
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            android.os.Message r9 = r0.obtainMessage(r9, r10)
            r9.sendToTarget()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.danmakulib.controller.DrawHandler.createDrawTask(boolean, com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer, android.content.Context, int, int, boolean, com.baidu.searchbox.danmakulib.controller.IDrawTask$TaskListener):com.baidu.searchbox.danmakulib.controller.IDrawTask");
    }

    public void seekTo(Long ms) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = ms.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, ms).sendToTarget();
    }

    public void addDanmaku(BaseDanmaku item) {
        IDanmakuDataProvider iDanmakuDataProvider;
        if (this.mDrawTask != null) {
            item.mFlags = this.mContext.mGlobalFlagValues;
            item.setTimer(this.mTimer);
            if (this.isUsedNewFramework && (iDanmakuDataProvider = this.dataProvider) != null) {
                iDanmakuDataProvider.addNativeDanmaku(item);
            }
            this.mDrawTask.addDanmaku(item);
            obtainMessage(11).sendToTarget();
        }
    }

    public void postAddDanmaku(BaseDanmaku item) {
        removeMessages(16);
        obtainMessage(16, item).sendToTarget();
    }

    public void batchAddDanmaku(IDanmakus danmakus) {
        if (this.mDrawTask != null && danmakus != null && !danmakus.isEmpty()) {
            danmakus.forEach(new IDanmakus.Consumer<BaseDanmaku, Object>() {
                public int accept(BaseDanmaku t) {
                    t.mFlags = DrawHandler.this.mContext.mGlobalFlagValues;
                    t.setTimer(DrawHandler.this.mTimer);
                    return 0;
                }
            });
            this.mDrawTask.batchAddDanmaku(danmakus);
            obtainMessage(11).sendToTarget();
        }
    }

    public void postBatchAddDanmaku(IDanmakus danmakus) {
        removeMessages(15);
        obtainMessage(15, danmakus).sendToTarget();
    }

    public void invalidateDanmaku(BaseDanmaku item, boolean remeasure) {
        IDrawTask iDrawTask = this.mDrawTask;
        if (!(iDrawTask == null || item == null)) {
            iDrawTask.invalidateDanmaku(item, remeasure);
        }
        redrawIfNeeded();
    }

    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void prepare() {
        BdDmkLog.d(TAG, "prepare");
        boolean z = false;
        this.mReady = false;
        if (Build.VERSION.SDK_INT <= 20 && this.mContext.mUpdateMethod == 0) {
            this.mContext.mUpdateMethod = 2;
        }
        validateUpdateMethod();
        if (this.mContext.mUpdateMethod == 1) {
            z = true;
        }
        this.mUpdateInSeparateThread = z;
        sendEmptyMessage(5);
    }

    private void validateUpdateMethod() {
        DanmakuContext danmakuContext = this.mContext;
        if (danmakuContext != null && danmakuContext.mUpdateMethod == 0) {
            this.mFrameCallback = new FrameCallback();
            try {
                Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                    public void doFrame(long frameTimeNanos) {
                    }
                });
            } catch (Exception e2) {
                this.mContext.mUpdateMethod = 2;
                this.mFrameCallback = null;
            }
        }
    }

    public void pause() {
        removeMessages(3);
        syncTimerIfNeeded();
        sendEmptyMessage(7);
    }

    public void showDanmakus(Long position) {
        this.mDanmakusVisible = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, position).sendToTarget();
    }

    public long hideDanmakus(boolean quitDrawTask) {
        BdDmkLog.d(TAG, "hideDanmakus quitDrawTask:" + quitDrawTask);
        if (!this.mDanmakusVisible) {
            return this.mTimer.mCurrMillisecond;
        }
        this.mDanmakusVisible = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(quitDrawTask)).sendToTarget();
        return this.mTimer.mCurrMillisecond;
    }

    public void forceRender() {
        removeMessages(14);
        obtainMessage(14).sendToTarget();
    }

    public boolean getVisibility() {
        return this.mDanmakusVisible;
    }

    public IRenderer.RenderingState draw(Canvas canvas) {
        AbsDanmakuSync danmakuSync;
        boolean isSyncPlayingState;
        if (this.mDrawTask == null) {
            return this.mRenderingState;
        }
        if (!this.mInWaitingState && (danmakuSync = this.mContext.mDanmakuSync) != null && ((isSyncPlayingState = danmakuSync.isSyncPlayingState()) || !this.mQuitFlag)) {
            int syncState = danmakuSync.getSyncState();
            if (syncState == 2) {
                long fromTime = this.mTimer.mCurrMillisecond;
                long toTime = danmakuSync.getUptimeMillis();
                long offset = toTime - fromTime;
                if (Math.abs(offset) > danmakuSync.getThresholdTimeMills()) {
                    if (isSyncPlayingState && this.mQuitFlag) {
                        resume();
                    }
                    this.mDrawTask.requestSync(fromTime, toTime, offset);
                    this.mTimer.update(toTime);
                    this.mTimeBase -= offset;
                    this.mRemainingTime = 0;
                }
            } else if (syncState == 1 && isSyncPlayingState && !this.mQuitFlag) {
                pause();
            }
        }
        this.mDisp.setExtraData(canvas);
        this.mRenderingState.set(this.mDrawTask.draw(this.mDisp));
        recordRenderingTime();
        return this.mRenderingState;
    }

    /* access modifiers changed from: private */
    public void redrawIfNeeded() {
        if (this.mQuitFlag && this.mDanmakusVisible) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100);
        }
    }

    /* access modifiers changed from: private */
    public void notifyRendering() {
        if (this.mInWaitingState) {
            IDrawTask iDrawTask = this.mDrawTask;
            if (iDrawTask != null) {
                iDrawTask.requestClear();
            }
            if (this.mUpdateInSeparateThread) {
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
                IDrawTask iDrawTask2 = this.mDrawTask;
                if (iDrawTask2 != null) {
                    synchronized (iDrawTask2) {
                        this.mDrawTask.notifyAll();
                    }
                }
            } else {
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.mInWaitingState = false;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    /* access modifiers changed from: private */
    public void waitRendering(long dTime) {
        if (!isStop() && isPrepared() && !this.mInSeekingAction) {
            this.mRenderingState.mSysTime = SystemClock.uptimeMillis();
            this.mInWaitingState = true;
            if (this.mUpdateInSeparateThread) {
                if (this.mThread != null) {
                    try {
                        synchronized (this.mDrawTask) {
                            if (dTime == 10000000) {
                                this.mDrawTask.wait();
                            } else {
                                this.mDrawTask.wait(dTime);
                            }
                            sendEmptyMessage(11);
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (dTime == 10000000) {
                removeMessages(11);
                removeMessages(2);
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, dTime);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long getAverageRenderingTime() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.LinkedList<java.lang.Long> r0 = r7.mDrawTimes     // Catch:{ all -> 0x0032 }
            int r0 = r0.size()     // Catch:{ all -> 0x0032 }
            r1 = 0
            if (r0 > 0) goto L_0x000d
            monitor-exit(r7)
            return r1
        L_0x000d:
            java.util.LinkedList<java.lang.Long> r3 = r7.mDrawTimes     // Catch:{ all -> 0x0032 }
            java.lang.Object r3 = r3.peekFirst()     // Catch:{ all -> 0x0032 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0032 }
            java.util.LinkedList<java.lang.Long> r4 = r7.mDrawTimes     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r4.peekLast()     // Catch:{ all -> 0x0032 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0030
            if (r4 != 0) goto L_0x0022
            goto L_0x0030
        L_0x0022:
            long r1 = r4.longValue()     // Catch:{ all -> 0x0032 }
            long r5 = r3.longValue()     // Catch:{ all -> 0x0032 }
            long r1 = r1 - r5
            long r5 = (long) r0     // Catch:{ all -> 0x0032 }
            long r5 = r1 / r5
            monitor-exit(r7)
            return r5
        L_0x0030:
            monitor-exit(r7)
            return r1
        L_0x0032:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.danmakulib.controller.DrawHandler.getAverageRenderingTime():long");
    }

    private synchronized void recordRenderingTime() {
        this.mDrawTimes.addLast(Long.valueOf(SystemClock.uptimeMillis()));
        if (this.mDrawTimes.size() > 500) {
            this.mDrawTimes.removeFirst();
        }
    }

    public IDisplayer getDisplayer() {
        return this.mDisp;
    }

    public void notifyDispSizeChanged(int width, int height) {
        AbsDisplayer absDisplayer = this.mDisp;
        if (absDisplayer != null) {
            if (absDisplayer.getWidth() != width || this.mDisp.getHeight() != height) {
                this.mDisp.setSize(width, height);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void removeAllDanmakus(boolean isClearDanmakusOnScreen) {
        IDrawTask iDrawTask = this.mDrawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllDanmakus(isClearDanmakusOnScreen);
        }
    }

    public void removeAllLiveDanmakus() {
        IDrawTask iDrawTask = this.mDrawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllLiveDanmakus();
        }
    }

    public IDanmakus getCurrentVisibleDanmakus() {
        IDrawTask iDrawTask = this.mDrawTask;
        if (iDrawTask != null) {
            return iDrawTask.getVisibleDanmakusOnTime(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0;
        }
        if (this.mInSeekingAction) {
            return this.mDesireSeekingTime;
        }
        if (this.mQuitFlag || !this.mInWaitingState) {
            return this.mTimer.mCurrMillisecond - this.mRemainingTime;
        }
        return SystemClock.uptimeMillis() - this.mTimeBase;
    }

    public void clearDanmakusOnScreen() {
        obtainMessage(13).sendToTarget();
    }

    public DanmakuContext getConfig() {
        return this.mContext;
    }

    public void setQuitFlag(boolean flag) {
        this.mQuitFlag = flag;
    }

    public BaseDanmakuParser getParser() {
        return this.mParser;
    }
}
