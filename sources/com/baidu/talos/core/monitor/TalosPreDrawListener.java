package com.baidu.talos.core.monitor;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.TalosConstant;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.render.TalosUIHelper;
import com.baidu.talos.core.render.TalosUIManagerHelper;
import com.baidu.talos.core.util.ViewIDConvertUtil;
import com.baidu.talos.modules.R;
import com.baidu.talos.monitor.PerformanceMonitorConstants;
import com.baidu.talos.systrace.Systrace;
import java.util.Map;

public class TalosPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    private long mRootTag;
    private View mTarget;
    private ViewTreeObserver mViewTreeObserver;

    public TalosPreDrawListener(long rootTag, View target, ViewTreeObserver viewTreeObserver) {
        this.mRootTag = rootTag;
        this.mTarget = target;
        this.mViewTreeObserver = viewTreeObserver;
    }

    public boolean onPreDraw() {
        PagePerformanceFlagCache pagePerfCache = TalosUIManagerHelper.getPagePerformanceFlagCache(this.mTarget);
        if (pagePerfCache == null) {
            ViewTreeObserver viewTreeObserver = this.mViewTreeObserver;
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                this.mViewTreeObserver.removeOnPreDrawListener(this);
            }
            return true;
        } else if (!pagePerfCache.isFMPCollected(this.mRootTag) || !pagePerfCache.isFCPCollected(this.mRootTag)) {
            boolean isTargetForFMP = false;
            long timeStamp = System.currentTimeMillis();
            int[] absPos = new int[2];
            this.mTarget.getLocationOnScreen(absPos);
            Rect absRect = new Rect(absPos[0], absPos[1], absPos[0] + this.mTarget.getWidth(), absPos[1] + this.mTarget.getHeight());
            boolean isXPosInViewport = pagePerfCache.isXPosInViewport(this.mRootTag, absRect);
            boolean customFCP = Boolean.TRUE.equals(TalosUIHelper.getViewTag(this.mTarget, Boolean.class, R.id.fcp_tag_key));
            if (!pagePerfCache.isFCPCollected(this.mRootTag) && (!pagePerfCache.isPotentialFCPCollected(this.mRootTag) || customFCP)) {
                if (customFCP) {
                    pagePerfCache.setFCPCollected(this.mRootTag);
                } else if (!pagePerfCache.isPotentialFCPCollected(this.mRootTag)) {
                    pagePerfCache.setPotentialFCPCollected(this.mRootTag);
                }
                PagePerformanceMonitorSupplier.getInstance().record(pagePerfCache.getMonitorKeyByRootTag(this.mRootTag), PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VIEW, String.valueOf(timeStamp));
                if (Debug.isDebug()) {
                    Log.d("FMP-log", "RenderManager FCP root tag=" + this.mRootTag + ",fcg tag=" + ViewIDConvertUtil.getTalosViewTag(this.mTarget) + ",timestamp=" + timeStamp + ",class=" + this.mTarget.getClass() + ",isVisible=" + isXPosInViewport + ",customFCP=" + customFCP);
                }
            }
            if (!isXPosInViewport) {
                return true;
            }
            boolean customFMP = Boolean.TRUE.equals(TalosUIHelper.getViewTag(this.mTarget, Boolean.class, R.id.fmp_tag_key));
            if (!pagePerfCache.isFMPCollected(this.mRootTag)) {
                String monitorKey = pagePerfCache.getMonitorKeyByRootTag(this.mRootTag);
                if (customFMP || isTargetForFMP(absRect)) {
                    pagePerfCache.setFMPCollected(this.mRootTag);
                    Debug.isDebug();
                    Systrace.beginSection("talos_fmp_tag_" + ViewIDConvertUtil.getTalosViewTag(this.mTarget));
                    Systrace.endSection();
                    isTargetForFMP = true;
                }
                if (customFMP) {
                    PagePerformanceMonitorSupplier.getInstance().record(monitorKey, PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP, "1");
                }
                String str = "1";
                PagePerformanceMonitorSupplier.getInstance().record(monitorKey, "firstMeaningfulPaint", String.valueOf(timeStamp));
                PagePerformanceMonitorSupplier.getInstance().record(monitorKey, PerformanceMonitorConstants.PAGE_IS_FULL_SCREEN_FMP, isTargetForFMP ? str : "0");
                pagePerfCache.addRootFMPTag(monitorKey, ViewIDConvertUtil.getTalosViewTag(this.mTarget));
            }
            if (isTargetForFMP) {
                String monitorKey2 = pagePerfCache.getMonitorKeyByRootTag(this.mRootTag);
                long fmpTag = ViewIDConvertUtil.getTalosViewTag(this.mTarget);
                PagePerformanceFlagCache pagePerformanceFlagCache = pagePerfCache;
                boolean z = isTargetForFMP;
                PagePerformanceMonitorSupplier.getInstance().recordToTalosExt(monitorKey2, PerformanceMonitorConstants.PAGE_FMP_TAG, String.valueOf(fmpTag));
                TalosPageContext pageContext = TalosUIManagerHelper.getReactContext(this.mTarget);
                if (pageContext != null) {
                    pageContext.setEndFirstPage(true);
                }
                if (pageContext == null || !pageContext.isInSSRRender()) {
                    PagePerformanceMonitorSupplier.getInstance().stop(monitorKey2);
                }
                if (Debug.isDebug()) {
                    TalosPageContext talosPageContext = pageContext;
                    String str2 = monitorKey2;
                    Log.d(TalosConstant.FMP_LOG_TAG, " FMP root tag=" + this.mRootTag + ",fmp tag=" + fmpTag + ",customFMP=" + customFMP + ",timestamp=" + timeStamp + ",class=" + this.mTarget.getClass());
                } else {
                    String str3 = monitorKey2;
                }
            } else {
                boolean z2 = isTargetForFMP;
            }
            ViewTreeObserver viewTreeObserver2 = this.mViewTreeObserver;
            if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                return true;
            }
            this.mViewTreeObserver.removeOnPreDrawListener(this);
            return true;
        } else {
            ViewTreeObserver viewTreeObserver3 = this.mViewTreeObserver;
            if (viewTreeObserver3 != null && viewTreeObserver3.isAlive()) {
                this.mViewTreeObserver.removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    private boolean isTargetForFMP(Rect targetRect) {
        Map<String, String> monitorData;
        PagePerformanceFlagCache pagePerfCache = TalosUIManagerHelper.getPagePerformanceFlagCache(this.mTarget);
        if (pagePerfCache == null || (monitorData = PagePerformanceMonitorSupplier.getInstance().getMonitorData(pagePerfCache.getMonitorKeyByRootTag(this.mRootTag))) == null) {
            return false;
        }
        if (!TextUtils.equals(monitorData.get(PerformanceMonitorConstants.PAGE_FMP_WAIT_VALID_NODE), "1") || monitorData.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VALID_NODE)) {
            return pagePerfCache.isTargetForFMP(this.mRootTag, targetRect);
        }
        return false;
    }
}
