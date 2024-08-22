package com.baidu.searchbox.player.layer.floating;

import com.baidu.searchbox.floating.permission.FloatPermissionUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/player/layer/floating/VideoFloatingPlugin$resultListener$2$1", "invoke", "()Lcom/baidu/searchbox/player/layer/floating/VideoFloatingPlugin$resultListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFloatingPlugin.kt */
final class VideoFloatingPlugin$resultListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ VideoFloatingPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFloatingPlugin$resultListener$2(VideoFloatingPlugin videoFloatingPlugin) {
        super(0);
        this.this$0 = videoFloatingPlugin;
    }

    public final AnonymousClass1 invoke() {
        final VideoFloatingPlugin videoFloatingPlugin = this.this$0;
        return new FloatPermissionUtil.OnPermissionResult() {
            public void onResult(int result) {
                videoFloatingPlugin.onPermissionResult(result);
            }
        };
    }
}
