package com.baidu.searchbox.feed.widget.browseonly;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/BrowseGuideItemData;", "", "title", "", "icon", "iconSelected", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getIconSelected", "setIconSelected", "()Z", "setChecked", "(Z)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBrowseGuideData.kt */
public final class BrowseGuideItemData {
    private String icon;
    private String iconSelected;
    private boolean isChecked;
    private String title;

    public static /* synthetic */ BrowseGuideItemData copy$default(BrowseGuideItemData browseGuideItemData, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = browseGuideItemData.title;
        }
        if ((i2 & 2) != 0) {
            str2 = browseGuideItemData.icon;
        }
        if ((i2 & 4) != 0) {
            str3 = browseGuideItemData.iconSelected;
        }
        if ((i2 & 8) != 0) {
            z = browseGuideItemData.isChecked;
        }
        return browseGuideItemData.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.iconSelected;
    }

    public final boolean component4() {
        return this.isChecked;
    }

    public final BrowseGuideItemData copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(str3, "iconSelected");
        return new BrowseGuideItemData(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowseGuideItemData)) {
            return false;
        }
        BrowseGuideItemData browseGuideItemData = (BrowseGuideItemData) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) browseGuideItemData.title) && Intrinsics.areEqual((Object) this.icon, (Object) browseGuideItemData.icon) && Intrinsics.areEqual((Object) this.iconSelected, (Object) browseGuideItemData.iconSelected) && this.isChecked == browseGuideItemData.isChecked;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.iconSelected.hashCode()) * 31;
        boolean z = this.isChecked;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "BrowseGuideItemData(title=" + this.title + ", icon=" + this.icon + ", iconSelected=" + this.iconSelected + ", isChecked=" + this.isChecked + ')';
    }

    public BrowseGuideItemData(String title2, String icon2, String iconSelected2, boolean isChecked2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(iconSelected2, "iconSelected");
        this.title = title2;
        this.icon = icon2;
        this.iconSelected = iconSelected2;
        this.isChecked = isChecked2;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getIconSelected() {
        return this.iconSelected;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setIconSelected(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconSelected = str;
    }
}
