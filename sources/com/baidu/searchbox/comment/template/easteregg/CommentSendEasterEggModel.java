package com.baidu.searchbox.comment.template.easteregg;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J3\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/comment/template/easteregg/CommentSendEasterEggModel;", "", "isEasterEgg", "", "content", "", "isAiSubject", "isAiImage", "(ZLjava/lang/String;ZZ)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentSendEasterEggModel.kt */
public final class CommentSendEasterEggModel {
    public String content;
    public boolean isAiImage;
    public boolean isAiSubject;
    public boolean isEasterEgg;

    public CommentSendEasterEggModel() {
        this(false, (String) null, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentSendEasterEggModel copy$default(CommentSendEasterEggModel commentSendEasterEggModel, boolean z, String str, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = commentSendEasterEggModel.isEasterEgg;
        }
        if ((i2 & 2) != 0) {
            str = commentSendEasterEggModel.content;
        }
        if ((i2 & 4) != 0) {
            z2 = commentSendEasterEggModel.isAiSubject;
        }
        if ((i2 & 8) != 0) {
            z3 = commentSendEasterEggModel.isAiImage;
        }
        return commentSendEasterEggModel.copy(z, str, z2, z3);
    }

    public final boolean component1() {
        return this.isEasterEgg;
    }

    public final String component2() {
        return this.content;
    }

    public final boolean component3() {
        return this.isAiSubject;
    }

    public final boolean component4() {
        return this.isAiImage;
    }

    public final CommentSendEasterEggModel copy(boolean z, String str, boolean z2, boolean z3) {
        return new CommentSendEasterEggModel(z, str, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentSendEasterEggModel)) {
            return false;
        }
        CommentSendEasterEggModel commentSendEasterEggModel = (CommentSendEasterEggModel) obj;
        return this.isEasterEgg == commentSendEasterEggModel.isEasterEgg && Intrinsics.areEqual((Object) this.content, (Object) commentSendEasterEggModel.content) && this.isAiSubject == commentSendEasterEggModel.isAiSubject && this.isAiImage == commentSendEasterEggModel.isAiImage;
    }

    public int hashCode() {
        boolean z = this.isEasterEgg;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.content;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z3 = this.isAiSubject;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isAiImage;
        if (!z4) {
            z2 = z4;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "CommentSendEasterEggModel(isEasterEgg=" + this.isEasterEgg + ", content=" + this.content + ", isAiSubject=" + this.isAiSubject + ", isAiImage=" + this.isAiImage + ')';
    }

    public CommentSendEasterEggModel(boolean isEasterEgg2, String content2, boolean isAiSubject2, boolean isAiImage2) {
        this.isEasterEgg = isEasterEgg2;
        this.content = content2;
        this.isAiSubject = isAiSubject2;
        this.isAiImage = isAiImage2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentSendEasterEggModel(boolean z, String str, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3);
    }
}
