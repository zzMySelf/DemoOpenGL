package com.baidu.searchbox.talos.lite.interaction.action;

import com.baidu.searchbox.talos.lite.BaseAction;
import com.baidu.searchbox.talos.lite.TalosLiteManager;
import com.baidu.searchbox.talos.lite.render.TalosLiteRenderManager;
import com.baidu.searchbox.talos.lite.runtime.TalosLiteRuntimeContext;
import com.baidu.searchbox.talos.lite.utils.TalosLiteRenderNodeParserKt;
import com.baidu.talos.core.data.ParamArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J(\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/talos/lite/interaction/action/CommandAction;", "Lcom/baidu/searchbox/talos/lite/BaseAction;", "()V", "command", "", "commandParams", "Lcom/baidu/talos/core/data/ParamArray;", "targetViewTag", "", "execute", "", "getType", "onParseParams", "rootViewTag", "viewTag", "scopeId", "args", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommandAction.kt */
public final class CommandAction extends BaseAction {
    private String command = "";
    private ParamArray commandParams;
    private long targetViewTag = -1;

    public String getType() {
        return "command";
    }

    public void onParseParams(long rootViewTag, long viewTag, long scopeId, String args) {
        Intrinsics.checkNotNullParameter(args, "args");
        super.onParseParams(rootViewTag, viewTag, scopeId, args);
        try {
            JSONObject argsJson = new JSONObject(args);
            this.targetViewTag = argsJson.optLong("id", -1);
            String optString = argsJson.optString("command", "");
            Intrinsics.checkNotNullExpressionValue(optString, "argsJson.optString(ACTION_COMMAND, \"\")");
            this.command = optString;
            JSONArray commandParamJson = argsJson.optJSONArray("params");
            if (commandParamJson != null) {
                this.commandParams = TalosLiteRenderNodeParserKt.parseRenderJsonArray$default(commandParamJson, false, 2, (Object) null);
            }
        } catch (JSONException e2) {
        }
    }

    public void execute() {
        TalosLiteRenderManager renderManager;
        TalosLiteRuntimeContext runtimeContext = TalosLiteManager.INSTANCE.getRuntimeContext();
        if (runtimeContext != null && (renderManager = runtimeContext.getRenderManager()) != null) {
            renderManager.dispatchViewManagerCommand(this.targetViewTag, this.command, this.commandParams);
        }
    }
}
