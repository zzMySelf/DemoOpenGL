package com.baidu.searchbox.bdmediacore.callback.actions;

import android.os.Bundle;
import com.baidu.searchbox.bdmediacore.callback.PlaybackManager;

public interface IActionsHandler {
    String getAction();

    Bundle getParams();

    PlaybackManager getPlaybackManager();

    void handle();

    void setAction(String str);

    void setParams(Bundle bundle);

    void setPlaybackManager(PlaybackManager playbackManager);
}
