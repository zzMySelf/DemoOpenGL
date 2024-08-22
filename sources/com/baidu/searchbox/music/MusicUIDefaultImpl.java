package com.baidu.searchbox.music;

import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.music.bean.Song;
import java.util.ArrayList;
import java.util.List;

public class MusicUIDefaultImpl implements IMusicUI {
    public void setPlayState(MusicPlayState state) {
    }

    public void setPreNextEnabled(boolean pre, boolean next) {
    }

    public void setVoiceManagementEnabled(boolean enabled) {
    }

    public void setTitle(String title) {
    }

    public void setArtist(String artist) {
    }

    public void setAlbum(String album, String albumImgUrl, String albumUrl) {
    }

    public void setImage(String imgUrl) {
    }

    public void setDuration(int duration) {
    }

    public void setFreeDuration(int duration) {
    }

    public void setPosition(int position, int progress, int lastTtsProgress) {
    }

    public void setDownloadProgress(int progress) {
    }

    public void setPlayMode(int mode) {
    }

    public void setDownloadState(DownloadState downloadState) {
    }

    public void setDefaultUI(boolean isShow) {
    }

    public void setExtraInfo(Song song) {
    }

    public void notifyDataChange(int type, ArrayList<Song> arrayList) {
    }

    public void notifyTotalPullUpSize(int totalSize, int currPageIndex, int currPageSize) {
    }

    public int getMode() {
        return 0;
    }

    public void notifyHistoryUpdate() {
    }

    public void notifyFavorDataChange(String favor) {
    }

    public void notifyModeChange(int oldMode, int newMode) {
    }

    public void setCollect(Song song) {
    }

    public void onLoginResultFormCollectList() {
    }

    public void setPlayingParagraph(int paragraph) {
    }

    public void setLyricsData(List<String> list, boolean isMusicLyrics, boolean isLyricsComplete) {
    }
}
