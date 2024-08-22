package com.baidu.searchbox.talos.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.talos.lite.ITalosLiteContainer;
import com.baidu.searchbox.talos.lite.TalosLiteManager;
import com.baidu.searchbox.talos.lite.TalosLiteRenderParams;
import com.baidu.searchbox.talos.lite.impl.RemoveViewCallback;
import com.baidu.searchbox.talos.lite.model.TalosLiteDialogData;
import com.baidu.searchbox.talos.lite.model.TalosLiteSchemeData;
import com.baidu.talos.util.DeviceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0006\u0010\u001e\u001a\u00020\u0016J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020#R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/talos/lite/ui/TalosLiteShowDialog;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "container", "Lcom/baidu/searchbox/talos/lite/ITalosLiteContainer;", "isClose", "", "()Z", "setClose", "(Z)V", "isFromBottom", "setFromBottom", "isNeedShowAnimation", "addAnimation", "", "into", "getContainerWith", "config", "Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData$AlertConfig;", "getPadding", "", "size", "onDestory", "showDialog", "data", "Lcom/baidu/searchbox/talos/lite/model/TalosLiteDialogData;", "removeCb", "Lcom/baidu/searchbox/talos/lite/impl/RemoveViewCallback;", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosLiteShowDialog.kt */
public final class TalosLiteShowDialog extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private Activity activity;
    /* access modifiers changed from: private */
    public ITalosLiteContainer container;
    private boolean isClose;
    private boolean isFromBottom;
    private boolean isNeedShowAnimation;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TalosLiteShowDialog(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TalosLiteShowDialog(Context context, AttributeSet attributeSet) {
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
    public TalosLiteShowDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.activity = context instanceof Activity ? (Activity) context : null;
        this.isFromBottom = true;
        NightModeHelper.subscribeNightModeChangeEvent(this, new TalosLiteShowDialog$$ExternalSyntheticLambda1(this));
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, new TalosLiteShowDialog$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TalosLiteShowDialog(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final boolean isClose() {
        return this.isClose;
    }

    public final void setClose(boolean z) {
        this.isClose = z;
    }

    public final boolean isFromBottom() {
        return this.isFromBottom;
    }

    public final void setFromBottom(boolean z) {
        this.isFromBottom = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4212_init_$lambda0(TalosLiteShowDialog this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITalosLiteContainer iTalosLiteContainer = this$0.container;
        if (iTalosLiteContainer != null) {
            iTalosLiteContainer.changeTheme();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4213_init_$lambda1(TalosLiteShowDialog this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ITalosLiteContainer iTalosLiteContainer = this$0.container;
        if (iTalosLiteContainer != null) {
            iTalosLiteContainer.changeFontLevel();
        }
    }

    public final boolean showDialog(TalosLiteDialogData data, TalosLiteSchemeData.AlertConfig config, RemoveViewCallback removeCb) {
        TalosLiteSchemeData.AlertConfig alertConfig = config;
        RemoveViewCallback removeViewCallback = removeCb;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(removeViewCallback, "removeCb");
        TalosLiteRenderParams newRenderParams = data.getRenderParams();
        int i2 = 0;
        if (newRenderParams == null) {
            return false;
        }
        if (alertConfig != null) {
            TalosLiteSchemeData.AlertConfig it = config;
            setPadding(DeviceUtils.ScreenInfo.dp2px(getContext(), getPadding(it.getLeftMargin() - 8)), DeviceUtils.ScreenInfo.dp2px(getContext(), getPadding(it.getTopMargin())), DeviceUtils.ScreenInfo.dp2px(getContext(), getPadding(it.getRightMargin() - 8)), DeviceUtils.ScreenInfo.dp2px(getContext(), getPadding(it.getBottomMargin())));
            this.isNeedShowAnimation = it.getAnimationType() == 1;
        }
        if (this.isNeedShowAnimation) {
            i2 = 8;
        }
        setVisibility(i2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ShadowLayout shadowLayout = new ShadowLayout(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        addView(shadowLayout, new RelativeLayout.LayoutParams(-2, -2));
        if (newRenderParams.isValid()) {
            if (this.activity != null) {
                TalosLiteManager talosLiteManager = TalosLiteManager.INSTANCE;
                Activity activity2 = this.activity;
                Intrinsics.checkNotNull(activity2);
                ITalosLiteContainer talosLiteContainer = TalosLiteManager.createTalosLiteContainer$default(talosLiteManager, "", activity2, newRenderParams, getContainerWith(alertConfig), false, 16, (Object) null);
                this.container = talosLiteContainer;
                View talosLiteView = talosLiteContainer.createView();
                if (talosLiteView != null) {
                    shadowLayout.addView(talosLiteView);
                    talosLiteContainer.addActionIntercept("close", new TalosLiteShowDialog$showDialog$2(this, removeViewCallback));
                } else {
                    setVisibility(8);
                }
            }
            addAnimation(true);
        }
        return true;
    }

    private final float getPadding(int size) {
        if (size == -1) {
            return 0.0f;
        }
        return ((float) size) / 1.15f;
    }

    private final int getContainerWith(TalosLiteSchemeData.AlertConfig config) {
        int i2 = 0;
        int displayWidth = DeviceUtils.ScreenInfo.getDisplayWidth(getContext()) - (config != null ? config.getLeftMargin() : 0);
        if (config != null) {
            i2 = config.getRightMargin();
        }
        return displayWidth - i2;
    }

    /* access modifiers changed from: private */
    public final void addAnimation(boolean into) {
        float toYValue;
        float fromYValue;
        float f2 = 1.0f;
        if (into) {
            if (!this.isFromBottom) {
                f2 = -1.0f;
            }
            fromYValue = f2;
            toYValue = 0.0f;
        } else {
            fromYValue = 0.0f;
            if (!this.isFromBottom) {
                f2 = -1.0f;
            }
            toYValue = f2;
        }
        if (this.isNeedShowAnimation) {
            TranslateAnimation ctrlAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, fromYValue, 1, toYValue);
            ctrlAnimation.setDuration(400);
            ctrlAnimation.setAnimationListener(new TalosLiteShowDialog$addAnimation$ctrlAnimation$1$1(this, into));
            post(new TalosLiteShowDialog$$ExternalSyntheticLambda0(this, ctrlAnimation));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addAnimation$lambda-4  reason: not valid java name */
    public static final void m4214addAnimation$lambda4(TalosLiteShowDialog this$0, TranslateAnimation $ctrlAnimation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($ctrlAnimation, "$ctrlAnimation");
        this$0.setVisibility(0);
        this$0.startAnimation($ctrlAnimation);
    }

    public final void onDestory() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
        ITalosLiteContainer iTalosLiteContainer = this.container;
        if (iTalosLiteContainer != null) {
            ITalosLiteContainer.DefaultImpls.dispatchContainerEvent$default(iTalosLiteContainer, "disappear", (JSONObject) null, 2, (Object) null);
        }
    }
}
