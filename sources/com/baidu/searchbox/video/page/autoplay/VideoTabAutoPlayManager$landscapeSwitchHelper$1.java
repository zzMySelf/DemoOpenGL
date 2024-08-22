package com.baidu.searchbox.video.page.autoplay;

import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.video.detail.autoplay.base.IVideoAutoPlayView;
import com.baidu.searchbox.video.detail.autoplay.base.TplServiceManager;
import com.baidu.searchbox.video.detail.autoplay.base.VideoAutoPlayModel;
import com.baidu.searchbox.video.page.autoplay.VideoTabAutoPlayManager;
import com.baidu.searchbox.video.player.common.IPlayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/page/autoplay/VideoTabAutoPlayManager$landscapeSwitchHelper$1", "Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;", "switchToFullStyle", "", "switchToNormalStyle", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabAutoPlayManager.kt */
public final class VideoTabAutoPlayManager$landscapeSwitchHelper$1 implements IPlayerStyleSwitchHelper {
    final /* synthetic */ VideoTabAutoPlayManager this$0;

    VideoTabAutoPlayManager$landscapeSwitchHelper$1(VideoTabAutoPlayManager $receiver) {
        this.this$0 = $receiver;
    }

    public void switchToFullStyle() {
        VideoTabAutoPlayManager.OnAutoPlayExternalCallback interceptListener = this.this$0.getInterceptListener();
        if (interceptListener != null) {
            interceptListener.switchToFullStyle();
        }
        IVideoAutoPlayView curAutoPlayView = this.this$0.getCurrentItemView();
        if (curAutoPlayView != null) {
            this.this$0.internalPlayerAttachListener.onPlayerDetach();
            curAutoPlayView.bindTplManager((TplServiceManager) null);
        }
    }

    public void switchToNormalStyle() {
        VideoAutoPlayModel curSelectedModel;
        IPlayer player;
        IVideoAutoPlayView curAutoPlayView = this.this$0.getCurrentItemView();
        if (curAutoPlayView != null) {
            curAutoPlayView.bindTplManager(this.this$0.tplServiceManager);
        }
        this.this$0.internalPlayerAttachListener.onPlayerAttach();
        VideoTabAutoPlayManager.OnAutoPlayExternalCallback interceptListener = this.this$0.getInterceptListener();
        if (interceptListener != null) {
            interceptListener.switchToNormalStyle();
        }
        if (curAutoPlayView != null && (curSelectedModel = curAutoPlayView.getModel()) != null && (player = this.this$0.findPlayer(curSelectedModel)) != null) {
            this.this$0.startPlaySelectedItem(curAutoPlayView, player);
        }
    }
}
