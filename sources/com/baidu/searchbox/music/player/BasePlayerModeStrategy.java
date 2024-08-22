package com.baidu.searchbox.music.player;

import android.content.Context;
import com.baidu.searchbox.music.IPlayListView;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.bean.Song;

public class BasePlayerModeStrategy implements IPlayerModeStrategy {
    public void playHistoryItem(int position) {
    }

    public boolean isPlayThisItem(String nid) {
        return false;
    }

    public void registerDownloadReceiver(Context context) {
    }

    public void unregisterDownloadReceiver() {
    }

    public void notifyUserEvent(int vId, int mode) {
    }

    public void initEventMap() {
    }

    public void userEventCloseAlert(int mode) {
    }

    public void userEventClosePlayer(int mode) {
    }

    public void userEventPlayerPause(int mode) {
    }

    public void userEventClosePlayList(int mode) {
    }

    public int getScanSourceTopMargin(Context context, int mode) {
        return 0;
    }

    public void onPlayStateChange(MusicPlayState state, boolean isForeground, int mode) {
    }

    public String getCoverImage(String image) {
        return null;
    }

    public void setCurrentSong(Song currentSong) {
    }

    public int getDefaultCoverRes() {
        return 0;
    }

    public int getProgressBarRes() {
        return 0;
    }

    public void destroy() {
    }

    public void scanFeed(Context context) {
    }

    public boolean canScanFeed(int mode) {
        return false;
    }

    public int getUBCMode(int mode) {
        return 0;
    }

    public void finishUBC(int mode) {
    }

    public void musicPreviousUBC() {
    }

    public void musicNextUBC() {
    }

    public void musicPreviousClickCallback() {
    }

    public void musicNextClickCallbak() {
    }

    public void notifyUI() {
    }

    public void injectView(IPlayListView playlistView) {
    }

    public void requestHistorys() {
    }

    public void beforeFinish(Context context, String source) {
    }
}
