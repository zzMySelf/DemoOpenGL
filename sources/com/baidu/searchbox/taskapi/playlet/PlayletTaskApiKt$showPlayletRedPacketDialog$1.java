package com.baidu.searchbox.taskapi.playlet;

import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayletTaskApi.kt */
final class PlayletTaskApiKt$showPlayletRedPacketDialog$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $showCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayletTaskApiKt$showPlayletRedPacketDialog$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$showCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean success) {
        TaskDebugUtil.debugLog("[短剧][展示红包弹窗] 展示结果：" + success);
        this.$showCallback.invoke(Boolean.valueOf(success));
    }
}
