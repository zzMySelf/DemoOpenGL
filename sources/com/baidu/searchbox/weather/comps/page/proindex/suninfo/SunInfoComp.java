package com.baidu.searchbox.weather.comps.page.proindex.suninfo;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.weather.R;
import com.baidu.searchbox.weather.comps.page.proindex.view.SunriseView;
import com.baidu.searchbox.weather.util.FontUtilKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0016\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0016R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \f*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/searchbox/weather/comps/page/proindex/suninfo/SunInfoComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/weather/comps/page/proindex/suninfo/SunInfoViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "pageToken", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "animView", "Lcom/baidu/searchbox/weather/comps/page/proindex/view/SunriseView;", "kotlin.jvm.PlatformType", "arrow", "Landroid/widget/ImageView;", "layoutLocOnScreen", "", "getPageToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "screenHeight", "", "scrollChangeListener", "com/baidu/searchbox/weather/comps/page/proindex/suninfo/SunInfoComp$scrollChangeListener$1", "Lcom/baidu/searchbox/weather/comps/page/proindex/suninfo/SunInfoComp$scrollChangeListener$1;", "sunIcon", "sunriseAnim", "Landroid/animation/ValueAnimator;", "sunriseText", "Landroid/widget/TextView;", "sunriseTime", "sunsetText", "sunsetTime", "title", "bindSunriseScale", "", "viewModel", "bindSunriseText", "bindSunriseTime", "bindSunsetText", "bindSunsetTime", "bindTitle", "onBindViewModel", "onCreate", "onCreateViewModel", "onDestroy", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "Companion", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunInfoComp.kt */
public final class SunInfoComp extends BaseExtSlaveComponent<SunInfoViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<UniqueId> animatedPageTokens = new ArrayList();
    private final SunriseView animView;
    private final ImageView arrow;
    /* access modifiers changed from: private */
    public final int[] layoutLocOnScreen = new int[2];
    private final UniqueId pageToken;
    /* access modifiers changed from: private */
    public final int screenHeight = DeviceUtils.ScreenInfo.getDisplayHeight(getContext());
    private final SunInfoComp$scrollChangeListener$1 scrollChangeListener;
    private final ImageView sunIcon;
    /* access modifiers changed from: private */
    public final ValueAnimator sunriseAnim;
    private final TextView sunriseText;
    private final TextView sunriseTime;
    private final TextView sunsetText;
    private final TextView sunsetTime;
    private final TextView title;

    public final UniqueId getPageToken() {
        return this.pageToken;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SunInfoComp(LifecycleOwner owner, View view2, UniqueId pageToken2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(pageToken2, "pageToken");
        this.pageToken = pageToken2;
        this.title = (TextView) view2.findViewById(R.id.sunInfoTitle);
        TextView $this$sunriseTime_u24lambda_u2d0 = (TextView) view2.findViewById(R.id.sunriseTime);
        $this$sunriseTime_u24lambda_u2d0.setTypeface(FontUtilKt.getNumberFontType());
        this.sunriseTime = $this$sunriseTime_u24lambda_u2d0;
        TextView $this$sunsetTime_u24lambda_u2d1 = (TextView) view2.findViewById(R.id.sunsetTime);
        $this$sunsetTime_u24lambda_u2d1.setTypeface(FontUtilKt.getNumberFontType());
        this.sunsetTime = $this$sunsetTime_u24lambda_u2d1;
        this.sunriseText = (TextView) view2.findViewById(R.id.sunriseText);
        this.sunsetText = (TextView) view2.findViewById(R.id.sunsetText);
        this.sunIcon = (ImageView) view2.findViewById(R.id.sunIcon);
        this.arrow = (ImageView) view2.findViewById(R.id.arrow);
        this.animView = (SunriseView) view2.findViewById(R.id.animView);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator $this$sunriseAnim_u24lambda_u2d3 = ofFloat;
        $this$sunriseAnim_u24lambda_u2d3.setDuration(2000);
        $this$sunriseAnim_u24lambda_u2d3.addUpdateListener(new SunInfoComp$$ExternalSyntheticLambda6(this));
        this.sunriseAnim = ofFloat;
        this.scrollChangeListener = new SunInfoComp$scrollChangeListener$1(this, view2);
        onNightModeChange(NightModeHelper.getNightModeSwitcherState());
        onFontSizeChange(FontSizeInfo.Companion.getInfo());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/weather/comps/page/proindex/suninfo/SunInfoComp$Companion;", "", "()V", "animatedPageTokens", "", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getAnimatedPageTokens", "()Ljava/util/List;", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SunInfoComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<UniqueId> getAnimatedPageTokens() {
            return SunInfoComp.animatedPageTokens;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sunriseAnim$lambda-3$lambda-2  reason: not valid java name */
    public static final void m7531sunriseAnim$lambda3$lambda2(SunInfoComp this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
        float max = Math.max(f2 != null ? f2.floatValue() : 0.0f, 0.0f);
        Float value = ((SunInfoViewModel) this$0.getViewModel()).getSunriseScale$lib_weather_landing_release().getValue();
        if (value == null) {
            value = Float.valueOf(0.0f);
        }
        this$0.animView.setAngleScale(Math.min(max, value.floatValue()));
    }

    public void onCreate() {
        super.onCreate();
        getView().getViewTreeObserver().addOnScrollChangedListener(this.scrollChangeListener);
    }

    public SunInfoViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("SunInfoComp", SunInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"SunInfoCom…nfoViewModel::class.java)");
        return (SunInfoViewModel) viewModel;
    }

    public void onBindViewModel(SunInfoViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        bindTitle(viewModel, owner);
        bindSunriseText(viewModel, owner);
        bindSunsetText(viewModel, owner);
        bindSunriseTime(viewModel, owner);
        bindSunsetTime(viewModel, owner);
        bindSunriseScale(viewModel, owner);
    }

    private final void bindTitle(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getTitle$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTitle$lambda-4  reason: not valid java name */
    public static final void m7530bindTitle$lambda4(SunInfoComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = it;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.title.setVisibility(4);
            return;
        }
        this$0.title.setVisibility(0);
        this$0.title.setText(it);
    }

    private final void bindSunriseText(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSunriseText$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSunriseText$lambda-5  reason: not valid java name */
    public static final void m7526bindSunriseText$lambda5(SunInfoComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = it;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.sunriseText.setVisibility(4);
            return;
        }
        this$0.sunriseText.setVisibility(0);
        this$0.sunriseText.setText(it);
    }

    private final void bindSunsetText(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSunsetText$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSunsetText$lambda-6  reason: not valid java name */
    public static final void m7528bindSunsetText$lambda6(SunInfoComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = it;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.sunsetText.setVisibility(4);
            return;
        }
        this$0.sunsetText.setVisibility(0);
        this$0.sunsetText.setText(it);
    }

    private final void bindSunriseTime(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSunriseTime$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSunriseTime$lambda-7  reason: not valid java name */
    public static final void m7527bindSunriseTime$lambda7(SunInfoComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = it;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.sunriseTime.setVisibility(4);
            return;
        }
        this$0.sunriseTime.setVisibility(0);
        this$0.sunriseTime.setText(it);
    }

    private final void bindSunsetTime(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSunsetTime$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSunsetTime$lambda-8  reason: not valid java name */
    public static final void m7529bindSunsetTime$lambda8(SunInfoComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = it;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.sunsetTime.setVisibility(4);
            return;
        }
        this$0.sunsetTime.setVisibility(0);
        this$0.sunsetTime.setText(it);
    }

    private final void bindSunriseScale(SunInfoViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSunriseScale$lib_weather_landing_release().observe(owner, new SunInfoComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSunriseScale$lambda-10  reason: not valid java name */
    public static final void m7525bindSunriseScale$lambda10(SunInfoComp this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (animatedPageTokens.contains(this$0.pageToken) && it != null) {
            float floatValue = it.floatValue();
            this$0.animView.setAngleScale(it.floatValue());
        }
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ResWrapper.setTextColor(this.title, com.baidu.searchbox.search.style.res.R.color.SC12);
        ResWrapper.setTextColor(this.sunriseTime, com.baidu.searchbox.search.style.res.R.color.SC9);
        ResWrapper.setTextColor(this.sunriseText, com.baidu.searchbox.search.style.res.R.color.SC9);
        ResWrapper.setTextColor(this.sunsetTime, com.baidu.searchbox.search.style.res.R.color.SC9);
        ResWrapper.setTextColor(this.sunsetText, com.baidu.searchbox.search.style.res.R.color.SC9);
        ResWrapper.setImageDrawable(this.sunIcon, R.drawable.search_weather_sunrise_icon);
        ResWrapper.setImageDrawable(this.arrow, R.drawable.search_weather_sunrise_arrow);
        this.animView.onNightModeChange(isNightMode);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        FontSizeExtKt.updateTextSize$default(this.title, 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(this.sunriseTime, 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(this.sunriseText, 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(this.sunsetTime, 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(this.sunsetText, 0, 1, (Object) null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.sunriseAnim.cancel();
        getView().getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangeListener);
    }
}
