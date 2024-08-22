package com.baidu.searchbox.aisearch.comps.input.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/input/model/RhetoricalTagModel;", "", "tagId", "", "tagText", "tagStyle", "Lorg/json/JSONArray;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)V", "getTagId", "()Ljava/lang/String;", "getTagStyle", "()Lorg/json/JSONArray;", "getTagText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RhetoricalModel.kt */
public final class RhetoricalTagModel {
    private final String tagId;
    private final JSONArray tagStyle;
    private final String tagText;

    public static /* synthetic */ RhetoricalTagModel copy$default(RhetoricalTagModel rhetoricalTagModel, String str, String str2, JSONArray jSONArray, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rhetoricalTagModel.tagId;
        }
        if ((i2 & 2) != 0) {
            str2 = rhetoricalTagModel.tagText;
        }
        if ((i2 & 4) != 0) {
            jSONArray = rhetoricalTagModel.tagStyle;
        }
        return rhetoricalTagModel.copy(str, str2, jSONArray);
    }

    public final String component1() {
        return this.tagId;
    }

    public final String component2() {
        return this.tagText;
    }

    public final JSONArray component3() {
        return this.tagStyle;
    }

    public final RhetoricalTagModel copy(String str, String str2, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(str, "tagId");
        Intrinsics.checkNotNullParameter(str2, "tagText");
        return new RhetoricalTagModel(str, str2, jSONArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RhetoricalTagModel)) {
            return false;
        }
        RhetoricalTagModel rhetoricalTagModel = (RhetoricalTagModel) obj;
        return Intrinsics.areEqual((Object) this.tagId, (Object) rhetoricalTagModel.tagId) && Intrinsics.areEqual((Object) this.tagText, (Object) rhetoricalTagModel.tagText) && Intrinsics.areEqual((Object) this.tagStyle, (Object) rhetoricalTagModel.tagStyle);
    }

    public int hashCode() {
        int hashCode = ((this.tagId.hashCode() * 31) + this.tagText.hashCode()) * 31;
        JSONArray jSONArray = this.tagStyle;
        return hashCode + (jSONArray == null ? 0 : jSONArray.hashCode());
    }

    public String toString() {
        return "RhetoricalTagModel(tagId=" + this.tagId + ", tagText=" + this.tagText + ", tagStyle=" + this.tagStyle + ')';
    }

    public RhetoricalTagModel(String tagId2, String tagText2, JSONArray tagStyle2) {
        Intrinsics.checkNotNullParameter(tagId2, "tagId");
        Intrinsics.checkNotNullParameter(tagText2, "tagText");
        this.tagId = tagId2;
        this.tagText = tagText2;
        this.tagStyle = tagStyle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RhetoricalTagModel(String str, String str2, JSONArray jSONArray, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : jSONArray);
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final JSONArray getTagStyle() {
        return this.tagStyle;
    }
}
