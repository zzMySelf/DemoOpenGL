package com.baidu.searchbox.video.detail.utils;

import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.BdVideoNewParser;

public class BdVideoSeriesFactory {
    private static final boolean DEBUG = IVideoAppConfig.Impl.get().isDebug();

    public static BdVideoSeries createVideoSeries(String videoInfo) {
        try {
            return BdVideoNewParser.parseToVideoSeriesSafely(videoInfo);
        } catch (Exception e2) {
            BdVideoLog.logException("BdVideoSeriesFactory", e2);
            return null;
        }
    }
}
