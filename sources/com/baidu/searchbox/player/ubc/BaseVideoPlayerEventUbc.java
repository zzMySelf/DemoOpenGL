package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.barcode.entry.CodeScannerActivity;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import com.baidu.ubc.UBCManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseVideoPlayerEventUbc {
    protected static final String KEY_TYPE = "type";
    protected static final String KEY_VALUE = "value";
    protected static final String VALUE_CLICK = "click";
    protected static final String VALUE_SHOW = "show";
    static UBCManager ubc = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));

    public static void upPlayerStatics(BDVideoPlayerUbcContent content, String status) {
    }

    public static void firstFrame(BDVideoPlayerUbcContent content) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", "first_frame");
            ubc.onEvent("322", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onError(BDVideoPlayerUbcContent content, int extra, String errorInfo) {
        try {
            JSONObject extLog = content.getExtStatisticsLogClone();
            extLog.putOpt(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_ERROR_NO, Integer.valueOf(extra));
            extLog.putOpt(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_SUB_ERROR, Integer.valueOf(extra));
            extLog.putOpt("errorInfo", errorInfo);
            ubc.onEvent("36", BDVideoPlayerUbcHelper.getUbcContent(extLog, content, (JSONObject) null));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void carlton(BDVideoPlayerUbcContent content, String extra) {
        if (!TextUtils.isEmpty(extra)) {
            try {
                JSONObject extLog = content.getExtStatisticsLogClone();
                JSONObject businessLog = new JSONObject(extra);
                Iterator iterator = businessLog.keys();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    extLog.putOpt(key, businessLog.optString(key));
                }
                ubc.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_CARLTON, BDVideoPlayerUbcHelper.getUbcContent(extLog, content, businessLog));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void addOnlyErrorUEStatisticCache(String errorInfo) {
    }

    public static void netTips(BDVideoPlayerUbcContent content, String type, int toastType) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", type);
            if (TextUtils.equals(type, "toast_show") && toastType != 0) {
                businessLog.putOpt("toastType", Integer.valueOf(toastType));
            }
            ubc.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_NET_TIPS, BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void guideLayerShow(BDVideoPlayerUbcContent content, String type, String page) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", type);
            ubc.onEvent("464", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog, page));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void guideLayerClick(BDVideoPlayerUbcContent content, String type, String page, String guideType) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", type);
            businessLog.putOpt(WidgetDataStatisticUtils.STATISTIC_EXT_GUIDE_TYPE, guideType);
            ubc.onEvent("464", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog, page));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onPosterLoad(BDVideoPlayerUbcContent content, int loadStatus) {
        VideoPlayerRuntime.getVideoPlayerContext().doVideoPosterStatistic(loadStatus, content.getExtStatisticsLog().toString());
    }

    public static void onVolumeComplete() {
    }

    public static void onBrightComplete() {
    }

    public static void onDragSeekBarProgress(BDVideoPlayerUbcContent content, int startPos, int endPos) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", "seek_bar_change");
            businessLog.putOpt("value", endPos - startPos > 0 ? "forward" : "back");
            businessLog.put(CodeScannerActivity.CodeScannerCaller.KEY_FROM_POSITION, startPos);
            businessLog.put("toPosition", endPos);
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onVideoSpeedMenuAction(BDVideoPlayerUbcContent content, String type, boolean isFull, String ext) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", type);
            businessLog.put(PluginInvokerConstants.PLAYER_TYPE, isFull ? "full_screen" : "screen");
            if (!TextUtils.isEmpty(ext)) {
                businessLog.put("value", ext);
            }
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void clarityChange(BDVideoPlayerUbcContent content, String currentClarity, String toClarity, boolean isFull) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", "quality_clk");
            businessLog.putOpt("fromDef", currentClarity);
            businessLog.putOpt("value", toClarity);
            JSONObject extLog = content.getExtStatisticsLogClone();
            extLog.putOpt("fromDef", currentClarity);
            extLog.putOpt("videoMode", isFull ? "full" : "mini");
            extLog.putOpt("highest_res_key", content.getClarityHighestKey());
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(extLog, content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void controlPanelShow(BDVideoPlayerUbcContent content, boolean full) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("videoMode", full ? "full" : "mini");
            ubc.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PANEL_SHOW, BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onBackExit(long startPlayTime) {
    }

    public static void onSwitchLockMode(BDVideoPlayerUbcContent content, boolean isLock) {
        try {
            doVideoFuncStatistic(content, "lock_clk", isLock ? "lock" : "unlock", (String) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onLongPressSeek(BDVideoPlayerUbcContent content, String seekStatus, String screenStatus) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", "ff_rew_clk");
            businessLog.put("value", seekStatus);
            businessLog.put("source", screenStatus);
            ubc.onEvent("464", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onSwitchMuteMode(BDVideoPlayerUbcContent content, boolean isMute) {
        doVideoFuncStatistic(content, "mute_btn_clk", isMute ? "on" : "off", (String) null);
    }

    public static void onMuteIconPopShow(BDVideoPlayerUbcContent content) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", "sound_toast_show");
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onDownloadVideo(BDVideoPlayerUbcContent content, String value) {
        doVideoFuncStatistic(content, "download_clk", value, (String) null);
    }

    public static void onVideoPlay(BDVideoPlayerUbcContent content, boolean isPlaying) {
        doVideoFuncStatistic(content, "play_clk", isPlaying ? "stop" : "play", (String) null);
    }

    public static void onChangedBrightVolumeSeek(BDVideoPlayerUbcContent content, String type) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", type);
            businessLog.put("source", "na");
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onFullShare(BDVideoPlayerUbcContent content) {
        doVideoFuncStatistic(content, "fullscreen_share_clk", (String) null, (String) null);
    }

    public static void onVideoReplay(BDVideoPlayerUbcContent content, boolean isFull) {
        doVideoFuncStatistic(content, "replay_clk", (String) null, isFull ? "full" : "mini");
    }

    public static void onVideoShare(BDVideoPlayerUbcContent content, String value, boolean isFull) {
        doVideoFuncStatistic(content, "share_clk", value, isFull ? "full" : "mini");
    }

    public static void onVideoReload(BDVideoPlayerUbcContent content) {
        doVideoFuncStatistic(content, "reload_clk", (String) null, (String) null);
    }

    public static void onPreviousNextClick(BDVideoPlayerUbcContent content, String value) {
        doVideoFuncStatistic(content, "", value, (String) null);
    }

    public static void switchPlayMode(BDVideoPlayerUbcContent content, boolean isFullMode, int switchType) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("switchReason", Integer.valueOf(switchType));
            businessLog.putOpt("value", isFullMode ? "full" : "mini");
            businessLog.putOpt("type", UBC2736.TYPE.TYPE_FULL_CLK);
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void doVideoFuncStatistic(BDVideoPlayerUbcContent content, String type, String value, String source) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", type);
            if (!TextUtils.isEmpty(value)) {
                businessLog.put("value", value);
            }
            if (!TextUtils.isEmpty(source)) {
                businessLog.put("source", source);
            }
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void downloadToast(String type, String value) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("from", "tool");
            businessLog.put("page", "toast");
            businessLog.put("type", type);
            businessLog.put("value", value);
            ubc.onEvent("615", businessLog);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void clickOneWeek() {
        JSONObject ubcLog = new JSONObject();
        try {
            ubcLog.put("type", "no_tip_aweek");
            ubcLog.put("from", "video");
            String network = NetWorkUtils.getNetworkClass();
            if (TextUtils.equals(network, "no") || TextUtils.equals(network, "unknown")) {
                network = "other";
            }
            ubcLog.put("network", network);
            ubc.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_NET_TIPS, ubcLog);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onAirplay(BDVideoPlayerUbcContent content, String value) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.put("type", "miracast");
            businessLog.put("value", value);
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void kernelSwitchClarity(BDVideoPlayerUbcContent content, String currentClarity, String targetClarity, String status, int errorCode, boolean isFull) {
        try {
            JSONObject businessLog = new JSONObject();
            businessLog.putOpt("type", "kernelSwitchClarity");
            businessLog.putOpt("value", targetClarity);
            JSONObject extLog = content.getExtStatisticsLogClone();
            extLog.put("status", status);
            if (errorCode < 0) {
                extLog.put("errorCode", errorCode);
            }
            extLog.putOpt("fromDef", currentClarity);
            extLog.putOpt("videoMode", isFull ? "full" : "mini");
            extLog.putOpt("highest_res_key", content.getClarityHighestKey());
            ubc.onEvent("465", BDVideoPlayerUbcHelper.getUbcContent(extLog, content, businessLog));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void onPlayerControlFloatingClick(BDVideoPlayerUbcContent content) {
        doVideoFuncStatistic(content, "play_mini_window_clk", (String) null, (String) null);
    }

    public static void clarityUserOptimizeToastShow(BDVideoPlayerUbcContent content) {
        doVideoFuncStatistic(content, "clarity_user_optimize_toast_up", "show", (String) null);
    }

    public static void clarityFullScreenOptimize(BDVideoPlayerUbcContent content, boolean isUp) {
        doVideoFuncStatistic(content, "clarity_full_optimize", isUp ? "up" : "down", (String) null);
    }
}
