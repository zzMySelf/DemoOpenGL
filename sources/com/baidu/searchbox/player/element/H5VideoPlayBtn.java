package com.baidu.searchbox.player.element;

import com.baidu.searchbox.player.H5VideoPlayer;

public class H5VideoPlayBtn extends VideoControlPlayBtn {
    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (getVideoPlayer() instanceof H5VideoPlayer) {
            ((H5VideoPlayer) getVideoPlayer()).getPlayerCallbackManager().onPauseCallBack();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getVideoPlayer() instanceof H5VideoPlayer) {
            ((H5VideoPlayer) getVideoPlayer()).getPlayerCallbackManager().onResumeCallBack();
        }
    }
}
