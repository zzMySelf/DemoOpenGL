package com.baidu.searchbox.weather.comps.page.topbar;

import android.media.AudioManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/media/AudioManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopBarViewModel.kt */
final class TopBarViewModel$audioManager$2 extends Lambda implements Function0<AudioManager> {
    public static final TopBarViewModel$audioManager$2 INSTANCE = new TopBarViewModel$audioManager$2();

    TopBarViewModel$audioManager$2() {
        super(0);
    }

    public final AudioManager invoke() {
        Object systemService = AppRuntime.getApplication().getSystemService("audio");
        if (systemService instanceof AudioManager) {
            return (AudioManager) systemService;
        }
        return null;
    }
}
