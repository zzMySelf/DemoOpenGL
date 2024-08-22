package com.baidu.searchbox.search.webvideo.abtest;

import android.widget.FrameLayout;
import com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer;

public class H5VideoConfigAdapter implements IH5VideoConfig {
    protected SearchH5ProxyPlayer mProxyPlayer;

    public H5VideoConfigAdapter(SearchH5ProxyPlayer proxyPlayer) {
        this.mProxyPlayer = proxyPlayer;
    }

    public void notify(int what, Object obj) {
    }

    public void setVideoViewHolder(FrameLayout frameLayout) {
    }

    public void release() {
    }

    public void goBackOrForground(boolean foreground) {
    }

    public void onOffsetsForFullscreenChanged(int offsetY) {
    }

    public void updateUI() {
    }

    public void setIsInWhiteList(boolean isInWhiteList) {
    }

    public boolean isTransNa() {
        return false;
    }
}
