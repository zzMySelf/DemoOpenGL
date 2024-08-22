package com.baidu.searchbox.search.video.player;

import android.app.Activity;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.LocalVideoPlayer;
import com.baidu.searchbox.player.helper.NormalSwitchHelper;
import com.baidu.searchbox.video.utils.ConfigurationChangedHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/search/video/player/SearchSimpleVideoPlayer;", "Lcom/baidu/searchbox/player/LocalVideoPlayer;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "getPlayerStageType", "", "initHelper", "", "release", "StyleHelper", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchSimpleVideoPlayer.kt */
public final class SearchSimpleVideoPlayer extends LocalVideoPlayer {
    private Activity activity;

    public SearchSimpleVideoPlayer(Activity activity2) {
        super(activity2);
        this.activity = activity2;
    }

    public Activity getActivity() {
        return this.activity;
    }

    /* access modifiers changed from: protected */
    public void initHelper() {
        super.initHelper();
        setStyleSwitchHelper(new StyleHelper(this, this));
    }

    public int getPlayerStageType() {
        return 6;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/search/video/player/SearchSimpleVideoPlayer$StyleHelper;", "Lcom/baidu/searchbox/player/helper/NormalSwitchHelper;", "player", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "(Lcom/baidu/searchbox/search/video/player/SearchSimpleVideoPlayer;Lcom/baidu/searchbox/player/BaseVideoPlayer;)V", "switchToNormalStyle", "", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchSimpleVideoPlayer.kt */
    private final class StyleHelper extends NormalSwitchHelper {
        final /* synthetic */ SearchSimpleVideoPlayer this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StyleHelper(SearchSimpleVideoPlayer this$02, BaseVideoPlayer player) {
            super(player);
            Intrinsics.checkNotNullParameter(player, "player");
            this.this$0 = this$02;
        }

        public void switchToNormalStyle() {
            this.mPlayer.setIsFullMode(false);
            Activity activity = this.mPlayer.getActivity();
            requestPortrait(activity);
            if (activity != null) {
                ConfigurationChangedHelper.configPortraitWindow(activity, true);
            }
            brightnessRecover(false, activity);
        }
    }

    public void release() {
        super.release();
        this.activity = null;
    }
}
