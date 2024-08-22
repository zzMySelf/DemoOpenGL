package com.baidu.searchbox.introduction.model;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.homeintroduction.R;
import com.baidu.searchbox.introduction.data.TaskGainData;
import com.baidu.searchbox.introduction.inter.ITaskPersuadeCallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/introduction/model/TaskGuidePersuadeUtil;", "", "()V", "hasGainPackage", "", "getHasGainPackage", "()Z", "setHasGainPackage", "(Z)V", "gainPersuadePackage", "", "dialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "callback", "Lcom/baidu/searchbox/introduction/inter/ITaskPersuadeCallBack;", "goToTaskList", "scheme", "", "handlePersuadeGainResult", "taskGainData", "Lcom/baidu/searchbox/introduction/data/TaskGainData;", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskGuidePersuadeUtil.kt */
public final class TaskGuidePersuadeUtil {
    public static final TaskGuidePersuadeUtil INSTANCE = new TaskGuidePersuadeUtil();
    private static boolean hasGainPackage;

    private TaskGuidePersuadeUtil() {
    }

    public final boolean getHasGainPackage() {
        return hasGainPackage;
    }

    public final void setHasGainPackage(boolean z) {
        hasGainPackage = z;
    }

    public final void gainPersuadePackage(BdAlertDialog dialog, ITaskPersuadeCallBack callback) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        TaskGuideRequestUtil.INSTANCE.gainGuideResult("persuade", new TaskGuidePersuadeUtil$gainPersuadePackage$1(dialog, callback));
    }

    /* access modifiers changed from: private */
    public final void handlePersuadeGainResult(BdAlertDialog dialog, TaskGainData taskGainData, ITaskPersuadeCallBack callback) {
        if (taskGainData == null) {
            UiThreadUtils.runOnUiThread(new TaskGuidePersuadeUtil$$ExternalSyntheticLambda0(callback));
        } else if (taskGainData.getResultCode() != 0) {
            UiThreadUtils.runOnUiThread(new TaskGuidePersuadeUtil$$ExternalSyntheticLambda1(taskGainData, callback));
        } else if (taskGainData.getResultType() == 1 || taskGainData.getResultType() == 2) {
            UiThreadUtils.runOnUiThread(new TaskGuidePersuadeUtil$$ExternalSyntheticLambda2(dialog, taskGainData, callback));
        } else if (taskGainData.getResultType() == 3) {
            UiThreadUtils.runOnUiThread(new TaskGuidePersuadeUtil$$ExternalSyntheticLambda3(dialog, taskGainData, callback));
        } else if (taskGainData.getResultType() == 4) {
            UiThreadUtils.runOnUiThread(new TaskGuidePersuadeUtil$$ExternalSyntheticLambda4(dialog, taskGainData, callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePersuadeGainResult$lambda-0  reason: not valid java name */
    public static final void m20467handlePersuadeGainResult$lambda0(ITaskPersuadeCallBack $callback) {
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.net_error).show();
        if ($callback != null) {
            $callback.onGainPersuadeResult("server_fail");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePersuadeGainResult$lambda-1  reason: not valid java name */
    public static final void m20468handlePersuadeGainResult$lambda1(TaskGainData $taskGainData, ITaskPersuadeCallBack $callback) {
        String errorMsg;
        if (TextUtils.isEmpty($taskGainData.getErrorMsg())) {
            errorMsg = AppRuntime.getAppContext().getResources().getString(R.string.net_error);
        } else {
            errorMsg = $taskGainData.getErrorMsg();
        }
        Intrinsics.checkNotNullExpressionValue(errorMsg, "if (TextUtils.isEmpty(ta…lse taskGainData.errorMsg");
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) errorMsg).show();
        if ($callback != null) {
            $callback.onGainPersuadeResult("server_fail");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePersuadeGainResult$lambda-2  reason: not valid java name */
    public static final void m20469handlePersuadeGainResult$lambda2(BdAlertDialog $dialog, TaskGainData $taskGainData, ITaskPersuadeCallBack $callback) {
        Intrinsics.checkNotNullParameter($dialog, "$dialog");
        TaskGuidePersuadeUtil taskGuidePersuadeUtil = INSTANCE;
        hasGainPackage = true;
        TaskGuideDataUtilKt.clearLocalResource();
        taskGuidePersuadeUtil.goToTaskList($dialog, $taskGainData.getAutomaticSchema());
        if ($callback != null) {
            $callback.onGainPersuadeResult("receive_success");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePersuadeGainResult$lambda-3  reason: not valid java name */
    public static final void m20470handlePersuadeGainResult$lambda3(BdAlertDialog $dialog, TaskGainData $taskGainData, ITaskPersuadeCallBack $callback) {
        Intrinsics.checkNotNullParameter($dialog, "$dialog");
        TaskGuidePersuadeUtil taskGuidePersuadeUtil = INSTANCE;
        hasGainPackage = true;
        TaskGuideDataUtilKt.clearLocalResource();
        taskGuidePersuadeUtil.goToTaskList($dialog, $taskGainData.getAutomaticSchema());
        if ($callback != null) {
            $callback.onGainPersuadeResult("fail1");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePersuadeGainResult$lambda-4  reason: not valid java name */
    public static final void m20471handlePersuadeGainResult$lambda4(BdAlertDialog $dialog, TaskGainData $taskGainData, ITaskPersuadeCallBack $callback) {
        Intrinsics.checkNotNullParameter($dialog, "$dialog");
        TaskGuidePersuadeUtil taskGuidePersuadeUtil = INSTANCE;
        hasGainPackage = true;
        TaskGuideDataUtilKt.clearLocalResource();
        taskGuidePersuadeUtil.goToTaskList($dialog, $taskGainData.getAutomaticSchema());
        if ($callback != null) {
            $callback.onGainPersuadeResult("fail2");
        }
    }

    private final void goToTaskList(BdAlertDialog dialog, String scheme) {
        View decorView;
        Activity activity;
        Router.invoke(AppRuntime.getAppContext(), scheme);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (activity = BdBoxActivityManager.getRealTopActivity()) != null) {
            try {
                if (!ActivityUtils.isDestroyed(activity) && dialog.isShowing() && decorView.isAttachedToWindow()) {
                    dialog.dismiss();
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
