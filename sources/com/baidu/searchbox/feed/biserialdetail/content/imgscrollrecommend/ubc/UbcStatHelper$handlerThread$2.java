package com.baidu.searchbox.feed.biserialdetail.content.imgscrollrecommend.ubc;

import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/HandlerThread;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UbcStatHelper.kt */
final class UbcStatHelper$handlerThread$2 extends Lambda implements Function0<HandlerThread> {
    public static final UbcStatHelper$handlerThread$2 INSTANCE = new UbcStatHelper$handlerThread$2();

    UbcStatHelper$handlerThread$2() {
        super(0);
    }

    public final HandlerThread invoke() {
        return new HandlerThread("img_recommend_ubc_stat_helper");
    }
}
