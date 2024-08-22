package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/IntelligentRecommendModel;", "Lcom/baidu/searchbox/NoProGuard;", "switch", "", "style", "", "icon", "prefix", "expandDelaySeconds", "", "priority", "", "items", "", "Lcom/baidu/searchbox/flowvideo/detail/repos/IntelligentRecommendItemModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/util/List;)V", "getExpandDelaySeconds", "()J", "getIcon", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getPrefix", "getPriority", "()I", "getStyle", "getSwitch", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "isBottomShow", "isCanShowBannerIntelligent", "isCanShowCelebrityRecognition", "isHasIntelligentData", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class IntelligentRecommendModel implements NoProGuard {
    private final long expandDelaySeconds;
    private final String icon;
    private final List<IntelligentRecommendItemModel> items;
    private final String prefix;
    private final int priority;
    private final String style;

    /* renamed from: switch  reason: not valid java name */
    private final boolean f1138switch;

    public IntelligentRecommendModel() {
        this(false, (String) null, (String) null, (String) null, 0, 0, (List) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IntelligentRecommendModel copy$default(IntelligentRecommendModel intelligentRecommendModel, boolean z, String str, String str2, String str3, long j2, int i2, List list, int i3, Object obj) {
        IntelligentRecommendModel intelligentRecommendModel2 = intelligentRecommendModel;
        return intelligentRecommendModel.copy((i3 & 1) != 0 ? intelligentRecommendModel2.f1138switch : z, (i3 & 2) != 0 ? intelligentRecommendModel2.style : str, (i3 & 4) != 0 ? intelligentRecommendModel2.icon : str2, (i3 & 8) != 0 ? intelligentRecommendModel2.prefix : str3, (i3 & 16) != 0 ? intelligentRecommendModel2.expandDelaySeconds : j2, (i3 & 32) != 0 ? intelligentRecommendModel2.priority : i2, (i3 & 64) != 0 ? intelligentRecommendModel2.items : list);
    }

    public final boolean component1() {
        return this.f1138switch;
    }

    public final String component2() {
        return this.style;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.prefix;
    }

    public final long component5() {
        return this.expandDelaySeconds;
    }

    public final int component6() {
        return this.priority;
    }

    public final List<IntelligentRecommendItemModel> component7() {
        return this.items;
    }

    public final IntelligentRecommendModel copy(boolean z, String str, String str2, String str3, long j2, int i2, List<IntelligentRecommendItemModel> list) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str, "style");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(str3, "prefix");
        return new IntelligentRecommendModel(z, str, str2, str3, j2, i2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntelligentRecommendModel)) {
            return false;
        }
        IntelligentRecommendModel intelligentRecommendModel = (IntelligentRecommendModel) obj;
        return this.f1138switch == intelligentRecommendModel.f1138switch && Intrinsics.areEqual((Object) this.style, (Object) intelligentRecommendModel.style) && Intrinsics.areEqual((Object) this.icon, (Object) intelligentRecommendModel.icon) && Intrinsics.areEqual((Object) this.prefix, (Object) intelligentRecommendModel.prefix) && this.expandDelaySeconds == intelligentRecommendModel.expandDelaySeconds && this.priority == intelligentRecommendModel.priority && Intrinsics.areEqual((Object) this.items, (Object) intelligentRecommendModel.items);
    }

    public int hashCode() {
        boolean z = this.f1138switch;
        if (z) {
            z = true;
        }
        int hashCode = (((((((((((z ? 1 : 0) * true) + this.style.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.prefix.hashCode()) * 31) + Long.hashCode(this.expandDelaySeconds)) * 31) + Integer.hashCode(this.priority)) * 31;
        List<IntelligentRecommendItemModel> list = this.items;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "IntelligentRecommendModel(switch=" + this.f1138switch + ", style=" + this.style + ", icon=" + this.icon + ", prefix=" + this.prefix + ", expandDelaySeconds=" + this.expandDelaySeconds + ", priority=" + this.priority + ", items=" + this.items + ')';
    }

    public IntelligentRecommendModel(boolean z, String style2, String icon2, String prefix2, long expandDelaySeconds2, int priority2, List<IntelligentRecommendItemModel> items2) {
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(prefix2, "prefix");
        this.f1138switch = z;
        this.style = style2;
        this.icon = icon2;
        this.prefix = prefix2;
        this.expandDelaySeconds = expandDelaySeconds2;
        this.priority = priority2;
        this.items = items2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntelligentRecommendModel(boolean z, String str, String str2, String str3, long j2, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? 0 : j2, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? null : list);
    }

    public final boolean getSwitch() {
        return this.f1138switch;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final long getExpandDelaySeconds() {
        return this.expandDelaySeconds;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final List<IntelligentRecommendItemModel> getItems() {
        return this.items;
    }

    public final boolean isBottomShow() {
        return Intrinsics.areEqual((Object) this.style, (Object) "2");
    }

    public final boolean isCanShowBannerIntelligent() {
        return this.priority == 1 && !isBottomShow();
    }

    public final boolean isHasIntelligentData() {
        if (this.f1138switch) {
            List<IntelligentRecommendItemModel> list = this.items;
            if (BdPlayerUtils.orZero(list != null ? Integer.valueOf(list.size()) : null) > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCanShowCelebrityRecognition() {
        return this.priority == 2;
    }
}
