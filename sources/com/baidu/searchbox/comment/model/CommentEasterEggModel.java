package com.baidu.searchbox.comment.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentEasterEggModel;", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "easterEggId", "", "getEasterEggId", "()Ljava/lang/String;", "setEasterEggId", "(Ljava/lang/String;)V", "easterEggPicUrl", "getEasterEggPicUrl", "setEasterEggPicUrl", "height", "getHeight", "setHeight", "width", "getWidth", "setWidth", "isNull", "", "isValid", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentEasterEggModel.kt */
public final class CommentEasterEggModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final JSONObject data;
    private String easterEggId;
    private String easterEggPicUrl;
    private String height;
    private String width;

    public CommentEasterEggModel() {
        this((JSONObject) null, 1, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final CommentEasterEggModel json2Model(String str) {
        return Companion.json2Model(str);
    }

    @JvmStatic
    public static final CommentEasterEggModel jsonObject2Modle(JSONObject jSONObject) {
        return Companion.jsonObject2Modle(jSONObject);
    }

    @JvmStatic
    public static final JSONObject model2JsonObject(CommentEasterEggModel commentEasterEggModel) {
        return Companion.model2JsonObject(commentEasterEggModel);
    }

    @JvmStatic
    public static final String model2String(CommentEasterEggModel commentEasterEggModel) {
        return Companion.model2String(commentEasterEggModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CommentEasterEggModel(org.json.JSONObject r5) {
        /*
            r4 = this;
            r4.<init>()
            r4.data = r5
            if (r5 == 0) goto L_0x003e
            r0 = r5
            r1 = 0
            java.lang.String r2 = "pic"
            org.json.JSONObject r2 = r0.optJSONObject(r2)
            if (r2 != 0) goto L_0x0014
            goto L_0x003e
        L_0x0014:
            java.lang.String r3 = "pic ?: return@let"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = "url"
            java.lang.String r3 = r2.optString(r3)
            r4.easterEggPicUrl = r3
            java.lang.String r3 = "width"
            java.lang.String r3 = r2.optString(r3)
            r4.width = r3
            java.lang.String r3 = "height"
            java.lang.String r3 = r2.optString(r3)
            r4.height = r3
            java.lang.String r3 = "egg_id"
            java.lang.String r3 = r0.optString(r3)
            r4.easterEggId = r3
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.model.CommentEasterEggModel.<init>(org.json.JSONObject):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentEasterEggModel(JSONObject jSONObject, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : jSONObject);
    }

    public final String getWidth() {
        return this.width;
    }

    public final void setWidth(String str) {
        this.width = str;
    }

    public final String getHeight() {
        return this.height;
    }

    public final void setHeight(String str) {
        this.height = str;
    }

    public final String getEasterEggPicUrl() {
        return this.easterEggPicUrl;
    }

    public final void setEasterEggPicUrl(String str) {
        this.easterEggPicUrl = str;
    }

    public final String getEasterEggId() {
        return this.easterEggId;
    }

    public final void setEasterEggId(String str) {
        this.easterEggId = str;
    }

    public final boolean isNull() {
        return this.data == null;
    }

    public final boolean isValid() {
        if (!TextUtils.isEmpty(this.easterEggPicUrl)) {
            CharSequence charSequence = this.width;
            if (!(charSequence == null || charSequence.length() == 0)) {
                CharSequence charSequence2 = this.height;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    CharSequence charSequence3 = this.easterEggId;
                    if (!(charSequence3 == null || charSequence3.length() == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentEasterEggModel$Companion;", "", "()V", "json2Model", "Lcom/baidu/searchbox/comment/model/CommentEasterEggModel;", "jsonString", "", "jsonObject2Modle", "jsonObject", "Lorg/json/JSONObject;", "model2JsonObject", "model", "model2String", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentEasterEggModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommentEasterEggModel json2Model(String jsonString) {
            Object obj;
            CommentEasterEggModel commentEasterEggModel = null;
            if (jsonString != null) {
                String str = jsonString;
                Companion $this$json2Model_u24lambda_u2d1_u24lambda_u2d0 = CommentEasterEggModel.Companion;
                try {
                    Result.Companion companion = Result.Companion;
                    commentEasterEggModel = $this$json2Model_u24lambda_u2d1_u24lambda_u2d0.jsonObject2Modle(new JSONObject(jsonString));
                    obj = Result.m8971constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                Result.m8970boximpl(obj);
            }
            return commentEasterEggModel;
        }

        @JvmStatic
        public final CommentEasterEggModel jsonObject2Modle(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            CommentEasterEggModel commentEasterEggModel = new CommentEasterEggModel((JSONObject) null, 1, (DefaultConstructorMarker) null);
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                commentEasterEggModel.setEasterEggId(jsonObject.optString("id"));
                commentEasterEggModel.setEasterEggPicUrl(jsonObject.optString("url"));
                commentEasterEggModel.setWidth(jsonObject.optString("width"));
                commentEasterEggModel.setHeight(jsonObject.optString("height"));
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            return commentEasterEggModel;
        }

        @JvmStatic
        public final String model2String(CommentEasterEggModel model) {
            JSONObject json;
            if (model == null || (json = model2JsonObject(model)) == null) {
                return null;
            }
            return json.toString();
        }

        @JvmStatic
        public final JSONObject model2JsonObject(CommentEasterEggModel model) {
            Object obj;
            if (model == null) {
                return null;
            }
            JSONObject json = new JSONObject();
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                json.put("id", model.getEasterEggId());
                json.put("url", model.getEasterEggPicUrl());
                json.put("width", model.getWidth());
                obj = Result.m8971constructorimpl(json.put("height", model.getHeight()));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r2 = Result.m8974exceptionOrNullimpl(obj);
            if (r2 != null) {
                Throwable th3 = r2;
                obj = json;
            }
            return (JSONObject) obj;
        }
    }
}
