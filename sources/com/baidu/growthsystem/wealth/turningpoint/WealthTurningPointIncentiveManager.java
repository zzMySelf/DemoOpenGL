package com.baidu.growthsystem.wealth.turningpoint;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.growthsystem.wealth.InternalWealthTaskManager;
import com.baidu.growthsystem.wealth.common.talos.WealthTaskTalosConstantsKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoDialogUtilKt;
import com.baidu.growthsystem.wealth.scenes.SceneConfigRepo;
import com.baidu.growthsystem.wealth.scenes.SceneModel;
import com.baidu.growthsystem.wealth.turningpoint.model.WealthTurningPointIncentiveCcsModel;
import com.baidu.growthsystem.wealth.turningpoint.model.WealthTurningPointIncentiveUpdateModel;
import com.baidu.growthsystem.wealth.turningpoint.model.WealthTurningPointIncentiveUserModel;
import com.baidu.growthsystem.wealth.turningpoint.util.WealthTurningPointIncentiveCcsModelParserKt;
import com.baidu.growthsystem.wealth.turningpoint.util.WealthTurningPointIncentiveUserModelParserKt;
import com.baidu.growthsystem.wealth.video.service.WealthTaskVideoItemModel;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ/\u0010\u001a\u001a\u00020\u00152%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\"\u001a\u00020\u0015H\u0002J\u000e\u0010#\u001a\u00020\u0004*\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/baidu/growthsystem/wealth/turningpoint/WealthTurningPointIncentiveManager;", "", "()V", "DEBUG", "", "TAG", "", "ccsModel", "Lcom/baidu/growthsystem/wealth/turningpoint/model/WealthTurningPointIncentiveCcsModel;", "isTryingShowIncentiveDialog", "updateModel", "Lcom/baidu/growthsystem/wealth/turningpoint/model/WealthTurningPointIncentiveUpdateModel;", "value", "Lcom/baidu/growthsystem/wealth/turningpoint/model/WealthTurningPointIncentiveUserModel;", "userModel", "setUserModel", "(Lcom/baidu/growthsystem/wealth/turningpoint/model/WealthTurningPointIncentiveUserModel;)V", "checkCanShowIncentiveDialog", "itemModel", "Lcom/baidu/growthsystem/wealth/video/service/WealthTaskVideoItemModel;", "clearDialogDisplayCount", "", "handleVideoItemChanged", "isFirstVideoFromNonVideoTabScene", "setCssModel", "setUpdateModel", "showIncentiveDialog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "showIncentiveDialogIfNeeded", "updateUserModel", "updateUserWatchVideoData", "isWealthTaskEnabled", "Lcom/baidu/growthsystem/wealth/scenes/SceneModel;", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTurningPointIncentiveManager.kt */
public final class WealthTurningPointIncentiveManager {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final WealthTurningPointIncentiveManager INSTANCE = new WealthTurningPointIncentiveManager();
    private static final String TAG = "WealthTurningPointIncentiveManager";
    private static WealthTurningPointIncentiveCcsModel ccsModel = WealthTurningPointIncentiveCcsModelParserKt.readWealthTurningPointIncentiveCcsModelFromSp();
    /* access modifiers changed from: private */
    public static boolean isTryingShowIncentiveDialog;
    private static WealthTurningPointIncentiveUpdateModel updateModel;
    /* access modifiers changed from: private */
    public static WealthTurningPointIncentiveUserModel userModel = WealthTurningPointIncentiveUserModelParserKt.readWealthTurningPointIncentiveUserModelFromSp();

    private WealthTurningPointIncentiveManager() {
    }

    /* access modifiers changed from: private */
    public final void setUserModel(WealthTurningPointIncentiveUserModel value) {
        userModel = value;
        WealthTurningPointIncentiveUserModelParserKt.writeWealthTurningPointIncentiveUserModelToSp(value);
        if (DEBUG) {
            Log.d(TAG, "Update user model: watch video count = " + value.getWatchVideoCount() + ", dialog display count = " + value.getDialogDisplayCount() + ", has shown today = " + value.getHasDisplayedDialogToday());
        }
    }

    public final void setUpdateModel(WealthTurningPointIncentiveUpdateModel updateModel2) {
        updateModel = updateModel2;
    }

    public final void setCssModel(WealthTurningPointIncentiveCcsModel ccsModel2) {
        Intrinsics.checkNotNullParameter(ccsModel2, "ccsModel");
        ccsModel = ccsModel2;
    }

    public final void updateUserModel(WealthTurningPointIncentiveUserModel userModel2) {
        Intrinsics.checkNotNullParameter(userModel2, "userModel");
        setUserModel(userModel2);
    }

    public final void handleVideoItemChanged(WealthTaskVideoItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        updateUserWatchVideoData();
        showIncentiveDialogIfNeeded(itemModel);
    }

    public final void clearDialogDisplayCount() {
        setUserModel(userModel.buildUpon().setDialogDisplayCount(0).build());
        if (DEBUG) {
            Log.d(TAG, "Clear turning point incentive dialog display count");
        }
    }

    private final void updateUserWatchVideoData() {
        int watchVideoCount;
        boolean hasShownDialogToday;
        long currentTime = System.currentTimeMillis();
        if (DateTimeUtils.isSameDay(currentTime, userModel.getLatestWatchVideoTimeMillis())) {
            watchVideoCount = userModel.getWatchVideoCount() + 1;
            hasShownDialogToday = userModel.getHasDisplayedDialogToday();
        } else {
            watchVideoCount = 1;
            hasShownDialogToday = false;
        }
        setUserModel(userModel.buildUpon().setWatchVideoCount(watchVideoCount).setLatestWatchVideoTimeMillis(currentTime).setHasDisplayedDialogToday(hasShownDialogToday).build());
    }

