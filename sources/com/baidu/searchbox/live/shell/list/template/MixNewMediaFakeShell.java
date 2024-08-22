package com.baidu.searchbox.live.shell.list.template;

import android.content.Context;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.shell.list.basic.MixBasicFakeShell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/template/MixNewMediaFakeShell;", "Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", "context", "Landroid/content/Context;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "getLiveTemplateId", "", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MixNewMediaFakeShell.kt */
public final class MixNewMediaFakeShell extends MixBasicFakeShell {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MixNewMediaFakeShell(Context context, MiniUniqueId mixUniqueId, IMixActivityInterface mixActivity) {
        super(context, mixUniqueId, mixActivity);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(mixUniqueId, "mixUniqueId");
        Intrinsics.checkParameterIsNotNull(mixActivity, "mixActivity");
    }

    public String getLiveTemplateId() {
        return "1";
    }
}
