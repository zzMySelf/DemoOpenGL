package com.baidu.searchbox.player.utils;

import android.text.TextUtils;
import com.baidu.searchbox.player.ab.PlayerAbManager;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesExt;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrefetchVideoUtils {
    public static final String PAGE_FEED = "feed";
    public static final String PAGE_MINIVIDEO = "mini_video_landing";
    public static final String PAGE_VIDECHANNEL = "videoChannel";
    private static final String TAG = "PrefetchVideoUtils";
    public static final String TYPE_FILTER_PREFETCH = "2";
    public static final String TYPE_START_PREFETCH = "1";

    public static boolean hasPrefetchVideo(JSONArray prefetchVideo) {
        if (prefetchVideo == null) {
            return false;
        }
        BdCyberInstallUtils.installCyber();
        JSONObject prefetchInfo = BdClarityUtil.getAdjustOptionClarity(prefetchVideo);
        if (prefetchInfo == null) {
            prefetchInfo = prefetchVideo.optJSONObject(0);
        }
        if (prefetchInfo == null) {
            return false;
        }
        String url = prefetchInfo.optString("url");
        int prefetchSize = prefetchInfo.optInt("size");
        int optInt = prefetchInfo.optInt("rank");
        if (prefetchInfo.has("h265Url") && prefetchInfo.has("h265VideoSize")) {
            url = prefetchInfo.optString("h265Url");
            prefetchSize = (int) prefetchInfo.optDouble("h265VideoSize");
        }
        if (prefetchSize <= 0) {
            return false;
        }
        return hasPrefetchVideo(url, (BasicVideoSeries) null);
    }

    public static boolean hasPrefetchVideo(String url, BasicVideoSeries videoSeries) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        if (!PlayerAbManager.isPackageUrlParamsEnable()) {
            if (!BdNetUtils.isNetWifi() && BdNetUtils.isDashengCard()) {
                url = VideoPlayerRuntime.getVideoPlayerContext().getCDNReplaceURL(url);
            }
            url = NetUtils.appendCDNStatParams(url, 0, VideoPlayerParamsUtil.getDeviceScore(), BasicVideoSeriesExt.getVideoScene(videoSeries));
        }
        return DumediaUtils.hasCacheFile(url);
    }
}
