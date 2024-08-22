package com.baidu.searchbox.danmakulib.danmaku.renderer;

import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuTimer;
import com.baidu.searchbox.danmakulib.danmaku.model.ICacheManager;
import com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus;
import com.baidu.searchbox.danmakulib.danmaku.model.IDisplayer;
import com.baidu.searchbox.danmakulib.danmaku.model.IDrawingCache;
import com.baidu.searchbox.danmakulib.danmaku.renderer.DanmakusRetainer;
import com.baidu.searchbox.danmakulib.danmaku.renderer.IRenderer;
import com.baidu.searchbox.danmakulib.interfaces.OnDanmakuTranslateListener;

public class DanmakuRenderer extends Renderer {
    /* access modifiers changed from: private */
    public boolean isUsedNewFramework = false;
    /* access modifiers changed from: private */
    public ICacheManager mCacheManager;
    private Consumer mConsumer = new Consumer();
    /* access modifiers changed from: private */
    public final DanmakuContext mContext;
    /* access modifiers changed from: private */
    public final DanmakusRetainer mDanmakusRetainer;
    /* access modifiers changed from: private */
    public IRenderer.OnDanmakuPositionListener mOnDanmakuPositionListener;
    /* access modifiers changed from: private */
    public IRenderer.OnDanmakuShownListener mOnDanmakuShownListener;
    /* access modifiers changed from: private */
    public OnDanmakuTranslateListener mOnDanmakuTranslateListener;
    /* access modifiers changed from: private */
    public DanmakuTimer mStartTimer;
    /* access modifiers changed from: private */
    public DanmakusRetainer.Verifier mVerifier;
    private final DanmakusRetainer.Verifier verifier = new DanmakusRetainer.Verifier() {
        public boolean skipLayout(BaseDanmaku danmaku, float fixedTop, int lines, boolean willHit) {
            if (danmaku.mPriority == 0) {
                if (DanmakuRenderer.this.mContext.mDanmakuFilters.filterSecondary(danmaku, lines, 0, DanmakuRenderer.this.mStartTimer, willHit, DanmakuRenderer.this.mContext)) {
                    danmaku.recordInvisibleCase(4);
                    danmaku.setVisibility(false);
                    if (DanmakuRenderer.this.mOnDanmakuTranslateListener == null) {
                        return true;
                    }
                    DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(danmaku, 4);
                    return true;
                }
            }
            return false;
        }
    };

    private class Consumer extends IDanmakus.DefaultConsumer<BaseDanmaku> {
        public IDisplayer mDisp;
        private BaseDanmaku mLastItem;
        public IRenderer.RenderingState mRenderingState;
        public long mStartRenderTime;

        private Consumer() {
        }

