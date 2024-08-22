package com.baidu.searchbox.download.center.clearcache.view.guide;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.PhoneAccelerateActivityKt;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.PhoneAccelerateAddWidgetEvent;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.PhoneAccelerateUBCKt;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.widget.IWidgetService;
import com.baidu.searchbox.widget.pin.IWidgetAddCallback;
import com.baidu.searchbox.widget.pin.PinResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/download/center/clearcache/view/guide/PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1", "Lcom/baidu/searchbox/widget/pin/IWidgetAddCallback;", "onFailure", "", "failureResponse", "Lcom/baidu/searchbox/widget/pin/PinResponse;", "onShowing", "showIngResponse", "onSuccess", "successResponse", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneAccelerateWidgetGuideManager.kt */
public final class PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1 implements IWidgetAddCallback {
    final /* synthetic */ String $from;
    final /* synthetic */ Resources $resources;
    final /* synthetic */ ShowGuideScene $scene;
    final /* synthetic */ String $source;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhoneAccelerateWidgetGuideManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShowGuideScene.values().length];
            iArr[ShowGuideScene.PHONE_ACCELERATE_PAGE.ordinal()] = 1;
            iArr[ShowGuideScene.CLEAR_CACHE_PAGE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1(ShowGuideScene $scene2, String $source2, String $from2, Resources $resources2) {
        this.$scene = $scene2;
        this.$source = $source2;
        this.$from = $from2;
        this.$resources = $resources2;
    }

    public void onSuccess(PinResponse successResponse) {
        Intrinsics.checkNotNullParameter(successResponse, "successResponse");
        if (PhoneAccelerateActivityKt.getACCELERATE_DEBUG()) {
            Log.d(PhoneAccelerateActivityKt.ACCELERATE_TAG, "onSuccess perform");
        }
        if (this.$scene == ShowGuideScene.CLEAR_CACHE_PAGE) {
            ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, (String) null, PhoneAccelerateUBCKt.VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET, this.$source, ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, "1", ClearCacheStatistic.INSTANCE.generateCleanedExtUbc$lib_clearcache_business_release(), (String) null, 65, (Object) null);
        } else {
            ClearCacheStatistic clearCacheStatistic = ClearCacheStatistic.INSTANCE;
            String str = this.$from;
            if (str == null) {
                str = "";
            }
            PhoneAccelerateUBCKt.phoneAccelerateUBC$default((String) null, clearCacheStatistic.getUbcFromValue$lib_clearcache_business_release(str), "1", 1, (Object) null);
        }
        UiThreadUtils.runOnUiThread(new PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1$$ExternalSyntheticLambda0());
        UiThreadUtils.runOnUiThread(new PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1$$ExternalSyntheticLambda1(this.$resources), 500);
        if (PhoneAccelerateWidgetGuideManager.INSTANCE.judgePhoneTypeIsHuaweiAndOppoAndHonor()) {
            PhoneAccelerateWidgetGuideManager.INSTANCE.clearWidgetRecordShowInfo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m17353onSuccess$lambda0() {
        BdEventBus.Companion.getDefault().post(new PhoneAccelerateAddWidgetEvent());
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m17354onSuccess$lambda1(Resources $resources2) {
        Intrinsics.checkNotNullParameter($resources2, "$resources");
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) $resources2.getString(R.string.phone_accelerate_widget_add_success)).show();
        PhoneAccelerateWidgetGuideManager.INSTANCE.printLog("添加成功");
    }

    public void onFailure(PinResponse failureResponse) {
        String str;
        Intrinsics.checkNotNullParameter(failureResponse, "failureResponse");
        if (PhoneAccelerateActivityKt.getACCELERATE_DEBUG()) {
            Log.d(PhoneAccelerateActivityKt.ACCELERATE_TAG, "onFailure perform failureCode is " + failureResponse.getStatusCode());
        }
        if (1003 != failureResponse.getStatusCode()) {
            IWidgetService getOrNull = IWidgetService.Companion.getGetOrNull();
            boolean isShowGuideDialog = getOrNull != null ? getOrNull.isWidgetGuideDialogShow() : false;
            switch (WhenMappings.$EnumSwitchMapping$0[this.$scene.ordinal()]) {
                case 1:
                    str = "speed";
                    break;
                case 2:
                    str = "clean";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String guideFrom = str;
            IWidgetService getOrNull2 = IWidgetService.Companion.getGetOrNull();
            JSONObject guideData = getOrNull2 != null ? getOrNull2.getWidgetGuideData() : null;
            if (!isShowGuideDialog || guideData == null) {
                Router.invoke(AppRuntime.getAppContext(), "baiduboxapp://v1/easybrowse/open?url=https://mbd.baidu.com/baiduapp/widget/android");
            } else {
                IWidgetService getOrNull3 = IWidgetService.Companion.getGetOrNull();
                if (getOrNull3 != null) {
                    getOrNull3.showWidgetGuideDialog("speed_clean", guideFrom, guideData);
                }
            }
        }
        if (this.$scene == ShowGuideScene.CLEAR_CACHE_PAGE) {
            ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, (String) null, PhoneAccelerateUBCKt.VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET, this.$source, ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, "0", ClearCacheStatistic.INSTANCE.generateCleanedExtUbc$lib_clearcache_business_release(), (String) null, 65, (Object) null);
        } else {
            ClearCacheStatistic clearCacheStatistic = ClearCacheStatistic.INSTANCE;
            String str2 = this.$from;
            if (str2 == null) {
                str2 = "";
            }
            PhoneAccelerateUBCKt.phoneAccelerateUBC$default((String) null, clearCacheStatistic.getUbcFromValue$lib_clearcache_business_release(str2), "0", 1, (Object) null);
        }
        if (failureResponse.isSystemAdd()) {
            PhoneAccelerateWidgetGuideManager.INSTANCE.printLog("添加失败");
            UiThreadUtils.runOnUiThread(new PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1$$ExternalSyntheticLambda2(this.$resources), 500);
            if (PhoneAccelerateWidgetGuideManager.INSTANCE.judgePhoneTypeIsHuaweiAndOppoAndHonor()) {
                PhoneAccelerateWidgetGuideManager.INSTANCE.recordShowGuideDialogTimeInfo();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-2  reason: not valid java name */
    public static final void m17352onFailure$lambda2(Resources $resources2) {
        Intrinsics.checkNotNullParameter($resources2, "$resources");
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) $resources2.getString(R.string.phone_accelerate_widget_add_failure)).show();
    }

    public void onShowing(PinResponse showIngResponse) {
        Intrinsics.checkNotNullParameter(showIngResponse, "showIngResponse");
        if (this.$scene == ShowGuideScene.CLEAR_CACHE_PAGE) {
            ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, (String) null, PhoneAccelerateUBCKt.VALUE_PHONE_WIDGET_DIALOG_SHOW, this.$source, ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, (String) null, ClearCacheStatistic.INSTANCE.generateCleanedExtUbc$lib_clearcache_business_release(), (String) null, 81, (Object) null);
        } else {
            ClearCacheStatistic clearCacheStatistic = ClearCacheStatistic.INSTANCE;
            String str = this.$from;
            if (str == null) {
                str = "";
            }
            PhoneAccelerateUBCKt.phoneAccelerateUBC$default(PhoneAccelerateUBCKt.VALUE_PHONE_WIDGET_DIALOG_SHOW, clearCacheStatistic.getUbcFromValue$lib_clearcache_business_release(str), (String) null, 4, (Object) null);
        }
        if (PhoneAccelerateWidgetGuideManager.INSTANCE.judgePhoneTypeIsHuaweiAndOppoAndHonor()) {
            PhoneAccelerateWidgetGuideManager.INSTANCE.recordShowGuideDialogTimeInfo();
        }
    }
}
