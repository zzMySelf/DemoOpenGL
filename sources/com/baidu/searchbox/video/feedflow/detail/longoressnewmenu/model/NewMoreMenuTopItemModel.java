package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003JI\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/model/NewMoreMenuTopItemModel;", "", "itemType", "", "icon", "title", "", "selectedIcon", "selectedTitle", "isSelected", "", "(IILjava/lang/String;ILjava/lang/String;Z)V", "getIcon", "()I", "setIcon", "(I)V", "()Z", "setSelected", "(Z)V", "getItemType", "getSelectedIcon", "setSelectedIcon", "getSelectedTitle", "()Ljava/lang/String;", "setSelectedTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressNewMorePanelModel.kt */
public final class NewMoreMenuTopItemModel {
    private int icon;
    private boolean isSelected;
    private final int itemType;
    private int selectedIcon;
    private String selectedTitle;
    private String title;

    public static /* synthetic */ NewMoreMenuTopItemModel copy$default(NewMoreMenuTopItemModel newMoreMenuTopItemModel, int i2, int i3, String str, int i4, String str2, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = newMoreMenuTopItemModel.itemType;
        }
        if ((i5 & 2) != 0) {
            i3 = newMoreMenuTopItemModel.icon;
        }
        int i6 = i3;
        if ((i5 & 4) != 0) {
            str = newMoreMenuTopItemModel.title;
        }
        String str3 = str;
        if ((i5 & 8) != 0) {
            i4 = newMoreMenuTopItemModel.selectedIcon;
        }
        int i7 = i4;
        if ((i5 & 16) != 0) {
            str2 = newMoreMenuTopItemModel.selectedTitle;
        }
        String str4 = str2;
        if ((i5 & 32) != 0) {
            z = newMoreMenuTopItemModel.isSelected;
        }
        return newMoreMenuTopItemModel.copy(i2, i6, str3, i7, str4, z);
    }

    public final int component1() {
        return this.itemType;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.selectedIcon;
    }

    public final String component5() {
        return this.selectedTitle;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final NewMoreMenuTopItemModel copy(@NewMoreItemType int i2, int i3, String str, int i4, String str2, boolean z) {
        return new NewMoreMenuTopItemModel(i2, i3, str, i4, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewMoreMenuTopItemModel)) {
            return false;
        }
        NewMoreMenuTopItemModel newMoreMenuTopItemModel = (NewMoreMenuTopItemModel) obj;
        return this.itemType == newMoreMenuTopItemModel.itemType && this.icon == newMoreMenuTopItemModel.icon && Intrinsics.areEqual((Object) this.title, (Object) newMoreMenuTopItemModel.title) && this.selectedIcon == newMoreMenuTopItemModel.selectedIcon && Intrinsics.areEqual((Object) this.selectedTitle, (Object) newMoreMenuTopItemModel.selectedTitle) && this.isSelected == newMoreMenuTopItemModel.isSelected;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.itemType) * 31) + Integer.hashCode(this.icon)) * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.selectedIcon)) * 31;
        String str2 = this.selectedTitle;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "NewMoreMenuTopItemModel(itemType=" + this.itemType + ", icon=" + this.icon + ", title=" + this.title + ", selectedIcon=" + this.selectedIcon + ", selectedTitle=" + this.selectedTitle + ", isSelected=" + this.isSelected + ')';
    }

    public NewMoreMenuTopItemModel(@NewMoreItemType int itemType2, int icon2, String title2, int selectedIcon2, String selectedTitle2, boolean isSelected2) {
        this.itemType = itemType2;
        this.icon = icon2;
        this.title = title2;
        this.selectedIcon = selectedIcon2;
        this.selectedTitle = selectedTitle2;
        this.isSelected = isSelected2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NewMoreMenuTopItemModel(int r10, int r11, java.lang.String r12, int r13, java.lang.String r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 4
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r5 = r1
            goto L_0x0008
        L_0x0007:
            r5 = r12
        L_0x0008:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x000e
            r7 = r1
            goto L_0x000f
        L_0x000e:
            r7 = r14
        L_0x000f:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0016
            r0 = 0
            r8 = r0
            goto L_0x0017
        L_0x0016:
            r8 = r15
        L_0x0017:
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model.NewMoreMenuTopItemModel.<init>(int, int, java.lang.String, int, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final void setIcon(int i2) {
        this.icon = i2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getSelectedIcon() {
        return this.selectedIcon;
    }

    public final void setSelectedIcon(int i2) {
        this.selectedIcon = i2;
    }

    public final String getSelectedTitle() {
        return this.selectedTitle;
    }

    public final void setSelectedTitle(String str) {
        this.selectedTitle = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
