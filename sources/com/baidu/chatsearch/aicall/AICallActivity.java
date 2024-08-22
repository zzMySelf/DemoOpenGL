package com.baidu.chatsearch.aicall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.chatsearch.aicall.comps.common.IActivityResultCallbackKt;
import com.baidu.chatsearch.aicall.comps.common.IConfigurationChangedKt;
import com.baidu.chatsearch.aicall.comps.common.IRequestPermissionResultCallbackKt;
import com.baidu.chatsearch.aicall.comps.page.AICallPageComp;
import com.baidu.chatsearch.aicall.comps.page.AICallPageParams;
import com.baidu.chatsearch.aicall.comps.page.BasePageComp;
import com.baidu.chatsearch.aicall.comps.page.ContainerAnimation;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideInterceptor;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\u001a\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J-\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u000b2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u001fH\u0003J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/chatsearch/aicall/AICallActivity;", "Lcom/baidu/searchbox/appframework/BaseActivity;", "Lcom/baidu/searchbox/widget/SlideInterceptor;", "()V", "pageComp", "Lcom/baidu/chatsearch/aicall/comps/page/BasePageComp;", "isSlidable", "", "ev", "Landroid/view/MotionEvent;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setTransitionAnimation", "animationType", "setupSliding", "enableSliding", "setupStatusBarStyle", "activity", "Landroid/app/Activity;", "updateStatusBarType", "isNight", "useLightStatusBar", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallActivity.kt */
public final class AICallActivity extends BaseActivity implements SlideInterceptor {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
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
        super.onCreate(savedInstanceState);
        AICallPageParams aICallPageParams = null;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = getIntent();
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(AICallActivityKt.EXTRA_AICALL_PARAMS) : null;
            if (serializableExtra != null) {
                obj = Result.m8971constructorimpl((AICallPageParams) serializableExtra);
                if (!Result.m8977isFailureimpl(obj)) {
                    aICallPageParams = obj;
                }
                AICallPageParams params = aICallPageParams;
                if (params == null) {
                    finish();
                    return;
                }
                setTransitionAnimation("fadeEnter");
                setupSliding(false);
                setupStatusBarStyle(this);
                setContentView(R.layout.aicall_activity);
                View findViewById = findViewById(R.id.page_comp);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.page_comp)");
                BasePageComp<?> aICallPageComp = new AICallPageComp(this, findViewById, params);
                this.pageComp = aICallPageComp;
                aICallPageComp.setCloseContainerWithAnimation(new AICallActivity$onCreate$1(this));
                BasePageComp<?> basePageComp = this.pageComp;
                if (basePageComp != null) {
                    basePageComp.setOverrideAnimationEvent(new AICallActivity$onCreate$2(this));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.chatsearch.aicall.comps.page.AICallPageParams");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    private final void setupSliding(boolean enableSliding) {
        if (enableSliding) {
            if (Build.VERSION.SDK_INT == 26) {
                setEnableSliding(false);
                setCurrentActivityNoTransparent();
            } else {
                setEnableSliding(true, this);
            }
            setSlideExtraListener(new AICallActivity$setupSliding$1(this));
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

    /* access modifiers changed from: private */
    public final void setTransitionAnimation(@ContainerAnimation String animationType) {
        if (Intrinsics.areEqual((Object) animationType, (Object) "slideEnterRight")) {
            setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        } else {
            setPendingTransition(R.anim.aicall_fade_in, R.anim.aicall_fade_out, R.anim.aicall_fade_in, R.anim.aicall_fade_out);
        }
    }

    private final boolean useLightStatusBar() {
        return true;
    }

    private final void setupStatusBarStyle(Activity activity) {
        Window window = activity.getWindow();
        if (DeviceUtils.OSInfo.hasMarshMallow()) {
            setEnableImmersion(false);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            updateStatusBarType(!useLightStatusBar());
        } else if (DeviceUtils.OSInfo.hasKitKat()) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
        }
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
        if ((event != null && event.getAction() == 0) && BasePageComp.onBackPressed$default(pageComp2, "fadeEnter", false, 2, (Object) null)) {
            UniversalToast.makeText((Context) AppRuntime.getApplication(), (CharSequence) getString(R.string.aicall_call_finish)).setDuration(3).setLocation(ToastLocation.MIDDLE).show();
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
        try {
            Result.Companion companion = Result.Companion;
            setResult(-1);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        super.onDestroy();
    }

    public boolean isSlidable(MotionEvent ev) {
        BasePageComp<?> basePageComp = this.pageComp;
        if (basePageComp != null) {
            return basePageComp.isSlidable(ev);
        }
        return false;
    }
}
