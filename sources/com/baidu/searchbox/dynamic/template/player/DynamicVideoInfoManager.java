package com.baidu.searchbox.dynamic.template.player;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.player.model.VideoPlayHistoryItemInfo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import java.util.HashMap;
import java.util.Map;

public class DynamicVideoInfoManager {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = DynamicVideoInfoManager.class.getSimpleName();
    private static volatile DynamicVideoInfoManager sInstance;
    private final Map<String, DynamicPlayInfo> mVideoInfo = new HashMap();

    private DynamicVideoInfoManager() {
    }

    public static DynamicVideoInfoManager getInstance() {
        if (sInstance == null) {
            synchronized (DynamicVideoInfoManager.class) {
                if (sInstance == null) {
                    sInstance = new DynamicVideoInfoManager();
                }
            }
        }
        return sInstance;
    }

    public void saveCurLength(BdVideoSeries series) {
        if (series != null && series.getSelectedVideo() != null) {
            BdVideo video = series.getSelectedVideo();
            String curLength = video.getCurrentLength();
            String totalLength = video.getTotalLength();
            DynamicPlayInfo info = new DynamicPlayInfo();
            if (TextUtils.equals(curLength, totalLength)) {
                info.curLength = "0";
            } else {
                info.curLength = curLength;
            }
            info.totalLength = totalLength;
            if (DEBUG) {
                Log.d(TAG, "#HotDiscussionVideoInfoManager#, saveCurLength: " + info.curLength + ", totalLength: " + info.totalLength);
            }
            String key = VideoPlayHistoryItemInfo.genId(video.getSourceUrl());
            if (!TextUtils.isEmpty(key)) {
                this.mVideoInfo.put(key, info);
            }
        }
    }

    public DynamicPlayInfo getSavedVideoInfo(BdVideoSeries series) {
        if (series == null || series.getSelectedVideo() == null) {
            return null;
        }
        return this.mVideoInfo.get(VideoPlayHistoryItemInfo.genId(series.getSelectedVideo().getSourceUrl()));
    }

    public void clearVideoInfo(BdVideoSeries series) {
        DynamicPlayInfo info = getSavedVideoInfo(series);
        if (info != null) {
            this.mVideoInfo.remove(info);
        }
    }

    public void setVideoLength(BdVideoSeries series) {
        if (series != null) {
            BdVideo video = series.getSelectedVideo();
            DynamicPlayInfo info = getSavedVideoInfo(series);
            if (info != null && video != null) {
                if (DEBUG) {
                    Log.d(TAG, "#HotDiscussionVideoInfoManager#, saveCurLength: " + info.curLength + ", totalLength: " + info.totalLength);
                }
                video.setCurrentLength(TextUtils.isEmpty(info.curLength) ? "0" : info.curLength);
                video.setTotalLength(info.totalLength);
            }
        }
    }
}