        public int accept(BaseDanmaku drawItem) {
            this.mLastItem = drawItem;
            if (drawItem.isTimeOut()) {
                this.mDisp.recycle(drawItem);
                drawItem.recordInvisibleCase(1);
                if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                    DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 1);
                }
                if (this.mRenderingState.mIsRunningDanmakus) {
                    return 2;
                }
                return 0;
            } else if (this.mRenderingState.mIsRunningDanmakus || !drawItem.isOffset()) {
                if (!drawItem.hasPassedFilter()) {
                    DanmakuRenderer.this.mContext.mDanmakuFilters.filter(drawItem, this.mRenderingState.mIndexInScreen, this.mRenderingState.mTotalSizeInScreen, this.mRenderingState.mTimer, false, DanmakuRenderer.this.mContext);
                }
                if ((!drawItem.mIsLive && drawItem.getActualTime() < this.mStartRenderTime) || (drawItem.mPriority == 0 && (!DanmakuRenderer.this.isUsedNewFramework ? drawItem.isFiltered() : drawItem.isFilteredByNewFrameWork()))) {
                    drawItem.recordInvisibleCase(4);
                    if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                        DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 4);
                    }
                    return 0;
                } else if (drawItem.isEarlier()) {
                    IDrawingCache<?> cache = drawItem.getDrawingCache();
                    if (DanmakuRenderer.this.mCacheManager != null && (cache == null || cache.get() == null)) {
                        DanmakuRenderer.this.mCacheManager.addDanmaku(drawItem);
                    }
                    drawItem.recordInvisibleCase(8);
                    if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                        DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 8);
                    }
                    return 1;
                } else {
                    if (drawItem.getType() == 1) {
                        this.mRenderingState.mIndexInScreen++;
                    }
                    if (!drawItem.isMeasured()) {
                        drawItem.measure(this.mDisp, false);
                    }
                    if (!drawItem.isPrepared()) {
                        drawItem.prepare(this.mDisp, false);
                        if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                            DanmakuRenderer.this.mOnDanmakuTranslateListener.onPrepare(drawItem);
                        }
                    }
                    DanmakuRenderer.this.mDanmakusRetainer.fix(drawItem, this.mDisp, DanmakuRenderer.this.mVerifier);
                    if (!drawItem.isShown()) {
                        drawItem.recordInvisibleCase(32);
                        if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                            DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 32);
                        }
                    } else if (drawItem.mLines != null || drawItem.getBottom() <= ((float) this.mDisp.getHeight())) {
                        int renderingType = drawItem.draw(this.mDisp);
                        if (renderingType == 1) {
                            this.mRenderingState.mCacheHitCount++;
                        } else if (renderingType == 2) {
                            this.mRenderingState.mCacheMissCount++;
                            if (DanmakuRenderer.this.mCacheManager != null) {
                                DanmakuRenderer.this.mCacheManager.addDanmaku(drawItem);
                            }
                        }
                        this.mRenderingState.addCount(drawItem.getType(), 1);
                        this.mRenderingState.addTotalCount(1);
                        this.mRenderingState.appendToRunningDanmakus(drawItem);
                        if (!(DanmakuRenderer.this.mOnDanmakuShownListener == null || drawItem.mFirstShownFlag == DanmakuRenderer.this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG)) {
                            drawItem.mFirstShownFlag = DanmakuRenderer.this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG;
                            DanmakuRenderer.this.mOnDanmakuShownListener.onDanmakuShown(drawItem);
                        }
                        if (DanmakuRenderer.this.mOnDanmakuPositionListener != null) {
                            DanmakuRenderer.this.mOnDanmakuPositionListener.onGetCurPos(drawItem);
                        }
                        if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                            DanmakuRenderer.this.mOnDanmakuTranslateListener.onTranslate(drawItem);
                        }
                    } else {
                        drawItem.recordInvisibleCase(16);
                        if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                            DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 16);
                        }
                        return 0;
                    }
                    return 0;
                }
            } else {
                drawItem.recordInvisibleCase(2);
                if (DanmakuRenderer.this.mOnDanmakuTranslateListener != null) {
                    DanmakuRenderer.this.mOnDanmakuTranslateListener.onInvisible(drawItem, 2);
                }
                return 0;
            }
        }

        public void after() {
            this.mRenderingState.mLastDanmaku = this.mLastItem;
            super.after();
        }
    }

    public DanmakuRenderer(DanmakuContext config, boolean isUsedNewFramework2) {
        this.mContext = config;
        this.isUsedNewFramework = isUsedNewFramework2;
        this.mDanmakusRetainer = new DanmakusRetainer(config.isAlignBottom(), isUsedNewFramework2);
    }

    public void clear() {
        clearRetainer();
        this.mContext.mDanmakuFilters.clear();
    }

    public void clearRetainer() {
        this.mDanmakusRetainer.clear();
    }

    public void release() {
        this.mDanmakusRetainer.release();
        this.mContext.mDanmakuFilters.clear();
    }

    public void setVerifierEnabled(boolean enabled) {
        this.mVerifier = enabled ? this.verifier : null;
    }

    public void draw(IDisplayer disp, IDanmakus danmakus, long startRenderTime, IRenderer.RenderingState renderingState) {
        this.mStartTimer = renderingState.mTimer;
        this.mConsumer.mDisp = disp;
        this.mConsumer.mRenderingState = renderingState;
        this.mConsumer.mStartRenderTime = startRenderTime;
        danmakus.forEachSync(this.mConsumer);
    }

    public void setCacheManager(ICacheManager cacheManager) {
        this.mCacheManager = cacheManager;
    }

    public void setOnDanmakuShownListener(IRenderer.OnDanmakuShownListener onDanmakuShownListener) {
        this.mOnDanmakuShownListener = onDanmakuShownListener;
    }

    public void setOnDanmakuPosListener(IRenderer.OnDanmakuPositionListener onDanmakuPositionListener) {
        this.mOnDanmakuPositionListener = onDanmakuPositionListener;
    }

    public void removeOnDanmakuShownListener() {
        this.mOnDanmakuShownListener = null;
    }

    public void setOnDanmakuTranslateListener(OnDanmakuTranslateListener onDanmakuTranslateListener) {
        this.mOnDanmakuTranslateListener = onDanmakuTranslateListener;
    }

    public void removeOnDanmakuTranslateListener() {
        this.mOnDanmakuTranslateListener = null;
    }

    public void alignBottom(boolean enable) {
        DanmakusRetainer danmakusRetainer = this.mDanmakusRetainer;
        if (danmakusRetainer != null) {
            danmakusRetainer.alignBottom(enable);
        }
    }
}
