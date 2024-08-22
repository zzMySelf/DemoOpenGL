package com.baidu.browser.interceptor;

import android.os.Build;
import android.util.Log;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.search.switchs.ImgCacheShareSwitchListener;

public class InterceptorUtils {
    private static final String IMG_CACHE_MAX_MEM_KEY = "img_cache_max_mem";
    private static final int MB = 1048576;
    public static final int OFF = 0;
    public static final int OFF2ON = 1;
    public static final int ON = 3;
    public static final int ON2OFF = 2;
    private static boolean hasLoadimageNASwitch = false;
    private static int imageMaxMem = -1;
    private static boolean imageNASwitch = false;
    private static boolean isMemoryEnough = false;
    private static int mCurrentStatus = 0;
    private static final int maxMemDefault = 512;
    private static long memory = 0;

    public static boolean needInterceptorImage() {
        return getImageNASwitch() && matchCondition();
    }

    public static boolean matchCondition() {
        return isSdkVersionEnough() && isMemoryEnough();
    }

    private static boolean isSdkVersionEnough() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isMemoryEnough() {
        if (imageMaxMem == -1) {
            imageMaxMem = AbTestManager.getInstance().getSwitch(IMG_CACHE_MAX_MEM_KEY, 512);
            long maxMemory = Runtime.getRuntime().maxMemory() / 1048576;
            memory = maxMemory;
            isMemoryEnough = maxMemory >= ((long) imageMaxMem);
            log("首次加载图片内存限制，当前限制为：" + imageMaxMem + ", 内存为" + memory);
        }
        log("当前内存限制为：" + imageMaxMem + ", 内存为" + memory);
        return isMemoryEnough;
    }

    public static boolean getImageNASwitch() {
        if (!hasLoadimageNASwitch) {
            imageNASwitch = DefaultSharedPrefsWrapper.getInstance().getBoolean(ImgCacheShareSwitchListener.SEARCH_IMG_CACHE_SHARE_SWITCH_KEY, false);
            hasLoadimageNASwitch = true;
            log("首次加载图片NA拦截开关，当前值为：" + imageNASwitch);
        }
        log("图片NA拦截开关值为：" + imageNASwitch);
        return imageNASwitch;
    }

    public static int getImageInterceptorStatus(String url) {
        if (!needInterceptorImage()) {
            mCurrentStatus = 0;
            return 0;
        }
        boolean isImageTab = isImageTab(url);
        log("当前url是否是六合图片tab" + isImageTab);
        switch (mCurrentStatus) {
            case 0:
            case 2:
                if (!isImageTab) {
                    mCurrentStatus = 0;
                    break;
                } else {
                    mCurrentStatus = 1;
                    break;
                }
            case 1:
            case 3:
                if (!isImageTab) {
                    mCurrentStatus = 2;
                    break;
                } else {
                    mCurrentStatus = 3;
                    break;
                }
        }
        return mCurrentStatus;
    }

    public static int getImageInterceptorStatus() {
        return mCurrentStatus;
    }

    private static boolean isImageTab(String url) {
        return BrowserUrlUtils.isImageTabUrl(url);
    }

    private static void log(String info) {
        if (ImageResourceCache.DEBUG) {
            Log.d(ImageResourceCache.TAG, info);
        }
    }
}
