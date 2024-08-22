package com.baidu.searchbox.music.comp.playlist.panel;

import android.view.View;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.utils.MusicLoginUtils;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/music/comp/playlist/panel/PlayListPanelComp$collectSongList$1", "Lcom/baidu/searchbox/music/utils/MusicLoginUtils$OnAllowFuncListener;", "allowFunc", "", "onLoginFail", "failCode", "", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayListPanelComp.kt */
public final class PlayListPanelComp$collectSongList$1 implements MusicLoginUtils.OnAllowFuncListener {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ List<ISong> $songList;
    final /* synthetic */ PlayListPanelComp this$0;

    PlayListPanelComp$collectSongList$1(PlayListPanelComp $receiver, List<? extends ISong> $songList2, View $anchorView2) {
        this.this$0 = $receiver;
        this.$songList = $songList2;
        this.$anchorView = $anchorView2;
    }

    public void allowFunc() {
        this.this$0.dismissPanel(new PlayListPanelComp$collectSongList$1$allowFunc$1(this.this$0, this.$songList, this.$anchorView));
    }

    public void onLoginFail(int failCode) {
    }
}
