package com.baidu.searchbox.audio.model.local;

import android.text.TextUtils;
import com.baidu.searchbox.audio.model.Album;
import com.baidu.searchbox.audio.model.AlbumAddToShelfCallback;
import com.baidu.searchbox.audio.model.AlbumDataSource;
import com.baidu.searchbox.audio.model.AlbumLoadCallback;
import com.baidu.searchbox.audio.model.AlbumSubscribeCallback;
import com.baidu.searchbox.audio.model.EpisodeLandingLoadCallback;
import com.baidu.searchbox.audio.model.EpisodeListLoadCallback;
import com.baidu.searchbox.audio.model.EpisodeLoadCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumLocalDataSource implements AlbumDataSource {
    private static volatile AlbumLocalDataSource INSTANCE = null;
    private static final String PRE_EXT = "ext_";
    private static final String PRE_SEXT = "sExt_";
    private Map<String, String> mCachedLogInfo;

    private AlbumLocalDataSource() {
    }

    public static AlbumLocalDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (AlbumLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AlbumLocalDataSource();
                }
            }
        }
        return INSTANCE;
    }

    public void getAlbum(String albumId, AlbumLoadCallback callback, String... args) {
    }

    public void getEpisodeList(String albumId, String audioId, List<String> list, List<String> list2, EpisodeListLoadCallback callback, String... args) {
    }

    public void refreshEpisodes() {
    }

    public void subscribeAlbum(Album album, String operation, AlbumSubscribeCallback callback) {
    }

    public void fetchRealPlayURL(String albumID, String episodeID, String ext, EpisodeLoadCallback callback) {
    }

    public void addToBookshelf(Album album, String operation, AlbumAddToShelfCallback callback) {
    }

    public void getEpisodeLandingData(String albumId, String audioId, EpisodeLandingLoadCallback callback) {
    }

    public void setLogInfo(String albumId, String ext, String sExt) {
        if (this.mCachedLogInfo == null) {
            this.mCachedLogInfo = new HashMap();
        }
        if (!TextUtils.isEmpty(ext)) {
            this.mCachedLogInfo.put("ext_" + albumId, ext);
        }
        if (!TextUtils.isEmpty(ext)) {
            this.mCachedLogInfo.put(PRE_SEXT + albumId, sExt);
        }
    }

    public String getExtFromCache(String albumId) {
        Map<String, String> map = this.mCachedLogInfo;
        if (map == null || !map.containsKey("ext_" + albumId)) {
            return "";
        }
        return this.mCachedLogInfo.get("ext_" + albumId);
    }

    public String getSExtFromCache(String albumId) {
        Map<String, String> map = this.mCachedLogInfo;
        if (map == null || !map.containsKey(PRE_SEXT + albumId)) {
            return "";
        }
        return this.mCachedLogInfo.get(PRE_SEXT + albumId);
    }
}
