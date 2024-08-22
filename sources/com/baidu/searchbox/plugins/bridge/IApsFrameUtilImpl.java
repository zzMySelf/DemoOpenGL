package com.baidu.searchbox.plugins.bridge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.plugin.api.SharePluginManager;
import com.baidu.searchbox.plugin.bridge.IApsFrameUtilsInterface;
import com.baidu.searchbox.plugins.PluginShareActivity;
import com.baidu.searchbox.plugins.utils.PluginCacheUtils;

public class IApsFrameUtilImpl implements IApsFrameUtilsInterface {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "LightAppPluginManager";

    public String getStoragePath(String packageName, boolean external) {
        return PluginCacheUtils.getStoragePath(packageName, external);
    }

    public boolean checkPluginAndAppId(String appId, String pluginSrc) {
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        TextUtils.isEmpty(pluginSrc);
        return false;
    }

    public void shareSyncForPlugin(Context context, String title, String content, String url, Bitmap capture, String imageUrl, String iconUrl, boolean isLinkShare, boolean withCloseLoop, String appId, boolean needBaiduParams, int browserType, SharePluginManager.PluginShareResultListener listener) {
        Bitmap bitmap = capture;
        SharePluginManager.PluginShareResultListener pluginShareResultListener = listener;
        Intent intent = new Intent(AppRuntime.getAppContext(), PluginShareActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        intent.putExtra("url", url);
        intent.putExtra("image_url", imageUrl);
        intent.putExtra("icon_url", iconUrl);
        intent.putExtra(PluginShareActivity.EXTRA_IS_LINK_SHARE, isLinkShare);
        intent.putExtra(PluginShareActivity.EXTRA_WITH_CLOSE_LOOP, withCloseLoop);
        intent.putExtra("appid", appId);
        intent.putExtra("need_baidu_params", needBaiduParams);
        intent.putExtra(PluginShareActivity.EXTRA_BROWSER_TYPE, browserType);
        if (bitmap != null) {
            String bitmapTag = String.valueOf(System.currentTimeMillis());
            PluginShareActivity.addBitmapToCache(bitmapTag, bitmap);
            intent.putExtra(PluginShareActivity.EXTRA_BITMAP_TAG, bitmapTag);
        }
        if (pluginShareResultListener != null) {
            String listenerTag = String.valueOf(System.currentTimeMillis());
            PluginShareActivity.addResultListenerToCache(listenerTag, pluginShareResultListener);
            intent.putExtra(PluginShareActivity.EXTRA_RESULT_LISTENER_TAG, listenerTag);
        }
        ActivityUtils.startActivitySafely(context, intent);
    }
}
