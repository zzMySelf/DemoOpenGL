package com.baidu.searchbox.player.element;

import android.content.Context;
import android.os.Message;
import android.view.ViewGroup;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ElementLayer;

public abstract class AbsElement implements IElement {
    protected ElementLayer mParent;

    public abstract void initElement();

    public void setParent(ElementLayer parent) {
        this.mParent = parent;
    }

    public ElementLayer getParent() {
        return this.mParent;
    }

    public void sendEvent(VideoEvent event) {
        this.mParent.sendEvent(event);
    }

    public Context getContext() {
        return this.mParent.getContentView().getContext();
    }

    public BDVideoPlayer getVideoPlayer() {
        return this.mParent.getBindPlayer();
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
    }

    public void onEventNotify(VideoEvent event) {
    }

    public void onLayerRelease() {
    }

    public void onLayerDetach() {
    }

    public void onContainerDetach() {
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    public boolean attachToRootAtOnce() {
        return true;
    }

    public void handleLayerMessage(Message msg) {
    }

    public void onParentVisibleChanged(int visibility) {
        getContentView().setVisibility(visibility);
    }

    /* access modifiers changed from: protected */
    public void dispatchElementEvent(VideoEvent event) {
        this.mParent.dispatchEvent(event);
    }
}
