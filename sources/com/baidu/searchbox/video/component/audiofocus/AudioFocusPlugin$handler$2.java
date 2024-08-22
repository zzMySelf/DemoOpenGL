package com.baidu.searchbox.video.component.audiofocus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/component/audiofocus/AudioFocusPlugin$handler$2$1", "invoke", "()Lcom/baidu/searchbox/video/component/audiofocus/AudioFocusPlugin$handler$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioFocusPlugin.kt */
final class AudioFocusPlugin$handler$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ AudioFocusPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioFocusPlugin$handler$2(AudioFocusPlugin audioFocusPlugin) {
        super(0);
        this.this$0 = audioFocusPlugin;
    }

    public final AnonymousClass1 invoke() {
        Looper mainLooper = Looper.getMainLooper();
        final AudioFocusPlugin audioFocusPlugin = this.this$0;
        return new Handler(mainLooper) {
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (msg.what == 0) {
                    audioFocusPlugin.abandonFocus();
                }
            }
        };
    }
}
