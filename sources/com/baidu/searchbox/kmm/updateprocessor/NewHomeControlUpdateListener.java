package com.baidu.searchbox.kmm.updateprocessor;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt;
import com.baidu.searchbox.kmm.services.update.UpdateDataCallback;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/kmm/updateprocessor/NewHomeControlUpdateListener;", "Lcom/baidu/searchbox/kmm/services/update/UpdateDataCallback;", "()V", "getLocalVersion", "", "getNodePath", "getUploadParams", "", "handleData", "", "version", "data", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObject;", "com.baidu.searchbox.kmm.business.updateprocessor"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeControlUpdateListener.kt */
public final class NewHomeControlUpdateListener extends UpdateDataCallback {
    public String getNodePath() {
        return "home/new_home_ctrl";
    }

    public String getLocalVersion() {
        return QuickConfigKt.getQuickConfigString("new_home_ctrl_version", "0");
    }

    public Map<String, ?> getUploadParams() {
        String str;
        HashMap hashMap = new HashMap();
        HashMap $this$getUploadParams_u24lambda_u2d0 = hashMap;
        if (NewHomeControlUpdateListenerKt.isUpdateNewHome()) {
            str = "1";
        } else {
            str = "0";
        }
        String reason = QuickConfigKt.getQuickConfigString("new_home_ctrl_switch_reason", "");
        $this$getUploadParams_u24lambda_u2d0.put("switch", str);
        $this$getUploadParams_u24lambda_u2d0.put("switchReason", reason);
        return hashMap;
    }

    public boolean handleData(String version, JsonObject data) {
        Intrinsics.checkNotNullParameter(version, "version");
        if (data == null) {
            return false;
        }
        BackgroundTaskUtilsKt.bgSerialWork(new NewHomeControlUpdateListener$handleData$1(version, this, data));
        return true;
    }
}
