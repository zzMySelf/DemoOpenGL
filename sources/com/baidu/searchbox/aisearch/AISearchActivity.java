package com.baidu.searchbox.aisearch;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.aisearch.comps.common.IActivityResultCallbackKt;
import com.baidu.searchbox.aisearch.comps.common.IConfigurationChangedKt;
import com.baidu.searchbox.aisearch.comps.common.IRequestPermissionResultCallbackKt;
import com.baidu.searchbox.aisearch.comps.halfconainer.ContainerTypeManagerKt;
import com.baidu.searchbox.aisearch.comps.page.AISearchContextKt;
import com.baidu.searchbox.aisearch.comps.page.AISearchPageComp;
import com.baidu.searchbox.aisearch.comps.page.AISearchPageParams;
import com.baidu.searchbox.aisearch.comps.page.BasePageComp;
import com.baidu.searchbox.aisearch.comps.page.ContainerAnimation;
import com.baidu.searchbox.aisearch.event.CloseContainerEvent;
import com.baidu.searchbox.aisearch.event.CloseOtherContainerEvent;
import com.baidu.searchbox.aisearch.event.OverrideAnimationEvent;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.EdgeInterceptor;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J-\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\rH\u0014J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\u0014\u0010)\u001a\u00020\r2\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\"H\u0003J\b\u0010+\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/aisearch/AISearchActivity;", "Lcom/baidu/searchbox/appframework/BaseActivity;", "Lcom/baidu/searchbox/widget/SlideInterceptor;", "Lcom/baidu/searchbox/widget/EdgeInterceptor;", "()V", "hasSentCloseOtherContainerEvent", "", "pageComp", "Lcom/baidu/searchbox/aisearch/comps/page/BasePageComp;", "isSlidable", "ev", "Landroid/view/MotionEvent;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPostCreate", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "registerCloseEvents", "registerOverrideAnimationEvent", "setTransitionAnimation", "animationType", "setupSliding", "setupStatusBarStyle", "activity", "Landroid/app/Activity;", "shouldIntercept", "updateStatusBarType", "isNight", "useLightStatusBar", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchActivity.kt */
public final class AISearchActivity extends BaseActivity implements SlideInterceptor, EdgeInterceptor {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean hasSentCloseOtherContainerEvent;
    /* access modifiers changed from: private */
    public BasePageComp<?> pageComp;

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

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Object obj;
        IAISearchSpeedStat.Companion.getImpl().updateStatistic("aisearch", "onCreate");
        IAISearchSpeedStat.Companion.getImpl().updateStatistic("aisearch_inspiration", "onCreate");
        super.onCreate(savedInstanceState);
        AISearchPageParams aISearchPageParams = null;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = getIntent();
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("extra_aisearch_params") : null;
            if (serializableExtra != null) {
                obj = Result.m8971constructorimpl((AISearchPageParams) serializableExtra);
                if (!Result.m8977isFailureimpl(obj)) {
                    aISearchPageParams = obj;
                }
                AISearchPageParams params = aISearchPageParams;
                if (params == null) {
                    finish();
                    return;
                }
                ContainerTypeManagerKt.updateContainerType(AISearchContextKt.getMainBotToken());
                AISearchActivityKt.topActivityRef = new WeakReference(this);
                setTransitionAnimation(params.getAnimationType());
                setupSliding();
                setupStatusBarStyle(this);
                setContentView(R.layout.aisearch_activity);
                if (this.pageComp == null) {
                    View inflate = ((ViewStub) _$_findCachedViewById(R.id.page_comp_vs)).inflate();
                    Intrinsics.checkNotNullExpressionValue(inflate, "page_comp_vs.inflate()");
                    this.pageComp = new AISearchPageComp(this, inflate, params);
                }
                registerCloseEvents();
                registerOverrideAnimationEvent();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.aisearch.comps.page.AISearchPageParams");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SlideHelper slideHelper = getSlideHelper();
        if (slideHelper != null) {
            slideHelper.setEdgeInterceptor(this);
        }
    }

