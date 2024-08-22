package com.baidu.live.arch.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MiniUiThreadUtil.kt */
final class MiniUiThreadUtil$sMainHandler$2 extends Lambda implements Function0<Handler> {
    public static final MiniUiThreadUtil$sMainHandler$2 INSTANCE = new MiniUiThreadUtil$sMainHandler$2();

    MiniUiThreadUtil$sMainHandler$2() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
