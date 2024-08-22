package com.baidu.searchbox.widget.aiwidget.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/widget/aiwidget/model/AiWidgetCardClickModel;", "", "id", "", "count", "", "lastClickTime", "", "(Ljava/lang/String;IJ)V", "getCount", "()I", "getId", "()Ljava/lang/String;", "getLastClickTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiWidgetCardClickModel.kt */
public final class AiWidgetCardClickModel {
    private final int count;
    private final String id;
    private final long lastClickTime;

    public static /* synthetic */ AiWidgetCardClickModel copy$default(AiWidgetCardClickModel aiWidgetCardClickModel, String str, int i2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aiWidgetCardClickModel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = aiWidgetCardClickModel.count;
        }
        if ((i3 & 4) != 0) {
            j2 = aiWidgetCardClickModel.lastClickTime;
        }
        return aiWidgetCardClickModel.copy(str, i2, j2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.count;
    }

    public final long component3() {
        return this.lastClickTime;
    }

    public final AiWidgetCardClickModel copy(String str, int i2, long j2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new AiWidgetCardClickModel(str, i2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiWidgetCardClickModel)) {
            return false;
        }
        AiWidgetCardClickModel aiWidgetCardClickModel = (AiWidgetCardClickModel) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) aiWidgetCardClickModel.id) && this.count == aiWidgetCardClickModel.count && this.lastClickTime == aiWidgetCardClickModel.lastClickTime;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Long.hashCode(this.lastClickTime);
    }

    public String toString() {
        return "AiWidgetCardClickModel(id=" + this.id + ", count=" + this.count + ", lastClickTime=" + this.lastClickTime + ')';
    }

    public AiWidgetCardClickModel(String id2, int count2, long lastClickTime2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
        this.count = count2;
        this.lastClickTime = lastClickTime2;
    }

    public final String getId() {
        return this.id;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getLastClickTime() {
        return this.lastClickTime;
    }
}
