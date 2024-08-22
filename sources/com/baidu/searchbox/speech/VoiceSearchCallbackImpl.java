package com.baidu.searchbox.speech;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.manage.BasePopTask;
import com.baidu.android.ext.manage.MutexPopTaskConstants;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.Browser;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.explore.GroupCardBackgroundKt;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.browser.utils.SessionIdUtilKt;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.statistic.SearchStatisticUtils;
import com.baidu.search.basic.utils.SearchWholeDurationUtil;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.search.core.utils.SearchUrlGenerator;
import com.baidu.search.network.ResponseParser;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.MainContext;
import com.baidu.searchbox.appframework.MainContextHolder;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.feed.tts.commonstreams.StreamsFacade;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.hissug.data.IHistoryInterface;
import com.baidu.searchbox.home.constants.HomePageConstants;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.player.utils.BdNetUtils;
import com.baidu.searchbox.player.utils.VideoPlayerSpUtil;
import com.baidu.searchbox.speech.ioc.VoiceAppRuntime;
import com.baidu.ubc.UBC;
import com.baidu.ubc.bussiness.UBCDurationEntryService;
import com.baidu.voice.pyramid.VoicePanelInterface;
import com.baidu.voice.vscb.ILocationInfoCallBack;
import com.baidu.voice.vscb.IVoiceSearchCallback;
import com.baidu.voice.vscb.LocationInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceSearchCallbackImpl implements IVoiceSearchCallback, NoProGuard {
    private static final boolean DEBUG = BrowserRuntime.GLOBAL_DEBUG;
    private static final String TAG = "VoiceSearchCallbackImpl";
    private static final String TYPE_WAKE = "wake";
    public static final String VOICE_SEARCH_KEY = "voice_search_key";

    public boolean executeDirectSearch(Context context, JSONObject jsonCommand, Bundle bundle) {
        if (VoiceNaDirectHelper.INSTANCE.handleNaDirect(jsonCommand)) {
            return true;
        }
        SpeechHelper.sSpeechSearch = true;
        if (isDirectScheme(context, jsonCommand)) {
            return true;
        }
        SpeechHelper.isVoiceDirectSearch = true;
        SpeechHelper.isShowToast = true;
        SpeechHelper.clearVoiceDirectParams();
        SpeechHelper.parseVoiceDirectSearchParams(jsonCommand);
        if (bundle != null) {
            SpeechHelper.searchCallId = bundle.getString(SpeechHelper.BUNDLE_PARAM_SEARCH_CALL_ID, "");
            SpeechHelper.searchCallType = bundle.getInt(SpeechHelper.BUNDLE_PARAM_SEARCH_CALL_TYPE, 0);
        }
        if (jsonCommand != null && "2".equals(jsonCommand.optString("mode"))) {
            Intent intent = CommandUtils.parseCommand(context, jsonCommand, 1);
            if (BrowserRuntime.getSearch().startTargetView(context, intent) || BrowserRuntime.getSearch().isMainActivity(context)) {
                return true;
            }
            Activity topActivity = BdBoxActivityManager.getRealTopActivity();
            Activity penultimateActivity = BdBoxActivityManager.getPenultimateActivity();
            VoicePanelInterface voicePanelInterface = (VoicePanelInterface) ServiceManager.getService(VoicePanelInterface.SERVICE_REFERENCE);
            if (voicePanelInterface != null && voicePanelInterface.isVoiceShellActivity(topActivity) && (BrowserRuntime.getSearch().startTargetView(penultimateActivity, intent) || BrowserRuntime.getSearch().isMainActivity(penultimateActivity))) {
                return true;
            }
        }
        return CommandUtils.invokeCommand(context.getApplicationContext(), jsonCommand, (JSONArray) null);
    }

    private boolean isDirectScheme(Context context, JSONObject jsonCommand) {
        String mode = jsonCommand.optString("mode");
        if (!TextUtils.isEmpty(mode) && TextUtils.equals("2", mode)) {
            IHistoryInterface historyInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
            if (historyInterface != null) {
                historyInterface.addVoiceSearchHistory(context, jsonCommand);
            }
            return VoiceMessageCenter.invokeScheme(context, jsonCommand.optString("url"), "inside", (Bundle) null);
        } else if (!DEBUG) {
            return false;
        } else {
            Log.d(TAG, "isDirectScheme mode is not url");
            return false;
        }
    }

    public boolean executeWiseSearch(Context context, List<String> list, JSONObject jsonCommand, Bundle bundle) {
        if (context == null || jsonCommand == null) {
            return false;
        }
        recordSearchStartTimeStamp(bundle, "executeWiseSearch");
        SpeechHelper.sSpeechSearch = true;
        Intent intent = CommandUtils.parseCommand(context, jsonCommand, 1);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(VOICE_SEARCH_KEY, true);
        if (BrowserRuntime.getSearch().startTargetView(context, intent) || BrowserRuntime.getSearch().isMainActivity(context)) {
            return true;
        }
        Activity topActivity = BdBoxActivityManager.getRealTopActivity();
        Activity penultimateActivity = BdBoxActivityManager.getPenultimateActivity();
        VoicePanelInterface voicePanelInterface = (VoicePanelInterface) ServiceManager.getService(VoicePanelInterface.SERVICE_REFERENCE);
        if (voicePanelInterface != null && voicePanelInterface.isVoiceShellActivity(topActivity) && (BrowserRuntime.getSearch().startTargetView(penultimateActivity, intent) || BrowserRuntime.getSearch().isMainActivity(penultimateActivity))) {
            return true;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    public void createShortcut(Context context) {
        VoiceAppRuntime.getVoiceAppImpl().createVoiceShortcut(context);
    }

    public void addUserEventLog(Context context, String key, List<String> values) {
        if (!TextUtils.isEmpty(key) && values != null && values.size() > 0) {
            JSONObject contents = new JSONObject();
            for (String item : values) {
                if (!TextUtils.isEmpty(item) && item.contains("=")) {
                    String[] array = item.split("=");
                    if (array.length == 2) {
                        try {
                            contents.put(array[0].trim(), array[1].trim());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            UBC.onEvent(key, contents);
        }
    }

    public void addUserEventLog(Context context, String key, JSONObject jsonObject) {
        if (!TextUtils.isEmpty(key) && jsonObject != null) {
            UBC.onEvent(key, jsonObject);
        }
    }

    public int getSkinId(Context context) {
        return NgWebViewUtils.isNightMode(context) ? 1 : 0;
    }

    public void requestLocationInfo(String type, ILocationInfoCallBack iLocationInfoCallBack) {
        if (iLocationInfoCallBack != null) {
            iLocationInfoCallBack.updateLocationInfo(getLocationInfo(((BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE)).getLocationInfo()));
        } else if (DEBUG) {
            throw new IllegalArgumentException("ILocationInfoCallBack can't be null ");
        }
    }

    private LocationInfo getLocationInfo(com.baidu.searchbox.location.LocationInfo locationInfo) {
        if (locationInfo == null) {
            return null;
        }
        LocationInfo voiceLocation = new LocationInfo();
        voiceLocation.time = locationInfo.time;
        voiceLocation.longitude = locationInfo.longitude;
        voiceLocation.latitude = locationInfo.latitude;
        voiceLocation.radius = locationInfo.radius;
        voiceLocation.addressStr = locationInfo.addressStr;
        voiceLocation.province = locationInfo.province;
        voiceLocation.city = locationInfo.city;
        voiceLocation.street = locationInfo.street;
        voiceLocation.streetNo = locationInfo.streetNo;
        voiceLocation.district = locationInfo.district;
        voiceLocation.cityCode = locationInfo.cityCode;
        voiceLocation.coorType = locationInfo.coorType;
        voiceLocation.country = locationInfo.country;
        voiceLocation.countryCode = locationInfo.countryCode;
        return voiceLocation;
    }

    public String getCommonParams() {
        BeeBdWindow window;
        String voiceFrom = "";
        String referer = "";
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        Activity penultimateActivity = BdBoxActivityManager.getPenultimateActivity();
        VoicePanelInterface voicePanelInterface = (VoicePanelInterface) ServiceManager.getService(VoicePanelInterface.SERVICE_REFERENCE);
        if (!(voicePanelInterface == null || !voicePanelInterface.isVoiceShellActivity(activity) || penultimateActivity == null)) {
            activity = penultimateActivity;
        }
        if (activity != null && (activity instanceof MainContextHolder)) {
            MainContext mainContext = ((MainContextHolder) activity).getMainContext();
            if (mainContext != null) {
                voiceFrom = (mainContext.getHomeState() == -1 || mainContext.getHomeState() != 2) ? mainContext.isBrowser() ? "searchResult" : mainContext.isSug() ? "ime" : mainContext.isHome() ? "home" : "other" : "feed";
            }
        } else if (BrowserRuntime.getContext().isLightSearchActivity(activity)) {
            voiceFrom = VoiceAppRuntime.getVoiceAppImpl().isHissug(activity) ? "ime" : "searchResult";
        }
        Browser browser = BrowserRuntime.getSearch().getBrowser(activity);
        if (!(browser == null || browser.getBrowserView() == null || (window = browser.getBrowserView().getCurrentWindow()) == null)) {
            referer = window.getUrl();
        }
        if (TextUtils.isEmpty(voiceFrom)) {
            voiceFrom = "other";
        }
        if (DEBUG) {
            Log.d(TAG, voiceFrom);
            Log.d(TAG, "referer=" + referer);
        }
        return SpeechHelper.getDynamicSpeechParams(VoiceAppRuntime.getAppContext(), voiceFrom, referer, false);
    }

    public boolean mutexVoiceShowToast(String message, int priority) {
        if (TextUtils.isEmpty(message)) {
            return false;
        }
        BasePopTask task = new BasePopTask(UniversalToast.makeText(VoiceAppRuntime.getAppContext(), (CharSequence) message).setDuration(3), "showToast", new Object[0]);
        task.setPriority(BasePopTask.getLowerPriority(priority, MutexPopTaskConstants.sPriority_Voice));
        task.setResumable(MutexPopTaskConstants.isResumable_Voice);
        task.setEnqueue(MutexPopTaskConstants.isEnqueue_Voice);
        task.setEnforce(MutexPopTaskConstants.isEnforce_Voice);
        return task.execute();
    }

    public void executeTwoInOneSearch(final Context context, final JSONObject jsonCommand, final Bundle bundle, long streamId) {
        if (context != null && jsonCommand != null) {
            if (DEBUG) {
                Log.i(TAG, "executeTwoInOneSearch");
            }
            recordSearchStartTimeStamp(bundle, "executeTwoInOneSearch");
            TLVManager.INSTANCE.createTransportBuffer();
            TLVManager.INSTANCE.setCurrentTransportId(Long.valueOf(streamId));
            UiThreadUtils.getMainHandler().post(new Runnable() {
                public void run() {
                    SpeechHelper.sSpeechSearch = true;
                    Intent intent = CommandUtils.parseCommand(context, jsonCommand, 1);
                    Bundle bundle = bundle;
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    intent.putExtra(VoiceSearchCallbackImpl.VOICE_SEARCH_KEY, true);
                    if (!BrowserRuntime.getSearch().startTargetView(context, intent) && !BrowserRuntime.getSearch().isMainActivity(context)) {
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    public void setTransportHeaderForTwoInOne(String header, long streamId) {
        if (DEBUG) {
            Log.i(TAG, "setTransportHeaderForTwoInOne");
        }
        if (TLVManager.INSTANCE.checkCurrentTransportingStreamId(Long.valueOf(streamId))) {
            TLVManager.INSTANCE.setCurrentTransportHeader(header);
        }
    }

    public void writeDataToTLVStreamForTwoInOne(Buffer buffer, long size, long streamId) throws Exception {
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "writeDataToTLVStreamForTwoInOne");
        }
        if (TLVManager.INSTANCE.checkCurrentTransportingStreamId(Long.valueOf(streamId))) {
            TLVManager.INSTANCE.writeDataToTLVStream(buffer, size);
            return;
        }
        if (z) {
            Log.w(TAG, "mCurrentTransportInputStream not create");
        }
        throw new IOException("mCurrentTransportInputStream not create");
    }

    public void setTLVStreamEndForTwoInOne(long streamId) {
        if (DEBUG) {
            Log.i(TAG, "setTLVStreamEndForTwoInOne");
        }
        if (TLVManager.INSTANCE.checkCurrentTransportingStreamId(Long.valueOf(streamId))) {
            TLVManager.INSTANCE.setReachEnd(true);
        }
    }

    public void writeErrorForTwoInOne(String error) {
        if (DEBUG) {
            Log.i(TAG, "writeErrorForTwoInOne error is " + error);
        }
        TLVManager.INSTANCE.writeErrorToUBC(error);
    }

    public String getWebSearchUrl(Context context, String word, String searchSource) {
        try {
            return SearchUrlGenerator.buildWebSearchUrl(context, word, searchSource);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void startVoiceSearchActivity(JSONObject jsonObject) {
        IHomeFun iHomeFun;
        IHomeTabFun homeTabFun;
        VoiceDirectUtils.getInstance().cancelToast();
        SpeechHelper.isShowToast = false;
        if (jsonObject != null && "wake".equals(jsonObject.optString("type")) && (iHomeFun = (IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE)) != null && iHomeFun.isHomeTabShow() && (homeTabFun = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE)) != null) {
            if ("Feed".equals(homeTabFun.getCurrentTabTag())) {
                UBCDurationEntryService.timeSplitStasticsWithSource(HomePageConstants.UBC_DURATION_ENTRY_SEARCH_VOICE, (JSONObject) null);
                return;
            }
            JSONObject extJsonObject = new JSONObject();
            try {
                extJsonObject.put(HomePageConstants.UBC_DURATION_ENTRY_VOICE_EXT_KEY_SEARCH_FROM, HomePageConstants.UBC_DURATION_ENTRY_VOICE_EXT_VALUE_OTHER_TAB);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            UBCDurationEntryService.timeSplitStasticsWithSource(HomePageConstants.UBC_DURATION_ENTRY_SEARCH_OTHER_VOICE, extJsonObject);
        }
    }

    public void finishVoiceSearchActivity(JSONObject jsonObject, boolean isSearchStart) {
        IHomeFun iHomeFun;
        if (!isSearchStart && (iHomeFun = (IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE)) != null) {
            boolean isHome = iHomeFun.isHomeTabShow();
            IHomeTabFun homeTabFun = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
            if (homeTabFun != null && isHome && "Feed".equals(homeTabFun.getCurrentTabTag())) {
                SearchWholeDurationUtil.INSTANCE.setHasRecordFromOtherEntry(false);
            }
        }
    }

    public String getWebViewUA() {
        return NaRequestManager.INSTANCE.getUserAgentString();
    }

    public boolean getCanPlayTTS() {
        JSONObject ttsStatusJson = StreamsFacade.getStreamsStatus(new JSONObject());
        if ((!ttsStatusJson.optString("category").equals("novel") && !ttsStatusJson.optString("category").equals("search") && !ttsStatusJson.optString("category").equals(IFeedTTSContext.CATEGORY_SEARCHLIST) && !ttsStatusJson.optString("category").equals("")) || ttsStatusJson.optString("ttsStatus").equals("idle")) {
            return true;
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "语音获取 小说等业务方正在播报，直接返回");
        return false;
    }

    public ResponseParser getPbResponseParser() {
        return TLVManager.INSTANCE.getNewNaProtoResponseParser();
    }

    public void addSearchNeedHeader(Map<String, String> headers) {
        if (headers != null) {
            headers.put(NaRequestManager.VIDEO_PREPARE_AUTOPLAY, canPlay() ? "1" : "0");
            BrowserUrlUtils.addSearchNeedHeader(headers, GroupCardBackgroundKt.getGroupCardNaWH(BrowserRuntime.getAppContext()), false, false, false, SessionIdUtilKt.getSessionId());
        }
    }

    private boolean canPlay() {
        if (BdNetUtils.isWifiOrDashengCard()) {
            return VideoPlayerSpUtil.isAutoPlayInWifi();
        }
        if (BdNetUtils.isMobileNetwork()) {
            return VideoPlayerSpUtil.isAutoPlayInGPRS();
        }
        return false;
    }

    private void recordSearchStartTimeStamp(Bundle bundle, String fromLog) {
        if (bundle != null) {
            long startTimeStamp = bundle.getLong(VoiceSearchManager.SPRESSUPTIMETAG, 0);
            if (startTimeStamp != 0) {
                SearchStatisticUtils.recordSearchTimeStamp(startTimeStamp, fromLog);
            }
        }
    }

    private String generateJsonString(String key, Object object) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key, object);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject.toString();
    }
}
