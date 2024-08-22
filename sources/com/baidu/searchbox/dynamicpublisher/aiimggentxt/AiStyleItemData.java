package com.baidu.searchbox.dynamicpublisher.aiimggentxt;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/aiimggentxt/AiStyleItemData;", "Ljava/io/Serializable;", "styleName", "", "taskId", "result", "point", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPoint", "()Ljava/lang/String;", "setPoint", "(Ljava/lang/String;)V", "getResult", "setResult", "getStyleName", "getTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiStyleListData.kt */
public final class AiStyleItemData implements Serializable {
    private String point;
    private String result;
    @SerializedName("style_name")
    private final String styleName;
    @SerializedName("task_id")
    private final String taskId;

    public AiStyleItemData() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AiStyleItemData copy$default(AiStyleItemData aiStyleItemData, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aiStyleItemData.styleName;
        }
        if ((i2 & 2) != 0) {
            str2 = aiStyleItemData.taskId;
        }
        if ((i2 & 4) != 0) {
            str3 = aiStyleItemData.result;
        }
        if ((i2 & 8) != 0) {
            str4 = aiStyleItemData.point;
        }
        return aiStyleItemData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.styleName;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.result;
    }

    public final String component4() {
        return this.point;
    }

    public final AiStyleItemData copy(String str, String str2, String str3, String str4) {
        return new AiStyleItemData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiStyleItemData)) {
            return false;
        }
        AiStyleItemData aiStyleItemData = (AiStyleItemData) obj;
        return Intrinsics.areEqual((Object) this.styleName, (Object) aiStyleItemData.styleName) && Intrinsics.areEqual((Object) this.taskId, (Object) aiStyleItemData.taskId) && Intrinsics.areEqual((Object) this.result, (Object) aiStyleItemData.result) && Intrinsics.areEqual((Object) this.point, (Object) aiStyleItemData.point);
    }

    public int hashCode() {
        String str = this.styleName;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.taskId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.result;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.point;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "AiStyleItemData(styleName=" + this.styleName + ", taskId=" + this.taskId + ", result=" + this.result + ", point=" + this.point + ')';
    }

    public AiStyleItemData(String styleName2, String taskId2, String result2, String point2) {
        this.styleName = styleName2;
        this.taskId = taskId2;
        this.result = result2;
        this.point = point2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AiStyleItemData(String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getStyleName() {
        return this.styleName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final String getPoint() {
        return this.point;
    }

    public final void setPoint(String str) {
        this.point = str;
    }
}
