package com.baidu.cyberplayer.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.searchbox.aisearch.utils.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class DuplayerHandlerThreadPool {
    private static final int JELLY_BEAN_MR2 = 18;
    private static final int MAX_POOL_THREAD_SIZE = 3;
    private static final int MAX_THREAD_IDLE_TIME_LONG = 900000;
    private static final int MAX_THREAD_IDLE_TIME_SHORT = 120000;
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";
    private static final Object sPoolSync = new Object();
    private ArrayList<DuplayerHandlerThread> mBusyPool;
    private PrivateHandler mHandler;
    DuplayerHandlerThreadFactory mHandlerThreadFactory;
    private ArrayList<DuplayerHandlerThread> mIdlePool;

    private DuplayerHandlerThreadPool() {
        this.mIdlePool = new ArrayList<>();
        this.mBusyPool = new ArrayList<>();
        this.mHandlerThreadFactory = new DuplayerHandlerThreadFactory("duplayer-t");
        this.mHandler = new PrivateHandler(Looper.getMainLooper());
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static DuplayerHandlerThreadPool sInstance = new DuplayerHandlerThreadPool();

        private Holder() {
        }
    }

    public static DuplayerHandlerThreadPool getInstance() {
        return Holder.sInstance;
    }

    private DuplayerHandlerThread newHandlerThread() {
        DuplayerHandlerThread handlerThread = this.mHandlerThreadFactory.newHandlerThread();
        handlerThread.start();
        return handlerThread;
    }

    public DuplayerHandlerThread obtain() {
        DuplayerHandlerThread handlerThread;
        synchronized (sPoolSync) {
            if (this.mIdlePool.size() == 0) {
                handlerThread = newHandlerThread();
            } else {
                int lastIndex = this.mIdlePool.size() - 1;
                DuplayerHandlerThread handlerThread2 = this.mIdlePool.get(lastIndex);
                this.mIdlePool.remove(lastIndex);
                if (handlerThread2 == null) {
                    handlerThread = newHandlerThread();
                } else {
                    handlerThread = handlerThread2;
                }
            }
            handlerThread.setRunState(1);
            handlerThread.setIdleBeginTime(-1);
            this.mBusyPool.add(handlerThread);
            if (this.mIdlePool.size() <= 0) {
                this.mHandler.removeMessages(100);
            }
            if (this.mIdlePool.size() <= 3) {
                this.mHandler.removeMessages(101);
            }
            CyberLog.d(TAG, " obtain handlerThread:" + handlerThread);
            print();
        }
        return handlerThread;
    }

    public void recycle(DuplayerHandlerThread handlerThread) {
        if (handlerThread != null) {
            CyberLog.d(TAG, " recycle handlerThread:" + handlerThread);
            synchronized (sPoolSync) {
                handlerThread.setIdleBeginTime(SystemClock.uptimeMillis());
                handlerThread.setRunState(0);
                this.mBusyPool.remove(handlerThread);
                this.mIdlePool.add(handlerThread);
                if (this.mIdlePool.size() > 0) {
                    this.mHandler.sendEmptyMessageDelayed(100, 900000);
                }
                if (this.mIdlePool.size() > 3) {
                    this.mHandler.sendEmptyMessageDelayed(101, 120000);
                }
                print();
            }
            CyberLog.d(TAG, " recycle  end ");
        }
    }

    private void quitHandlerThread(DuplayerHandlerThread handlerThread) {
        CyberLog.d(TAG, " quitHandlerThread handlerThread:" + handlerThread);
        if (handlerThread == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            handlerThread.getLooper().quit();
        } else if (handlerThread != null) {
            try {
                handlerThread.getLooper().quitSafely();
            } catch (NoSuchMethodError e2) {
                handlerThread.getLooper().quit();
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkIdlePoolShortTimeNoUse() {
        synchronized (sPoolSync) {
            int size = this.mIdlePool.size();
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int delta = size - 3;
                Iterator<DuplayerHandlerThread> iterator = this.mIdlePool.iterator();
                while (iterator.hasNext() && delta > 0) {
                    DuplayerHandlerThread next = iterator.next();
                    if (next != null) {
                        long beginTime = next.getIdleBeginTime();
                        if (beginTime > 0 && SystemClock.uptimeMillis() - beginTime >= 120000) {
                            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                            iterator.remove();
                            quitHandlerThread(next);
                            delta--;
                        }
                    }
                }
                print();
            }
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse end");
        }
    }

    public void checkIdlePoolLongTimeNoUse() {
        synchronized (sPoolSync) {
            if (this.mIdlePool.size() > 0) {
                CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse called size:" + this.mIdlePool.size());
                Iterator<DuplayerHandlerThread> iterator = this.mIdlePool.iterator();
                while (iterator.hasNext()) {
                    DuplayerHandlerThread next = iterator.next();
                    if (next != null) {
                        long beginTime = next.getIdleBeginTime();
                        CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - beginTime));
                        if (beginTime > 0 && SystemClock.uptimeMillis() - beginTime >= 900000) {
                            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use");
                            iterator.remove();
                            quitHandlerThread(next);
                        }
                    }
                }
                print();
                CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse  called end");
            }
        }
    }

    public void print() {
        synchronized (sPoolSync) {
            int size = this.mIdlePool.size();
            CyberLog.d(TAG, "-- mIdlePool size:" + size + DateUtils.INVALID_TIMES);
            for (int i2 = 0; i2 < size; i2++) {
                CyberLog.d(TAG, "-- mIdlePool i:" + i2 + " " + this.mIdlePool.get(i2) + " --");
            }
            int size2 = this.mBusyPool.size();
            CyberLog.d(TAG, "-- mBusyPool size:" + size2 + " --");
            for (int i3 = 0; i3 < size2; i3++) {
                CyberLog.d(TAG, "-- mBusyPool i:" + i3 + " " + this.mBusyPool.get(i3) + " --");
            }
        }
    }

    private static class PrivateHandler extends Handler {
        private PrivateHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    DuplayerHandlerThreadPool.getInstance().checkIdlePoolLongTimeNoUse();
                    return;
                case 101:
                    DuplayerHandlerThreadPool.getInstance().checkIdlePoolShortTimeNoUse();
                    return;
                default:
                    return;
            }
        }
    }

    private static class DuplayerHandlerThreadFactory {
        private final String mNamePrefix;
        private int mPriority = 5;
        private final AtomicInteger mThreadNumber = new AtomicInteger(1);

        DuplayerHandlerThreadFactory(String namePrefix, int priority) {
            this.mNamePrefix = namePrefix + "-";
            this.mPriority = priority;
        }

        DuplayerHandlerThreadFactory(String namePrefix) {
            this.mNamePrefix = namePrefix + "-";
            this.mPriority = 5;
        }

        public DuplayerHandlerThread newHandlerThread() {
            DuplayerHandlerThread t = new DuplayerHandlerThread(this.mNamePrefix + this.mThreadNumber.getAndIncrement());
            t.setPriority(this.mPriority);
            return t;
        }
    }
}
