package com.baidu.searchbox.player.ab;

import com.baidu.searchbox.export.IPlayerSpeedScoreManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerAbManager.kt */
final class PlayerAbManager$staticScore$2 extends Lambda implements Function0<Float> {
    public static final PlayerAbManager$staticScore$2 INSTANCE = new PlayerAbManager$staticScore$2();

    PlayerAbManager$staticScore$2() {
        super(0);
    }

    public final Float invoke() {
        return Float.valueOf(IPlayerSpeedScoreManager.Impl.getInstance().getStaticDeviceScore());
    }
}
