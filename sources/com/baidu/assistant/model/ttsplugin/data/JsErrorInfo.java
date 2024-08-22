package com.baidu.assistant.model.ttsplugin.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/assistant/model/ttsplugin/data/JsErrorInfo;", "", "status", "", "msg", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getMsg", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-model-ttsplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TtsData.kt */
public final class JsErrorInfo {
    private final String error;
    private final String msg;
    private final String status;

    public static /* synthetic */ JsErrorInfo copy$default(JsErrorInfo jsErrorInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = jsErrorInfo.status;
        }
        if ((i2 & 2) != 0) {
            str2 = jsErrorInfo.msg;
        }
        if ((i2 & 4) != 0) {
            str3 = jsErrorInfo.error;
        }
        return jsErrorInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.error;
    }

    public final JsErrorInfo copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "status");
        return new JsErrorInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JsErrorInfo)) {
            return false;
        }
        JsErrorInfo jsErrorInfo = (JsErrorInfo) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) jsErrorInfo.status) && Intrinsics.areEqual((Object) this.msg, (Object) jsErrorInfo.msg) && Intrinsics.areEqual((Object) this.error, (Object) jsErrorInfo.error);
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.msg;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "JsErrorInfo(status=" + this.status + ", msg=" + this.msg + ", error=" + this.error + ')';
    }

    public JsErrorInfo(String status2, String msg2, String error2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
        this.msg = msg2;
        this.error = error2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getError() {
        return this.error;
    }
}
