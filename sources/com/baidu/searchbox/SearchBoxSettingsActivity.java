package com.baidu.searchbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.settings.ioc.ISettingsApp;
import com.baidu.searchbox.settings.ioc.ISettingsItems;
import com.baidu.searchbox.settings.tips.ISearchBoxSettingsTipsRefreshCallback;
import com.baidu.searchbox.settings.tips.SearchBoxSettingsTipManager;
import com.baidu.searchbox.trafficmode.SaveTrafficSettingsModeUtil;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.util.SettingsUBC;
import com.baidu.searchbox.widget.newpreference.SettingFragment;
import com.baidu.searchbox.widget.newpreference.model.SettingGroupModel;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import com.baidu.searchbox.widget.newpreference.model.tips.SettingTipsInfo;
import com.baidu.searchbox.widget.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u000eH\u0014J\b\u0010%\u001a\u00020\u000eH\u0014J\b\u0010&\u001a\u00020\u000eH\u0014J\b\u0010'\u001a\u00020\u000eH\u0007J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/SearchBoxSettingsActivity;", "Lcom/baidu/searchbox/BaseSettingActivity;", "()V", "lifecycleListener", "com/baidu/searchbox/SearchBoxSettingsActivity$lifecycleListener$1", "Lcom/baidu/searchbox/SearchBoxSettingsActivity$lifecycleListener$1;", "mPageDurationUbc", "Lcom/baidu/searchbox/SettingDurationUbc;", "mSettingDurationUbc", "getMSettingDurationUbc", "()Lcom/baidu/searchbox/SettingDurationUbc;", "mSettingDurationUbc$delegate", "Lkotlin/Lazy;", "activeNetSpeedTest", "", "changeTrafficMode", "context", "Landroid/content/Context;", "resultCode", "", "getActivityTitle", "", "getBottomBarOption", "Lcom/baidu/searchbox/unifiedtoolbar/option/UnifiedBottomBarOption;", "getPreferenceFragment", "Lcom/baidu/searchbox/widget/newpreference/SettingFragment;", "isNeedNetSpeedTest", "", "logout", "data", "Landroid/content/Intent;", "onActivityResult", "requestCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "stableApiStub", "swithcAccount", "Companion", "SearchBoxSettingFragment", "lib-settings_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxSettingsActivity.kt */
public final class SearchBoxSettingsActivity extends BaseSettingActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LAST_TEST_TIME = "last_test_time";
    private static final int PASSWORD_TYPE_CONFIRM_PWD = 8;
    private static final int TEENAGER_PASSWORD_ACTION_DEFAULT = -1;
    private static final String TEENAGER_PASSWORD_TYPE_KEY = "passwordType";
    public static final int TEENAGER_PWD_RESULT_CODE_LOGOUT = 1002;
    public static final int TEENAGER_PWD_RESULT_CODE_SWITCH_ACCOUNT = 1001;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final SearchBoxSettingsActivity$lifecycleListener$1 lifecycleListener = new SearchBoxSettingsActivity$lifecycleListener$1(this);
    private final SettingDurationUbc mPageDurationUbc = new SettingDurationUbc();
    private final Lazy mSettingDurationUbc$delegate = LazyKt.lazy(SearchBoxSettingsActivity$mSettingDurationUbc$2.INSTANCE);

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

    /* access modifiers changed from: private */
    public final SettingDurationUbc getMSettingDurationUbc() {
        return (SettingDurationUbc) this.mSettingDurationUbc$delegate.getValue();
    }

    @StableApi
    public final void stableApiStub() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        super.onCreate(savedInstanceState);
        activeNetSpeedTest();
        if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
            UnifiedTopBarButton unifiedTopBackButton = getUnifiedTopBackButton();
            if (unifiedTopBackButton != null) {
                unifiedTopBackButton.ubcBackButtonShow("base", "shezhi", (Map<String, ? extends Object>) null);
            }
        } else {
            HashMap datas = new HashMap();
            datas.put("from", "base");
            datas.put("page", "shezhi");
            UnifiedBottomBar bottomBar = UnifiedBottomBarExtKt.getBottomBar(this);
            if (bottomBar != null) {
                bottomBar.onElementsShowEventStatistic(BottomBarElementID.ELEMENT_ID_BACK, datas);
            }
        }
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.lifecycleListener);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getMSettingDurationUbc().endDurationFlow(SettingsUBC.PAGE_SETTING_ALL);
        ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.lifecycleListener);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mPageDurationUbc.beginDurationFlow("set");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mPageDurationUbc.endDurationFlow("set");
    }

    public String getActivityTitle() {
        String string = getString(com.baidu.searchbox.settings.R.string.preference);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.preference)");
        return string;
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFloatingBack $this$getBottomBarOption_u24lambda_u2d0 = new BottomBarOptionFloatingBack(false, 1, (DefaultConstructorMarker) null);
        $this$getBottomBarOption_u24lambda_u2d0.setHideBackWithTopBackExperiment(true);
        return $this$getBottomBarOption_u24lambda_u2d0;
    }

    public SettingFragment getPreferenceFragment() {
        return new SearchBoxSettingFragment();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/SearchBoxSettingsActivity$SearchBoxSettingFragment;", "Lcom/baidu/searchbox/widget/newpreference/SettingFragment;", "Lcom/baidu/searchbox/settings/tips/ISearchBoxSettingsTipsRefreshCallback;", "()V", "doSettingItemClickUbc", "", "settingItemId", "", "tipType", "", "getItemList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/widget/newpreference/model/SettingGroupModel;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "settingItemModel", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "onResume", "refreshTipsInfo", "lib-settings_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchBoxSettingsActivity.kt */
    public static final class SearchBoxSettingFragment extends SettingFragment implements ISearchBoxSettingsTipsRefreshCallback {
        public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

        public void _$_clearFindViewByIdCache() {
            this._$_findViewCache.clear();
        }

        public View _$_findCachedViewById(int i2) {
            View findViewById;
            Map<Integer, View> map = this._$_findViewCache;
            View view2 = map.get(Integer.valueOf(i2));
            if (view2 != null) {
                return view2;
            }
            View view3 = getView();
            if (view3 == null || (findViewById = view3.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }

        public /* synthetic */ void onDestroyView() {
            super.onDestroyView();
            _$_clearFindViewByIdCache();
        }

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ISettingsItems.Impl.get().init(getContext());
            SearchBoxSettingsTipManager.INSTANCE.registerTipsRefreshListener(this);
            SearchBoxSettingsTipManager.INSTANCE.refreshOperationTipsInfoAsync();
        }

        public void onResume() {
            SearchBoxSettingsTipManager.INSTANCE.refreshBusinessTipsInfoAsync();
            super.onResume();
        }

        public void onDestroy() {
            super.onDestroy();
            ISettingsApp.Impl.get().clearPreferenceUbcRecord();
            SearchBoxSettingsTipManager.INSTANCE.releaseData();
        }

        public ArrayList<SettingGroupModel> getItemList() {
            ArrayList<SettingGroupModel> settingsList = ISettingsItems.Impl.get().getSettingsList();
            Intrinsics.checkNotNullExpressionValue(settingsList, "get().settingsList");
            return settingsList;
        }

        public void refreshTipsInfo() {
            FragmentActivity attachedActivity = getActivity();
            if (attachedActivity != null && !ActivityUtils.isDestroyed(attachedActivity)) {
                reload();
            }
        }

        public void onItemClick(SettingItemModel settingItemModel) {
            Intrinsics.checkNotNullParameter(settingItemModel, "settingItemModel");
            super.onItemClick(settingItemModel);
            SettingTipsInfo tipsInfo = settingItemModel.getMTipsInfo();
            doSettingItemClickUbc(settingItemModel.getItemId(), tipsInfo != null ? tipsInfo.getStyle() : 0);
            if (tipsInfo != null) {
                SearchBoxSettingsTipManager.INSTANCE.handleTipsClicked(tipsInfo);
            }
        }

        private final void doSettingItemClickUbc(String settingItemId, int tipType) {
            if (!StringsKt.isBlank(settingItemId) && !Intrinsics.areEqual((Object) "teenager", (Object) settingItemId) && !Intrinsics.areEqual((Object) "edit_data", (Object) settingItemId)) {
                SettingsUBC.ubcSettingItemClick(String.valueOf(tipType), settingItemId);
            }
        }
    }

    private final void activeNetSpeedTest() {
        if (ISettingsApp.Impl.get().isNetworkConnected(this) && isNeedNetSpeedTest()) {
            ExecutorUtilsExt.postOnElastic(new SearchBoxSettingsActivity$$ExternalSyntheticLambda0(this), "NetSpeedTest", 2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: activeNetSpeedTest$lambda-1  reason: not valid java name */
    public static final void m14335activeNetSpeedTest$lambda1(SearchBoxSettingsActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISettingsApp.Impl.get().netSpeedTest(this$0);
    }

    private final boolean isNeedNetSpeedTest() {
        if (!ISettingsApp.Impl.get().isNeedNetSpeedTest(this)) {
            return false;
        }
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(preference, "getDefaultSharedPreferences(applicationContext)");
        long lastTime = preference.getLong(LAST_TEST_TIME, 0);
        long curTime = System.currentTimeMillis();
        if (curTime - lastTime <= 86400000) {
            return false;
        }
        SharedPreferences.Editor editor = preference.edit();
        editor.putLong(LAST_TEST_TIME, curTime);
        editor.apply();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SaveTrafficSettingsModeUtil.KEY_RESULT_FROM_SAVE_TRAFFIC) {
            changeTrafficMode(this, resultCode);
        } else if (requestCode == 1001) {
            swithcAccount(resultCode, data);
        } else if (requestCode == 1002) {
            logout(resultCode, data);
        }
    }

    private final void changeTrafficMode(Context context, int resultCode) {
        if (resultCode == -1) {
            UniversalToast.makeText(context, (CharSequence) SaveTrafficSettingsModeUtil.getCurrentTrafficToastTitle()).showToast();
        }
    }

    private final void swithcAccount(int resultCode, Intent data) {
        int passwordActionType = -1;
        if (resultCode == -1) {
            if (data != null) {
                passwordActionType = data.getIntExtra("passwordType", -1);
            }
            if (passwordActionType == 8) {
                ISettingsItems.Impl.get().switchAccount();
            }
        }
    }

    private final void logout(int resultCode, Intent data) {
        int passwordActionType = -1;
        if (resultCode == -1) {
            if (data != null) {
                passwordActionType = data.getIntExtra("passwordType", -1);
            }
            if (passwordActionType == 8) {
                ISettingsItems.Impl.get().logout();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/SearchBoxSettingsActivity$Companion;", "", "()V", "LAST_TEST_TIME", "", "PASSWORD_TYPE_CONFIRM_PWD", "", "TEENAGER_PASSWORD_ACTION_DEFAULT", "TEENAGER_PASSWORD_TYPE_KEY", "TEENAGER_PWD_RESULT_CODE_LOGOUT", "TEENAGER_PWD_RESULT_CODE_SWITCH_ACCOUNT", "lib-settings_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchBoxSettingsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
