package com.baidu.searchbox.talos.lite.interaction.action;

import com.baidu.searchbox.talos.lite.BaseAction;
import com.baidu.searchbox.talos.lite.ioc.ITalosLiteCmdRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/talos/lite/interaction/action/SchemeAction;", "Lcom/baidu/searchbox/talos/lite/BaseAction;", "()V", "cmd", "", "execute", "", "getType", "onParseParams", "rootViewTag", "", "viewTag", "scopeId", "args", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchemeAction.kt */
public final class SchemeAction extends BaseAction {
    private String cmd = "";

    public void onParseParams(long rootViewTag, long viewTag, long scopeId, String args) {
        Intrinsics.checkNotNullParameter(args, "args");
        super.onParseParams(rootViewTag, viewTag, scopeId, args);
        this.cmd = args;
    }

    public String getType() {
        return "cmd";
    }

    public void execute() {
        if (this.cmd.length() > 0) {
            ITalosLiteCmdRouter.Impl.INSTANCE.get().invoke(ActionUtilsKt.getAvailableValue(getScopeId(), getRootViewTag(), this.cmd, getExtraArgs()));
        }
    }
}
