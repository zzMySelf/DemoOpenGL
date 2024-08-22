package com.baidu.swan.apps.swancore;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.swancore.preset.PresetSwanCoreControl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutDevSwanCoreHistory {
    private static final String NEW_LINE = "\n";
    private static final String PREF_CORE_VERSION_LIST = "aiapps_core_ver_list_key";
    private static final String PREF_GAME_CORE_VERSION_LIST = "aigames_core_ver_list_key";
    private static final String SWAN_CORE_TIME_KEY = "time";
    private static final String SWAN_CORE_VERSION_KEY = "version";

    private AboutDevSwanCoreHistory() {
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final AboutDevSwanCoreHistory sInstance = new AboutDevSwanCoreHistory();

        private SingletonHolder() {
        }
    }

    public static AboutDevSwanCoreHistory getIns() {
        return SingletonHolder.sInstance;
    }

    public static String getMD5KeyByFrameType(int frameType) {
        if (frameType == 1) {
            return "installed_game_swan_js_md5";
        }
        return "installed_swan_js_md5";
    }

    public void cacheSwanCoreInfo(long swanCoreVersionCode, int frameType) {
        List<SwanCoreHistory> list = getSwanCoreHistorySafely(frameType);
        if (list.size() >= 10) {
            list.remove(0);
        }
        boolean contain = false;
        Iterator<SwanCoreHistory> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                SwanCoreHistory history = it.next();
                if (history != null && history.swanCoreVersionCode == swanCoreVersionCode) {
                    contain = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!contain) {
            list.add(new SwanCoreHistory(Calendar.getInstance().getTimeInMillis(), swanCoreVersionCode));
            Set<String> versionSet = new HashSet<>();
            for (SwanCoreHistory history2 : list) {
                if (history2 != null) {
                    versionSet.add(history2.toJson());
                }
            }
            SwanAppSpHelper.getInstance().putStringSet(getCoreVersionKeyByFrameType(frameType), versionSet);
        }
    }

    private static void sortByTime(List<SwanCoreHistory> versionList) {
        Collections.sort(versionList, new Comparator<SwanCoreHistory>() {
            public int compare(SwanCoreHistory p1, SwanCoreHistory p2) {
                if (p1 == null) {
                    return -1;
                }
                if (p2 == null) {
                    return 1;
                }
                return String.valueOf(p1.curtTime).compareTo(String.valueOf(p2.curtTime));
            }
        });
    }

    public String getSwanCoreHistoryListString(int frameType) {
        StringBuilder sb = new StringBuilder();
        String md5 = SwanAppSpHelper.getInstance().getString(getMD5KeyByFrameType(frameType), "");
        if (!TextUtils.isEmpty(md5)) {
            sb.append("md5: ").append(md5).append("\n").append("\n");
        }
        List<SwanCoreHistory> list = getSwanCoreHistorySafely(frameType);
        boolean addHistory = false;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            SwanCoreHistory history = list.get(i2);
            if (history != null) {
                addHistory = true;
                sb.append(history.toString());
                if (i2 < size - 1) {
                    sb.append("\n");
                }
            }
        }
        if (!addHistory) {
            sb.append(new SwanCoreHistory(System.currentTimeMillis(), PresetSwanCoreControl.getCurPresetVersionCode(frameType)).toString());
        } else {
            SwanCoreVersion current = SwanAppController.getInstance().getCoreVersion();
            SwanCoreHistory history2 = list.get(size - 1);
            if (!(history2 == null || current == null || current.swanCoreVersionCode <= history2.swanCoreVersionCode)) {
                sb.append("\n");
                sb.append(new SwanCoreHistory(System.currentTimeMillis(), current.swanCoreVersionCode).toString());
            }
        }
        return sb.toString();
    }

    private List<SwanCoreHistory> getSwanCoreHistorySafely(int frameType) {
        List<SwanCoreHistory> historyList = new ArrayList<>();
        Set<String> versionList = SwanAppSpHelper.getInstance().getStringSet(getCoreVersionKeyByFrameType(frameType), (Set<String>) null);
        if (versionList == null || versionList.size() == 0) {
            return historyList;
        }
        for (String versionInfo : versionList) {
            SwanCoreHistory history = parseSwanCoreHistory(versionInfo);
            if (history != null) {
                historyList.add(history);
            }
        }
        sortByTime(historyList);
        return historyList;
    }

    private SwanCoreHistory parseSwanCoreHistory(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            return new SwanCoreHistory(jsonObject.optLong("time"), jsonObject.optLong("version"));
        } catch (JSONException e2) {
            if (!SwanAppLibConfig.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static class SwanCoreHistory {
        long curtTime;
        long swanCoreVersionCode;

        SwanCoreHistory(long time, long versionCode) {
            this.curtTime = time;
            this.swanCoreVersionCode = versionCode;
        }

        public String toString() {
            String dateString = null;
            try {
                dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.curtTime));
            } catch (Exception e2) {
                if (SwanAppLibConfig.DEBUG) {
                    e2.printStackTrace();
                }
            }
            return dateString + " ---> " + this.swanCoreVersionCode;
        }

        public String toJson() {
            try {
                JSONObject object = new JSONObject();
                object.put("time", this.curtTime);
                object.put("version", this.swanCoreVersionCode);
                return object.toString();
            } catch (JSONException e2) {
                if (!SwanAppLibConfig.DEBUG) {
                    return null;
                }
                e2.printStackTrace();
                return null;
            }
        }
    }

    private static String getCoreVersionKeyByFrameType(int frameType) {
        if (frameType == 1) {
            return PREF_GAME_CORE_VERSION_LIST;
        }
        return PREF_CORE_VERSION_LIST;
    }
}
