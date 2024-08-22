package com.baidu.searchbox.download.center.clearcache.view.funison;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.BdListPopupWindow;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.DiskUtilKt;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.AccelerateEvent;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.AccelerateUtils;
import com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AllAutoBackupSwitchView;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheContentCardInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheItemInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.download.utils.CheckPermissionUtilsKt;
import com.baidu.searchbox.download.center.clearcache.view.funison.download.utils.StartActicityUtilsKt;
import com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.DiskScanManager;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheDataHelper;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheManager;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.IClearCacheCallback;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.download.DownloadFileScanner;
import com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicCommandHelper;
import com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicManger;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.ClearScanHomeHeaderView;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.feedback.FeedbackInfoManager;
import com.baidu.searchbox.kmm.clearcache.ubc.ClearCacheUBCKt;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.widget.ImmersionHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0002J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020$H\u0016J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020$H\u0014J\u0012\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u00020$H\u0002J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020$H\u0014J\b\u0010>\u001a\u00020$H\u0014J\b\u0010?\u001a\u00020$H\u0014J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002J\u0010\u0010C\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010D\u001a\u00020$J\b\u0010E\u001a\u00020$H\u0002J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/AbsClearCacheHomeActivity;", "Lcom/baidu/searchbox/appframework/ActionToolBarActivity;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/IClearCacheCallback;", "()V", "mCacheState", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/ClearCacheState;", "mClearCacheManager", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/ClearCacheManager;", "getMClearCacheManager", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/ClearCacheManager;", "mClearCacheManager$delegate", "Lkotlin/Lazy;", "mClearCacheUbcController", "Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;", "getMClearCacheUbcController", "()Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;", "mClearCacheUbcController$delegate", "mHasAudioPermission", "", "mHasFeedBackReportFile", "mHasImageVideoPermission", "mHasUbcDataResult", "mIsShowAutoBackupSwitch", "mMenuPopupWindow", "Lcom/baidu/android/ext/widget/BdListPopupWindow;", "mPendingCleanSizeInfo", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/CachePendingCleanSizeInfo;", "mobileUsedMemory", "", "ubcSource", "", "getUbcSource", "()Ljava/lang/String;", "setUbcSource", "(Ljava/lang/String;)V", "checkScanDataForUbc", "", "generateHomeExtUbc", "Lorg/json/JSONObject;", "generateHomeScanExtUbc", "getBottomBarOption", "Lcom/baidu/searchbox/unifiedtoolbar/option/UnifiedBottomBarOption;", "initLiveData", "needScanImageVideo", "isAutoAddTopBack", "isShieldedNetDiskAbility", "onCacheScannedComplete", "onCacheScannedResult", "cacheId", "cacheSize", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClicked", "anchorView", "Landroid/view/View;", "onMenuFeedbackClicked", "onNightModeChanged", "isNightMode", "onPause", "onRestart", "onResume", "registerAccelerateFinish", "registerCleanedFinish", "resetCacheItemSelectedStatus", "showMenuPopupWindow", "startScanFile", "updateHeaderTotalSize", "updateWhenNightModeChanged", "useImmersion", "Companion", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsClearCacheHomeActivity.kt */
public abstract class AbsClearCacheHomeActivity extends ActionToolBarActivity implements IClearCacheCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FEEDBACK_SOURCE = "35469";
    private static final String SP_KEY_CLEAR_CACHE_HOME_MENU_CLICKED = "sp_bool_clear_cache_main_menu_clicked";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ClearCacheState mCacheState = ClearCacheState.SCANNING;
    private final Lazy mClearCacheManager$delegate = LazyKt.lazy(new AbsClearCacheHomeActivity$mClearCacheManager$2(this));
    private final Lazy mClearCacheUbcController$delegate = LazyKt.lazy(AbsClearCacheHomeActivity$mClearCacheUbcController$2.INSTANCE);
    private boolean mHasAudioPermission;
    private boolean mHasFeedBackReportFile;
    private boolean mHasImageVideoPermission;
    private boolean mHasUbcDataResult;
    private boolean mIsShowAutoBackupSwitch;
    private BdListPopupWindow mMenuPopupWindow;
    private final CachePendingCleanSizeInfo mPendingCleanSizeInfo = new CachePendingCleanSizeInfo();
    private int mobileUsedMemory;
    private String ubcSource = "";

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

    public void onCacheCleaned(String cacheId, long cacheCleanedSize) {
        IClearCacheCallback.DefaultImpls.onCacheCleaned(this, cacheId, cacheCleanedSize);
    }

    public void onCacheCleanedComplete() {
        IClearCacheCallback.DefaultImpls.onCacheCleanedComplete(this);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/AbsClearCacheHomeActivity$Companion;", "", "()V", "FEEDBACK_SOURCE", "", "SP_KEY_CLEAR_CACHE_HOME_MENU_CLICKED", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsClearCacheHomeActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final String getUbcSource() {
        return this.ubcSource;
    }

    /* access modifiers changed from: protected */
    public final void setUbcSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ubcSource = str;
    }

    /* access modifiers changed from: private */
    public final ClearCacheUbcController getMClearCacheUbcController() {
        return (ClearCacheUbcController) this.mClearCacheUbcController$delegate.getValue();
    }

    private final ClearCacheManager getMClearCacheManager() {
        return (ClearCacheManager) this.mClearCacheManager$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [android.view.ViewGroup$LayoutParams] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = com.baidu.android.common.ui.style.R.anim.slide_in_from_right
            int r2 = com.baidu.android.common.ui.style.R.anim.slide_out_to_left
            int r3 = com.baidu.android.common.ui.style.R.anim.slide_in_from_left
            int r4 = com.baidu.android.common.ui.style.R.anim.slide_out_to_right
            r0.setPendingTransition(r1, r2, r3, r4)
            r1 = r0
            com.baidu.searchbox.appframework.ext.IUnifiedBottomBarExt r1 = (com.baidu.searchbox.appframework.ext.IUnifiedBottomBarExt) r1
            r2 = 1
            com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt.setUseUnifiedBottomBar(r1, r2)
            super.onCreate(r18)
            int r1 = com.baidu.searchbox.clearcache.business.R.layout.clear_cache_home_activity
            r0.setContentView((int) r1)
            r1 = r0
            com.baidu.searchbox.appframework.BaseActivity r1 = (com.baidu.searchbox.appframework.BaseActivity) r1
            com.baidu.searchbox.download.center.clearcache.view.funison.ActivitySlidingHelperKt.considerEnableSliding(r1)
            r1 = r0
            com.baidu.searchbox.appframework.ext.IActionBarExt r1 = (com.baidu.searchbox.appframework.ext.IActionBarExt) r1
            com.baidu.searchbox.ui.BdActionBar r1 = com.baidu.searchbox.appframework.ext.ActionBarExtKt.getBdActionBar(r1)
            r3 = 8
            if (r1 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r1.setVisibility(r3)
        L_0x0031:
            r17.useImmersion()
            int r1 = com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r4 = 0
            if (r1 == 0) goto L_0x0044
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            goto L_0x0045
        L_0x0044:
            r1 = r4
        L_0x0045:
            boolean r5 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r5 == 0) goto L_0x004c
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r1
            goto L_0x004d
        L_0x004c:
            r1 = r4
        L_0x004d:
            if (r1 != 0) goto L_0x0050
            goto L_0x0056
        L_0x0050:
            int r5 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.getStatusBarHeight()
            r1.topMargin = r5
        L_0x0056:
            int r5 = com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle
            android.view.View r5 = r0._$_findCachedViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 != 0) goto L_0x0061
            goto L_0x0067
        L_0x0061:
            r6 = r1
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r5.setLayoutParams(r6)
        L_0x0067:
            com.baidu.searchbox.config.DefaultSharedPrefsWrapper r5 = com.baidu.searchbox.config.DefaultSharedPrefsWrapper.getInstance()
            java.lang.String r6 = "sp_bool_clear_cache_main_menu_clicked"
            r7 = 0
            boolean r5 = r5.getBoolean(r6, r7)
            if (r5 == 0) goto L_0x0083
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeMenuBadgeView
            android.view.View r6 = r0._$_findCachedViewById(r6)
            if (r6 != 0) goto L_0x007f
            goto L_0x008f
        L_0x007f:
            r6.setVisibility(r3)
            goto L_0x008f
        L_0x0083:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeMenuBadgeView
            android.view.View r6 = r0._$_findCachedViewById(r6)
            if (r6 != 0) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            r6.setVisibility(r7)
        L_0x008f:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeMenu
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00a1
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda4 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda4
            r8.<init>(r0)
            r6.setOnClickListener(r8)
        L_0x00a1:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeMenuClickArea
            android.view.View r6 = r0._$_findCachedViewById(r6)
            if (r6 == 0) goto L_0x00b1
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda5 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda5
            r8.<init>(r0)
            r6.setOnClickListener(r8)
        L_0x00b1:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheAccelerateButton
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00e3
            r8 = 0
            com.baidu.searchbox.download.center.clearcache.view.accelerate.AccelerateUtils r9 = com.baidu.searchbox.download.center.clearcache.view.accelerate.AccelerateUtils.INSTANCE
            int r9 = r9.getMobileUsedMemory()
            r0.mobileUsedMemory = r9
            android.content.res.Resources r9 = r6.getResources()
            if (r9 == 0) goto L_0x00db
            int r10 = com.baidu.searchbox.clearcache.business.R.string.clear_cache_phone_memory_used
            java.lang.Object[] r11 = new java.lang.Object[r2]
            int r12 = r0.mobileUsedMemory
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r11[r7] = r12
            java.lang.String r9 = r9.getString(r10, r11)
            goto L_0x00dc
        L_0x00db:
            r9 = r4
        L_0x00dc:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r6.setText(r9)
        L_0x00e3:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.accelerateLayout
            android.view.View r6 = r0._$_findCachedViewById(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda6 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda6
            r8.<init>(r0)
            r6.setOnClickListener(r8)
            com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper r6 = com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper.INSTANCE
            boolean r6 = r6.getSwitchStateAutoBackup()
            if (r6 != 0) goto L_0x0104
            boolean r6 = r17.isShieldedNetDiskAbility()
            if (r6 != 0) goto L_0x0104
            r6 = r2
            goto L_0x0105
        L_0x0104:
            r6 = r7
        L_0x0105:
            r0.mIsShowAutoBackupSwitch = r6
            if (r6 == 0) goto L_0x0118
            int r3 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeAutoBackupSwitcherView
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AllAutoBackupSwitchView r3 = (com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AllAutoBackupSwitchView) r3
            if (r3 != 0) goto L_0x0114
            goto L_0x0126
        L_0x0114:
            r3.setVisibility(r7)
            goto L_0x0126
        L_0x0118:
            int r6 = com.baidu.searchbox.clearcache.business.R.id.clearCacheHomeAutoBackupSwitcherView
            android.view.View r6 = r0._$_findCachedViewById(r6)
            com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AllAutoBackupSwitchView r6 = (com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AllAutoBackupSwitchView) r6
            if (r6 != 0) goto L_0x0123
            goto L_0x0126
        L_0x0123:
            r6.setVisibility(r3)
        L_0x0126:
            com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic r3 = com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic.INSTANCE
            java.lang.String r6 = r0.ubcSource
            org.json.JSONObject r8 = r17.generateHomeExtUbc()
            java.lang.String r9 = "clean_juhe"
            r3.doPageShowUbc(r9, r6, r8)
            int r3 = com.baidu.searchbox.clearcache.business.R.id.baiduClearCache
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem r3 = (com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem) r3
            if (r3 == 0) goto L_0x015b
            r6 = 0
            int r8 = com.baidu.searchbox.clearcache.business.R.string.content_clear_cache_baidu_title
            r3.setItemTitle(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.drawable.baidu_cache
            r3.setItemIcon(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.clear_cache_home_item_default_subtitle
            r3.setItemSubTitle(r8)
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda7 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda7
            r8.<init>(r0)
            r3.setOnClickListener(r8)
        L_0x015b:
            int r3 = com.baidu.searchbox.clearcache.business.R.id.pictureClearCache
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem r3 = (com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem) r3
            if (r3 == 0) goto L_0x017f
            r6 = 0
            int r8 = com.baidu.searchbox.clearcache.business.R.drawable.picture_cache
            r3.setItemIcon(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.content_clear_cache_pic_title
            r3.setItemTitle(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.clear_cache_home_item_default_subtitle
            r3.setItemSubTitle(r8)
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda8 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda8
            r8.<init>(r0)
            r3.setOnClickListener(r8)
        L_0x017f:
            int r3 = com.baidu.searchbox.clearcache.business.R.id.videoClearCache
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem r3 = (com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem) r3
            if (r3 == 0) goto L_0x01a3
            r6 = 0
            int r8 = com.baidu.searchbox.clearcache.business.R.drawable.video_cache
            r3.setItemIcon(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.content_clear_cache_video_title
            r3.setItemTitle(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.clear_cache_home_item_default_subtitle
            r3.setItemSubTitle(r8)
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda9 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda9
            r8.<init>(r0)
            r3.setOnClickListener(r8)
        L_0x01a3:
            int r3 = com.baidu.searchbox.clearcache.business.R.id.bigFileClearCache
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem r3 = (com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearCacheHomeItem) r3
            if (r3 == 0) goto L_0x01c7
            r6 = 0
            int r8 = com.baidu.searchbox.clearcache.business.R.drawable.big_file_cache
            r3.setItemIcon(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.content_clear_cache_big_file_title
            r3.setItemTitle(r8)
            int r8 = com.baidu.searchbox.clearcache.business.R.string.clear_cache_home_item_default_subtitle
            r3.setItemSubTitle(r8)
            com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda10 r8 = new com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity$$ExternalSyntheticLambda10
            r8.<init>(r0)
            r3.setOnClickListener(r8)
        L_0x01c7:
            com.baidu.searchbox.download.center.clearcache.view.funison.ClearCacheState r3 = com.baidu.searchbox.download.center.clearcache.view.funison.ClearCacheState.SCANNING
            r0.mCacheState = r3
            r17.updateWhenNightModeChanged()
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.String[] r6 = com.baidu.searchbox.download.center.clearcache.view.funison.download.utils.CheckPermissionUtilsKt.getPermissions(r6)
            boolean r3 = com.baidu.searchbox.permission.DangerousPermissionUtils.isPermissionGroupGranted(r3, r6)
            r0.mHasImageVideoPermission = r3
            if (r3 != 0) goto L_0x01ed
            boolean r3 = com.baidu.searchbox.download.center.clearcache.view.funison.download.utils.CheckPermissionUtilsKt.checkHasTiramisu()
            if (r3 == 0) goto L_0x01f3
            boolean r3 = r0.mHasAudioPermission
            if (r3 == 0) goto L_0x01f3
        L_0x01ed:
            initLiveData$default(r0, r7, r2, r4)
            r17.startScanFile()
        L_0x01f3:
            com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheManager r2 = r17.getMClearCacheManager()
            r2.calculateCacheSize()
            r17.registerAccelerateFinish()
            r17.registerCleanedFinish()
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr r2 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr.INSTANCE
            boolean r2 = r2.isHitTopBackExperiment()
            if (r2 == 0) goto L_0x0258
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton$Companion r8 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton.Companion
            r9 = r0
            android.content.Context r9 = (android.content.Context) r9
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType r10 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType.BACK
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 44
            r16 = 0
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton r2 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton.Companion.createTopBarButton$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            int r3 = com.baidu.searchbox.clearcache.business.R.id.clearCacheRootView
            android.view.View r3 = r0._$_findCachedViewById(r3)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            if (r3 == 0) goto L_0x0250
            r6 = 0
            r8 = r2
            android.view.View r8 = (android.view.View) r8
            r3.addView(r8, r7)
            android.view.ViewGroup$LayoutParams r7 = r2.getLayoutParams()
            boolean r8 = r7 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r8 == 0) goto L_0x0237
            r4 = r7
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
        L_0x0237:
            if (r4 == 0) goto L_0x0250
            r7 = 0
            int r8 = r3.getId()
            r4.startToStart = r8
            int r8 = com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle
            android.view.View r8 = r0._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r8 = r8.getId()
            r4.topToTop = r8
        L_0x0250:
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExtensionsKt.setBackButtonCommonLeftMargin(r2)
            r0.setUnifiedTopBackButton(r2)
            goto L_0x0261
        L_0x0258:
            r2 = r0
            com.baidu.searchbox.appframework.ext.IUnifiedBottomBarExt r2 = (com.baidu.searchbox.appframework.ext.IUnifiedBottomBarExt) r2
            java.lang.String r3 = "huancun_main"
            com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUnifiedBackUbcKt.bottomBarShowStat(r2, r3)
        L_0x0261:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.clearcache.view.funison.AbsClearCacheHomeActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m17199onCreate$lambda0(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onMenuClicked((ImageView) this$0._$_findCachedViewById(R.id.clearCacheHomeMenu));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m17200onCreate$lambda1(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onMenuClicked((ImageView) this$0._$_findCachedViewById(R.id.clearCacheHomeMenu));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m17202onCreate$lambda3(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int mobileUsedMemory2 = AccelerateUtils.INSTANCE.getMobileUsedMemory();
        this$0.mobileUsedMemory = mobileUsedMemory2;
        StartActicityUtilsKt.gotoPhoneAccelerateActivity(this$0, mobileUsedMemory2);
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, "speed", "clean_juhe", (String) null, (JSONObject) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-5$lambda-4  reason: not valid java name */
    public static final void m17203onCreate$lambda5$lambda4(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StartActicityUtilsKt.gotoClearBDCacheActivity(this$0);
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, ClearCacheUbcConstant.UBC_VALUE_SOURCE_BAIDUAPP_CLEAN, "clean_juhe", (String) null, (JSONObject) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7$lambda-6  reason: not valid java name */
    public static final void m17204onCreate$lambda7$lambda6(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StartActicityUtilsKt.gotoClearPicCacheActivity(this$0);
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, "image_clean", "clean_juhe", (String) null, (JSONObject) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-9$lambda-8  reason: not valid java name */
    public static final void m17205onCreate$lambda9$lambda8(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StartActicityUtilsKt.gotoClearVideoCacheActivity(this$0);
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, "video_clean", "clean_juhe", (String) null, (JSONObject) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-11$lambda-10  reason: not valid java name */
    public static final void m17201onCreate$lambda11$lambda10(AbsClearCacheHomeActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StartActicityUtilsKt.startPreviewFileActivity(this$0, 7);
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, ClearCacheUbcConstant.UBC_VALUE_PAGE_FILE_CLEAN, "clean_juhe", (String) null, (JSONObject) null, 12, (Object) null);
    }

    private final void onMenuClicked(View anchorView) {
        if (anchorView != null) {
            showMenuPopupWindow(anchorView);
            View _$_findCachedViewById = _$_findCachedViewById(R.id.clearCacheHomeMenuBadgeView);
            if (_$_findCachedViewById != null) {
                _$_findCachedViewById.setVisibility(8);
            }
            DefaultSharedPrefsWrapper.getInstance().putBoolean(SP_KEY_CLEAR_CACHE_HOME_MENU_CLICKED, true);
        }
    }

    private final void showMenuPopupWindow(View anchorView) {
        BdListPopupWindow bdListPopupWindow;
        BdListPopupWindow bdListPopupWindow2 = this.mMenuPopupWindow;
        boolean z = true;
        if (bdListPopupWindow2 == null || true != bdListPopupWindow2.isShowing()) {
            z = false;
        }
        if (z && (bdListPopupWindow = this.mMenuPopupWindow) != null) {
            bdListPopupWindow.dismiss();
        }
        ArrayList popupWindowDatas = new ArrayList();
        BdListPopupWindow.ListItemData autoUploadSetting = new BdListPopupWindow.ListItemData(R.string.clear_cache_home_menu_backup, R.drawable.clear_cache_menu_icon_backup);
        autoUploadSetting.setItemClickListener(new AbsClearCacheHomeActivity$showMenuPopupWindow$1(this));
        BdListPopupWindow.ListItemData feedbackEntry = new BdListPopupWindow.ListItemData(R.string.clear_cache_home_menu_feedback, R.drawable.clear_cache_menu_icon_feedback);
        feedbackEntry.setItemClickListener(new AbsClearCacheHomeActivity$showMenuPopupWindow$2(this));
        if (!isShieldedNetDiskAbility()) {
            popupWindowDatas.add(autoUploadSetting);
        }
        popupWindowDatas.add(feedbackEntry);
        BdListPopupWindow bdListPopupWindow3 = new BdListPopupWindow(this, popupWindowDatas);
        this.mMenuPopupWindow = bdListPopupWindow3;
        bdListPopupWindow3.showAtAnchorView(anchorView);
    }

    /* access modifiers changed from: private */
    public final void onMenuFeedbackClicked() {
        ClearCacheUBCKt.clearCacheStatisticUBC(this.ubcSource);
        FeedbackInfoManager.startToFeedbackFaqIntent(this, FEEDBACK_SOURCE, (String) null, (String) null, (JSONObject) null);
        if (!this.mHasFeedBackReportFile) {
            this.mHasFeedBackReportFile = true;
            DiskUtilKt.cleanCacheReportBaiduFileForFeedbackDone();
        }
    }

    static /* synthetic */ void initLiveData$default(AbsClearCacheHomeActivity absClearCacheHomeActivity, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = true;
            }
            absClearCacheHomeActivity.initLiveData(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initLiveData");
    }

    private final void initLiveData(boolean needScanImageVideo) {
        if (needScanImageVideo) {
            DiskScanManager.INSTANCE.getAllPicSizeLiveData().observe(this, new AbsClearCacheHomeActivity$$ExternalSyntheticLambda11(this));
            DiskScanManager.INSTANCE.getAllVideoSizeLiveDate().observe(this, new AbsClearCacheHomeActivity$$ExternalSyntheticLambda12(this));
        }
        DiskScanManager.INSTANCE.getBigFileSizeLiveDate().observe(this, new AbsClearCacheHomeActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initLiveData$lambda-14  reason: not valid java name */
    public static final void m17196initLiveData$lambda14(AbsClearCacheHomeActivity this$0, String size) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = size;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ClearCacheHomeItem clearCacheHomeItem = (ClearCacheHomeItem) this$0._$_findCachedViewById(R.id.pictureClearCache);
            if (clearCacheHomeItem != null) {
                Intrinsics.checkNotNullExpressionValue(size, "size");
                clearCacheHomeItem.setSubItemTitle(size);
            }
            if (!this$0.mHasUbcDataResult) {
                this$0.checkScanDataForUbc();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initLiveData$lambda-15  reason: not valid java name */
    public static final void m17197initLiveData$lambda15(AbsClearCacheHomeActivity this$0, String size) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = size;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ClearCacheHomeItem clearCacheHomeItem = (ClearCacheHomeItem) this$0._$_findCachedViewById(R.id.videoClearCache);
            if (clearCacheHomeItem != null) {
                Intrinsics.checkNotNullExpressionValue(size, "size");
                clearCacheHomeItem.setSubItemTitle(size);
            }
            if (!this$0.mHasUbcDataResult) {
                this$0.checkScanDataForUbc();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initLiveData$lambda-16  reason: not valid java name */
    public static final void m17198initLiveData$lambda16(AbsClearCacheHomeActivity this$0, String size) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence charSequence = size;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ClearCacheHomeItem clearCacheHomeItem = (ClearCacheHomeItem) this$0._$_findCachedViewById(R.id.bigFileClearCache);
            if (clearCacheHomeItem != null) {
                Intrinsics.checkNotNullExpressionValue(size, "size");
                clearCacheHomeItem.setSubItemTitle(size);
            }
            if (!this$0.mHasUbcDataResult) {
                this$0.checkScanDataForUbc();
            }
        }
    }

    private final void checkScanDataForUbc() {
        String picSize = DiskScanManager.INSTANCE.getAllPicSize();
        String videoSize = DiskScanManager.INSTANCE.getAllVideoSize();
        String bigFileSize = DiskScanManager.INSTANCE.getBigFileSize();
        CharSequence charSequence = picSize;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = videoSize;
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                CharSequence charSequence3 = bigFileSize;
                if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                    z = true;
                }
                if (!z && this.mCacheState == ClearCacheState.SCANNED) {
                    ClearCacheStatistic.doCacheScanUbc$default(ClearCacheStatistic.INSTANCE, this.ubcSource, (String) null, "clean_juhe", generateHomeScanExtUbc(), 2, (Object) null);
                    this.mHasUbcDataResult = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        updateHeaderTotalSize();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
        if (clearScanHomeHeaderView != null) {
            clearScanHomeHeaderView.onResume();
        }
        updateHeaderTotalSize();
        AllAutoBackupSwitchView allAutoBackupSwitchView = (AllAutoBackupSwitchView) _$_findCachedViewById(R.id.clearCacheHomeAutoBackupSwitcherView);
        if (allAutoBackupSwitchView != null) {
            allAutoBackupSwitchView.updateUIForSwitchState();
        }
        try {
            Result.Companion companion = Result.Companion;
            TextView textView = (TextView) _$_findCachedViewById(R.id.clearCacheAccelerateButton);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "clearCacheAccelerateButton");
                TextView $this$onResume_u24lambda_u2d18_u24lambda_u2d17 = textView;
                this.mobileUsedMemory = AccelerateUtils.INSTANCE.getMobileUsedMemory();
                if (Integer.parseInt($this$onResume_u24lambda_u2d18_u24lambda_u2d17.getText().toString()) > this.mobileUsedMemory) {
                    Resources resources = $this$onResume_u24lambda_u2d18_u24lambda_u2d17.getResources();
                    if (resources != null) {
                        str = resources.getString(R.string.clear_cache_phone_memory_used, new Object[]{String.valueOf(this.mobileUsedMemory)});
                    } else {
                        str = null;
                    }
                    $this$onResume_u24lambda_u2d18_u24lambda_u2d17.setText(str);
                }
            } else {
                textView = null;
            }
            Result.m8971constructorimpl(textView);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!this.mHasImageVideoPermission && DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), CheckPermissionUtilsKt.getPermissions(0))) {
            initLiveData$default(this, false, 1, (Object) null);
            startScanFile();
        } else if (CheckPermissionUtilsKt.checkHasTiramisu() && !this.mHasAudioPermission && DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), CheckPermissionUtilsKt.getPermissions(1))) {
            initLiveData(false);
            startScanFile();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
        if (clearScanHomeHeaderView != null) {
            clearScanHomeHeaderView.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ScanSimilarPicManger.INSTANCE.stopNewScan();
        DiskScanManager.INSTANCE.clearCache();
        ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
        if (clearScanHomeHeaderView != null) {
            clearScanHomeHeaderView.onDestroy();
        }
        BdEventBus.Companion.getDefault().unregister(this);
        resetCacheItemSelectedStatus();
        super.onDestroy();
    }

    public final void startScanFile() {
        DiskScanManager.scanForCacheActivity$default(DiskScanManager.INSTANCE, 0, 1, (Object) null);
        if (ScanSimilarPicCommandHelper.INSTANCE.getSwitchState() && ScanSimilarPicManger.INSTANCE.checkIsSoValid()) {
            try {
                ScanSimilarPicManger.INSTANCE.starScanIfNeed();
            } catch (Throwable e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onCacheScannedResult(String cacheId, long cacheSize) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        if (!ActivityUtils.isDestroyed(this) && ClearCacheState.SCANNING == this.mCacheState) {
            if (!getMClearCacheManager().isDownloadCache(cacheId)) {
                ClearCacheDataHelper.INSTANCE.updateItemCacheSize(cacheId, cacheSize);
            }
            long cacheFilesTotalSize = 0 + DownloadFileScanner.INSTANCE.getAllDownloadFilesSize();
            updateHeaderTotalSize();
        }
    }

    public void onCacheScannedComplete() {
        if (!ActivityUtils.isDestroyed(this) && ClearCacheState.SCANNING == this.mCacheState) {
            this.mCacheState = ClearCacheState.SCANNED;
            this.mPendingCleanSizeInfo.initSelectedInfo(ClearCacheDataHelper.INSTANCE.getSelectedClearCacheCardsInfo());
            ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
            if (clearScanHomeHeaderView != null) {
                clearScanHomeHeaderView.changeStateToScanned();
            }
            updateHeaderTotalSize();
            checkScanDataForUbc();
        }
    }

    private final void updateHeaderTotalSize() {
        this.mPendingCleanSizeInfo.initSelectedInfo(ClearCacheDataHelper.INSTANCE.getSelectedClearCacheCardsInfo());
        boolean isScanning = this.mCacheState == ClearCacheState.SCANNING;
        ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
        if (clearScanHomeHeaderView != null) {
            clearScanHomeHeaderView.updateTotalSize(this.mPendingCleanSizeInfo.isShowTotalSize(), this.mPendingCleanSizeInfo.getSelectedCacheFilesTotalSize(), this.mPendingCleanSizeInfo.getSelectedPrivacyRecordsCountText(), isScanning);
        }
        long cacheFilesTotalSize = ClearCacheDataHelper.INSTANCE.getTotalSizeCacheFiles() + DownloadFileScanner.INSTANCE.getAllDownloadFilesSize();
        ClearCacheHomeItem clearCacheHomeItem = (ClearCacheHomeItem) _$_findCachedViewById(R.id.baiduClearCache);
        if (clearCacheHomeItem != null) {
            clearCacheHomeItem.setSubItemTitle(CacheSizeFormatter.INSTANCE.formatSize(cacheFilesTotalSize));
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        updateWhenNightModeChanged();
    }

    private final void updateWhenNightModeChanged() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.clearCacheTitle);
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(this, com.baidu.android.common.ui.style.R.color.GC1));
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.clearCacheHomeMenu);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this, com.baidu.searchbox.download.center.R.drawable.download_icon_actionbar_more_selector));
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.clearCacheHomeMenuBadgeView);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setBackground(ContextCompat.getDrawable(this, R.drawable.clear_cache_red_point_background));
        }
        ClearScanHomeHeaderView clearScanHomeHeaderView = (ClearScanHomeHeaderView) _$_findCachedViewById(R.id.clearCacheCardContentHeader);
        if (clearScanHomeHeaderView != null) {
            clearScanHomeHeaderView.updateWhenNightModeChanged();
        }
        ClearCacheHomeItem clearCacheHomeItem = (ClearCacheHomeItem) _$_findCachedViewById(R.id.baiduClearCache);
        if (clearCacheHomeItem != null) {
            clearCacheHomeItem.updateNightTheme(ContextCompat.getDrawable(this, R.drawable.baidu_cache));
        }
        ClearCacheHomeItem clearCacheHomeItem2 = (ClearCacheHomeItem) _$_findCachedViewById(R.id.pictureClearCache);
        if (clearCacheHomeItem2 != null) {
            clearCacheHomeItem2.updateNightTheme(ContextCompat.getDrawable(this, R.drawable.picture_cache));
        }
        ClearCacheHomeItem clearCacheHomeItem3 = (ClearCacheHomeItem) _$_findCachedViewById(R.id.videoClearCache);
        if (clearCacheHomeItem3 != null) {
            clearCacheHomeItem3.updateNightTheme(ContextCompat.getDrawable(this, R.drawable.video_cache));
        }
        ClearCacheHomeItem clearCacheHomeItem4 = (ClearCacheHomeItem) _$_findCachedViewById(R.id.bigFileClearCache);
        if (clearCacheHomeItem4 != null) {
            clearCacheHomeItem4.updateNightTheme(ContextCompat.getDrawable(this, R.drawable.big_file_cache));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.accelerateLayout);
        if (constraintLayout != null) {
            constraintLayout.setBackground(getResources().getDrawable(R.drawable.clear_cache_background_corner));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.clearCacheAccelerateTitle);
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.clearCacheAccelerateSubTitle);
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
        }
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.clearCacheAccelerateButton);
        if (textView4 != null) {
            textView4.setTextColor(getResources().getColor(R.color.BC136));
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.clearCacheAccelerateIcon);
        if (imageView2 != null) {
            imageView2.setBackground(ContextCompat.getDrawable(this, R.drawable.phone_accelerate));
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.clearCacheRootView);
        if (constraintLayout2 != null) {
            constraintLayout2.setBackground(ContextCompat.getDrawable(this, R.drawable.clear_cache_home_page_top_background));
        }
        AllAutoBackupSwitchView allAutoBackupSwitchView = (AllAutoBackupSwitchView) _$_findCachedViewById(R.id.clearCacheHomeAutoBackupSwitcherView);
        if (allAutoBackupSwitchView != null) {
            allAutoBackupSwitchView.updateWhenNightModeChanged();
        }
    }

    private final void useImmersion() {
        setEnableImmersion(true);
        if (immersionEnabled()) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.getConfig().setIsShowStatusBar(false);
            this.mImmersionHelper.getConfig().setUseLightStatusBar(true ^ NightModeHelper.isNightMode());
            this.mImmersionHelper.setImmersion();
            setImmersionHelper(this.mImmersionHelper);
        }
    }

    private final JSONObject generateHomeExtUbc() {
        try {
            JSONObject extJson = new JSONObject();
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_SIZE_SPEED, String.valueOf(AccelerateUtils.INSTANCE.getMobileUsedMemory()));
            extJson.put("speed", "1");
            if (this.mIsShowAutoBackupSwitch) {
                extJson.put("back_up", "1");
                return extJson;
            }
            extJson.put("back_up", "0");
            return extJson;
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
            JSONObject jSONObject = null;
            return null;
        }
    }

    private final JSONObject generateHomeScanExtUbc() {
        try {
            JSONObject extJson = generateHomeExtUbc();
            if (extJson == null) {
                return null;
            }
            String cleanCacheConfidence = CacheSizeFormatter.INSTANCE.formatSize(ClearCacheDataHelper.INSTANCE.getTotalSizeCacheFiles() + DownloadFileScanner.INSTANCE.getAllDownloadFilesSize());
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_SIZE_SCAN, CacheSizeFormatter.INSTANCE.formatSize(this.mPendingCleanSizeInfo.getSelectedCacheFilesTotalSize()));
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_BAIDUAPP_SIZE_SCAN, cleanCacheConfidence);
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_IMAGE_SIZE_SCAN, DiskScanManager.INSTANCE.getAllPicSize());
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_VIDEO_SIZE_SCAN, DiskScanManager.INSTANCE.getAllVideoSize());
            extJson.put(ClearCacheUbcConstant.UBC_VALUE_EXT_FILE_SIZE_SCAN, DiskScanManager.INSTANCE.getBigFileSize());
            return extJson;
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
            JSONObject jSONObject = null;
            return null;
        }
    }

    private final void registerCleanedFinish() {
        BdEventBus.Companion.getDefault().register(this, CacheCleanedEvent.class, new AbsClearCacheHomeActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCleanedFinish$lambda-20  reason: not valid java name */
    public static final void m17207registerCleanedFinish$lambda20(AbsClearCacheHomeActivity this$0, CacheCleanedEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        UiThreadUtils.runOnUiThread(new AbsClearCacheHomeActivity$$ExternalSyntheticLambda3(this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCleanedFinish$lambda-20$lambda-19  reason: not valid java name */
    public static final void m17208registerCleanedFinish$lambda20$lambda19(AbsClearCacheHomeActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateHeaderTotalSize();
    }

    private final void registerAccelerateFinish() {
        BdEventBus.Companion.getDefault().register(this, AccelerateEvent.class, new AbsClearCacheHomeActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerAccelerateFinish$lambda-23  reason: not valid java name */
    public static final void m17206registerAccelerateFinish$lambda23(AbsClearCacheHomeActivity this$0, AccelerateEvent it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        TextView $this$registerAccelerateFinish_u24lambda_u2d23_u24lambda_u2d22 = (TextView) this$0._$_findCachedViewById(R.id.clearCacheAccelerateButton);
        if ($this$registerAccelerateFinish_u24lambda_u2d23_u24lambda_u2d22 != null) {
            try {
                Result.Companion companion = Result.Companion;
                this$0.mobileUsedMemory = it.getMobileUsedMemory();
                Resources resources = $this$registerAccelerateFinish_u24lambda_u2d23_u24lambda_u2d22.getResources();
                if (resources != null) {
                    str = resources.getString(R.string.clear_cache_phone_memory_used, new Object[]{String.valueOf(it.getMobileUsedMemory())});
                } else {
                    str = null;
                }
                $this$registerAccelerateFinish_u24lambda_u2d23_u24lambda_u2d22.setText(str);
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    private final void resetCacheItemSelectedStatus() {
        for (ClearCacheContentCardInfo clearCacheContentCardInfo : ClearCacheDataHelper.INSTANCE.getClearCacheItems()) {
            boolean isNeedSelected = ClearCacheContentCardInfo.SubTitleType.TOTAL_SIZE_SELECTED == clearCacheContentCardInfo.getSubTitleType();
            for (ClearCacheItemInfo clearCacheItemInfo : clearCacheContentCardInfo.getItems()) {
                clearCacheItemInfo.setSelected(isNeedSelected);
            }
        }
    }

    private final boolean isShieldedNetDiskAbility() {
        IDownloadCenterFun it = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
        if (it != null) {
            return it.isShieldedNetDiskAbility();
        }
        return false;
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        UnifiedBottomBarOption $this$getBottomBarOption_u24lambda_u2d27 = super.getBottomBarOption();
        $this$getBottomBarOption_u24lambda_u2d27.setHideBackWithTopBackExperiment(true);
        return $this$getBottomBarOption_u24lambda_u2d27;
    }

    public boolean isAutoAddTopBack() {
        return false;
    }
}
