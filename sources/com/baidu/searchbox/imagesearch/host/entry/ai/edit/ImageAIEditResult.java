package com.baidu.searchbox.imagesearch.host.entry.ai.edit;

import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageAIEditResult;", "", "status", "", "resultUrl", "", "message", "id", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getMessage", "getResultUrl", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "lib-entry-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAccessible
/* compiled from: ImageAIEditResult.kt */
public final class ImageAIEditResult {
    public static final int AI_EDIT_STATUS_SUCCESS = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_DATA = "data";
    private static final String KEY_JUMP_URL = "jumpUrl";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STATUS = "status";
    private String id;
    private final String message;
    private final String resultUrl;
    private final int status;

    public ImageAIEditResult() {
        this(0, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ImageAIEditResult copy$default(ImageAIEditResult imageAIEditResult, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = imageAIEditResult.status;
        }
        if ((i3 & 2) != 0) {
            str = imageAIEditResult.resultUrl;
        }
        if ((i3 & 4) != 0) {
            str2 = imageAIEditResult.message;
        }
        if ((i3 & 8) != 0) {
            str3 = imageAIEditResult.id;
        }
        return imageAIEditResult.copy(i2, str, str2, str3);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.resultUrl;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.id;
    }

    public final ImageAIEditResult copy(int i2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "id");
        return new ImageAIEditResult(i2, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageAIEditResult)) {
            return false;
        }
        ImageAIEditResult imageAIEditResult = (ImageAIEditResult) obj;
        return this.status == imageAIEditResult.status && Intrinsics.areEqual((Object) this.resultUrl, (Object) imageAIEditResult.resultUrl) && Intrinsics.areEqual((Object) this.message, (Object) imageAIEditResult.message) && Intrinsics.areEqual((Object) this.id, (Object) imageAIEditResult.id);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.status) * 31;
        String str = this.resultUrl;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "ImageAIEditResult(status=" + this.status + ", resultUrl=" + this.resultUrl + ", message=" + this.message + ", id=" + this.id + ')';
    }

    public ImageAIEditResult(int status2, String resultUrl2, String message2, String id2) {
        Intrinsics.checkNotNullParameter(message2, "message");
        Intrinsics.checkNotNullParameter(id2, "id");
        this.status = status2;
        this.resultUrl = resultUrl2;
        this.message = message2;
        this.id = id2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageAIEditResult(int i2, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3);
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getResultUrl() {
        return this.resultUrl;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageAIEditResult$Companion;", "", "()V", "AI_EDIT_STATUS_SUCCESS", "", "KEY_DATA", "", "KEY_JUMP_URL", "KEY_MESSAGE", "KEY_STATUS", "fromJson", "Lcom/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageAIEditResult;", "json", "Lorg/json/JSONObject;", "lib-entry-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAIEditResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageAIEditResult fromJson(JSONObject json) {
            Object obj;
            ImageAIEditResult imageAIEditResult;
            ImageAIEditResult imageAIEditResult2 = null;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                if (json != null) {
                    JSONObject $this$fromJson_u24lambda_u2d1_u24lambda_u2d0 = json;
                    int optInt = $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.optInt("status", 0);
                    String optString = $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.optString("message", "");
                    JSONObject optJSONObject = $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.optJSONObject("data");
                    String optString2 = optJSONObject != null ? optJSONObject.optString(ImageAIEditResult.KEY_JUMP_URL, "") : null;
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(KEY_MESSAGE, \"\")");
                    imageAIEditResult = new ImageAIEditResult(optInt, optString2, optString, (String) null, 8, (DefaultConstructorMarker) null);
                } else {
                    imageAIEditResult = null;
                }
                obj = Result.m8971constructorimpl(imageAIEditResult);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m8977isFailureimpl(obj)) {
                imageAIEditResult2 = obj;
            }
            return imageAIEditResult2;
        }
    }
}
