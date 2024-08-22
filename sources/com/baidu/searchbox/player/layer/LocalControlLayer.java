package com.baidu.searchbox.player.layer;

import android.os.Message;
import com.baidu.searchbox.player.element.LocalBottomBarElement;
import com.baidu.searchbox.player.element.LocalControlTitle;
import com.baidu.searchbox.player.element.LocalMuteBtnElement;
import com.baidu.searchbox.player.element.ReplayBtnElement;
import com.baidu.searchbox.player.element.VideoControlPlayBtn;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.VideoNotchUtils;

public class LocalControlLayer extends ControlLayer {
    /* access modifiers changed from: protected */
    public void setupElement() {
        addElement(new ReplayBtnElement());
        addElement(new LocalControlTitle());
        addElement(new VideoControlPlayBtn());
        addElement(new LocalBottomBarElement());
        addElement(new LocalMuteBtnElement());
    }

    public void onPlayerEventNotify(VideoEvent event) {
        if ("player_event_on_error".equals(event.getAction())) {
            togglePanelVisible(false);
        }
        dispatchEvent(event);
    }

    /* access modifiers changed from: protected */
    public void handleLayerMessage(Message msg) {
        if (msg.what == 1 && !getBindPlayer().isComplete()) {
            togglePanelVisible(false);
        }
    }

    public void onSystemEventNotify(VideoEvent event) {
        super.onSystemEventNotify(event);
        if (SystemEvent.ACTION_CONFIGURATION_CHANGED.equals(event.getAction()) && getBindPlayer().isFullMode() && getBindPlayer().getAppContext().getResources().getConfiguration().orientation == 1) {
            VideoNotchUtils.resetPadding(this);
        }
    }
}
