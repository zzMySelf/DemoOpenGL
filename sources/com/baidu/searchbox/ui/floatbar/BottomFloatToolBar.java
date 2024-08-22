package com.baidu.searchbox.ui.floatbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/ui/floatbar/BottomFloatToolBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mClickListeners", "Lcom/baidu/searchbox/ui/floatbar/IBottomFloatToolBarClickListener;", "onAttachedToWindow", "", "onDetachedFromWindow", "onFontSizeChange", "onNightModeChange", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "setClickListener", "clickListener", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomFloatToolBar.kt */
public final class BottomFloatToolBar extends FrameLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private volatile IBottomFloatToolBarClickListener mClickListeners;

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
    public BottomFloatToolBar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda0(this));
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda1(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomFloatToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda0(this));
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda1(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomFloatToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda0(this));
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new BottomFloatToolBar$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4563_init_$lambda0(BottomFloatToolBar this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener = this$0.mClickListeners;
        if (iBottomFloatToolBarClickListener != null) {
            iBottomFloatToolBarClickListener.onBackButtonClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4564_init_$lambda1(BottomFloatToolBar this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener = this$0.mClickListeners;
        if (iBottomFloatToolBarClickListener != null) {
            iBottomFloatToolBarClickListener.onMenuButtonClick();
        }
    }

    public final void setClickListener(IBottomFloatToolBarClickListener clickListener) {
        runOnUIThread(new BottomFloatToolBar$$ExternalSyntheticLambda6(this, clickListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListener$lambda-2  reason: not valid java name */
    public static final void m4569setClickListener$lambda2(BottomFloatToolBar this$0, IBottomFloatToolBarClickListener $clickListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mClickListeners = $clickListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onNightModeChange();
        onFontSizeChange();
        NightModeHelper.subscribeNightModeChangeEvent(this, new BottomFloatToolBar$$ExternalSyntheticLambda4(this));
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new BottomFloatToolBar$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-3  reason: not valid java name */
    public static final void m4565onAttachedToWindow$lambda3(BottomFloatToolBar this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onNightModeChange();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-4  reason: not valid java name */
    public static final void m4566onAttachedToWindow$lambda4(BottomFloatToolBar this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onFontSizeChange();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    private final void onNightModeChange() {
        runOnUIThread(new BottomFloatToolBar$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onNightModeChange$lambda-5  reason: not valid java name */
    public static final void m4568onNightModeChange$lambda5(BottomFloatToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.new_home_float_bar_back));
        }
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.new_home_float_bar_function));
        }
    }

    private final void onFontSizeChange() {
        runOnUIThread(new BottomFloatToolBar$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onFontSizeChange$lambda-6  reason: not valid java name */
    public static final void m4567onFontSizeChange$lambda6(BottomFloatToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes$default(imageView, 2, R.dimen.new_home_float_bar_width, R.dimen.new_home_float_bar_height, 0, 8, (Object) null);
        }
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView2 != null) {
            FontSizeViewExtKt.setScaledSizeRes$default(imageView2, 2, R.dimen.new_home_float_bar_width, R.dimen.new_home_float_bar_height, 0, 8, (Object) null);
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (UiThreadUtils.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtils.runOnUiThread(runnable);
        }
    }
}
