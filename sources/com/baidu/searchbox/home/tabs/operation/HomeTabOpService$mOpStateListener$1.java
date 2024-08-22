package com.baidu.searchbox.home.tabs.operation;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.home.tabs.bubble.HomeTabBubbleInfo;
import com.baidu.searchbox.home.tabs.bubble.HomeTabBubbleUtils;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, d2 = {"com/baidu/searchbox/home/tabs/operation/HomeTabOpService$mOpStateListener$1", "Lcom/baidu/searchbox/home/tabs/operation/IOperationStateListener;", "failedType", "Ljava/util/LinkedHashSet;", "", "getFailedType", "()Ljava/util/LinkedHashSet;", "setFailedType", "(Ljava/util/LinkedHashSet;)V", "hasNotifyDismiss", "", "getHasNotifyDismiss", "()Z", "setHasNotifyDismiss", "(Z)V", "hasNotifySuccess", "getHasNotifySuccess", "setHasNotifySuccess", "onOpDismiss", "", "isAllDismiss", "type", "onOpShow", "isSuccess", "lib-home-tab-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTabOpService.kt */
public final class HomeTabOpService$mOpStateListener$1 implements IOperationStateListener {
    private LinkedHashSet<String> failedType = new LinkedHashSet<>();
    private boolean hasNotifyDismiss;
    private boolean hasNotifySuccess;
    final /* synthetic */ HomeTabOpService this$0;

    HomeTabOpService$mOpStateListener$1(HomeTabOpService $receiver) {
        this.this$0 = $receiver;
    }

    public final boolean getHasNotifySuccess() {
        return this.hasNotifySuccess;
    }

    public final void setHasNotifySuccess(boolean z) {
        this.hasNotifySuccess = z;
    }

    public final boolean getHasNotifyDismiss() {
        return this.hasNotifyDismiss;
    }

    public final void setHasNotifyDismiss(boolean z) {
        this.hasNotifyDismiss = z;
    }

    public final LinkedHashSet<String> getFailedType() {
        return this.failedType;
    }

    public final void setFailedType(LinkedHashSet<String> linkedHashSet) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<set-?>");
        this.failedType = linkedHashSet;
    }

    public void onOpShow(boolean isSuccess, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.hasNotifySuccess && !this.hasNotifyDismiss) {
            boolean isAllFailed = true;
            if (isSuccess) {
                this.failedType.remove(type);
                if (!this.hasNotifySuccess) {
                    this.hasNotifySuccess = true;
                    Function2 access$getMOpShowCallback$p = this.this$0.mOpShowCallback;
                    if (access$getMOpShowCallback$p != null) {
                        access$getMOpShowCallback$p.invoke(true, null);
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("HomeTabOpService", "onOpShow: 通知KMM tabTag==" + this.this$0.getMTabTag() + " 上的运营数据已经展示");
                        return;
                    }
                    return;
                }
            } else {
                this.failedType.add(type);
            }
            if ((!this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_BUBBLE_ICON_ALL) && ((!this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_BUBBLE) || !this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_ICON)) && (!this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_ICON) || (!this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_INNER_BUBBLE) && !this.failedType.contains(HomeTabIconAndBubbleProcess.HOME_BAR_OPERATION_OUT_BUBBLE))))) || !this.failedType.contains(HomeTabRedDotProcess.HOME_BAR_OPERATION_BADGE_RED_DOT)) {
                isAllFailed = false;
            }
            if (isAllFailed && !this.hasNotifySuccess) {
                Function2 access$getMOpShowCallback$p2 = this.this$0.mOpShowCallback;
                if (access$getMOpShowCallback$p2 != null) {
                    access$getMOpShowCallback$p2.invoke(false, null);
                }
                this.failedType.clear();
                if (AppConfig.isDebug()) {
                    Log.d("HomeTabOpService", "onOpShow: 通知KMM tabTag==" + this.this$0.getMTabTag() + " 上的运营数据没有展示");
                }
            }
        }
    }

    public void onOpDismiss(boolean isAllDismiss, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int delayShowTimeMs = 1000;
        if (HomeTabBubbleUtils.checkRegressionData(this.this$0.getMConfig())) {
            HomeTabIconAndBubbleProcess mIconAndBubbleProcess = this.this$0.getMIconAndBubbleProcess();
            String str = null;
            HomeTabBubbleInfo info = mIconAndBubbleProcess != null ? mIconAndBubbleProcess.getBubbleInfo(HomeTabIconAndBubbleProcess.OPERATION_REGRESSION_TYPE) : null;
            if (info != null) {
                str = info.bubbleDelay;
            }
            delayShowTimeMs = 1000 + HomeTabBubbleUtils.getMilSecTimeFromSec(str, 0);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new HomeTabOpService$mOpStateListener$1$$ExternalSyntheticLambda0(this.this$0, this), (long) delayShowTimeMs);
    }

    /* access modifiers changed from: private */
    /* renamed from: onOpDismiss$lambda-0  reason: not valid java name */
    public static final void m20244onOpDismiss$lambda0(HomeTabOpService this$02, HomeTabOpService$mOpStateListener$1 this$1) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (!this$02.hasOpShowingCurTab() && !this$1.hasNotifyDismiss) {
            this$1.hasNotifyDismiss = true;
            Function0 access$getMOpDismissCallback$p = this$02.mOpDismissCallback;
            if (access$getMOpDismissCallback$p != null) {
                access$getMOpDismissCallback$p.invoke();
            }
            if (AppConfig.isDebug()) {
                Log.d("HomeTabOpService", "onOpDismiss: 通知KMM tabTag==" + this$02.getMTabTag() + " 上的运营数据消失");
            }
        }
    }
}
