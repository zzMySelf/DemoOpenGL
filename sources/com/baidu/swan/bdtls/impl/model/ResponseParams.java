package com.baidu.swan.bdtls.impl.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/baidu/swan/bdtls/impl/model/ResponseParams;", "", "responseMessage", "", "responseStatusCode", "", "([BLjava/lang/Integer;)V", "getResponseMessage", "()[B", "setResponseMessage", "([B)V", "getResponseStatusCode", "()Ljava/lang/Integer;", "setResponseStatusCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "([BLjava/lang/Integer;)Lcom/baidu/swan/bdtls/impl/model/ResponseParams;", "equals", "", "other", "hashCode", "toString", "", "lib-swan-bdtls-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdtlsModel.kt */
public final class ResponseParams {
    private byte[] responseMessage;
    private Integer responseStatusCode;

    public ResponseParams() {
        this((byte[]) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResponseParams copy$default(ResponseParams responseParams, byte[] bArr, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr = responseParams.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = responseParams.responseStatusCode;
        }
        return responseParams.copy(bArr, num);
    }

    public final byte[] component1() {
        return this.responseMessage;
    }

    public final Integer component2() {
        return this.responseStatusCode;
    }

    public final ResponseParams copy(byte[] bArr, Integer num) {
        return new ResponseParams(bArr, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseParams)) {
            return false;
        }
        ResponseParams responseParams = (ResponseParams) obj;
        return Intrinsics.areEqual((Object) this.responseMessage, (Object) responseParams.responseMessage) && Intrinsics.areEqual((Object) this.responseStatusCode, (Object) responseParams.responseStatusCode);
    }

    public int hashCode() {
        byte[] bArr = this.responseMessage;
        int i2 = 0;
        int hashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
        Integer num = this.responseStatusCode;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + Arrays.toString(this.responseMessage) + ", responseStatusCode=" + this.responseStatusCode + ')';
    }

    public ResponseParams(byte[] responseMessage2, Integer responseStatusCode2) {
        this.responseMessage = responseMessage2;
        this.responseStatusCode = responseStatusCode2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseParams(byte[] bArr, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bArr, (i2 & 2) != 0 ? 0 : num);
    }

    public final byte[] getResponseMessage() {
        return this.responseMessage;
    }

    public final void setResponseMessage(byte[] bArr) {
        this.responseMessage = bArr;
    }

    public final Integer getResponseStatusCode() {
        return this.responseStatusCode;
    }

    public final void setResponseStatusCode(Integer num) {
        this.responseStatusCode = num;
    }
}
