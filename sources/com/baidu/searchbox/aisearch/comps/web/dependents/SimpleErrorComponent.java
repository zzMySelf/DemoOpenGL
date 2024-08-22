package com.baidu.searchbox.aisearch.comps.web.dependents;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.aisearch.comps.common.SimpleComponent;
import com.baidu.searchbox.aisearch.comps.web.WebViewLoadErrorState;
import com.baidu.searchbox.ng.browser.util.WeakNetworkManager;
import com.baidu.searchbox.ng.errorview.ErrorViewManager;
import com.baidu.searchbox.ng.errorview.ErrorViewUbcHelper;
import com.baidu.searchbox.ng.errorview.view.BdBaseErrorView;
import com.baidu.searchbox.ng.errorview.view.IBdErrorView;
import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/web/dependents/SimpleErrorComponent;", "Lcom/baidu/searchbox/aisearch/comps/common/SimpleComponent;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "errorView", "Lcom/baidu/searchbox/ng/errorview/view/IBdErrorView;", "reloadCallback", "Lkotlin/Function0;", "", "(Landroidx/lifecycle/LifecycleOwner;Lcom/baidu/searchbox/ng/errorview/view/IBdErrorView;Lkotlin/jvm/functions/Function0;)V", "onCreate", "onNightModeChange", "isNightMode", "", "onResume", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleErrorComponent.kt */
public final class SimpleErrorComponent extends SimpleComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final IBdErrorView errorView;
    /* access modifiers changed from: private */
    public final Function0<Unit> reloadCallback;

    public /* synthetic */ SimpleErrorComponent(LifecycleOwner lifecycleOwner, IBdErrorView iBdErrorView, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, iBdErrorView, function0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SimpleErrorComponent(androidx.lifecycle.LifecycleOwner r3, com.baidu.searchbox.ng.errorview.view.IBdErrorView r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5) {
        /*
            r2 = this;
            android.view.View r0 = r4.getView()
            java.lang.String r1 = "errorView.view"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r3, r0)
            r2.errorView = r4
            r2.reloadCallback = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aisearch.comps.web.dependents.SimpleErrorComponent.<init>(androidx.lifecycle.LifecycleOwner, com.baidu.searchbox.ng.errorview.view.IBdErrorView, kotlin.jvm.functions.Function0):void");
    }

    public void onCreate() {
        super.onCreate();
        onNightModeChange(NightModeHelper.isNightMode());
        IBdErrorView iBdErrorView = this.errorView;
        if (iBdErrorView instanceof BdBaseErrorView) {
            ((BdBaseErrorView) iBdErrorView).setEventListener(new SimpleErrorComponent$onCreate$1(this));
        }
    }

    public void onResume() {
        super.onResume();
        ErrorViewUbcHelper.ubcShow(this.errorView);
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        this.errorView.updateUIForNight(isNightMode);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/web/dependents/SimpleErrorComponent$Companion;", "", "()V", "create", "Lcom/baidu/searchbox/aisearch/comps/web/dependents/SimpleErrorComponent;", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "errorState", "Lcom/baidu/searchbox/aisearch/comps/web/WebViewLoadErrorState;", "reloadCallback", "Lkotlin/Function0;", "", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimpleErrorComponent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleErrorComponent create(Context context, LifecycleOwner owner, WebViewLoadErrorState errorState, Function0<Unit> reloadCallback) {
            IBdErrorView errorView;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(errorState, "errorState");
            Intrinsics.checkNotNullParameter(reloadCallback, "reloadCallback");
            if (errorState.getHasErrorOccurred() || !WeakNetworkManager.isWeakNetwork()) {
                errorView = ErrorViewManager.createErrorView(errorState.getErrorCode(), errorState.getHttpErrorCode(), context);
                Intrinsics.checkNotNullExpressionValue(errorView, "{\n                ErrorV…e, context)\n            }");
            } else {
                errorView = ErrorViewManager.createWeakNetworkErrorView(context);
                Intrinsics.checkNotNullExpressionValue(errorView, "{\n                ErrorV…ew(context)\n            }");
            }
            return new SimpleErrorComponent(owner, errorView, reloadCallback, (DefaultConstructorMarker) null);
        }
    }
}
