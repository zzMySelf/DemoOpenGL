package com.baidu.searchbox.music.adapter;

import android.view.View;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.music.IMusicUI;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.bean.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class AbstractMusicAdapter implements IMusic {
    private boolean mEnablePullDown;
    private boolean mEnablePullUp;
    protected int mRealMaxProgress;
    protected volatile Vector<IMusicUI> mUICallback = new Vector<>();

    public abstract void init();

    public void initBizPlayer() {
    }

    /* access modifiers changed from: protected */
    public void addUICallback(IMusicUI callback) {
        Vector<IMusicUI> copy = new Vector<>(this.mUICallback);
        if (callback != null && !copy.contains(callback)) {
            copy.add(callback);
        }
        this.mUICallback = copy;
    }

    /* access modifiers changed from: protected */
    public void removeUICallback(IMusicUI callback) {
        Vector<IMusicUI> copy = new Vector<>(this.mUICallback);
        if (callback != null) {
            copy.remove(callback);
        }
        this.mUICallback = copy;
    }

    /* access modifiers changed from: protected */
    public void setPlayState(MusicPlayState state) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPlayState(state);
        }
    }

    public void setPreNextEnabled(boolean pre, boolean next) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPreNextEnabled(pre, next);
        }
    }

    public void setVoiceManagementEnabled(boolean enabled) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setVoiceManagementEnabled(enabled);
        }
    }

    /* access modifiers changed from: protected */
    public void setTitle(String title) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setTitle(title);
        }
    }

    /* access modifiers changed from: protected */
    public void setArtist(String artist) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setArtist(artist);
        }
    }

    /* access modifiers changed from: protected */
    public void setAlbum(String album, String albumImgUrl, String albumUrl) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setAlbum(album, albumImgUrl, albumUrl);
        }
    }

    /* access modifiers changed from: protected */
    public void setImage(String image) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setImage(image);
        }
    }

    /* access modifiers changed from: protected */
    public void setExtraInfo(Song song) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setExtraInfo(song);
        }
    }

    /* access modifiers changed from: protected */
    public void setDuration(int duration) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setDuration(duration);
        }
    }

    /* access modifiers changed from: protected */
    public void setFreeDuration(int duration) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setFreeDuration(duration);
        }
    }

    public int getMaxProgress() {
        return this.mRealMaxProgress;
    }

    /* access modifiers changed from: protected */
    public void setPosition(int position, int progress) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPosition(position, progress, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setPosition(int position, int progress, int lastTtsProgress) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPosition(position, progress, lastTtsProgress);
        }
    }

    /* access modifiers changed from: protected */
    public void setDownloadProgress(int progress) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setDownloadProgress(progress);
        }
    }

    /* access modifiers changed from: protected */
    public void setPlayMode(int mode) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPlayMode(mode);
        }
    }

    /* access modifiers changed from: protected */
    public void setCollect(Song song) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setCollect(song);
        }
    }

    public void onLoginResultFormCollectList() {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().onLoginResultFormCollectList();
        }
    }

    /* access modifiers changed from: protected */
    public void setDownloadState(DownloadState downloadState) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setDownloadState(downloadState);
        }
    }

    public void setEnablePullUp(boolean enablePullUp, boolean enablePullDown) {
        this.mEnablePullUp = enablePullUp;
        this.mEnablePullDown = enablePullDown;
    }

    public boolean isEnablePullUp() {
        return this.mEnablePullUp;
    }

    public boolean isEnablePullDown() {
        return this.mEnablePullDown;
    }

    /* access modifiers changed from: package-private */
    public void notifyDataChange(int type, ArrayList<Song> dataList) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().notifyDataChange(type, dataList);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyTotalPullUpSize(int totalSize, int currPageIndex, int currPageSize) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().notifyTotalPullUpSize(totalSize, currPageIndex, currPageSize);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDefaultUI(boolean isShow) {
        MediaRuntime.getContext().logOnline("TTSAdapter.setDefaultUI >> " + isShow);
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setDefaultUI(isShow);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyHistoryUpdate() {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().notifyHistoryUpdate();
        }
    }

    public void setSource(String mSource) {
    }

    public void notifyUserClickEvent(View v, int mode) {
    }

    public void onClickTitle() {
    }

    public void onShowSettingButton() {
    }

    public void showVoiceManagementView(View anchorView, String from) {
    }

    public void dismissVoiceManagementView() {
    }

    public void startMiniFront(int mMode) {
    }

    public void endMiniFront(int mMode) {
    }

    public void startMiniBack(int mMode) {
    }

    public void endMiniBack(int mMode) {
    }

    public void startFloatFront(int mMode) {
    }

    public void endFloatFront(int mMode) {
    }

    public void startFloatBack(int mMode) {
    }

    public void endFloatBack(int mMode) {
    }

    /* access modifiers changed from: protected */
    public void setPlayingParagraph(int paragraph) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setPlayingParagraph(paragraph);
        }
    }

    /* access modifiers changed from: protected */
    public void setLyricsData(List<String> lyricsData, boolean isMusicLyrics, long lyricsOffset, List<Long> list, List<Integer> list2, boolean isLyricsComplete) {
        Iterator<IMusicUI> it = this.mUICallback.iterator();
        while (it.hasNext()) {
            it.next().setLyricsData(lyricsData, isMusicLyrics, isLyricsComplete);
        }
    }
}
