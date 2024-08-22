package com.baidu.searchbox.smartmenu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.pinchsummary.interfaces.IPinchSummaryService;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/smartmenu/ABTestSmartMenuHelper;", "", "()V", "<set-?>", "", "smartMenuExpValue", "getSmartMenuExpValue", "()I", "hitPinchExperiment", "", "hitSmartMenuExperiment", "isTablet", "context", "Landroid/content/Context;", "lib-smart-menu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ABTestSmartMenuHelper.kt */
public final class ABTestSmartMenuHelper {
    public static final ABTestSmartMenuHelper INSTANCE = new ABTestSmartMenuHelper();
    private static int smartMenuExpValue = AbTestManager.getInstance().getSwitch(ABTestSmartMenuHelperKt.SMART_MENU_EXP_SWITCH_KEY, 0);

    private ABTestSmartMenuHelper() {
    }

    public final int getSmartMenuExpValue() {
        return smartMenuExpValue;
    }

    public final boolean hitPinchExperiment() {
        IPinchSummaryService pinchService = (IPinchSummaryService) ServiceManager.getService(IPinchSummaryService.Companion.getSERVICE_REFERENCE());
        if (pinchService != null) {
            return pinchService.getPinchSummaryGlobalSwitch();
        }
        return false;
    }

    public final boolean hitSmartMenuExperiment() {
        if (AppConfig.isDebug() && QuickPersistConfig.getInstance().getBoolean("debug_key_smart_menu_enable", false)) {
            return true;
        }
        int i2 = smartMenuExpValue;
        if ((i2 == 2 || i2 == 3) && !DeviceUtils.isTabletDevice() && !isTablet(AppRuntime.getAppContext()) && !DeviceUtil.isSupportFoldable()) {
            return true;
        }
        return false;
    }

    private final boolean isTablet(Context context) {
        if (context == null) {
            return false;
        }
        boolean formalCase = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Display display = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics dm = new DisplayMetrics();
            display.getMetrics(dm);
            double inches = Math.sqrt(Math.pow((double) (((float) dm.widthPixels) / dm.xdpi), 2.0d) + Math.pow((double) (((float) dm.heightPixels) / dm.ydpi), 2.0d));
            if (formalCase || inches >= 7.0d) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
