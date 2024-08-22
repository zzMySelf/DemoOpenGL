package com.baidu.searchbox.preload.business.listener;

import android.content.Context;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.preload.business.ioc.PreloadContextKt;
import com.baidu.searchbox.preload.interfaces.listener.PreloadSimpleSyncListener;
import com.baidu.searchbox.preload.interfaces.store.PreloadSpWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/preload/business/listener/UpdateRegisterListener;", "Lcom/baidu/searchbox/preload/interfaces/listener/PreloadSimpleSyncListener;", "()V", "executeBusinessCommand", "", "context", "Landroid/content/Context;", "module", "", "action", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "lib-preload-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateRegisterListener.kt */
public final class UpdateRegisterListener extends PreloadSimpleSyncListener {
    public boolean executeBusinessCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        JSONObject it;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        if (value == null || (it = (JSONObject) value.data) == null) {
            return true;
        }
        PreloadSpWrapper.INSTANCE.putBoolean(PreloadContextKt.UPDATE_IS_USE_OLD_SWITCH, Intrinsics.areEqual((Object) it.optString("switch", "0"), (Object) "1"));
        return true;
    }
}
