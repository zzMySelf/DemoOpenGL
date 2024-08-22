package com.baidu.searchbox.danmakulib.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext;
import com.baidu.searchbox.danmakulib.danmaku.util.DanmakuBuilder;
import com.baidu.searchbox.danmakulib.danmaku.util.DanmakuUtils;
import com.baidu.searchbox.danmakulib.interfaces.OnSpecialDanmakuClickListener;
import com.baidu.searchbox.danmakulib.update.DanmakuPlatformConfigListener;
import com.baidu.searchbox.danmakulib.update.PreferUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.concurrent.ConcurrentHashMap;

public class SpecialDanmakuController {
    public static final float SPECIAL_TOP_EXPAND_DP = 11.7f;
    private Context context;
    public DanmakuContext danmakuContext;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isHidden = false;
    public OnSpecialDanmakuClickListener onSpecialDanmakuClickListener;
    private ConcurrentHashMap<String, View> specialBanmakuMap = new ConcurrentHashMap<>();
    private FrameLayout specialLayout;
    public float specialTopExpand = 0.0f;

    public SpecialDanmakuController(Context context2, FrameLayout specialLayout2) {
        this.context = context2;
        this.specialLayout = specialLayout2;
    }

    public void danmakuTranslate(BaseDanmaku danmaku) {
        View view2;
        if (checkSpecial(danmaku) && (view2 = this.specialBanmakuMap.get(danmaku.mDanmakuId)) != null) {
            if (!this.isHidden && view2.getVisibility() != 0) {
                view2.setVisibility(0);
            }
            view2.setX(danmaku.getLeft());
            view2.setY((danmaku.getTop() - ((float) this.danmakuContext.mMargin)) - getSpecialTopExpand());
            if (view2 instanceof SimpleDraweeView) {
                Animatable animatable = ((SimpleDraweeView) view2).getController().getAnimatable();
                if (animatable != null && !animatable.isRunning()) {
                    animatable.start();
                }
            } else if (view2 instanceof LottieAnimationView) {
                LottieAnimationView lottieView = (LottieAnimationView) view2;
                if (!lottieView.isAnimating()) {
                    lottieView.playAnimation();
                }
            }
        }
    }

