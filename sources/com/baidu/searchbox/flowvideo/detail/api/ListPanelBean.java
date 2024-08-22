package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003Jy\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000eHÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R&\u0010\r\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 ¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/ListPanelBean;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "subTitle", "subTitleIcon", "subTitleIconNight", "subTitleIconLandscape", "subTitleCmd", "goodsSupportAutoPop", "", "goodsAutoPopSecond", "goodsShowTimeSecond", "list", "", "Lcom/baidu/searchbox/flowvideo/detail/api/ListPanelItemBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;)V", "getGoodsAutoPopSecond", "()I", "setGoodsAutoPopSecond", "(I)V", "getGoodsShowTimeSecond", "setGoodsShowTimeSecond", "getGoodsSupportAutoPop", "setGoodsSupportAutoPop", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getSubTitleCmd", "setSubTitleCmd", "getSubTitleIcon", "setSubTitleIcon", "getSubTitleIconLandscape", "setSubTitleIconLandscape", "getSubTitleIconNight", "setSubTitleIconNight", "getTitle", "setTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class ListPanelBean implements NoProGuard {
    private int goodsAutoPopSecond;
    private int goodsShowTimeSecond;
    private int goodsSupportAutoPop;
    private List<ListPanelItemBean<?>> list;
    private String subTitle;
    private String subTitleCmd;
    private String subTitleIcon;
    private String subTitleIconLandscape;
    private String subTitleIconNight;
    private String title;

    public ListPanelBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, (List) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ListPanelBean copy$default(ListPanelBean listPanelBean, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, List list2, int i5, Object obj) {
        ListPanelBean listPanelBean2 = listPanelBean;
        int i6 = i5;
        return listPanelBean.copy((i6 & 1) != 0 ? listPanelBean2.title : str, (i6 & 2) != 0 ? listPanelBean2.subTitle : str2, (i6 & 4) != 0 ? listPanelBean2.subTitleIcon : str3, (i6 & 8) != 0 ? listPanelBean2.subTitleIconNight : str4, (i6 & 16) != 0 ? listPanelBean2.subTitleIconLandscape : str5, (i6 & 32) != 0 ? listPanelBean2.subTitleCmd : str6, (i6 & 64) != 0 ? listPanelBean2.goodsSupportAutoPop : i2, (i6 & 128) != 0 ? listPanelBean2.goodsAutoPopSecond : i3, (i6 & 256) != 0 ? listPanelBean2.goodsShowTimeSecond : i4, (i6 & 512) != 0 ? listPanelBean2.list : list2);
    }

    public final String component1() {
        return this.title;
    }

    public final List<ListPanelItemBean<?>> component10() {
        return this.list;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.subTitleIcon;
    }

    public final String component4() {
        return this.subTitleIconNight;
    }

    public final String component5() {
        return this.subTitleIconLandscape;
    }

    public final String component6() {
        return this.subTitleCmd;
    }

    public final int component7() {
        return this.goodsSupportAutoPop;
    }

    public final int component8() {
        return this.goodsAutoPopSecond;
    }

    public final int component9() {
        return this.goodsShowTimeSecond;
    }

    public final ListPanelBean copy(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, List<ListPanelItemBean<?>> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(str3, "subTitleIcon");
        Intrinsics.checkNotNullParameter(str4, "subTitleIconNight");
        Intrinsics.checkNotNullParameter(str5, "subTitleIconLandscape");
        Intrinsics.checkNotNullParameter(str6, "subTitleCmd");
        return new ListPanelBean(str, str2, str3, str4, str5, str6, i2, i3, i4, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListPanelBean)) {
            return false;
        }
        ListPanelBean listPanelBean = (ListPanelBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) listPanelBean.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) listPanelBean.subTitle) && Intrinsics.areEqual((Object) this.subTitleIcon, (Object) listPanelBean.subTitleIcon) && Intrinsics.areEqual((Object) this.subTitleIconNight, (Object) listPanelBean.subTitleIconNight) && Intrinsics.areEqual((Object) this.subTitleIconLandscape, (Object) listPanelBean.subTitleIconLandscape) && Intrinsics.areEqual((Object) this.subTitleCmd, (Object) listPanelBean.subTitleCmd) && this.goodsSupportAutoPop == listPanelBean.goodsSupportAutoPop && this.goodsAutoPopSecond == listPanelBean.goodsAutoPopSecond && this.goodsShowTimeSecond == listPanelBean.goodsShowTimeSecond && Intrinsics.areEqual((Object) this.list, (Object) listPanelBean.list);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.subTitleIcon.hashCode()) * 31) + this.subTitleIconNight.hashCode()) * 31) + this.subTitleIconLandscape.hashCode()) * 31) + this.subTitleCmd.hashCode()) * 31) + Integer.hashCode(this.goodsSupportAutoPop)) * 31) + Integer.hashCode(this.goodsAutoPopSecond)) * 31) + Integer.hashCode(this.goodsShowTimeSecond)) * 31;
        List<ListPanelItemBean<?>> list2 = this.list;
        return hashCode + (list2 == null ? 0 : list2.hashCode());
    }

    public String toString() {
        return "ListPanelBean(title=" + this.title + ", subTitle=" + this.subTitle + ", subTitleIcon=" + this.subTitleIcon + ", subTitleIconNight=" + this.subTitleIconNight + ", subTitleIconLandscape=" + this.subTitleIconLandscape + ", subTitleCmd=" + this.subTitleCmd + ", goodsSupportAutoPop=" + this.goodsSupportAutoPop + ", goodsAutoPopSecond=" + this.goodsAutoPopSecond + ", goodsShowTimeSecond=" + this.goodsShowTimeSecond + ", list=" + this.list + ')';
    }

    public ListPanelBean(String title2, String subTitle2, String subTitleIcon2, String subTitleIconNight2, String subTitleIconLandscape2, String subTitleCmd2, int goodsSupportAutoPop2, int goodsAutoPopSecond2, int goodsShowTimeSecond2, List<ListPanelItemBean<?>> list2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(subTitle2, "subTitle");
        Intrinsics.checkNotNullParameter(subTitleIcon2, "subTitleIcon");
        Intrinsics.checkNotNullParameter(subTitleIconNight2, "subTitleIconNight");
        Intrinsics.checkNotNullParameter(subTitleIconLandscape2, "subTitleIconLandscape");
        Intrinsics.checkNotNullParameter(subTitleCmd2, "subTitleCmd");
        this.title = title2;
        this.subTitle = subTitle2;
        this.subTitleIcon = subTitleIcon2;
        this.subTitleIconNight = subTitleIconNight2;
        this.subTitleIconLandscape = subTitleIconLandscape2;
        this.subTitleCmd = subTitleCmd2;
        this.goodsSupportAutoPop = goodsSupportAutoPop2;
        this.goodsAutoPopSecond = goodsAutoPopSecond2;
        this.goodsShowTimeSecond = goodsShowTimeSecond2;
        this.list = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListPanelBean(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? "" : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? "" : str4, (i5 & 16) != 0 ? "" : str5, (i5 & 32) != 0 ? "" : str6, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? 7 : i4, (i5 & 512) != 0 ? null : list2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final String getSubTitleIcon() {
        return this.subTitleIcon;
    }

    public final void setSubTitleIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleIcon = str;
    }

    public final String getSubTitleIconNight() {
        return this.subTitleIconNight;
    }

    public final void setSubTitleIconNight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleIconNight = str;
    }

    public final String getSubTitleIconLandscape() {
        return this.subTitleIconLandscape;
    }

    public final void setSubTitleIconLandscape(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleIconLandscape = str;
    }

    public final String getSubTitleCmd() {
        return this.subTitleCmd;
    }

    public final void setSubTitleCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleCmd = str;
    }

    public final int getGoodsSupportAutoPop() {
        return this.goodsSupportAutoPop;
    }

    public final void setGoodsSupportAutoPop(int i2) {
        this.goodsSupportAutoPop = i2;
    }

    public final int getGoodsAutoPopSecond() {
        return this.goodsAutoPopSecond;
    }

    public final void setGoodsAutoPopSecond(int i2) {
        this.goodsAutoPopSecond = i2;
    }

    public final int getGoodsShowTimeSecond() {
        return this.goodsShowTimeSecond;
    }

    public final void setGoodsShowTimeSecond(int i2) {
        this.goodsShowTimeSecond = i2;
    }

    public final List<ListPanelItemBean<?>> getList() {
        return this.list;
    }

    public final void setList(List<ListPanelItemBean<?>> list2) {
        this.list = list2;
    }
}
