package com.baidu.searchbox.comment.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoInfoModel;", "", "path", "", "cover", "duration", "", "draft", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getCover", "()Ljava/lang/String;", "getDraft", "getDuration", "()J", "getPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentVideoInfoModel.kt */
public final class CommentVideoInfoModel {
    private final String cover;
    private final String draft;
    private final long duration;
    private final String path;

    public CommentVideoInfoModel() {
        this((String) null, (String) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentVideoInfoModel copy$default(CommentVideoInfoModel commentVideoInfoModel, String str, String str2, long j2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentVideoInfoModel.path;
        }
        if ((i2 & 2) != 0) {
            str2 = commentVideoInfoModel.cover;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            j2 = commentVideoInfoModel.duration;
        }
        long j3 = j2;
        if ((i2 & 8) != 0) {
            str3 = commentVideoInfoModel.draft;
        }
        return commentVideoInfoModel.copy(str, str4, j3, str3);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.cover;
    }

    public final long component3() {
        return this.duration;
    }

    public final String component4() {
        return this.draft;
    }

    public final CommentVideoInfoModel copy(String str, String str2, long j2, String str3) {
        return new CommentVideoInfoModel(str, str2, j2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentVideoInfoModel)) {
            return false;
        }
        CommentVideoInfoModel commentVideoInfoModel = (CommentVideoInfoModel) obj;
        return Intrinsics.areEqual((Object) this.path, (Object) commentVideoInfoModel.path) && Intrinsics.areEqual((Object) this.cover, (Object) commentVideoInfoModel.cover) && this.duration == commentVideoInfoModel.duration && Intrinsics.areEqual((Object) this.draft, (Object) commentVideoInfoModel.draft);
    }

    public int hashCode() {
        String str = this.path;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cover;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.duration)) * 31;
        String str3 = this.draft;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "CommentVideoInfoModel(path=" + this.path + ", cover=" + this.cover + ", duration=" + this.duration + ", draft=" + this.draft + ')';
    }

    public CommentVideoInfoModel(String path2, String cover2, long duration2, String draft2) {
        this.path = path2;
        this.cover = cover2;
        this.duration = duration2;
        this.draft = draft2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentVideoInfoModel(String str, String str2, long j2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 0 : j2, (i2 & 8) != 0 ? null : str3);
    }

    public final String getPath() {
        return this.path;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getDraft() {
        return this.draft;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.path;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        CharSequence charSequence2 = this.cover;
        return !(charSequence2 == null || StringsKt.isBlank(charSequence2)) && this.duration > 0;
    }
}
