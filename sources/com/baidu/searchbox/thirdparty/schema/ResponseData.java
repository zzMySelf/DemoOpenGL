package com.baidu.searchbox.thirdparty.schema;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0014J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/thirdparty/schema/ResponseData;", "", "errno", "", "errmsg", "", "data", "Lcom/baidu/searchbox/thirdparty/schema/WXOpenidData;", "(ILjava/lang/String;Lcom/baidu/searchbox/thirdparty/schema/WXOpenidData;)V", "getData", "()Lcom/baidu/searchbox/thirdparty/schema/WXOpenidData;", "getErrmsg", "()Ljava/lang/String;", "getErrno", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "isSucceed", "toString", "Companion", "lib-openid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WXOpenidRepo.kt */
public final class ResponseData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_ERROR_NO = 100005;
    public static final String DEFAULT_FAIL_MSG = "网络请求失败";
    public static final int SUCCEED_ERROR_NO = 0;
    private final WXOpenidData data;
    private final String errmsg;
    private final int errno;

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, int i2, String str, WXOpenidData wXOpenidData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = responseData.errno;
        }
        if ((i3 & 2) != 0) {
            str = responseData.errmsg;
        }
        if ((i3 & 4) != 0) {
            wXOpenidData = responseData.data;
        }
        return responseData.copy(i2, str, wXOpenidData);
    }

    public final int component1() {
        return this.errno;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final WXOpenidData component3() {
        return this.data;
    }

    public final ResponseData copy(int i2, String str, WXOpenidData wXOpenidData) {
        Intrinsics.checkNotNullParameter(str, "errmsg");
        return new ResponseData(i2, str, wXOpenidData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseData)) {
            return false;
        }
        ResponseData responseData = (ResponseData) obj;
        return this.errno == responseData.errno && Intrinsics.areEqual((Object) this.errmsg, (Object) responseData.errmsg) && Intrinsics.areEqual((Object) this.data, (Object) responseData.data);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.errno) * 31) + this.errmsg.hashCode()) * 31;
        WXOpenidData wXOpenidData = this.data;
        return hashCode + (wXOpenidData == null ? 0 : wXOpenidData.hashCode());
    }

    public String toString() {
        return "ResponseData(errno=" + this.errno + ", errmsg=" + this.errmsg + ", data=" + this.data + ')';
    }

    public ResponseData(int errno2, String errmsg2, WXOpenidData data2) {
        Intrinsics.checkNotNullParameter(errmsg2, "errmsg");
        this.errno = errno2;
        this.errmsg = errmsg2;
        this.data = data2;
    }

    public final WXOpenidData getData() {
        return this.data;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final int getErrno() {
        return this.errno;
    }

    public final boolean isSucceed() {
        return this.errno == 0;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/thirdparty/schema/ResponseData$Companion;", "", "()V", "DEFAULT_ERROR_NO", "", "DEFAULT_FAIL_MSG", "", "SUCCEED_ERROR_NO", "withResponseJsonData", "Lcom/baidu/searchbox/thirdparty/schema/ResponseData;", "data", "lib-openid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WXOpenidRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @StableApi
        public final ResponseData withResponseJsonData(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                JSONObject json = new JSONObject(data);
                int errno = json.optInt("errno", 100005);
                String errmsg = json.optString("errmsg", "");
                Intrinsics.checkNotNullExpressionValue(errmsg, "json.optString(\"errmsg\", \"\")");
                JSONObject wxData = json.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(wxData, "json.getJSONObject(\"data\")");
                String wxRealData = wxData.optString(WXOpenidRepo.CMD, "");
                Intrinsics.checkNotNullExpressionValue(wxRealData, "wxData.optString(CMD, \"\")");
                return new ResponseData(errno, errmsg, WXOpenidData.Companion.withJsonData(wxRealData));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new ResponseData(100005, "网络请求失败", (WXOpenidData) null);
            }
        }
    }
}
