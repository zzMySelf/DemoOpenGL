package com.baidu.chatsearch.aisearch.resultpage.rhetorical;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/chatsearch/aisearch/resultpage/rhetorical/RhetoricalTagModel;", "", "tagText", "", "tagId", "tagStyle", "Lcom/baidu/chatsearch/aisearch/resultpage/rhetorical/RhetoricalModelTagStyle;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/chatsearch/aisearch/resultpage/rhetorical/RhetoricalModelTagStyle;)V", "getTagId", "()Ljava/lang/String;", "getTagStyle", "()Lcom/baidu/chatsearch/aisearch/resultpage/rhetorical/RhetoricalModelTagStyle;", "getTagText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RhetoricalModel.kt */
public final class RhetoricalTagModel {
    private final String tagId;
    private final RhetoricalModelTagStyle tagStyle;
    private final String tagText;

    public RhetoricalTagModel() {
        this((String) null, (String) null, (RhetoricalModelTagStyle) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RhetoricalTagModel copy$default(RhetoricalTagModel rhetoricalTagModel, String str, String str2, RhetoricalModelTagStyle rhetoricalModelTagStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rhetoricalTagModel.tagText;
        }
        if ((i2 & 2) != 0) {
            str2 = rhetoricalTagModel.tagId;
        }
        if ((i2 & 4) != 0) {
            rhetoricalModelTagStyle = rhetoricalTagModel.tagStyle;
        }
        return rhetoricalTagModel.copy(str, str2, rhetoricalModelTagStyle);
    }

    public final String component1() {
        return this.tagText;
    }

    public final String component2() {
        return this.tagId;
    }

    public final RhetoricalModelTagStyle component3() {
        return this.tagStyle;
    }

    public final RhetoricalTagModel copy(String str, String str2, RhetoricalModelTagStyle rhetoricalModelTagStyle) {
        return new RhetoricalTagModel(str, str2, rhetoricalModelTagStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RhetoricalTagModel)) {
            return false;
        }
        RhetoricalTagModel rhetoricalTagModel = (RhetoricalTagModel) obj;
        return Intrinsics.areEqual((Object) this.tagText, (Object) rhetoricalTagModel.tagText) && Intrinsics.areEqual((Object) this.tagId, (Object) rhetoricalTagModel.tagId) && Intrinsics.areEqual((Object) this.tagStyle, (Object) rhetoricalTagModel.tagStyle);
    }

    public int hashCode() {
        String str = this.tagText;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tagId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        RhetoricalModelTagStyle rhetoricalModelTagStyle = this.tagStyle;
        if (rhetoricalModelTagStyle != null) {
            i2 = rhetoricalModelTagStyle.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "RhetoricalTagModel(tagText=" + this.tagText + ", tagId=" + this.tagId + ", tagStyle=" + this.tagStyle + ')';
    }

    public RhetoricalTagModel(String tagText2, String tagId2, RhetoricalModelTagStyle tagStyle2) {
        this.tagText = tagText2;
        this.tagId = tagId2;
        this.tagStyle = tagStyle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RhetoricalTagModel(String str, String str2, RhetoricalModelTagStyle rhetoricalModelTagStyle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : rhetoricalModelTagStyle);
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final RhetoricalModelTagStyle getTagStyle() {
        return this.tagStyle;
    }
}
