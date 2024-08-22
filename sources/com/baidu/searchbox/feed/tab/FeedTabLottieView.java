package com.baidu.searchbox.feed.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tab.update.LottieInfo;
import com.baidu.searchbox.feed.tab.utils.FeedTabPreferenceUtils;
import com.baidu.searchbox.ui.BdBaseLottieView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/tab/FeedTabLottieView;", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bind", "", "tabView", "Landroid/view/ViewGroup;", "tabHeight", "lottie", "Lcom/baidu/searchbox/feed/tab/update/LottieInfo;", "hasTargetParentView", "", "loadLottieResFail", "throwable", "", "loadLottieResSuccess", "result", "Lcom/airbnb/lottie/LottieComposition;", "matchLottieUrl", "matchPlayTime", "parent", "matchWidthAndHeight", "removeLottie", "setView", "tryPlayAnimation", "unbind", "lib-feed-tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabLottieView.kt */
public final class FeedTabLottieView extends BdBaseLottieView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedTabLottieView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedTabLottieView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTabLottieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedTabLottieView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void unbind(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        clearAnimation();
        removeLottie(tabView);
    }

    public final void bind(ViewGroup tabView, int tabHeight, LottieInfo lottie) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView tabId:" + lottie.getTabId() + " 尝试处理Lottie动画");
        if (matchPlayTime(lottie, tabView) && matchWidthAndHeight(lottie, tabView) && matchLottieUrl(lottie)) {
            setView(tabView, tabHeight, lottie);
            setVisibility(0);
            setRepeatCount(lottie.isLoopPlay() ? -1 : 1);
            tryPlayAnimation(tabView, lottie);
        }
    }

    public final boolean hasTargetParentView(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        ViewParent parent = getParent();
        if (Intrinsics.areEqual((Object) parent instanceof ViewGroup ? (ViewGroup) parent : null, (Object) tabView)) {
            return true;
        }
        unbind(tabView);
        return false;
    }

    private final boolean matchPlayTime(LottieInfo lottie, ViewGroup parent) {
        if (Intrinsics.areEqual((Object) "2", (Object) lottie.getPlayTime())) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie播放时机:展示");
            return true;
        } else if (!Intrinsics.areEqual((Object) "1", (Object) lottie.getPlayTime()) || !parent.isSelected()) {
            OnLineLog.get(OnLineLog.TAG_TABS).e("FeedTabLottieView 不匹配Lottie播放时机:" + lottie.getPlayTime() + " selected:" + parent.isSelected());
            return false;
        } else {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie播放时机:选中");
            return true;
        }
    }

    private final boolean matchWidthAndHeight(LottieInfo lottie, ViewGroup parent) {
        int width = lottie.getWidth();
        int height = lottie.getHeight();
        if (width > 0) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie宽:" + width + " 高:" + height);
            return true;
        }
        OnLineLog.get(OnLineLog.TAG_TABS).e("FeedTabLottieView Lottie宽:" + width + " 高:" + height);
        return false;
    }

    private final boolean matchLottieUrl(LottieInfo lottie) {
        CharSequence targetUrl = lottie.getTargetUrl();
        if (targetUrl == null || targetUrl.length() == 0) {
            OnLineLog.get(OnLineLog.TAG_TABS).e("FeedTabLottieView Lottie Url为空");
            return false;
        }
        OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie Url:" + lottie.getTargetUrl());
        return true;
    }

    private final void setView(ViewGroup tabView, int tabHeight, LottieInfo lottie) {
        tabView.getLayoutParams().height = tabHeight;
        FrameLayout.LayoutParams lottieLayoutParams = new FrameLayout.LayoutParams(DeviceUtil.ScreenInfo.dp2px(getContext(), (float) lottie.getWidth()), DeviceUtil.ScreenInfo.dp2px(getContext(), (((float) lottie.getHeight()) * 19.0f) / ((float) 22)));
        lottieLayoutParams.gravity = 17;
        if (lottie.hasNameImage()) {
            if (getParent() != null) {
                ViewParent parent = getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            tabView.addView(this, lottieLayoutParams);
            return;
        }
        String level = lottie.getLevel();
        if (Intrinsics.areEqual((Object) level, (Object) "2")) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie展示层级:底层");
            if (getParent() != null) {
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(this);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            tabView.addView(this, 0, lottieLayoutParams);
        } else if (Intrinsics.areEqual((Object) level, (Object) "1")) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView Lottie展示层级:顶层");
            if (getParent() != null) {
                ViewParent parent3 = getParent();
                if (parent3 != null) {
                    ((ViewGroup) parent3).removeView(this);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            tabView.addView(this, lottieLayoutParams);
        } else {
            OnLineLog.get(OnLineLog.TAG_TABS).w("FeedTabLottieView Lottie展示层级(兜底):顶层");
            if (getParent() != null) {
                ViewParent parent4 = getParent();
                if (parent4 != null) {
                    ((ViewGroup) parent4).removeView(this);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            tabView.addView(this, lottieLayoutParams);
        }
    }

    private final void tryPlayAnimation(ViewGroup tabView, LottieInfo lottie) {
        try {
            LottieCompositionFactory.fromUrl(getContext(), lottie.getTargetUrl()).addListener(new FeedTabLottieView$$ExternalSyntheticLambda0(this, tabView, lottie)).addFailureListener(new FeedTabLottieView$$ExternalSyntheticLambda1(this, tabView));
        } catch (Exception e2) {
            loadLottieResFail(tabView, e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryPlayAnimation$lambda-0  reason: not valid java name */
    public static final void m19359tryPlayAnimation$lambda0(FeedTabLottieView this$0, ViewGroup $tabView, LottieInfo $lottie, LottieComposition result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($tabView, "$tabView");
        Intrinsics.checkNotNullParameter($lottie, "$lottie");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.loadLottieResSuccess($tabView, $lottie, result);
    }

    /* access modifiers changed from: private */
    /* renamed from: tryPlayAnimation$lambda-1  reason: not valid java name */
    public static final void m19360tryPlayAnimation$lambda1(FeedTabLottieView this$0, ViewGroup $tabView, Throwable result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($tabView, "$tabView");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.loadLottieResFail($tabView, result);
    }

    private final void loadLottieResSuccess(ViewGroup tabView, LottieInfo lottie, LottieComposition result) {
        if (lottie.hasNameImage()) {
            int childCount = tabView.getChildCount();
            for (int index = 0; index < childCount; index++) {
                View it = tabView.getChildAt(index);
                if (it != null && !Intrinsics.areEqual((Object) it, (Object) this)) {
                    it.setVisibility(4);
                }
            }
        }
        setVisibility(0);
        setComposition(result);
        playAnimation();
        if (lottie.showOnlyOnce()) {
            FeedTabPreferenceUtils.putBoolean(FeedTabLottieViewKt.KEY_FEED_TAB_LOTTIE_HAS_SHOWN, true);
        }
        OnLineLog.get(OnLineLog.TAG_TABS).d("FeedTabLottieView 播放成功");
    }

    private final void loadLottieResFail(ViewGroup tabView, Throwable throwable) {
        removeLottie(tabView);
        OnLineLog.get(OnLineLog.TAG_TABS).e("FeedTabLottieView 播放失败:" + throwable);
    }

    private final void removeLottie(ViewGroup tabView) {
        tabView.getLayoutParams().height = -2;
        setVisibility(8);
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }
}