    public void danmakuInvisible(BaseDanmaku danmaku, int action) {
        if (!checkSpecial(danmaku) || action == 2 || !this.specialBanmakuMap.containsKey(danmaku.mDanmakuId)) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            m16975lambda$danmakuInvisible$0$combaidusearchboxdanmakulibwidgetSpecialDanmakuController(danmaku, action);
        } else {
            this.handler.post(new SpecialDanmakuController$$ExternalSyntheticLambda1(this, danmaku, action));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: innerDoDanmakuInvisible */
    public void m16975lambda$danmakuInvisible$0$combaidusearchboxdanmakulibwidgetSpecialDanmakuController(BaseDanmaku danmaku, int action) {
        View view2;
        if (checkSpecial(danmaku) && (view2 = this.specialBanmakuMap.get(danmaku.mDanmakuId)) != null) {
            stopAnimation(view2);
            if (view2.getVisibility() == 0) {
                view2.setVisibility(8);
            }
            view2.setX((float) (view2.getWidth() * -1));
            view2.setY((float) (view2.getHeight() * -1));
        }
    }

    public void danmakuShown(BaseDanmaku danmaku) {
        recordSpecialDanmakuShowTimes(this.context, danmaku.nid);
    }

    public void prepareDanmaku(BaseDanmaku danmaku) {
        if (!checkSpecial(danmaku) || this.specialBanmakuMap.containsKey(danmaku.mDanmakuId)) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            m16977lambda$prepareDanmaku$1$combaidusearchboxdanmakulibwidgetSpecialDanmakuController(danmaku);
        } else {
            this.handler.post(new SpecialDanmakuController$$ExternalSyntheticLambda0(this, danmaku));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addAnimation */
    public void m16977lambda$prepareDanmaku$1$combaidusearchboxdanmakulibwidgetSpecialDanmakuController(BaseDanmaku danmaku) {
        if (checkSpecial(danmaku) && !this.specialBanmakuMap.containsKey(danmaku.mDanmakuId)) {
            View animationView = null;
            if (danmaku.special.effectType == 1) {
                animationView = addWebpAnimation(danmaku);
            } else if (danmaku.special.effectType == 2) {
                animationView = addLottieAnimation(danmaku);
            }
            if (animationView != null) {
                animationView.setOnClickListener(new SpecialDanmakuController$$ExternalSyntheticLambda3(this, danmaku));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$addAnimation$2$com-baidu-searchbox-danmakulib-widget-SpecialDanmakuController  reason: not valid java name */
    public /* synthetic */ void m16974lambda$addAnimation$2$combaidusearchboxdanmakulibwidgetSpecialDanmakuController(BaseDanmaku danmaku, View view2) {
        OnSpecialDanmakuClickListener onSpecialDanmakuClickListener2 = this.onSpecialDanmakuClickListener;
        if (onSpecialDanmakuClickListener2 != null) {
            onSpecialDanmakuClickListener2.onClick(danmaku, view2);
        }
    }

    private View addWebpAnimation(BaseDanmaku danmaku) {
        int realHeight;
        SimpleDraweeView mSimpleDraweeView = new SimpleDraweeView(this.context);
        mSimpleDraweeView.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(danmaku.special.effectUrl)).setAutoPlayAnimations(false)).build());
        mSimpleDraweeView.setX(danmaku.getLeft());
        mSimpleDraweeView.setY((danmaku.getTop() - ((float) this.danmakuContext.mMargin)) - getSpecialTopExpand());
        mSimpleDraweeView.setVisibility(8);
        if (danmaku.special.effectAspectWidth > 0) {
            realHeight = (int) (((danmaku.mPaintWidth * 1.0f) * ((float) danmaku.special.effectAspectHeight)) / ((float) danmaku.special.effectAspectWidth));
        } else {
            realHeight = (int) danmaku.mPaintHeight;
        }
        this.specialLayout.addView(mSimpleDraweeView, (int) danmaku.mPaintWidth, realHeight);
        this.specialBanmakuMap.put(danmaku.mDanmakuId, mSimpleDraweeView);
        return mSimpleDraweeView;
    }

    private View addLottieAnimation(BaseDanmaku danmaku) {
        int realHeight;
        LottieAnimationView mLottieView = new LottieAnimationView(this.context);
        mLottieView.setAnimationFromUrl(danmaku.special.effectUrl);
        mLottieView.setRepeatMode(1);
        mLottieView.setRepeatCount(-1);
        mLottieView.setX(danmaku.getLeft());
        mLottieView.setY((danmaku.getTop() - ((float) this.danmakuContext.mMargin)) - getSpecialTopExpand());
        mLottieView.setVisibility(8);
        if (danmaku.special.effectAspectWidth > 0) {
            realHeight = (int) (((danmaku.mPaintWidth * 1.0f) * ((float) danmaku.special.effectAspectHeight)) / ((float) danmaku.special.effectAspectWidth));
        } else {
            realHeight = (int) danmaku.mPaintHeight;
        }
        this.specialLayout.addView(mLottieView, (int) danmaku.mPaintWidth, realHeight);
        this.specialBanmakuMap.put(danmaku.mDanmakuId, mLottieView);
        return mLottieView;
    }

    public void onHide() {
        this.isHidden = true;
        for (View view2 : this.specialBanmakuMap.values()) {
            stopAnimation(view2);
            if (view2.getVisibility() == 0) {
                view2.setVisibility(8);
            }
            view2.setX((float) (view2.getWidth() * -1));
            view2.setY((float) (view2.getHeight() * -1));
        }
    }

    public void onShow() {
        this.isHidden = false;
    }

    public void onClear() {
        this.handler.post(new SpecialDanmakuController$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onClear$3$com-baidu-searchbox-danmakulib-widget-SpecialDanmakuController  reason: not valid java name */
    public /* synthetic */ void m16976lambda$onClear$3$combaidusearchboxdanmakulibwidgetSpecialDanmakuController() {
        for (View view2 : this.specialBanmakuMap.values()) {
            stopAnimation(view2);
            if (view2.getVisibility() == 0) {
                view2.setVisibility(8);
            }
            view2.setX((float) (view2.getWidth() * -1));
            view2.setY((float) (view2.getHeight() * -1));
        }
    }

    private void stopAnimation(View view2) {
        if (view2 instanceof SimpleDraweeView) {
            Animatable animatable = ((SimpleDraweeView) view2).getController().getAnimatable();
            if (animatable != null && animatable.isRunning()) {
                animatable.stop();
            }
        } else if (view2 instanceof LottieAnimationView) {
            LottieAnimationView lottieView = (LottieAnimationView) view2;
            if (lottieView.isAnimating()) {
                lottieView.cancelAnimation();
            }
        }
    }

    public void release() {
        for (View view2 : this.specialBanmakuMap.values()) {
            stopAnimation(view2);
        }
        this.specialLayout.removeAllViews();
        this.specialBanmakuMap.clear();
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    private boolean checkSpecial(BaseDanmaku danmaku) {
        if (danmaku == null || !danmaku.isSpecialDanmaku()) {
            return false;
        }
        return true;
    }

    public float getSpecialTopExpand() {
        float f2 = this.specialTopExpand;
        if (f2 > 0.0f) {
            return f2;
        }
        float expand = (float) Math.ceil((double) (11.7f * this.context.getResources().getDisplayMetrics().density));
        this.specialTopExpand = expand;
        return expand;
    }

    public static boolean isCanShowSpecialDanmaku(Context context2, String nid) {
        int showMaxCount = DanmakuUtils.stringToIntSafety(PreferUtils.getStringPreference(context2, DanmakuPlatformConfigListener.SPECIAL_MAX_COUNT, String.valueOf(5)), 5);
        int cmdShowTimes = PreferUtils.getIntPreference(context2, DanmakuBuilder.SPECIAL_SHOW_TIMES, 0);
        String nids = PreferUtils.getStringPreference(context2, DanmakuBuilder.SPECIAL_VIDEO_NIDS, "");
        if (System.currentTimeMillis() - DanmakuUtils.stringToLongSafety(PreferUtils.getStringPreference(context2, DanmakuBuilder.SPECIAL_START_SHOW_TIME, "0"), 0) >= 86400000 || nids.contains(nid + ",") || cmdShowTimes < showMaxCount) {
            return true;
        }
        return false;
    }

    public void recordSpecialDanmakuShowTimes(Context context2, String nid) {
        int cmdShowTimes = PreferUtils.getIntPreference(context2, DanmakuBuilder.SPECIAL_SHOW_TIMES, 0);
        String nids = PreferUtils.getStringPreference(context2, DanmakuBuilder.SPECIAL_VIDEO_NIDS, "");
        long currentTime = System.currentTimeMillis();
        if (currentTime - DanmakuUtils.stringToLongSafety(PreferUtils.getStringPreference(context2, DanmakuBuilder.SPECIAL_START_SHOW_TIME, "0"), 0) >= 86400000) {
            PreferUtils.setStringPreference(context2, DanmakuBuilder.SPECIAL_VIDEO_NIDS, nid + ",");
            PreferUtils.setIntPreference(context2, DanmakuBuilder.SPECIAL_SHOW_TIMES, cmdShowTimes + 1);
            PreferUtils.setStringPreference(context2, DanmakuBuilder.SPECIAL_START_SHOW_TIME, String.valueOf(currentTime));
        } else if (!nids.contains(nid + ",")) {
            int cmdShowTimes2 = cmdShowTimes + 1;
            if (nids.isEmpty()) {
                nids = ",";
            }
            PreferUtils.setIntPreference(context2, DanmakuBuilder.SPECIAL_SHOW_TIMES, cmdShowTimes2);
            PreferUtils.setStringPreference(context2, DanmakuBuilder.SPECIAL_VIDEO_NIDS, nids + nid + ",");
        }
    }
}
