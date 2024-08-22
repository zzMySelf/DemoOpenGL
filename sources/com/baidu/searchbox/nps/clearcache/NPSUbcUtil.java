package com.baidu.searchbox.nps.clearcache;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NPSUbcUtil {
    private static final String TAG = "ClearCache-NPSClearUtil";
    public static final String UBC_CUR_TIME = "cur_time";
    public static final String UBC_INSTALLED_LIST = "installed_list";
    public static final String UBC_LAST_TIME = "last_time";
    public static final String UBC_NPS_CLEAR_ID = "6206";
    public static final String UBC_OBSOLETE_LIST = "obsolete_list";
    public static final String UBC_PKG = "pkg";
    public static final String UBC_RET = "ret";
    public static final String UBC_RUNNING = "running";
    public static final String UBC_SIZE = "size";
    public static final String UBC_SOURCE_AUTO = "auto";
    public static final String UBC_SOURCE_MANUAL = "manual";
    public static final String UBC_UNINSTALLABLE = "uninstallable";
    public static final String UBC_UNINSTALLED_LIST = "uninstalled_list";

    public static class InstalledBundle {
        private long curTime;
        private boolean isRunning;
        private boolean isUninstallableInSdk;
        private long lastTime;
        private String pkg;
        private long size;

        public InstalledBundle(String pkg2, long size2, long curTime2, long lastTime2, boolean isRunning2, boolean isUninstallableInSdk2) {
            this.pkg = pkg2;
            this.size = size2;
            this.curTime = curTime2;
            this.lastTime = lastTime2;
            this.isRunning = isRunning2;
            this.isUninstallableInSdk = isUninstallableInSdk2;
        }

        /* access modifiers changed from: private */
        public JSONObject toUbcJson() {
            JSONObject ubcJson = new JSONObject();
            try {
                ubcJson.put("pkg", this.pkg);
                ubcJson.put("size", this.size);
                ubcJson.put("cur_time", this.curTime);
                ubcJson.put("last_time", this.lastTime);
                ubcJson.put("running", this.isRunning);
                ubcJson.put(NPSUbcUtil.UBC_UNINSTALLABLE, this.isUninstallableInSdk);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ubcJson;
        }
    }

    public static class UninstalledBundle {
        private String pkg;
        private boolean ret;
        private long size;

        public UninstalledBundle(String pkg2, long size2, boolean ret2) {
            this.pkg = pkg2;
            this.size = size2;
            this.ret = ret2;
        }

        /* access modifiers changed from: private */
        public JSONObject toUbcJson() {
            JSONObject ubcJson = new JSONObject();
            try {
                ubcJson.put("pkg", this.pkg);
                ubcJson.put("size", this.size);
                ubcJson.put("ret", this.ret);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ubcJson;
        }
    }

    public static class ObsoleteBundle {
        private String pkg;
        private long size;

        public ObsoleteBundle(String pkg2, long size2) {
            this.pkg = pkg2;
            this.size = size2;
        }

        /* access modifiers changed from: private */
        public JSONObject toUbcJson() {
            JSONObject ubcJson = new JSONObject();
            try {
                ubcJson.put("pkg", this.pkg);
                ubcJson.put("size", this.size);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ubcJson;
        }
    }

    public static void npsClearUBC(boolean isAuto, List<InstalledBundle> installedList, List<UninstalledBundle> uninstalledList, List<ObsoleteBundle> obsoleteList) {
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        try {
            JSONObject event = new JSONObject();
            if (isAuto) {
                event.put("source", "auto");
            } else {
                event.put("source", "manual");
            }
            JSONObject ext = new JSONObject();
            event.put("ext", ext);
            if (installedList != null && installedList.size() > 0) {
                JSONArray installedArray = new JSONArray();
                for (InstalledBundle installedBundle : installedList) {
                    installedArray.put(installedBundle.toUbcJson());
                }
                ext.put(UBC_INSTALLED_LIST, installedArray);
            }
            if (uninstalledList != null && uninstalledList.size() > 0) {
                JSONArray uninstalledArray = new JSONArray();
                for (UninstalledBundle uninstalledBundle : uninstalledList) {
                    uninstalledArray.put(uninstalledBundle.toUbcJson());
                }
                ext.put(UBC_UNINSTALLED_LIST, uninstalledArray);
            }
            if (obsoleteList != null && obsoleteList.size() > 0) {
                JSONArray obsoleteArray = new JSONArray();
                for (ObsoleteBundle obsoleteBundle : obsoleteList) {
                    obsoleteArray.put(obsoleteBundle.toUbcJson());
                }
                ext.put(UBC_OBSOLETE_LIST, obsoleteArray);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "npsClearUBC event : " + event.toString());
            }
            ubcManager.onEvent(UBC_NPS_CLEAR_ID, event);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void npsYYClearUBC(String source, List<UninstalledBundle> uninstalledList) {
        if (uninstalledList != null) {
            try {
                if (uninstalledList.size() > 0) {
                    UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                    JSONObject event = new JSONObject();
                    event.put("source", source);
                    JSONObject ext = new JSONObject();
                    event.put("ext", ext);
                    JSONArray uninstalledArray = new JSONArray();
                    for (UninstalledBundle uninstalledBundle : uninstalledList) {
                        uninstalledArray.put(uninstalledBundle.toUbcJson());
                    }
                    ext.put(UBC_UNINSTALLED_LIST, uninstalledArray);
                    if (AppConfig.isDebug()) {
                        Log.d("YYPluginUninstallCheck", "npsYYClearUBC event : " + event.toString());
                    }
                    ubcManager.onEvent(UBC_NPS_CLEAR_ID, event);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
