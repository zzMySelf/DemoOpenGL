package com.baidu.searchbox.comment.model;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 !2\u00020\u0001:\u0001!BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0006\u0010\u001f\u001a\u00020\tJ\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentPictureBrowseModel;", "", "tip", "", "avatarList", "", "btnText", "scheme", "showAvatar", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getAvatarList", "()Ljava/util/List;", "getBtnText", "()Ljava/lang/String;", "getScheme", "getShowAvatar", "()Z", "setShowAvatar", "(Z)V", "getTip", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "isValid", "toString", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentPictureBrowseModel.kt */
public final class CommentPictureBrowseModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<String> avatarList;
    private final String btnText;
    private final String scheme;
    private boolean showAvatar;
    private final String tip;

    public CommentPictureBrowseModel() {
        this((String) null, (List) null, (String) null, (String) null, false, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentPictureBrowseModel copy$default(CommentPictureBrowseModel commentPictureBrowseModel, String str, List<String> list, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentPictureBrowseModel.tip;
        }
        if ((i2 & 2) != 0) {
            list = commentPictureBrowseModel.avatarList;
        }
        List<String> list2 = list;
        if ((i2 & 4) != 0) {
            str2 = commentPictureBrowseModel.btnText;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = commentPictureBrowseModel.scheme;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            z = commentPictureBrowseModel.showAvatar;
        }
        return commentPictureBrowseModel.copy(str, list2, str4, str5, z);
    }

    @JvmStatic
    public static final CommentPictureBrowseModel parse(JSONObject jSONObject) {
        return Companion.parse(jSONObject);
    }

    public final String component1() {
        return this.tip;
    }

    public final List<String> component2() {
        return this.avatarList;
    }

    public final String component3() {
        return this.btnText;
    }

    public final String component4() {
        return this.scheme;
    }

    public final boolean component5() {
        return this.showAvatar;
    }

    public final CommentPictureBrowseModel copy(String str, List<String> list, String str2, String str3, boolean z) {
        return new CommentPictureBrowseModel(str, list, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentPictureBrowseModel)) {
            return false;
        }
        CommentPictureBrowseModel commentPictureBrowseModel = (CommentPictureBrowseModel) obj;
        return Intrinsics.areEqual((Object) this.tip, (Object) commentPictureBrowseModel.tip) && Intrinsics.areEqual((Object) this.avatarList, (Object) commentPictureBrowseModel.avatarList) && Intrinsics.areEqual((Object) this.btnText, (Object) commentPictureBrowseModel.btnText) && Intrinsics.areEqual((Object) this.scheme, (Object) commentPictureBrowseModel.scheme) && this.showAvatar == commentPictureBrowseModel.showAvatar;
    }

    public int hashCode() {
        String str = this.tip;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.avatarList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.btnText;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scheme;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.showAvatar;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "CommentPictureBrowseModel(tip=" + this.tip + ", avatarList=" + this.avatarList + ", btnText=" + this.btnText + ", scheme=" + this.scheme + ", showAvatar=" + this.showAvatar + ')';
    }

    public CommentPictureBrowseModel(String tip2, List<String> avatarList2, String btnText2, String scheme2, boolean showAvatar2) {
        this.tip = tip2;
        this.avatarList = avatarList2;
        this.btnText = btnText2;
        this.scheme = scheme2;
        this.showAvatar = showAvatar2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentPictureBrowseModel(String str, List list, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? true : z);
    }

    public final String getTip() {
        return this.tip;
    }

    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final void setShowAvatar(boolean z) {
        this.showAvatar = z;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.tip;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        CharSequence charSequence2 = this.btnText;
        if (charSequence2 == null || charSequence2.length() == 0) {
            return false;
        }
        Collection collection = this.avatarList;
        if (!(collection == null || collection.isEmpty())) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentPictureBrowseModel$Companion;", "", "()V", "parse", "Lcom/baidu/searchbox/comment/model/CommentPictureBrowseModel;", "data", "Lorg/json/JSONObject;", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentPictureBrowseModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ all -> 0x0074 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.baidu.searchbox.comment.model.CommentPictureBrowseModel parse(org.json.JSONObject r17) {
            /*
                r16 = this;
                r1 = r17
                r2 = 0
                if (r1 != 0) goto L_0x0006
                return r2
            L_0x0006:
                kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0074 }
                r0 = r16
                com.baidu.searchbox.comment.model.CommentPictureBrowseModel$Companion r0 = (com.baidu.searchbox.comment.model.CommentPictureBrowseModel.Companion) r0     // Catch:{ all -> 0x0074 }
                r3 = 0
                java.lang.String r4 = "ai_image_conf"
                org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ all -> 0x0074 }
                if (r4 != 0) goto L_0x001c
                java.lang.String r4 = "pic_easter_egg"
                org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ all -> 0x0074 }
            L_0x001c:
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0074 }
                r5.<init>()     // Catch:{ all -> 0x0074 }
                java.lang.String r6 = "tip"
                java.lang.String r8 = r4.optString(r6)     // Catch:{ all -> 0x0074 }
                java.lang.String r6 = "button_content"
                java.lang.String r10 = r4.optString(r6)     // Catch:{ all -> 0x0074 }
                java.lang.String r6 = "activity_scheme"
                java.lang.String r11 = r4.optString(r6)     // Catch:{ all -> 0x0074 }
                java.lang.String r6 = "avatar_list"
                org.json.JSONArray r6 = r4.optJSONArray(r6)     // Catch:{ all -> 0x0074 }
                if (r6 == 0) goto L_0x0062
                r7 = 0
                int r9 = r6.length()     // Catch:{ all -> 0x0074 }
            L_0x0041:
                if (r7 >= r9) goto L_0x0062
                java.lang.String r12 = r6.optString(r7)     // Catch:{ all -> 0x0074 }
                r13 = r12
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ all -> 0x0074 }
                if (r13 == 0) goto L_0x0055
                int r13 = r13.length()     // Catch:{ all -> 0x0074 }
                if (r13 != 0) goto L_0x0053
                goto L_0x0055
            L_0x0053:
                r13 = 0
                goto L_0x0056
            L_0x0055:
                r13 = 1
            L_0x0056:
                if (r13 != 0) goto L_0x005f
                java.lang.String r13 = r6.optString(r7)     // Catch:{ all -> 0x0074 }
                r5.add(r13)     // Catch:{ all -> 0x0074 }
            L_0x005f:
                int r7 = r7 + 1
                goto L_0x0041
            L_0x0062:
                com.baidu.searchbox.comment.model.CommentPictureBrowseModel r15 = new com.baidu.searchbox.comment.model.CommentPictureBrowseModel     // Catch:{ all -> 0x0074 }
                r9 = r5
                java.util.List r9 = (java.util.List) r9     // Catch:{ all -> 0x0074 }
                r12 = 0
                r13 = 16
                r14 = 0
                r7 = r15
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0074 }
                java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r15)     // Catch:{ all -> 0x0074 }
                goto L_0x007f
            L_0x0074:
                r0 = move-exception
                kotlin.Result$Companion r3 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
            L_0x007f:
                boolean r3 = kotlin.Result.m8977isFailureimpl(r0)
                if (r3 == 0) goto L_0x0086
                goto L_0x0087
            L_0x0086:
                r2 = r0
            L_0x0087:
                com.baidu.searchbox.comment.model.CommentPictureBrowseModel r2 = (com.baidu.searchbox.comment.model.CommentPictureBrowseModel) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.model.CommentPictureBrowseModel.Companion.parse(org.json.JSONObject):com.baidu.searchbox.comment.model.CommentPictureBrowseModel");
        }
    }
}
