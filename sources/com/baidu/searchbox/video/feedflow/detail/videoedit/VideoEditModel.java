package com.baidu.searchbox.video.feedflow.detail.videoedit;

import com.baidu.searchbox.creative.scheme.CreativeSchemeDispatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/videoedit/VideoEditModel;", "", "jsonStr", "", "(Ljava/lang/String;)V", "articleType", "nid", "getNid", "()Ljava/lang/String;", "setNid", "result", "type", "component1", "copy", "equals", "", "other", "hashCode", "", "isDelete", "isEdit", "isSuccess", "isVideo", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoEditState.kt */
public final class VideoEditModel {
    private String articleType = "";
    private final String jsonStr;
    private String nid = "";
    private String result = "";
    private String type = "";

    private final String component1() {
        return this.jsonStr;
    }

    public static /* synthetic */ VideoEditModel copy$default(VideoEditModel videoEditModel, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = videoEditModel.jsonStr;
        }
        return videoEditModel.copy(str);
    }

    public final VideoEditModel copy(String str) {
        Intrinsics.checkNotNullParameter(str, "jsonStr");
        return new VideoEditModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoEditModel) && Intrinsics.areEqual((Object) this.jsonStr, (Object) ((VideoEditModel) obj).jsonStr);
    }

    public int hashCode() {
        return this.jsonStr.hashCode();
    }

    public String toString() {
        return "VideoEditModel(jsonStr=" + this.jsonStr + ')';
    }

    public VideoEditModel(String jsonStr2) {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonStr2, "jsonStr");
        this.jsonStr = jsonStr2;
        if (!StringsKt.isBlank(jsonStr2)) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m8971constructorimpl(new JSONObject(jsonStr2));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            JSONObject $this$_init__u24lambda_u2d1 = (JSONObject) (Result.m8977isFailureimpl(obj) ? null : obj);
            if ($this$_init__u24lambda_u2d1 != null) {
                String optString = $this$_init__u24lambda_u2d1.optString("type");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"type\")");
                this.type = optString;
                String optString2 = $this$_init__u24lambda_u2d1.optString("nid");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"nid\")");
                this.nid = optString2;
                String optString3 = $this$_init__u24lambda_u2d1.optString("result");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"result\")");
                this.result = optString3;
                String optString4 = $this$_init__u24lambda_u2d1.optString(CreativeSchemeDispatch.ACTION_ARTICLE_TYPE);
                Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"articleType\")");
                this.articleType = optString4;
            }
        }
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nid = str;
    }

    public final boolean isEdit() {
        return Intrinsics.areEqual((Object) this.type, (Object) "edit");
    }

    public final boolean isDelete() {
        return Intrinsics.areEqual((Object) this.type, (Object) "delete");
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual((Object) this.result, (Object) "success");
    }

    public final boolean isVideo() {
        return Intrinsics.areEqual((Object) this.articleType, (Object) "video");
    }
}
