package com.baidu.searchbox.video.feedflow.firstframeavoid;

import com.baidu.searchbox.player.ab.PlayerAbManager;
import com.baidu.searchbox.player.model.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FirstFrameAvoidConfigManager.kt */
final class FirstFrameAvoidConfigManagerKt$isMatchRange$2 extends Lambda implements Function0<Boolean> {
    public static final FirstFrameAvoidConfigManagerKt$isMatchRange$2 INSTANCE = new FirstFrameAvoidConfigManagerKt$isMatchRange$2();

    FirstFrameAvoidConfigManagerKt$isMatchRange$2() {
        super(0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(new FloatRange("0.0_0.7").contains(PlayerAbManager.getStaticScore()));
    }
}
