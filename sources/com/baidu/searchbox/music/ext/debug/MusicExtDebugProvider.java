package com.baidu.searchbox.music.ext.debug;

import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.nacomp.extension.debug.DebugExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/music/ext/debug/MusicExtDebugProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "getChildItemList", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getGroupName", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicExtDebugProvider.kt */
public final class MusicExtDebugProvider extends DebugDataGroupProvider {
    public String getGroupName() {
        return "音乐NA";
    }

    public List<DebugItemInfo> getChildItemList() {
        List $this$getChildItemList_u24lambda_u2d0 = new ArrayList();
        $this$getChildItemList_u24lambda_u2d0.add(DebugExtKt.createAbControlDebugItem(this, MusicExtDebugProviderKt.KEY_MUSIC_STYLE_UPDATE, "播放器样式改版"));
        return $this$getChildItemList_u24lambda_u2d0;
    }
}
