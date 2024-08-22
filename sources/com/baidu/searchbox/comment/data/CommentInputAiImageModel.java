package com.baidu.searchbox.comment.data;

import com.baidu.searchbox.video.feedflow.ubc.UBC6233;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u000fJ\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/comment/data/CommentInputAiImageModel;", "", "placeholder", "", "scheme", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "getScheme", "setScheme", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "Companion", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentInputAiImageModel.kt */
public final class CommentInputAiImageModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String placeholder;
    private String scheme;

    public CommentInputAiImageModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentInputAiImageModel copy$default(CommentInputAiImageModel commentInputAiImageModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentInputAiImageModel.placeholder;
        }
        if ((i2 & 2) != 0) {
            str2 = commentInputAiImageModel.scheme;
        }
        return commentInputAiImageModel.copy(str, str2);
    }

    @JvmStatic
    public static final CommentInputAiImageModel parse(JSONObject jSONObject) {
        return Companion.parse(jSONObject);
    }

    public final String component1() {
        return this.placeholder;
    }

    public final String component2() {
        return this.scheme;
    }

    public final CommentInputAiImageModel copy(String str, String str2) {
        return new CommentInputAiImageModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentInputAiImageModel)) {
            return false;
        }
        CommentInputAiImageModel commentInputAiImageModel = (CommentInputAiImageModel) obj;
        return Intrinsics.areEqual((Object) this.placeholder, (Object) commentInputAiImageModel.placeholder) && Intrinsics.areEqual((Object) this.scheme, (Object) commentInputAiImageModel.scheme);
    }

    public int hashCode() {
        String str = this.placeholder;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.scheme;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CommentInputAiImageModel(placeholder=" + this.placeholder + ", scheme=" + this.scheme + ')';
    }

    public CommentInputAiImageModel(String placeholder2, String scheme2) {
        this.placeholder = placeholder2;
        this.scheme = scheme2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentInputAiImageModel(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.placeholder;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        CharSequence charSequence2 = this.scheme;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/data/CommentInputAiImageModel$Companion;", "", "()V", "parse", "Lcom/baidu/searchbox/comment/data/CommentInputAiImageModel;", "data", "Lorg/json/JSONObject;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentInputAiImageModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommentInputAiImageModel parse(JSONObject data) {
            Object obj;
            CommentInputAiImageModel commentInputAiImageModel = null;
            if (data == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.m8971constructorimpl(new CommentInputAiImageModel(data.optString(UBC6233.VALUE.VALUE_HOT_PANEL_CONTENT), data.optString("activity_scheme")));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m8977isFailureimpl(obj)) {
                commentInputAiImageModel = obj;
            }
            return commentInputAiImageModel;
        }
    }
}
