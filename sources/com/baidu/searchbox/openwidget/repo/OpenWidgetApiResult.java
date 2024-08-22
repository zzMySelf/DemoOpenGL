package com.baidu.searchbox.openwidget.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/openwidget/repo/OpenWidgetApiResult;", "T", "", "errorCode", "", "message", "", "data", "(JLjava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()J", "isSuccess", "", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(JLjava/lang/String;Ljava/lang/Object;)Lcom/baidu/searchbox/openwidget/repo/OpenWidgetApiResult;", "equals", "other", "hashCode", "", "toString", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetApiResult.kt */
public final class OpenWidgetApiResult<T> {
    private final T data;
    private final long errorCode;
    private final String message;

    public static /* synthetic */ OpenWidgetApiResult copy$default(OpenWidgetApiResult openWidgetApiResult, long j2, String str, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = openWidgetApiResult.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = openWidgetApiResult.message;
        }
        if ((i2 & 4) != 0) {
            t = openWidgetApiResult.data;
        }
        return openWidgetApiResult.copy(j2, str, t);
    }

    public final long component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final OpenWidgetApiResult<T> copy(long j2, String str, T t) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new OpenWidgetApiResult<>(j2, str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenWidgetApiResult)) {
            return false;
        }
        OpenWidgetApiResult openWidgetApiResult = (OpenWidgetApiResult) obj;
        return this.errorCode == openWidgetApiResult.errorCode && Intrinsics.areEqual((Object) this.message, (Object) openWidgetApiResult.message) && Intrinsics.areEqual((Object) this.data, (Object) openWidgetApiResult.data);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.errorCode) * 31) + this.message.hashCode()) * 31;
        T t = this.data;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "OpenWidgetApiResult(errorCode=" + this.errorCode + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public OpenWidgetApiResult(long errorCode2, String message2, T data2) {
        Intrinsics.checkNotNullParameter(message2, "message");
        this.errorCode = errorCode2;
        this.message = message2;
        this.data = data2;
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final T getData() {
        return this.data;
    }

    public final boolean isSuccess() {
        return this.errorCode == 0 && this.data != null;
    }
}
