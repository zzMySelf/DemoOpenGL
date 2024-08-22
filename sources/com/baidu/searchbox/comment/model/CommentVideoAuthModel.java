package com.baidu.searchbox.comment.model;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u0006\u0010+\u001a\u00020'J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAuthModel;", "", "ak", "", "sk", "token", "bucket", "mediaId", "sourceBucket", "sourceKey", "host", "region", "videoApply", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getAk", "()Ljava/lang/String;", "getBucket", "getHost", "getMediaId", "getRegion", "getSk", "getSourceBucket", "getSourceKey", "getToken", "getVideoApply", "()Lorg/json/JSONObject;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentVideoAuthModel.kt */
public final class CommentVideoAuthModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String ak;
    private final String bucket;
    private final String host;
    private final String mediaId;
    private final String region;
    private final String sk;
    private final String sourceBucket;
    private final String sourceKey;
    private final String token;
    private final JSONObject videoApply;

    public CommentVideoAuthModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (JSONObject) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentVideoAuthModel copy$default(CommentVideoAuthModel commentVideoAuthModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, JSONObject jSONObject, int i2, Object obj) {
        CommentVideoAuthModel commentVideoAuthModel2 = commentVideoAuthModel;
        int i3 = i2;
        return commentVideoAuthModel.copy((i3 & 1) != 0 ? commentVideoAuthModel2.ak : str, (i3 & 2) != 0 ? commentVideoAuthModel2.sk : str2, (i3 & 4) != 0 ? commentVideoAuthModel2.token : str3, (i3 & 8) != 0 ? commentVideoAuthModel2.bucket : str4, (i3 & 16) != 0 ? commentVideoAuthModel2.mediaId : str5, (i3 & 32) != 0 ? commentVideoAuthModel2.sourceBucket : str6, (i3 & 64) != 0 ? commentVideoAuthModel2.sourceKey : str7, (i3 & 128) != 0 ? commentVideoAuthModel2.host : str8, (i3 & 256) != 0 ? commentVideoAuthModel2.region : str9, (i3 & 512) != 0 ? commentVideoAuthModel2.videoApply : jSONObject);
    }

    @JvmStatic
    public static final CommentVideoAuthModel parse(String str) {
        return Companion.parse(str);
    }

    public final String component1() {
        return this.ak;
    }

    public final JSONObject component10() {
        return this.videoApply;
    }

    public final String component2() {
        return this.sk;
    }

    public final String component3() {
        return this.token;
    }

    public final String component4() {
        return this.bucket;
    }

    public final String component5() {
        return this.mediaId;
    }

    public final String component6() {
        return this.sourceBucket;
    }

    public final String component7() {
        return this.sourceKey;
    }

    public final String component8() {
        return this.host;
    }

    public final String component9() {
        return this.region;
    }

    public final CommentVideoAuthModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, JSONObject jSONObject) {
        return new CommentVideoAuthModel(str, str2, str3, str4, str5, str6, str7, str8, str9, jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentVideoAuthModel)) {
            return false;
        }
        CommentVideoAuthModel commentVideoAuthModel = (CommentVideoAuthModel) obj;
        return Intrinsics.areEqual((Object) this.ak, (Object) commentVideoAuthModel.ak) && Intrinsics.areEqual((Object) this.sk, (Object) commentVideoAuthModel.sk) && Intrinsics.areEqual((Object) this.token, (Object) commentVideoAuthModel.token) && Intrinsics.areEqual((Object) this.bucket, (Object) commentVideoAuthModel.bucket) && Intrinsics.areEqual((Object) this.mediaId, (Object) commentVideoAuthModel.mediaId) && Intrinsics.areEqual((Object) this.sourceBucket, (Object) commentVideoAuthModel.sourceBucket) && Intrinsics.areEqual((Object) this.sourceKey, (Object) commentVideoAuthModel.sourceKey) && Intrinsics.areEqual((Object) this.host, (Object) commentVideoAuthModel.host) && Intrinsics.areEqual((Object) this.region, (Object) commentVideoAuthModel.region) && Intrinsics.areEqual((Object) this.videoApply, (Object) commentVideoAuthModel.videoApply);
    }

    public int hashCode() {
        String str = this.ak;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sk;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.token;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bucket;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mediaId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sourceBucket;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sourceKey;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.host;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.region;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        JSONObject jSONObject = this.videoApply;
        if (jSONObject != null) {
            i2 = jSONObject.hashCode();
        }
        return hashCode9 + i2;
    }

    public String toString() {
        return "CommentVideoAuthModel(ak=" + this.ak + ", sk=" + this.sk + ", token=" + this.token + ", bucket=" + this.bucket + ", mediaId=" + this.mediaId + ", sourceBucket=" + this.sourceBucket + ", sourceKey=" + this.sourceKey + ", host=" + this.host + ", region=" + this.region + ", videoApply=" + this.videoApply + ')';
    }

    public CommentVideoAuthModel(String ak2, String sk2, String token2, String bucket2, String mediaId2, String sourceBucket2, String sourceKey2, String host2, String region2, JSONObject videoApply2) {
        this.ak = ak2;
        this.sk = sk2;
        this.token = token2;
        this.bucket = bucket2;
        this.mediaId = mediaId2;
        this.sourceBucket = sourceBucket2;
        this.sourceKey = sourceKey2;
        this.host = host2;
        this.region = region2;
        this.videoApply = videoApply2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentVideoAuthModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, JSONObject jSONObject, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) != 0 ? null : jSONObject);
    }

    public final String getAk() {
        return this.ak;
    }

    public final String getSk() {
        return this.sk;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getSourceBucket() {
        return this.sourceBucket;
    }

    public final String getSourceKey() {
        return this.sourceKey;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getRegion() {
        return this.region;
    }

    public final JSONObject getVideoApply() {
        return this.videoApply;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.ak;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        CharSequence charSequence2 = this.sk;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            return false;
        }
        CharSequence charSequence3 = this.token;
        if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
            return false;
        }
        CharSequence charSequence4 = this.sourceBucket;
        if (charSequence4 == null || charSequence4.length() == 0) {
            return false;
        }
        CharSequence charSequence5 = this.sourceKey;
        if ((charSequence5 == null || charSequence5.length() == 0) || this.videoApply == null) {
            return false;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAuthModel$Companion;", "", "()V", "parse", "Lcom/baidu/searchbox/comment/model/CommentVideoAuthModel;", "json", "", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentVideoAuthModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommentVideoAuthModel parse(String json) {
            String str = json;
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                JSONObject it = new JSONObject(str).optJSONObject("data");
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "optJSONObject(\"data\")");
                    String ak = it.optString("ak");
                    String sk = it.optString("sk");
                    String token = it.optString("token");
                    JSONObject videoObject = it.optJSONObject("videoApply");
                    return new CommentVideoAuthModel(ak, sk, token, (String) null, videoObject != null ? videoObject.optString("mediaId") : null, videoObject != null ? videoObject.optString("sourceBucket") : null, videoObject != null ? videoObject.optString("sourceKey") : null, videoObject != null ? videoObject.optString("host") : null, videoObject != null ? videoObject.optString("region") : null, videoObject);
                }
                Result.m8971constructorimpl((Object) null);
                return null;
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }
}
