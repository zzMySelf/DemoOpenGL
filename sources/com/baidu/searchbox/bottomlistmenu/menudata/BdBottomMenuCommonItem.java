package com.baidu.searchbox.bottomlistmenu.menudata;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/bottomlistmenu/menudata/BdBottomMenuCommonItem;", "Lcom/baidu/searchbox/bottomlistmenu/menudata/BdBottomMenuBaseData;", "menuId", "", "title", "", "enabled", "", "(ILjava/lang/String;Z)V", "isBuildinItem", "()Z", "setBuildinItem", "(Z)V", "isHideItem", "setHideItem", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "lib-bottomlistmenu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdBottomMenuCommonItem.kt */
public class BdBottomMenuCommonItem extends BdBottomMenuBaseData {
    @StableApi
    private boolean isBuildinItem;
    private boolean isHideItem;
    private String title;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BdBottomMenuCommonItem(int i2, String str, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, (i3 & 4) != 0 ? true : z);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BdBottomMenuCommonItem(int menuId, String title2, boolean enabled) {
        super(menuId, enabled);
        Intrinsics.checkNotNullParameter(title2, "title");
        this.title = title2;
    }

    public final boolean isBuildinItem() {
        return this.isBuildinItem;
    }

    public final void setBuildinItem(boolean z) {
        this.isBuildinItem = z;
    }

    public final boolean isHideItem() {
        return this.isHideItem;
    }

    public final void setHideItem(boolean z) {
        this.isHideItem = z;
    }
}
