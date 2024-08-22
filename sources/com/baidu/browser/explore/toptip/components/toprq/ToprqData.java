package com.baidu.browser.explore.toptip.components.toprq;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003JZ\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/baidu/browser/explore/toptip/components/toprq/ToprqData;", "", "list", "", "", "title", "show", "", "icon", "num", "type", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getList", "()Ljava/util/List;", "getNum", "getShow", "getTitle", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/baidu/browser/explore/toptip/components/toprq/ToprqData;", "equals", "", "other", "hashCode", "toString", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToprqData.kt */
public final class ToprqData {
    private final Integer icon;
    private final List<String> list;
    private final Integer num;
    private final Integer show;
    private final String title;
    private final String type;

    public static /* synthetic */ ToprqData copy$default(ToprqData toprqData, List<String> list2, String str, Integer num2, Integer num3, Integer num4, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list2 = toprqData.list;
        }
        if ((i2 & 2) != 0) {
            str = toprqData.title;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            num2 = toprqData.show;
        }
        Integer num5 = num2;
        if ((i2 & 8) != 0) {
            num3 = toprqData.icon;
        }
        Integer num6 = num3;
        if ((i2 & 16) != 0) {
            num4 = toprqData.num;
        }
        Integer num7 = num4;
        if ((i2 & 32) != 0) {
            str2 = toprqData.type;
        }
        return toprqData.copy(list2, str3, num5, num6, num7, str2);
    }

    public final List<String> component1() {
        return this.list;
    }

    public final String component2() {
        return this.title;
    }

    public final Integer component3() {
        return this.show;
    }

    public final Integer component4() {
        return this.icon;
    }

    public final Integer component5() {
        return this.num;
    }

    public final String component6() {
        return this.type;
    }

    public final ToprqData copy(List<String> list2, String str, Integer num2, Integer num3, Integer num4, String str2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        return new ToprqData(list2, str, num2, num3, num4, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToprqData)) {
            return false;
        }
        ToprqData toprqData = (ToprqData) obj;
        return Intrinsics.areEqual((Object) this.list, (Object) toprqData.list) && Intrinsics.areEqual((Object) this.title, (Object) toprqData.title) && Intrinsics.areEqual((Object) this.show, (Object) toprqData.show) && Intrinsics.areEqual((Object) this.icon, (Object) toprqData.icon) && Intrinsics.areEqual((Object) this.num, (Object) toprqData.num) && Intrinsics.areEqual((Object) this.type, (Object) toprqData.type);
    }

    public int hashCode() {
        int hashCode = this.list.hashCode() * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.show;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.icon;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.num;
        int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str2 = this.type;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "ToprqData(list=" + this.list + ", title=" + this.title + ", show=" + this.show + ", icon=" + this.icon + ", num=" + this.num + ", type=" + this.type + ')';
    }

    public ToprqData(List<String> list2, String title2, Integer show2, Integer icon2, Integer num2, String type2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.title = title2;
        this.show = show2;
        this.icon = icon2;
        this.num = num2;
        this.type = type2;
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getShow() {
        return this.show;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final Integer getNum() {
        return this.num;
    }

    public final String getType() {
        return this.type;
    }
}