    private final void showIncentiveDialogIfNeeded(WealthTaskVideoItemModel itemModel) {
        if (checkCanShowIncentiveDialog(itemModel)) {
            if (DEBUG) {
                Log.d(TAG, "Try to show turning point incentive dialog");
            }
            isTryingShowIncentiveDialog = true;
            showIncentiveDialog(WealthTurningPointIncentiveManager$showIncentiveDialogIfNeeded$1.INSTANCE);
        }
    }

    private final boolean checkCanShowIncentiveDialog(WealthTaskVideoItemModel itemModel) {
        Pair pair;
        WealthTurningPointIncentiveUpdateModel updateModel2 = updateModel;
        if (updateModel2 == null) {
            pair = new Pair(false, "update model is null");
        } else if (!updateModel2.isValid()) {
            pair = new Pair(false, "update model is invalid");
        } else if (!updateModel2.isHitExp()) {
            pair = new Pair(false, "not hit exp");
        } else if (!itemModel.isWealthTaskShowAble()) {
            pair = new Pair(false, "wealth task function is not allowed to show");
        } else if (!isWealthTaskEnabled(itemModel.getWealthTaskSceneModel())) {
            pair = new Pair(false, "wealth task function is not enabled on current page scene");
        } else if (isFirstVideoFromNonVideoTabScene(itemModel)) {
            pair = new Pair(false, "current video item is first item in non-flow-video-tab scene");
        } else if (userModel.getWatchVideoCount() < updateModel2.getWatchVideoThreshold()) {
            pair = new Pair(false, "watch video count is less than threshold");
        } else if (userModel.getHasDisplayedDialogToday()) {
            pair = new Pair(false, "dialog has displayed today");
        } else if (userModel.getDialogDisplayCount() >= ccsModel.getMaxDialogDisplayCount()) {
            pair = new Pair(false, "total display count exceed limit");
        } else if (!WealthVideoDialogUtilKt.isPopupDialogShowAble()) {
            pair = new Pair(false, "popup dialog is intercepted by flow-video module");
        } else if (WealthVideoDialogUtilKt.isWealthTaskDialogShowing()) {
            pair = new Pair(false, "wealth task dialog is already showing");
        } else if (WealthVideoDialogUtilKt.isWealthTaskDialogSequenceExecuting()) {
            pair = new Pair(false, "popup dialog sequence is already executing");
        } else if (isTryingShowIncentiveDialog) {
            pair = new Pair(false, "dialog is currently being attempted to display");
        } else {
            pair = new Pair(true, "");
        }
        boolean canShow = ((Boolean) pair.component1()).booleanValue();
        String failReason = (String) pair.component2();
        if (DEBUG && !canShow) {
            Log.d(TAG, "Cannot show turning point incentive dialog since " + failReason);
        }
        return canShow;
    }

    static /* synthetic */ void showIncentiveDialog$default(WealthTurningPointIncentiveManager wealthTurningPointIncentiveManager, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        wealthTurningPointIncentiveManager.showIncentiveDialog(function1);
    }

    private final void showIncentiveDialog(Function1<? super Boolean, Unit> callback) {
        WealthTurningPointIncentiveUpdateModel wealthTurningPointIncentiveUpdateModel = updateModel;
        String scheme = wealthTurningPointIncentiveUpdateModel != null ? wealthTurningPointIncentiveUpdateModel.getScheme() : null;
        CharSequence charSequence = scheme;
        if (!(charSequence == null || charSequence.length() == 0)) {
            UiThreadUtils.runOnUiThread(new WealthTurningPointIncentiveManager$$ExternalSyntheticLambda0(scheme, callback));
        } else if (callback != null) {
            callback.invoke(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showIncentiveDialog$lambda-2  reason: not valid java name */
    public static final void m13752showIncentiveDialog$lambda2(String $scheme, Function1 $callback) {
        Object obj;
        WealthTurningPointIncentiveManager wealthTurningPointIncentiveManager = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            InternalWealthTaskManager.INSTANCE.getInternalServiceManager().getWealthTaskSchemaService().invokeWealthVideoTalosPage($scheme, true, WealthTaskTalosConstantsKt.VALUE_WEALTH_TALOS_SOURCE_TURNING_POINT_INCENTIVE, new WealthTurningPointIncentiveManager$showIncentiveDialog$1$1$1($callback));
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8974exceptionOrNullimpl(obj) != null && $callback != null) {
            $callback.invoke(false);
        }
    }

    private final boolean isWealthTaskEnabled(SceneModel $this$isWealthTaskEnabled) {
        if ($this$isWealthTaskEnabled == null) {
            return false;
        }
        return SceneConfigRepo.INSTANCE.isWealthTaskModuleEnableOnCurrentPage($this$isWealthTaskEnabled);
    }

    private final boolean isFirstVideoFromNonVideoTabScene(WealthTaskVideoItemModel itemModel) {
        SceneModel sceneModel = itemModel.getWealthTaskSceneModel();
        if (sceneModel != null && !SceneConfigRepo.INSTANCE.isFlowVideoTabScene(sceneModel) && itemModel.isFirstItem()) {
            return true;
        }
        return false;
    }
}
