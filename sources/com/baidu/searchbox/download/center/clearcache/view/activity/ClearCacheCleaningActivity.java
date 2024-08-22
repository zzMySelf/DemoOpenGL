package com.baidu.searchbox.download.center.clearcache.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.download.center.clearcache.DiskUtilKt;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.searchbox.download.center.clearcache.util.DirToolUtils;
import com.baidu.searchbox.download.center.clearcache.view.funison.ActivitySlidingHelperKt;
import com.baidu.searchbox.download.center.clearcache.view.funison.CachePendingCleanSizeInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.ClearCacheState;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheContentCardInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheItemInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.DiskScanManager;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheDataHelper;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheManager;
import com.baidu.searchbox.download.center.clearcache.view.funison.manager.IClearCacheCallback;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.CleanedHeaderView;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.CleaningView;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.home.ClearMoreCacheContentCard;
import com.baidu.searchbox.download.center.clearcache.view.guide.PhoneAccelerateWidgetGuideManager;
import com.baidu.searchbox.download.center.clearcache.view.guide.ShowGuideScene;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUnifiedBackUbcKt;
import com.baidu.searchbox.download.center.ui.fusion.template.ClearCacheHomeCleanClickedEvent;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.uarm.UARInterface;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonMode;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonStyle;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExtensionsKt;
import com.baidu.searchbox.widget.ImmersionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0017H\u0014J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0014J\b\u0010-\u001a\u00020\u0017H\u0014J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/activity/ClearCacheCleaningActivity;", "Lcom/baidu/searchbox/appframework/ActionToolBarActivity;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/IClearCacheCallback;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$ICleaningViewEventCallback;", "()V", "mClearCacheManager", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/ClearCacheManager;", "getMClearCacheManager", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/ClearCacheManager;", "mClearCacheManager$delegate", "Lkotlin/Lazy;", "mClearCacheUbcController", "Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;", "getMClearCacheUbcController", "()Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;", "mClearCacheUbcController$delegate", "mPendingCleanSizeInfo", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/CachePendingCleanSizeInfo;", "mState", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/ClearCacheState;", "ubcSource", "", "finish", "", "getBottomBarOption", "Lcom/baidu/searchbox/unifiedtoolbar/option/UnifiedBottomBarOption;", "handleIntent", "onCacheCleaned", "cacheId", "cacheCleanedSize", "", "onCacheCleanedComplete", "onCacheScannedComplete", "onCacheScannedResult", "cacheSize", "onCleaningViewDismissActual", "onCleaningViewShowed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNightModeChanged", "isNightMode", "", "onPause", "onResume", "updateCacheReminderInfo", "updateWhenNightModeChanged", "useImmersion", "Companion", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheCleaningActivity.kt */
public final class ClearCacheCleaningActivity extends ActionToolBarActivity implements IClearCacheCallback, CleaningView.ICleaningViewEventCallback {
    public static final String CLEANING_PAGE_SOURCE = "cleaning_page_source";
    public static final String CLEAN_CACHE_PAGE_FROM = "clean_cache";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy mClearCacheManager$delegate = LazyKt.lazy(new ClearCacheCleaningActivity$mClearCacheManager$2(this));
    private final Lazy mClearCacheUbcController$delegate = LazyKt.lazy(ClearCacheCleaningActivity$mClearCacheUbcController$2.INSTANCE);
    private final CachePendingCleanSizeInfo mPendingCleanSizeInfo = new CachePendingCleanSizeInfo();
    private ClearCacheState mState = ClearCacheState.CLEARING;
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/activity/ClearCacheCleaningActivity$Companion;", "", "()V", "CLEANING_PAGE_SOURCE", "", "CLEAN_CACHE_PAGE_FROM", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheCleaningActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final ClearCacheUbcController getMClearCacheUbcController() {
        return (ClearCacheUbcController) this.mClearCacheUbcController$delegate.getValue();
    }

    private final ClearCacheManager getMClearCacheManager() {
        return (ClearCacheManager) this.mClearCacheManager$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        TextView textView;
        setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        setContentView(com.baidu.searchbox.clearcache.business.R.layout.clearing_cache_activity);
        ActivitySlidingHelperKt.considerEnableSliding(this);
        UnifiedBottomBarExtKt.dismissBottomBar(this);
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setVisibility(8);
        }
        useImmersion();
        handleIntent();
        ClearCacheStatistic.INSTANCE.doPageShowUbc(ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, this.ubcSource, ClearCacheStatistic.INSTANCE.generateCleanedExtUbc$lib_clearcache_business_release());
        TextView textView2 = (TextView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle);
        ViewGroup.LayoutParams layoutParams = textView2 != null ? textView2.getLayoutParams() : null;
        ConstraintLayout.LayoutParams titleLayoutParams = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (titleLayoutParams != null) {
            titleLayoutParams.topMargin = DeviceUtils.ScreenInfo.getStatusBarHeight();
        }
        TextView textView3 = (TextView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle);
        if (textView3 != null) {
            textView3.setLayoutParams(titleLayoutParams);
        }
        if (!TextUtils.equals(this.ubcSource, ClearCacheUbcConstant.UBC_VALUE_SOURCE_BAIDUAPP_CLEAN) && (textView = (TextView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle)) != null) {
            textView.setText(getResources().getString(com.baidu.searchbox.clearcache.business.R.string.clear_cache_phone_file_home_title));
        }
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.setEventListener(this);
        }
        CleaningView cleaningView2 = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView2 != null) {
            cleaningView2.transitionEntry();
        }
        updateWhenNightModeChanged();
        this.mPendingCleanSizeInfo.initSelectedInfo(ClearCacheDataHelper.INSTANCE.getSelectedClearCacheCardsInfo());
        updateCacheReminderInfo();
        if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
            UnifiedTopBarButton backBtn = UnifiedTopBarButton.Companion.createTopBarButton$default(UnifiedTopBarButton.Companion, this, UnifiedTopBarButtonType.BACK, (UnifiedTopBarButtonStyle) null, (UnifiedTopBarButtonMode) null, false, (Function0) null, 44, (Object) null);
            ConstraintLayout it = (ConstraintLayout) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheRootView);
            if (it != null) {
                it.addView(backBtn, 0);
                ViewGroup.LayoutParams layoutParams2 = backBtn.getLayoutParams();
                ConstraintLayout.LayoutParams $this$onCreate_u24lambda_u2d1_u24lambda_u2d0 = layoutParams2 instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams2 : null;
                if ($this$onCreate_u24lambda_u2d1_u24lambda_u2d0 != null) {
                    $this$onCreate_u24lambda_u2d1_u24lambda_u2d0.startToStart = it.getId();
                    $this$onCreate_u24lambda_u2d1_u24lambda_u2d0.topToTop = ((TextView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle)).getId();
                }
            }
            UnifiedTopBarExtensionsKt.setBackButtonCommonLeftMargin(backBtn);
            backBtn.ubcBackButtonShow("base", "huancun", MapsKt.mapOf(TuplesKt.to(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, ClearCacheUbcConstant.UBC_EXT_SEC_PAGE_BAIDU_ING)));
        } else {
            ClearCacheUnifiedBackUbcKt.bottomBarShowStat(this, ClearCacheUbcConstant.UBC_EXT_SEC_PAGE_BAIDU_ING);
        }
        UARInterface uarInterface = (UARInterface) ServiceManager.getService(UARInterface.Companion.getReference());
        if (uarInterface != null) {
            uarInterface.clearCache((JSONObject) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.onResume();
        }
        CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
        if (cleanedHeaderView != null) {
            cleanedHeaderView.onResume();
        }
        DiskScanManager.scanForCacheActivity$default(DiskScanManager.INSTANCE, 0, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.onPause();
        }
        CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
        if (cleanedHeaderView != null) {
            cleanedHeaderView.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.onDestroy();
        }
        CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
        if (cleanedHeaderView != null) {
            cleanedHeaderView.onDestroy();
        }
        super.onDestroy();
    }

    public void onCacheScannedResult(String cacheId, long cacheSize) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
    }

    public void onCacheScannedComplete() {
    }

    public void onCacheCleaned(String cacheId, long cacheCleanedSize) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        if (!ActivityUtils.isDestroyed(this)) {
            ClearCacheState clearCacheState = ClearCacheState.CLEARING;
        }
    }

    public void onCacheCleanedComplete() {
        if (!ActivityUtils.isDestroyed(this) && ClearCacheState.CLEARING == this.mState) {
            if (DiskManager.INSTANCE.isNewCleanStrategyEnable()) {
                DiskUtilKt.uploadCleanCacheData("2", (Map<String, Object>) null, ClearCacheCleaningActivity$onCacheCleanedComplete$1.INSTANCE);
            } else {
                DiskUtilKt.uploadCleanCacheData("2");
                DiskUtilKt.cleanCacheReportBaiduFileForCleanDone();
            }
            DirToolUtils.clearTargetDir();
            Collection destination$iv$iv = new ArrayList();
            Iterator it = ClearCacheDataHelper.INSTANCE.getClearCacheItems().iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv$iv = it.next();
                if (ClearCacheContentCardInfo.SubTitleType.TOTAL_COUNT_SELECTED == ((ClearCacheContentCardInfo) element$iv$iv).getSubTitleType()) {
                    z = true;
                }
                if (z) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            for (ClearCacheContentCardInfo clearCacheContentCardInfo : (List) destination$iv$iv) {
                for (ClearCacheItemInfo clearCacheItemInfo : clearCacheContentCardInfo.getItems()) {
                    clearCacheItemInfo.setSelected(false);
                }
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheRootView);
            if (constraintLayout != null) {
                constraintLayout.setBackground(ContextCompat.getDrawable(this, com.baidu.searchbox.clearcache.business.R.drawable.clear_cache_home_page_top_background));
            }
            CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
            if (cleaningView != null) {
                cleaningView.transitionExit();
            }
            ClearMoreCacheContentCard clearMoreCacheContentCard = (ClearMoreCacheContentCard) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCardContainer);
            if (clearMoreCacheContentCard != null) {
                clearMoreCacheContentCard.setUbcPage(ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH);
            }
            ClearMoreCacheContentCard clearMoreCacheContentCard2 = (ClearMoreCacheContentCard) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCardContainer);
            if (clearMoreCacheContentCard2 != null) {
                clearMoreCacheContentCard2.setMoreCacheSource(this.ubcSource);
            }
            ClearMoreCacheContentCard clearMoreCacheContentCard3 = (ClearMoreCacheContentCard) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCardContainer);
            if (clearMoreCacheContentCard3 != null) {
                clearMoreCacheContentCard3.addMoreCacheCard("clean_cache");
            }
            CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
            if (cleanedHeaderView != null) {
                cleanedHeaderView.transitionEntry();
            }
            ClearMoreCacheContentCard clearMoreCacheContentCard4 = (ClearMoreCacheContentCard) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCardContainer);
            if (clearMoreCacheContentCard4 != null) {
                clearMoreCacheContentCard4.transitionEntry();
            }
            if (!TextUtils.equals(this.ubcSource, ClearCacheUbcConstant.UBC_VALUE_SOURCE_BAIDUAPP_CLEAN)) {
                UiThreadUtils.runOnUiThread(new ClearCacheCleaningActivity$$ExternalSyntheticLambda0(this), 2500);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCacheCleanedComplete$lambda-5  reason: not valid java name */
    public static final void m17149onCacheCleanedComplete$lambda5(ClearCacheCleaningActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PhoneAccelerateWidgetGuideManager.INSTANCE.showGuide(this$0, "clean_cache", ShowGuideScene.CLEAR_CACHE_PAGE, this$0.ubcSource);
    }

    private final void updateCacheReminderInfo() {
        String pendingCleanText = this.mPendingCleanSizeInfo.getCachePendingCleanText();
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.setPendingCleanCacheText(pendingCleanText);
        }
        CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
        if (cleanedHeaderView != null) {
            cleanedHeaderView.setCleanCompletedText(pendingCleanText);
        }
    }

    public void onCleaningViewShowed() {
        getMClearCacheManager().doCacheClean();
    }

    public void onCleaningViewDismissActual() {
        UnifiedBottomBarExtKt.showBottomBar(this);
        this.mState = ClearCacheState.CLEARED;
        BdEventBus.Companion.getDefault().post(new ClearCacheHomeCleanClickedEvent());
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        updateWhenNightModeChanged();
    }

    private final void updateWhenNightModeChanged() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheRootView);
        if (constraintLayout != null) {
            constraintLayout.setBackground(ContextCompat.getDrawable(this, com.baidu.searchbox.clearcache.business.R.drawable.clear_cache_home_page_top_background));
        }
        TextView textView = (TextView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheTitle);
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(this, R.color.GC1));
        }
        CleaningView cleaningView = (CleaningView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleaningView);
        if (cleaningView != null) {
            cleaningView.updateWhenNightModeChanged();
        }
        CleanedHeaderView cleanedHeaderView = (CleanedHeaderView) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCleanedHeaderView);
        if (cleanedHeaderView != null) {
            cleanedHeaderView.updateWhenNightModeChanged();
        }
        ClearMoreCacheContentCard clearMoreCacheContentCard = (ClearMoreCacheContentCard) _$_findCachedViewById(com.baidu.searchbox.clearcache.business.R.id.clearCacheCardContainer);
        if (clearMoreCacheContentCard != null) {
            clearMoreCacheContentCard.updateWhenNightModeChanged();
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

    private final void handleIntent() {
        String source;
        Intent intent = getIntent();
        if (intent == null || (source = intent.getStringExtra(CLEANING_PAGE_SOURCE)) == null) {
            source = "";
        }
        this.ubcSource = source;
    }

    public void finish() {
        super.finish();
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, "back", ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, (String) null, (JSONObject) null, 12, (Object) null);
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        UnifiedBottomBarOption $this$getBottomBarOption_u24lambda_u2d6 = super.getBottomBarOption();
        $this$getBottomBarOption_u24lambda_u2d6.setHideBackWithTopBackExperiment(true);
        return $this$getBottomBarOption_u24lambda_u2d6;
    }
}
