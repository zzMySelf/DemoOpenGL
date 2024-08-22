package com.baidu.searchbox.browserenhanceengine.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.browserenhanceengine.ioc.BeeRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.launch.restore.ioc.LaunchRestoreUBCRuntime;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class BeeRenderMonitor {
    private static final String COLD_RESTORE_KEY = "coldRestore";
    private static final String COLD_RESTORE_VALUE = "1";
    public static final String CONTAINER_HASH_CODE = "hashcode";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String EXT_DEVICE_LEVEL = "device_level";
    private static final String EXT_DEVICE_SCORE = "device_score";
    private static final String EXT_NA_SIDS = "nasids";
    private static final String EXT_WISE_SIDS = "sids";
    private static final String FIRST_PREFIX = "first";
    public static final String PARAMS_INVOKE_START = "params_invoke_start";
    private static final String TAG = "BeeRenderMonitor";
    public static final String UBC_ERROR_INFO = "errorInfo";
    private static final String UBC_EXT = "ext";
    public static final String UBC_FIRST_DISPATCH_DRAW_END = "firstDispatchDrawEnd";
    public static final String UBC_FIRST_DISPATCH_DRAW_START = "firstDispatchDrawStart";
    public static final String UBC_FIRST_LAYOUT_END = "firstLayoutEnd";
    public static final String UBC_FIRST_LAYOUT_START = "firstLayoutStart";
    public static final String UBC_FIRST_MEASURE_END = "firstMeasureEnd";
    public static final String UBC_FIRST_MEASURE_START = "firstMeasureStart";
    private static final String UBC_FROM = "from";
    private static final String UBC_FROM_VALUE = "search";
    private static final String UBC_ID = "1013";
    public static final String UBC_INVOKE_CONTEXT = "invokeContext";
    public static final String UBC_INVOKE_STATUS = "invokeStatus";
    public static final String UBC_NETWORK_ANOMALY = "2";
    public static final String UBC_ON_ATTACHED_TO_WINDOW = "onAttachedToWindow";
    public static final String UBC_ON_CREATE = "onCreate";
    public static final String UBC_ON_DISPATCH = "onDispatch";
    public static final String UBC_ON_FADE_ANIM_END = "fadeAnimEnd";
    public static final String UBC_ON_FADE_ANIM_START = "fadeAnimStart";
    public static final String UBC_ON_IMAGE_LOAD_END = "imageLoadEnd";
    public static final String UBC_ON_PAGE_SHOW = "onPageShow";
    public static final String UBC_ON_ZOOM_ANIM_END = "zoomAnimEnd";
    public static final String UBC_ON_ZOOM_ANIM_START = "zoomAnimStart";
    private static final String UBC_PAGE = "page";
    public static final String UBC_PAGE_BIG_IMAGE = "bigimage";
    public static final String UBC_PAGE_BIG_IMAGE_DOWNLOAD = "bigImageDownload";
    public static final String UBC_PAGE_FROM_TYPE = "pageFromType";
    public static final String UBC_PAGE_LIGHT_BROWSER = "lightbrowser";
    public static final String UBC_PAGE_MUSIC_FULL = "musicfull";
    public static final String UBC_PAGE_NA_BROWSER = "nabrowser";
    public static final String UBC_PAGE_POI_DETAIL = "poidetail";
    public static final String UBC_PAGE_POI_MAP = "poimap";
    public static final String UBC_PAGE_SDM_IMAGE = "sdmimage";
    public static final String UBC_PAGE_SPORT_MATCH_DETAIL = "matchdetail";
    public static final String UBC_PAGE_SPORT_MATCH_LIST = "matchlist";
    public static final String UBC_PAGE_SPORT_PLAYER = "sportplayer";
    public static final String UBC_PAGE_SPORT_TEAM = "sportteam";
    public static final String UBC_PAGE_SPORT_TOURNAMENT = "tournament";
    public static final String UBC_PAGE_S_HYBIRD = "shybird";
    public static final String UBC_PAGE_VAD = "vad";
    public static final String UBC_PAGE_VIDEOLANDING = "videoLanding";
    public static final String UBC_PAGE_VOICE_STORY = "voiceStory";
    public static final String UBC_PAGE_WEATHER = "weather";
    public static final String UBC_RESOURCE_EXCEPTION = "3";
    public static final String UBC_STATUS = "status";
    public static final String UBC_STATUS_INVOKE_FAILED = "1001";
    public static final String UBC_STATUS_NORAML = "0";
    public static final String UBC_STATUS_USER_BACK = "1";
    private static final String UBC_TPL_EXT = "tplExt";
    public static final String UBC_TRACE_IDS = "traceIds";
    public static final String UBC_URL = "url";
    private static boolean coldRestoreFlag = false;
    public static String sNaSids = "";
    public static String sWiseSids = "";
    private final HashMap<String, Info> mStatistics;

    private BeeRenderMonitor() {
        this.mStatistics = new HashMap<>();
    }

    public static BeeRenderMonitor getInstance() {
        return BeeRenderMonitorCreator.monitor;
    }

    private static class BeeRenderMonitorCreator {
        /* access modifiers changed from: private */
        public static final BeeRenderMonitor monitor = new BeeRenderMonitor();

        private BeeRenderMonitorCreator() {
        }
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public long getStartTime(String page) {
        Info info;
        if (!TextUtils.isEmpty(page) && (info = this.mStatistics.get(page)) != null) {
            return info.startTime;
        }
        return -1;
    }

    public void setStartTime(String page, long time) {
        if (!TextUtils.isEmpty(page)) {
            Info info = this.mStatistics.get(page);
            if (info == null) {
                info = new Info();
                info.extMap.put("status", "0");
                this.mStatistics.put(page, info);
            } else {
                info.clearAll();
            }
            info.startTime = time;
        }
    }

    public void setColdRestoreFlag(boolean flag) {
        coldRestoreFlag = flag;
    }

    public void updateStatistic(String page, String action) {
        long time = getTime();
        if (coldRestoreFlag && TextUtils.equals(action, "onPageShow")) {
            LaunchRestoreUBCRuntime.INSTANCE.getLaunchRestoreUBC().onPageShow(22);
        }
        if (!TextUtils.isEmpty(page) && !TextUtils.isEmpty(action)) {
            Info info = this.mStatistics.get(page);
            if (info == null && TextUtils.equals(action, "onDispatch")) {
                setStartTime(page, time);
                info = this.mStatistics.get(page);
            }
            if (info != null && info.extMap != null) {
                if (info.startTime == -1) {
                    if (TextUtils.equals(action, "onDispatch")) {
                        info.startTime = time;
                    } else if (DEBUG) {
                        Log.i(TAG, "updateStatistic failed, without start time");
                        return;
                    } else {
                        return;
                    }
                }
                if (!action.startsWith("first") || !info.extMap.containsKey(action)) {
                    info.extMap.put(action, (time - info.startTime) + "");
                    if (DEBUG) {
                        Log.i(TAG, "updateStatistic " + page + " " + action + time);
                    }
                }
            } else if (DEBUG) {
                Log.i(TAG, "updateStatistic failed, info or extMap is null");
            }
        } else if (DEBUG) {
            Log.i(TAG, "updateStatistic failed, page or action is fault");
        }
    }

    public void updateStatistic(String page, String key, String value) {
        if (coldRestoreFlag && TextUtils.equals(key, "onPageShow")) {
            LaunchRestoreUBCRuntime.INSTANCE.getLaunchRestoreUBC().onPageShow(22);
        }
        if (!TextUtils.isEmpty(page) && !TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            Info info = this.mStatistics.get(page);
            if (info != null && info.extMap != null) {
                info.extMap.put(key, value);
                if (DEBUG) {
                    Log.i(TAG, "updateStatistic " + page + " " + key);
                }
            } else if (DEBUG) {
                Log.i(TAG, "updateStatistic failed, info or extMap is null");
            }
        } else if (DEBUG) {
            Log.i(TAG, "updateStatistic failed, page or key or value is fault");
        }
    }

    public String getStatistic(String page, String key) {
        Info info;
        if (TextUtils.isEmpty(page) || TextUtils.isEmpty(key) || (info = this.mStatistics.get(page)) == null || info.extMap == null || !info.extMap.containsKey(key)) {
            return "";
        }
        return info.extMap.get(key);
    }

    public void changeStatus(String page, String status) {
        updateStatistic(page, "status", status);
    }

    public void uploadStatistic(String page, String hashCode) {
        if (!TextUtils.isEmpty(page) && hashCode != null) {
            Info info = this.mStatistics.get(page);
            if (info == null || info.extMap == null) {
                if (DEBUG) {
                    Log.i(TAG, "uploadStatistic failed, info or extMap is null");
                }
            } else if (info.extMap.containsKey(CONTAINER_HASH_CODE) && info.extMap.get(CONTAINER_HASH_CODE).equals(hashCode)) {
                uploadStatistic(page);
            }
        } else if (DEBUG) {
            Log.i(TAG, "uploadStatistic failed, page is fault");
        }
    }

    public void uploadStatistic(String page) {
        if (TextUtils.isEmpty(page)) {
            if (DEBUG) {
                Log.i(TAG, "uploadStatistic failed, page is fault");
            }
            coldRestoreFlag = false;
            return;
        }
        Info info = this.mStatistics.get(page);
        if (info == null || info.extMap == null) {
            if (DEBUG) {
                Log.i(TAG, "uploadStatistic failed, info or extMap is null");
            }
            coldRestoreFlag = false;
        } else if (info.startTime == -1) {
            if (DEBUG) {
                Log.i(TAG, "uploadStatistic failed, already upload");
            }
            coldRestoreFlag = false;
        } else {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("page", page);
                jsonObject.put("from", "search");
                JSONObject extObject = new JSONObject();
                for (Map.Entry<String, String> entry : info.extMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("url".equals(key) || "refer".equals(key)) {
                        value = BeeRuntime.getSearchContext().excludeBDUSSParam(value);
                    }
                    if (!CONTAINER_HASH_CODE.equals(key)) {
                        extObject.put(key, value);
                    }
                }
                if (extObject.has("onPageShow")) {
                    if (!TextUtils.equals(info.extMap.get("status"), "0")) {
                        extObject.remove("onPageShow");
                    }
                } else if (TextUtils.equals(info.extMap.get("status"), "0")) {
                    changeStatus(page, "1");
                    if (extObject.has("status")) {
                        extObject.remove("status");
                    }
                    extObject.put("status", "1");
                }
                if (UBCDurationSearchSession.isInSearchSession()) {
                    extObject.put("s_session", UBCDurationSearchSession.getSSession());
                }
                IDeviceScore deviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
                if (deviceScore != null) {
                    extObject.put("device_score", String.valueOf(deviceScore.getFinalScore(AppRuntime.getAppContext())));
                    extObject.put("device_level", deviceScore.getScoreLevel(AppRuntime.getAppContext()));
                }
                if (!TextUtils.isEmpty(sNaSids)) {
                    extObject.put(EXT_NA_SIDS, sNaSids);
                }
                if (!TextUtils.isEmpty(sWiseSids)) {
                    extObject.put("sids", sWiseSids);
                }
                if (coldRestoreFlag) {
                    extObject.put(COLD_RESTORE_KEY, "1");
                }
                jsonObject.put("ext", extObject);
                UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (DEBUG) {
                    Log.i(TAG, "上传UBC打点" + jsonObject);
                }
                ubc.onEvent("1013", jsonObject);
                info.clearAll();
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                coldRestoreFlag = false;
                throw th2;
            }
            coldRestoreFlag = false;
        }
    }

    private static class Info {
        public LinkedHashMap<String, String> extMap;
        public long startTime;

        private Info() {
            this.startTime = -1;
            this.extMap = new LinkedHashMap<>();
        }

        public void clearAll() {
            this.startTime = -1;
            this.extMap.clear();
            this.extMap.put("status", "0");
        }
    }

    public static class InvokeHelper {
        public static final int ERR_CONTAINER_MANAGER_NULL = 2001;
        public static final int ERR_OPEN_CONTAINER_FAIL = 2002;

        public static void statInvokeStatus(String page, UnitedSchemeEntity entity, int statusCode) {
            BeeRenderMonitor monitor = BeeRenderMonitor.getInstance();
            if (statusCode == 0) {
                addTplExt(page, entity);
                monitor.updateStatistic(page, BeeRenderMonitor.UBC_INVOKE_STATUS, String.valueOf(statusCode));
                return;
            }
            if (monitor.getStartTime(page) == -1) {
                monitor.setStartTime(page, BeeRenderMonitor.getTime());
            }
            addTplExt(page, entity);
            addInvokeContext(page, entity);
            monitor.updateStatistic(page, BeeRenderMonitor.UBC_INVOKE_STATUS, String.valueOf(statusCode));
            monitor.changeStatus(page, "1001");
            monitor.uploadStatistic(page);
        }

        private static boolean addTplExt(String page, UnitedSchemeEntity entity) {
            BeeRenderMonitor monitor = BeeRenderMonitor.getInstance();
            JSONObject params = UnitedSchemeUtility.optParamsAsJo(entity);
            String tplExt = "";
            if (params != null) {
                tplExt = params.optString("_tplExt", "");
                monitor.updateStatistic(page, BeeRenderMonitor.UBC_TPL_EXT, tplExt);
            }
            return !TextUtils.isEmpty(tplExt);
        }

        private static void addInvokeContext(String page, UnitedSchemeEntity entity) {
            BeeRenderMonitor monitor = BeeRenderMonitor.getInstance();
            JSONObject context = new JSONObject();
            try {
                context.put("refer", entity.getReferUrl());
                context.put("scheme", entity.getUri());
            } catch (Throwable t) {
                if (BeeRenderMonitor.DEBUG) {
                    t.printStackTrace();
                }
            }
            monitor.updateStatistic(page, BeeRenderMonitor.UBC_INVOKE_CONTEXT, context.toString());
        }
    }
}
