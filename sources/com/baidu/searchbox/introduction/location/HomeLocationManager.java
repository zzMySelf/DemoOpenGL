package com.baidu.searchbox.introduction.location;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.manager.LaunchLoginGuideDialogManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.home.tabs.utils.HomeTabUtils;
import com.baidu.searchbox.introduction.updatelistener.HomeLocationListener;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.LocationCacheListener;
import com.baidu.searchbox.location.data.LocationConstants;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/introduction/location/HomeLocationManager;", "", "()V", "HOME_OPEN_LOCATION_SOURCE", "", "HOME_OPEN_TIMES_LOCATION", "HOME_SHOW_DEFAULT_TIMES", "", "HOME_SHOW_DIALOG_TIMES", "HOME_SHOW_ERROR_TIMES", "LOCATION_IS_ALERT_OFF", "LOCATION_IS_ALERT_ON", "TAG", "mIsInit", "", "mTimes", "getCityBlacklist", "", "getCityCodeAndShowDialog", "", "context", "Landroid/content/Context;", "isCityInBlackList", "cityCode", "cityCodeBlacklist", "onDestroy", "showLocationDialog", "showLocationDialogIfNeed", "Landroid/app/Activity;", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLocationManager.kt */
public final class HomeLocationManager {
    private static final String HOME_OPEN_LOCATION_SOURCE = "home_third_times";
    private static final String HOME_OPEN_TIMES_LOCATION = "home_open_times_location";
    private static final int HOME_SHOW_DEFAULT_TIMES = -1;
    private static final int HOME_SHOW_DIALOG_TIMES = 2;
    private static final int HOME_SHOW_ERROR_TIMES = -2;
    public static final HomeLocationManager INSTANCE = new HomeLocationManager();
    private static final String LOCATION_IS_ALERT_OFF = "0";
    private static final String LOCATION_IS_ALERT_ON = "1";
    private static final String TAG = "HomeLocationManager";
    private static volatile boolean mIsInit;
    /* access modifiers changed from: private */
    public static int mTimes = -1;

    private HomeLocationManager() {
    }

    public final void showLocationDialogIfNeed(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (mTimes == -1 && !LaunchLoginGuideDialogManager.hasLoginGuideShown()) {
            if (QuickPersistConfig.getInstance().contains(HOME_OPEN_TIMES_LOCATION)) {
                int i2 = QuickPersistConfig.getInstance().getInt(HOME_OPEN_TIMES_LOCATION, 0);
                mTimes = i2;
                int i3 = i2 + 1;
                mTimes = i3;
                if (2 == i3 && !Intrinsics.areEqual((Object) DefaultSharedPrefsWrapper.getInstance().getString("is_alert", "1"), (Object) "0")) {
                    getCityCodeAndShowDialog(context);
                }
            } else if (HomeTabUtils.isNewInstaller()) {
                mTimes = 1;
                QuickPersistConfig.getInstance().putInt(HOME_OPEN_TIMES_LOCATION, 1);
            } else {
                mTimes = -2;
            }
        }
        synchronized (this) {
            if (!mIsInit) {
                mIsInit = true;
                ExecutorUtilsExt.postOnElastic(new HomeLocationManager$$ExternalSyntheticLambda0(), "LocalInitTask", 1);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLocationDialogIfNeed$lambda-1$lambda-0  reason: not valid java name */
    public static final void m20449showLocationDialogIfNeed$lambda1$lambda0() {
        BoxLocationManager manager = (BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE);
        if (manager != null) {
            manager.getLocationInfoAsync((LocationCacheListener) null, "bd09");
        }
    }

    private final void getCityCodeAndShowDialog(Context context) {
        if (!DangerousPermissionUtils.isPermissionGroupGranted(context, LocationConstants.LOCATION_PERMISSION)) {
            List cityBlacklist = getCityBlacklist();
            if (cityBlacklist != null) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "云控数据合法，发起IP请求");
                }
                BoxLocationManager boxLocationManager = (BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE);
                if (boxLocationManager != null) {
                    boxLocationManager.addOnlyIPLocationListener(new HomeLocationManager$getCityCodeAndShowDialog$1(boxLocationManager, cityBlacklist, context));
                    boxLocationManager.requestLocationUseOnlyIP(false);
                }
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "位置信息已授权，不再请求IP发起弹窗");
        }
    }

    private final List<String> getCityBlacklist() {
        String cityCodeBlacklist = QuickPersistConfig.getInstance().getString(HomeLocationListener.LOCATION_BLACK_LIST, "");
        CharSequence charSequence = cityCodeBlacklist;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            List list = new ArrayList();
            JSONArray jsonArray = new JSONArray(cityCodeBlacklist);
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String it = jsonArray.getString(i2);
                if (it != null) {
                    list.add(it);
                }
            }
            return list;
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            List list2 = null;
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isCityInBlackList(String cityCode, List<String> cityCodeBlacklist) {
        if (cityCodeBlacklist.contains(cityCode)) {
            return true;
        }
        if (!AppConfig.isDebug()) {
            return false;
        }
        Log.d(TAG, "当前城市未被列入弹窗黑名单");
        return false;
    }

    /* access modifiers changed from: private */
    public final void showLocationDialog(Context context) {
        PopupExclusionManagerMap.getInstance().display("scene_home", new HomeLocationManager$showLocationDialog$1(context, ExclusionType.HOME_LOCATION_PERMISSION));
    }

    public final void onDestroy() {
        if (BdBoxActivityManager.getTopActivity() == null) {
            mTimes = -1;
        }
    }
}
