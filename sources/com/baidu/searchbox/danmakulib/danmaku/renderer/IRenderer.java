package com.baidu.searchbox.danmakulib.danmaku.renderer;

import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer;
import com.baidu.searchbox.danmakulib.danmaku.model.Danmakus;
import com.baidu.searchbox.danmakulib.danmaku.model.ICacheManager;
import com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus;
import com.baidu.searchbox.danmakulib.danmaku.model.IDisplayer;
import com.baidu.searchbox.danmakulib.interfaces.OnDanmakuTranslateListener;

public interface IRenderer {
    public static final int CACHE_RENDERING = 1;
    public static final int NOTHING_RENDERING = 0;
    public static final int TEXT_RENDERING = 2;

    public interface OnDanmakuPositionListener {
        void onGetCurPos(BaseDanmaku baseDanmaku);
    }

    public interface OnDanmakuShownListener {
        void onDanmakuShown(BaseDanmaku baseDanmaku);
    }

    void alignBottom(boolean z);

    void clear();

    void clearRetainer();

    void draw(IDisplayer iDisplayer, IDanmakus iDanmakus, long j2, RenderingState renderingState);

    void release();

    void removeOnDanmakuShownListener();

    void removeOnDanmakuTranslateListener();

    void setCacheManager(ICacheManager iCacheManager);

    void setOnDanmakuPosListener(OnDanmakuPositionListener onDanmakuPositionListener);

    void setOnDanmakuShownListener(OnDanmakuShownListener onDanmakuShownListener);

    void setOnDanmakuTranslateListener(OnDanmakuTranslateListener onDanmakuTranslateListener);

    void setVerifierEnabled(boolean z);

    public static class Area {
        private int mMaxHeight;
        private int mMaxWidth;
        public final float[] mRefreshRect = new float[4];

        public void setEdge(int maxWidth, int maxHeight) {
            this.mMaxWidth = maxWidth;
            this.mMaxHeight = maxHeight;
        }

        public void reset() {
            set((float) this.mMaxWidth, (float) this.mMaxHeight, 0.0f, 0.0f);
        }

        public void resizeToMax() {
            set(0.0f, 0.0f, (float) this.mMaxWidth, (float) this.mMaxHeight);
        }

        public void set(float left, float top, float right, float bottom) {
            float[] fArr = this.mRefreshRect;
            fArr[0] = left;
            fArr[1] = top;
            fArr[2] = right;
            fArr[3] = bottom;
        }
    }

    public static class RenderingState {
        public static final int UNKNOWN_TIME = -1;
        public long mBeginTime;
        public long mCacheHitCount;
        public long mCacheMissCount;
        public long mConsumingTime;
        public long mEndTime;
        public int mFbDanmakuCount;
        public int mFtDanmakuCount;
        public int mIndexInScreen;
        private boolean mIsObtaining;
        public boolean mIsRunningDanmakus;
        public int mL2rDanmakuCount;
        public BaseDanmaku mLastDanmaku;
        public int mLastTotalDanmakuCount;
        public boolean mNothingRendered;
        public int mR2lDanmakuCount;
        private IDanmakus mRunningDanmakus = new Danmakus(4);
        public int mSpecialDanmakuCount;
        public long mSysTime;
        public DanmakuTimer mTimer = new DanmakuTimer();
        public int mTotalDanmakuCount;
        public int mTotalSizeInScreen;

        public int addTotalCount(int count) {
            int i2 = this.mTotalDanmakuCount + count;
            this.mTotalDanmakuCount = i2;
            return i2;
        }

        public int addCount(int type, int count) {
            switch (type) {
                case 1:
                    int i2 = this.mR2lDanmakuCount + count;
                    this.mR2lDanmakuCount = i2;
                    return i2;
                case 4:
                    int i3 = this.mFbDanmakuCount + count;
                    this.mFbDanmakuCount = i3;
                    return i3;
                case 5:
                    int i4 = this.mFtDanmakuCount + count;
                    this.mFtDanmakuCount = i4;
                    return i4;
                case 6:
                    int i5 = this.mL2rDanmakuCount + count;
                    this.mL2rDanmakuCount = i5;
                    return i5;
                case 7:
                    int i6 = this.mSpecialDanmakuCount + count;
                    this.mSpecialDanmakuCount = i6;
                    return i6;
                default:
                    return 0;
            }
        }

        public void reset() {
            this.mLastTotalDanmakuCount = this.mTotalDanmakuCount;
            this.mFtDanmakuCount = 0;
            this.mL2rDanmakuCount = 0;
            this.mR2lDanmakuCount = 0;
            this.mTotalDanmakuCount = 0;
            this.mSpecialDanmakuCount = 0;
            this.mFbDanmakuCount = 0;
            this.mConsumingTime = 0;
            this.mEndTime = 0;
            this.mBeginTime = 0;
            this.mSysTime = 0;
            this.mNothingRendered = false;
            synchronized (this) {
                this.mRunningDanmakus.clear();
            }
        }

        public void set(RenderingState other) {
            if (other != null) {
                this.mLastTotalDanmakuCount = other.mLastTotalDanmakuCount;
                this.mR2lDanmakuCount = other.mR2lDanmakuCount;
                this.mL2rDanmakuCount = other.mL2rDanmakuCount;
                this.mFtDanmakuCount = other.mFtDanmakuCount;
                this.mFbDanmakuCount = other.mFbDanmakuCount;
                this.mSpecialDanmakuCount = other.mSpecialDanmakuCount;
                this.mTotalDanmakuCount = other.mTotalDanmakuCount;
                this.mConsumingTime = other.mConsumingTime;
                this.mBeginTime = other.mBeginTime;
                this.mEndTime = other.mEndTime;
                this.mNothingRendered = other.mNothingRendered;
                this.mSysTime = other.mSysTime;
                this.mCacheHitCount = other.mCacheHitCount;
                this.mCacheMissCount = other.mCacheMissCount;
            }
        }

        public void appendToRunningDanmakus(BaseDanmaku danmaku) {
            if (!this.mIsObtaining) {
                this.mRunningDanmakus.addItem(danmaku);
            }
        }

        public IDanmakus obtainRunningDanmakus() {
            IDanmakus danmakus;
            this.mIsObtaining = true;
            synchronized (this) {
                danmakus = this.mRunningDanmakus;
                this.mRunningDanmakus = new Danmakus(4);
            }
            this.mIsObtaining = false;
            return danmakus;
        }
    }
}
