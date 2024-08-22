package com.baidu.browser.utils;

import android.content.Context;
import com.baidu.android.ext.manage.BasePopTask;
import com.baidu.android.ext.manage.MutexPopTaskConstants;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.R;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.libsimcard.helper.SimCardHelper;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;

public class SearchFreeFlowUtils {
    private static final int EFFECTIVE_TIMES = 3;
    private static final String FREEFLOW_TOAST_LAST_SHOW_TIME_KEY = "freeflow_toast_last_show_time_key";
    private static final String FREEFLOW_TOAST_SHOW_TIMES_KEY = "simcard_toast_show_times_key";
    private static final String FREE_FLOW_URL = "https://eopa.baidu.com/page/HomePage-YW54iXYf?channel=5";
    private static final String HAS_SHOWN_FREE_LANDING = "has_shown_free_landing";
    private static final int TIME_INTERVAL = 604800000;
    private static final String UBC_SEARCH_FREE_FLOW = "793";
    private static boolean mHasShowFreeLanding = SearchPreferenceUtils.getInstance().getBoolean(HAS_SHOWN_FREE_LANDING, false);
    private static long sLastShowTime = SearchPreferenceUtils.getInstance().getLong(FREEFLOW_TOAST_LAST_SHOW_TIME_KEY, 0);
    /* access modifiers changed from: private */
    public static int sShowTimes = SearchPreferenceUtils.getInstance().getInt(FREEFLOW_TOAST_SHOW_TIMES_KEY, 0);

    public static void showLandingFreeFlowToast(Context context, BeeBdWindow bdWindow) {
        if (context != null && BrowserRuntime.getKernel().isPluginAvailable(BrowserRuntime.getAppContext()) && NetWorkUtils.isMobileNetworkConnected(context) && !SimCardHelper.getInstance().isMobcomFreeCard()) {
            if (!SimCardHelper.getInstance().isFreeFlowCard()) {
                if (checkControl()) {
                    showFreeFlowUnavailableToast(context, bdWindow);
                }
            } else if (!mHasShowFreeLanding && PreferenceUtils.getBoolean(SimCardHelper.PREF_FREE_FLOW_SEARCH, true)) {
                showFreeFlowAvailableToast(context);
            }
        }
    }

    private static boolean checkControl() {
        return sShowTimes < 3 && System.currentTimeMillis() - sLastShowTime > 604800000;
    }

    private static void showFreeFlowAvailableToast(Context context) {
        addMutexTask(UniversalToast.makeText(context, (CharSequence) context.getString(R.string.search_free_flow_on_text)).setDuration(3), "showToast", MutexPopTaskConstants.sPriority_FreeFlowCard);
        mHasShowFreeLanding = true;
        SearchPreferenceUtils.getInstance().putBoolean(HAS_SHOWN_FREE_LANDING, true);
    }

    private static void showFreeFlowUnavailableToast(Context context, final BeeBdWindow bdWindow) {
        addMutexTask(UniversalToast.makeText(context, (CharSequence) context.getString(R.string.search_free_flow_off_text)).setButtonText(context.getString(R.string.search_free_flow_off_btn_text)).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() {
            public void onToastClick() {
                BeeBdWindow beeBdWindow = BeeBdWindow.this;
                if (beeBdWindow != null) {
                    beeBdWindow.loadUrl(SearchFreeFlowUtils.FREE_FLOW_URL);
                    int unused = SearchFreeFlowUtils.sShowTimes = 3;
                    SearchPreferenceUtils.getInstance().putInt(SearchFreeFlowUtils.FREEFLOW_TOAST_SHOW_TIMES_KEY, SearchFreeFlowUtils.sShowTimes);
                    SearchFreeFlowUtils.ubcClick();
                }
            }
        }), "showClickableToast", MutexPopTaskConstants.sPriority_FreeFlowCard);
        sShowTimes++;
        SearchPreferenceUtils.getInstance().putInt(FREEFLOW_TOAST_SHOW_TIMES_KEY, sShowTimes);
        sLastShowTime = System.currentTimeMillis();
        SearchPreferenceUtils.getInstance().putLong(FREEFLOW_TOAST_LAST_SHOW_TIME_KEY, sLastShowTime);
    }

    public static void addMutexTask(PopItem item, String showMethodName, int priority) {
        BasePopTask task = new BasePopTask(item, showMethodName, new Object[0]);
        task.setPriority(priority);
        task.execute();
    }

    /* access modifiers changed from: private */
    public static void ubcClick() {
        HashMap map = new HashMap();
        map.put("from", "search");
        map.put("type", "click");
        map.put("page", "promotion_tips");
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_SEARCH_FREE_FLOW, (Map<String, String>) map);
    }
}
