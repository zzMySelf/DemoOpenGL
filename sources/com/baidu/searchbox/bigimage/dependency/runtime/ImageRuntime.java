package com.baidu.searchbox.bigimage.dependency.runtime;

import android.app.Application;
import android.content.Context;
import com.baidu.searchbox.bigimage.dependency.interfaces.IImageContext;
import com.baidu.searchbox.bigimage.dependency.interfaces.IImageDebug;
import com.baidu.searchbox.bigimage.dependency.interfaces.IImageHostConfig;
import com.baidu.searchbox.bigimage.dependency.interfaces.IImageSearch;
import com.baidu.searchbox.bigimage.dependency.interfaces.IImageVideoPlayer;
import com.baidu.searchbox.bigimage.dependency.interfaces.PicDownloadManager;
import com.baidu.searchbox.bigimage.ioc.ImageContextImpl_Factory;
import com.baidu.searchbox.bigimage.ioc.ImageHostConfigImpl_Factory;
import com.baidu.searchbox.bigimage.ioc.ImageSearchImpl_Factory;
import com.baidu.searchbox.bigimage.ioc.PicDownloadManagerImpl_Factory;
import com.baidu.searchbox.bigimage.ioc.debug.ImageDebugImpl_Factory;
import com.baidu.searchbox.bigimage.ioc.videoplayer.ImageVideoPlayerImpl_Factory;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class ImageRuntime {
    public static PicDownloadManager getPicDownloadManager() {
        return PicDownloadManagerImpl_Factory.get();
    }

    public static IImageContext getContext() {
        return ImageContextImpl_Factory.get();
    }

    public static IImageSearch getImageSearch() {
        return ImageSearchImpl_Factory.get();
    }

    public static IImageVideoPlayer getVideoPlayer() {
        return ImageVideoPlayerImpl_Factory.get();
    }

    public static IImageHostConfig getImageHostConfig() {
        return ImageHostConfigImpl_Factory.get();
    }

    public static IImageDebug getImageDebug() {
        return ImageDebugImpl_Factory.get();
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static Application getApplication() {
        return AppRuntime.getApplication();
    }
}