    private final void setupSliding() {
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            setEnableSliding(true, this);
        }
        setSlideExtraListener(new AISearchActivity$setupSliding$1(this));
    }

    private final void registerCloseEvents() {
        BdEventBus.Companion.getDefault().register(this, CloseContainerEvent.class, new AISearchActivity$$ExternalSyntheticLambda0(this));
        BdEventBus.Companion.getDefault().register(this, CloseOtherContainerEvent.class, new AISearchActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCloseEvents$lambda-1  reason: not valid java name */
    public static final void m15085registerCloseEvents$lambda1(AISearchActivity this$0, CloseContainerEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.getToken(), (Object) AISearchContextKt.getMainBotToken())) {
            this$0.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCloseEvents$lambda-2  reason: not valid java name */
    public static final void m15086registerCloseEvents$lambda2(AISearchActivity this$0, CloseOtherContainerEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AISearchActivity sourceActivity = (AISearchActivity) it.getSourceActivity().get();
        if (sourceActivity == null || !Intrinsics.areEqual((Object) sourceActivity, (Object) this$0)) {
            this$0.finish();
        }
    }

    private final void registerOverrideAnimationEvent() {
        BdEventBus.Companion.getDefault().register(this, OverrideAnimationEvent.class, new AISearchActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerOverrideAnimationEvent$lambda-3  reason: not valid java name */
    public static final void m15087registerOverrideAnimationEvent$lambda3(AISearchActivity this$0, OverrideAnimationEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.setTransitionAnimation(it.getAnimationType());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.hasSentCloseOtherContainerEvent) {
            BdEventBus.Companion.getDefault().post(new CloseOtherContainerEvent(new WeakReference(this)));
            this.hasSentCloseOtherContainerEvent = true;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            IConfigurationChangedKt.dispatchConfigurationChanged(basePageComp, newConfig);
        }
    }

    private final void setTransitionAnimation(@ContainerAnimation String animationType) {
        if (animationType != null) {
            switch (animationType.hashCode()) {
                case -1041204366:
                    if (animationType.equals("noAnim")) {
                        setPendingTransition(0, 0, 0, 0);
                        return;
                    }
                    break;
                case -908137028:
                    if (animationType.equals("fadeEnter")) {
                        setPendingTransition(R.anim.aisearch_fade_in, R.anim.aisearch_fade_out, R.anim.aisearch_fade_in, R.anim.aisearch_fade_out);
                        return;
                    }
                    break;
                case 1649376418:
                    if (animationType.equals("slideEnterUp")) {
                        setPendingTransition(R.anim.aisearch_slide_in_from_top, R.anim.aisearch_slide_out_to_bottom, R.anim.aisearch_slide_in_from_bottom, R.anim.aisearch_slide_out_to_top);
                        return;
                    }
                    break;
            }
        }
        setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    private final boolean useLightStatusBar() {
        return true;
    }

    private final void setupStatusBarStyle(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            setEnableImmersion(false);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            if (useLightStatusBar()) {
                updateStatusBarType(NightModeHelper.getNightModeSwitcherState());
                return;
            }
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private final void updateStatusBarType(boolean isNight) {
        int option;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            int option2 = decorView.getSystemUiVisibility();
            if (isNight) {
                option = option2 & -8193;
            } else {
                option = option2 | 8192;
            }
            decorView.setSystemUiVisibility(option);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        BasePageComp pageComp2 = this.pageComp;
        if (keyCode != 4 || pageComp2 == null) {
            return super.onKeyDown(keyCode, event);
        }
        if (event != null && event.getAction() == 0) {
            BasePageComp.onBackPressed$default(pageComp2, "slideEnterRight", false, 2, (Object) null);
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            IRequestPermissionResultCallbackKt.dispatchRequestPermissionResult(basePageComp, requestCode, permissions, grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            IActivityResultCallbackKt.dispatchActivityResult(basePageComp, requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            Result.Companion companion = Result.Companion;
            BdEventBus.Companion.getDefault().unregister(this);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public boolean isSlidable(MotionEvent ev) {
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            return basePageComp.isSlidable(ev);
        }
        return false;
    }

    public boolean shouldIntercept(MotionEvent ev) {
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            return basePageComp.shouldIntercept(ev);
        }
        return false;
    }
}
