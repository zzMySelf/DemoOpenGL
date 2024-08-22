package com.baidu.searchbox.player.utils;

import android.text.TextUtils;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.export.IPlayerUiThreadUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import com.baidu.webkit.sdk.WebView;
import java.util.regex.Pattern;

public class VideoPlayerUAManager {
    public static final Pattern BAIDU_CLOUD_URL_PATTERN = Pattern.compile("^(http|https)(://)(pan.baidu.com|yun.baidu.com).*");
    private static final String IQIYI_IDENTIFY = ".iqiyi.com";
    /* access modifiers changed from: private */
    public static String sAndroidDefaultUA;
    private static String sWiseDefaultUA;

    public static String getDefaultUA() {
        BdVideoLog.d("getDefaultUA " + sAndroidDefaultUA);
        return sAndroidDefaultUA;
    }

    public static void initUserAgent() {
        if (sAndroidDefaultUA == null) {
            IPlayerUiThreadUtils.Impl.get().runOnUiThread(new Runnable() {
                public void run() {
                    WebView webView = new WebView(AppRuntime.getAppContext());
                    String unused = VideoPlayerUAManager.sAndroidDefaultUA = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            });
        }
    }

    public static String getWiseDefaultUA() {
        if (sWiseDefaultUA == null) {
            sWiseDefaultUA = BaiduIdentityManager.getInstance().processUserAgent(sAndroidDefaultUA, BrowserType.MAIN);
        }
        return sWiseDefaultUA;
    }

    public String getUserAgent(BdVideo video, String referUrl) {
        String rtnUA = getDefaultUA();
        String url = null;
        if (video != null) {
            url = video.getPlayUrl();
        }
        if (!TextUtils.isEmpty(url) && url.contains(IQIYI_IDENTIFY)) {
            rtnUA = getWiseDefaultUA();
        } else if (TextUtils.isEmpty(url) || !BAIDU_CLOUD_URL_PATTERN.matcher(url).matches()) {
            String host = null;
            try {
                if (!TextUtils.isEmpty(referUrl)) {
                    host = VideoPlayerRuntime.getVideoPlayerContext().getHostAddress(referUrl);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(host) && host.contains(IQIYI_IDENTIFY)) {
                rtnUA = sWiseDefaultUA;
            }
        } else {
            rtnUA = getWiseDefaultUA();
        }
        BdVideoLog.d("getUserAgent rtn: " + rtnUA);
        return rtnUA;
    }
}
