package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.video.feedflow.component.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0011HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010W\u001a\u00020\u000bHÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u000bHÆ\u0003J\t\u0010[\u001a\u00020\u001aHÆ\u0003J\t\u0010\\\u001a\u00020\u000bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u000bHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jß\u0001\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010g\u001a\u00020\u000b2\b\u0010h\u001a\u0004\u0018\u00010iHÖ\u0003J\u0006\u0010j\u001a\u00020\u0003J\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\u000bJ\u0006\u0010o\u001a\u00020lJ\u000e\u0010p\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\u000bJ\t\u0010q\u001a\u00020\u0003HÖ\u0001J\t\u0010r\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010)\"\u0004\b,\u0010+R\u001a\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010)\"\u0004\b-\u0010+R\u001a\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010)\"\u0004\b.\u0010+R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010\"¨\u0006s"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "pos", "", "id", "", "titleName", "rnInfo", "Lcom/baidu/searchbox/video/feedflow/tab/RnInfoModel;", "pageType", "selected", "", "layout", "extInfo", "redDot", "Lcom/baidu/searchbox/video/feedflow/tab/RedDotModel;", "subModel", "", "logExt", "h5Info", "Lcom/baidu/searchbox/video/feedflow/tab/H5InfoModel;", "isImmersive", "selectedImmersive", "isSecondaryPanelShowing", "isSecondaryPanelImmerse", "tabStyle", "Lcom/baidu/searchbox/video/feedflow/tab/TabStyleModel;", "isLastTab", "newTip", "Lcom/baidu/searchbox/video/feedflow/tab/NewTipModel;", "(ILjava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/tab/RnInfoModel;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/tab/RedDotModel;Ljava/util/List;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/tab/H5InfoModel;ZZZZLcom/baidu/searchbox/video/feedflow/tab/TabStyleModel;ZLcom/baidu/searchbox/video/feedflow/tab/NewTipModel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getH5Info", "()Lcom/baidu/searchbox/video/feedflow/tab/H5InfoModel;", "setH5Info", "(Lcom/baidu/searchbox/video/feedflow/tab/H5InfoModel;)V", "getId", "setId", "()Z", "setImmersive", "(Z)V", "setLastTab", "setSecondaryPanelImmerse", "setSecondaryPanelShowing", "getLayout", "setLayout", "getLogExt", "setLogExt", "getNewTip", "()Lcom/baidu/searchbox/video/feedflow/tab/NewTipModel;", "setNewTip", "(Lcom/baidu/searchbox/video/feedflow/tab/NewTipModel;)V", "getPageType", "setPageType", "getPos", "()I", "setPos", "(I)V", "getRedDot", "()Lcom/baidu/searchbox/video/feedflow/tab/RedDotModel;", "setRedDot", "(Lcom/baidu/searchbox/video/feedflow/tab/RedDotModel;)V", "getRnInfo", "()Lcom/baidu/searchbox/video/feedflow/tab/RnInfoModel;", "setRnInfo", "(Lcom/baidu/searchbox/video/feedflow/tab/RnInfoModel;)V", "getSelected", "setSelected", "getSelectedImmersive", "setSelectedImmersive", "getSubModel", "()Ljava/util/List;", "setSubModel", "(Ljava/util/List;)V", "getTabStyle", "()Lcom/baidu/searchbox/video/feedflow/tab/TabStyleModel;", "setTabStyle", "(Lcom/baidu/searchbox/video/feedflow/tab/TabStyleModel;)V", "getTitleName", "setTitleName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getCurExpandIconView", "getCurTabStyle", "Lcom/baidu/searchbox/video/feedflow/tab/TabStyleConfigModel;", "getIndicatorConfigColor", "isNightMode", "getPreferredTabStyle", "getStatusBarConfigTheme", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabInfoModel.kt */
public final class TabInfoModel implements NoProGuard {
    private String extInfo;
    private H5InfoModel h5Info;
    private String id;
    private boolean isImmersive;
    private boolean isLastTab;
    private boolean isSecondaryPanelImmerse;
    private boolean isSecondaryPanelShowing;
    private String layout;
    private String logExt;
    private NewTipModel newTip;
    private String pageType;
    private int pos;
    private RedDotModel redDot;
    private RnInfoModel rnInfo;
    private boolean selected;
    private boolean selectedImmersive;
    private List<TabInfoModel> subModel;
    private TabStyleModel tabStyle;
    private String titleName;

    public static /* synthetic */ TabInfoModel copy$default(TabInfoModel tabInfoModel, int i2, String str, String str2, RnInfoModel rnInfoModel, String str3, boolean z, String str4, String str5, RedDotModel redDotModel, List list, String str6, H5InfoModel h5InfoModel, boolean z2, boolean z3, boolean z4, boolean z5, TabStyleModel tabStyleModel, boolean z6, NewTipModel newTipModel, int i3, Object obj) {
        TabInfoModel tabInfoModel2 = tabInfoModel;
        int i4 = i3;
        return tabInfoModel.copy((i4 & 1) != 0 ? tabInfoModel2.pos : i2, (i4 & 2) != 0 ? tabInfoModel2.id : str, (i4 & 4) != 0 ? tabInfoModel2.titleName : str2, (i4 & 8) != 0 ? tabInfoModel2.rnInfo : rnInfoModel, (i4 & 16) != 0 ? tabInfoModel2.pageType : str3, (i4 & 32) != 0 ? tabInfoModel2.selected : z, (i4 & 64) != 0 ? tabInfoModel2.layout : str4, (i4 & 128) != 0 ? tabInfoModel2.extInfo : str5, (i4 & 256) != 0 ? tabInfoModel2.redDot : redDotModel, (i4 & 512) != 0 ? tabInfoModel2.subModel : list, (i4 & 1024) != 0 ? tabInfoModel2.logExt : str6, (i4 & 2048) != 0 ? tabInfoModel2.h5Info : h5InfoModel, (i4 & 4096) != 0 ? tabInfoModel2.isImmersive : z2, (i4 & 8192) != 0 ? tabInfoModel2.selectedImmersive : z3, (i4 & 16384) != 0 ? tabInfoModel2.isSecondaryPanelShowing : z4, (i4 & 32768) != 0 ? tabInfoModel2.isSecondaryPanelImmerse : z5, (i4 & 65536) != 0 ? tabInfoModel2.tabStyle : tabStyleModel, (i4 & 131072) != 0 ? tabInfoModel2.isLastTab : z6, (i4 & 262144) != 0 ? tabInfoModel2.newTip : newTipModel);
    }

    public final int component1() {
        return this.pos;
    }

    public final List<TabInfoModel> component10() {
        return this.subModel;
    }

    public final String component11() {
        return this.logExt;
    }

    public final H5InfoModel component12() {
        return this.h5Info;
    }

    public final boolean component13() {
        return this.isImmersive;
    }

    public final boolean component14() {
        return this.selectedImmersive;
    }

    public final boolean component15() {
        return this.isSecondaryPanelShowing;
    }

    public final boolean component16() {
        return this.isSecondaryPanelImmerse;
    }

    public final TabStyleModel component17() {
        return this.tabStyle;
    }

    public final boolean component18() {
        return this.isLastTab;
    }

    public final NewTipModel component19() {
        return this.newTip;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.titleName;
    }

    public final RnInfoModel component4() {
        return this.rnInfo;
    }

    public final String component5() {
        return this.pageType;
    }

    public final boolean component6() {
        return this.selected;
    }

    public final String component7() {
        return this.layout;
    }

    public final String component8() {
        return this.extInfo;
    }

    public final RedDotModel component9() {
        return this.redDot;
    }

    public final TabInfoModel copy(int i2, String str, String str2, RnInfoModel rnInfoModel, String str3, boolean z, String str4, String str5, RedDotModel redDotModel, List<TabInfoModel> list, String str6, H5InfoModel h5InfoModel, boolean z2, boolean z3, boolean z4, boolean z5, TabStyleModel tabStyleModel, boolean z6, NewTipModel newTipModel) {
        Intrinsics.checkNotNullParameter(str2, "titleName");
        Intrinsics.checkNotNullParameter(str3, "pageType");
        Intrinsics.checkNotNullParameter(tabStyleModel, "tabStyle");
        return new TabInfoModel(i2, str, str2, rnInfoModel, str3, z, str4, str5, redDotModel, list, str6, h5InfoModel, z2, z3, z4, z5, tabStyleModel, z6, newTipModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabInfoModel)) {
            return false;
        }
        TabInfoModel tabInfoModel = (TabInfoModel) obj;
        return this.pos == tabInfoModel.pos && Intrinsics.areEqual((Object) this.id, (Object) tabInfoModel.id) && Intrinsics.areEqual((Object) this.titleName, (Object) tabInfoModel.titleName) && Intrinsics.areEqual((Object) this.rnInfo, (Object) tabInfoModel.rnInfo) && Intrinsics.areEqual((Object) this.pageType, (Object) tabInfoModel.pageType) && this.selected == tabInfoModel.selected && Intrinsics.areEqual((Object) this.layout, (Object) tabInfoModel.layout) && Intrinsics.areEqual((Object) this.extInfo, (Object) tabInfoModel.extInfo) && Intrinsics.areEqual((Object) this.redDot, (Object) tabInfoModel.redDot) && Intrinsics.areEqual((Object) this.subModel, (Object) tabInfoModel.subModel) && Intrinsics.areEqual((Object) this.logExt, (Object) tabInfoModel.logExt) && Intrinsics.areEqual((Object) this.h5Info, (Object) tabInfoModel.h5Info) && this.isImmersive == tabInfoModel.isImmersive && this.selectedImmersive == tabInfoModel.selectedImmersive && this.isSecondaryPanelShowing == tabInfoModel.isSecondaryPanelShowing && this.isSecondaryPanelImmerse == tabInfoModel.isSecondaryPanelImmerse && Intrinsics.areEqual((Object) this.tabStyle, (Object) tabInfoModel.tabStyle) && this.isLastTab == tabInfoModel.isLastTab && Intrinsics.areEqual((Object) this.newTip, (Object) tabInfoModel.newTip);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.pos) * 31;
        String str = this.id;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.titleName.hashCode()) * 31;
        RnInfoModel rnInfoModel = this.rnInfo;
        int hashCode3 = (((hashCode2 + (rnInfoModel == null ? 0 : rnInfoModel.hashCode())) * 31) + this.pageType.hashCode()) * 31;
        boolean z = this.selected;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str2 = this.layout;
        int hashCode4 = (i3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.extInfo;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        RedDotModel redDotModel = this.redDot;
        int hashCode6 = (hashCode5 + (redDotModel == null ? 0 : redDotModel.hashCode())) * 31;
        List<TabInfoModel> list = this.subModel;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.logExt;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        H5InfoModel h5InfoModel = this.h5Info;
        int hashCode9 = (hashCode8 + (h5InfoModel == null ? 0 : h5InfoModel.hashCode())) * 31;
        boolean z3 = this.isImmersive;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode9 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.selectedImmersive;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isSecondaryPanelShowing;
        if (z5) {
            z5 = true;
        }
        int i6 = (i5 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isSecondaryPanelImmerse;
        if (z6) {
            z6 = true;
        }
        int hashCode10 = (((i6 + (z6 ? 1 : 0)) * 31) + this.tabStyle.hashCode()) * 31;
        boolean z7 = this.isLastTab;
        if (!z7) {
            z2 = z7;
        }
        int i7 = (hashCode10 + (z2 ? 1 : 0)) * 31;
        NewTipModel newTipModel = this.newTip;
        if (newTipModel != null) {
            i2 = newTipModel.hashCode();
        }
        return i7 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TabInfoModel(pos=").append(this.pos).append(", id=").append(this.id).append(", titleName=").append(this.titleName).append(", rnInfo=").append(this.rnInfo).append(", pageType=").append(this.pageType).append(", selected=").append(this.selected).append(", layout=").append(this.layout).append(", extInfo=").append(this.extInfo).append(", redDot=").append(this.redDot).append(", subModel=").append(this.subModel).append(", logExt=").append(this.logExt).append(", h5Info=");
        sb.append(this.h5Info).append(", isImmersive=").append(this.isImmersive).append(", selectedImmersive=").append(this.selectedImmersive).append(", isSecondaryPanelShowing=").append(this.isSecondaryPanelShowing).append(", isSecondaryPanelImmerse=").append(this.isSecondaryPanelImmerse).append(", tabStyle=").append(this.tabStyle).append(", isLastTab=").append(this.isLastTab).append(", newTip=").append(this.newTip).append(')');
        return sb.toString();
    }

    public TabInfoModel(int pos2, String id2, String titleName2, RnInfoModel rnInfo2, String pageType2, boolean selected2, String layout2, String extInfo2, RedDotModel redDot2, List<TabInfoModel> subModel2, String logExt2, H5InfoModel h5Info2, boolean isImmersive2, boolean selectedImmersive2, boolean isSecondaryPanelShowing2, boolean isSecondaryPanelImmerse2, TabStyleModel tabStyle2, boolean isLastTab2, NewTipModel newTip2) {
        String str = titleName2;
        String str2 = pageType2;
        TabStyleModel tabStyleModel = tabStyle2;
        Intrinsics.checkNotNullParameter(str, "titleName");
        Intrinsics.checkNotNullParameter(str2, "pageType");
        Intrinsics.checkNotNullParameter(tabStyleModel, "tabStyle");
        this.pos = pos2;
        this.id = id2;
        this.titleName = str;
        this.rnInfo = rnInfo2;
        this.pageType = str2;
        this.selected = selected2;
        this.layout = layout2;
        this.extInfo = extInfo2;
        this.redDot = redDot2;
        this.subModel = subModel2;
        this.logExt = logExt2;
        this.h5Info = h5Info2;
        this.isImmersive = isImmersive2;
        this.selectedImmersive = selectedImmersive2;
        this.isSecondaryPanelShowing = isSecondaryPanelShowing2;
        this.isSecondaryPanelImmerse = isSecondaryPanelImmerse2;
        this.tabStyle = tabStyleModel;
        this.isLastTab = isLastTab2;
        this.newTip = newTip2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TabInfoModel(int r54, java.lang.String r55, java.lang.String r56, com.baidu.searchbox.video.feedflow.tab.RnInfoModel r57, java.lang.String r58, boolean r59, java.lang.String r60, java.lang.String r61, com.baidu.searchbox.video.feedflow.tab.RedDotModel r62, java.util.List r63, java.lang.String r64, com.baidu.searchbox.video.feedflow.tab.H5InfoModel r65, boolean r66, boolean r67, boolean r68, boolean r69, com.baidu.searchbox.video.feedflow.tab.TabStyleModel r70, boolean r71, com.baidu.searchbox.video.feedflow.tab.NewTipModel r72, int r73, kotlin.jvm.internal.DefaultConstructorMarker r74) {
        /*
            r53 = this;
            r0 = r73
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r55
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r57
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = ""
            r8 = r1
            goto L_0x001d
        L_0x001b:
            r8 = r58
        L_0x001d:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L_0x0024
            r9 = r3
            goto L_0x0026
        L_0x0024:
            r9 = r59
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002c
            r10 = r2
            goto L_0x002e
        L_0x002c:
            r10 = r60
        L_0x002e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0034
            r11 = r2
            goto L_0x0036
        L_0x0034:
            r11 = r61
        L_0x0036:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003c
            r12 = r2
            goto L_0x003e
        L_0x003c:
            r12 = r62
        L_0x003e:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0044
            r13 = r2
            goto L_0x0046
        L_0x0044:
            r13 = r63
        L_0x0046:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004c
            r14 = r2
            goto L_0x004e
        L_0x004c:
            r14 = r64
        L_0x004e:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0054
            r15 = r2
            goto L_0x0056
        L_0x0054:
            r15 = r65
        L_0x0056:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005d
            r16 = r3
            goto L_0x005f
        L_0x005d:
            r16 = r66
        L_0x005f:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0066
            r17 = r3
            goto L_0x0068
        L_0x0066:
            r17 = r67
        L_0x0068:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x006f
            r18 = r3
            goto L_0x0071
        L_0x006f:
            r18 = r68
        L_0x0071:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007a
            r19 = r3
            goto L_0x007c
        L_0x007a:
            r19 = r69
        L_0x007c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ca
            com.baidu.searchbox.video.feedflow.tab.TabStyleModel r1 = new com.baidu.searchbox.video.feedflow.tab.TabStyleModel
            r20 = r1
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 1073741823(0x3fffffff, float:1.9999999)
            r52 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            goto L_0x00cc
        L_0x00ca:
            r20 = r70
        L_0x00cc:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d4
            r21 = r3
            goto L_0x00d6
        L_0x00d4:
            r21 = r71
        L_0x00d6:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00de
            r22 = r2
            goto L_0x00e0
        L_0x00de:
            r22 = r72
        L_0x00e0:
            r3 = r53
            r4 = r54
            r6 = r56
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.TabInfoModel.<init>(int, java.lang.String, java.lang.String, com.baidu.searchbox.video.feedflow.tab.RnInfoModel, java.lang.String, boolean, java.lang.String, java.lang.String, com.baidu.searchbox.video.feedflow.tab.RedDotModel, java.util.List, java.lang.String, com.baidu.searchbox.video.feedflow.tab.H5InfoModel, boolean, boolean, boolean, boolean, com.baidu.searchbox.video.feedflow.tab.TabStyleModel, boolean, com.baidu.searchbox.video.feedflow.tab.NewTipModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getPos() {
        return this.pos;
    }

    public final void setPos(int i2) {
        this.pos = i2;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final void setTitleName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleName = str;
    }

    public final RnInfoModel getRnInfo() {
        return this.rnInfo;
    }

    public final void setRnInfo(RnInfoModel rnInfoModel) {
        this.rnInfo = rnInfoModel;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setPageType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageType = str;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final void setLayout(String str) {
        this.layout = str;
    }

    public final String getExtInfo() {
        return this.extInfo;
    }

    public final void setExtInfo(String str) {
        this.extInfo = str;
    }

    public final RedDotModel getRedDot() {
        return this.redDot;
    }

    public final void setRedDot(RedDotModel redDotModel) {
        this.redDot = redDotModel;
    }

    public final List<TabInfoModel> getSubModel() {
        return this.subModel;
    }

    public final void setSubModel(List<TabInfoModel> list) {
        this.subModel = list;
    }

    public final String getLogExt() {
        return this.logExt;
    }

    public final void setLogExt(String str) {
        this.logExt = str;
    }

    public final H5InfoModel getH5Info() {
        return this.h5Info;
    }

    public final void setH5Info(H5InfoModel h5InfoModel) {
        this.h5Info = h5InfoModel;
    }

    public final boolean isImmersive() {
        return this.isImmersive;
    }

    public final void setImmersive(boolean z) {
        this.isImmersive = z;
    }

    public final boolean getSelectedImmersive() {
        return this.selectedImmersive;
    }

    public final void setSelectedImmersive(boolean z) {
        this.selectedImmersive = z;
    }

    public final boolean isSecondaryPanelShowing() {
        return this.isSecondaryPanelShowing;
    }

    public final void setSecondaryPanelShowing(boolean z) {
        this.isSecondaryPanelShowing = z;
    }

    public final boolean isSecondaryPanelImmerse() {
        return this.isSecondaryPanelImmerse;
    }

    public final void setSecondaryPanelImmerse(boolean z) {
        this.isSecondaryPanelImmerse = z;
    }

    public final TabStyleModel getTabStyle() {
        return this.tabStyle;
    }

    public final void setTabStyle(TabStyleModel tabStyleModel) {
        Intrinsics.checkNotNullParameter(tabStyleModel, "<set-?>");
        this.tabStyle = tabStyleModel;
    }

    public final boolean isLastTab() {
        return this.isLastTab;
    }

    public final void setLastTab(boolean z) {
        this.isLastTab = z;
    }

    public final NewTipModel getNewTip() {
        return this.newTip;
    }

    public final void setNewTip(NewTipModel newTipModel) {
        this.newTip = newTipModel;
    }

    public final TabStyleConfigModel getCurTabStyle() {
        if (Intrinsics.areEqual((Object) this.tabStyle.getCurTheme(), (Object) "light")) {
            return this.tabStyle.getLightConfig();
        }
        return this.tabStyle.getDarkConfig();
    }

    public final TabStyleConfigModel getPreferredTabStyle() {
        if (Intrinsics.areEqual((Object) this.tabStyle.getPreferredTheme(), (Object) "light")) {
            return this.tabStyle.getLightConfig();
        }
        return this.tabStyle.getDarkConfig();
    }

    public final int getCurExpandIconView() {
        if (Intrinsics.areEqual((Object) this.tabStyle.getCurTheme(), (Object) "dark")) {
            return R.drawable.video_flow_tab_secondary_expand_icon;
        }
        if (NightModeHelper.isNightMode()) {
            return R.drawable.video_flow_tab_secondary_expand_icon_night;
        }
        return R.drawable.video_flow_tab_secondary_expand_icon_light;
    }

    public final String getIndicatorConfigColor(boolean isNightMode) {
        if (isNightMode) {
            return this.tabStyle.getIndicatorNightColor();
        }
        return this.tabStyle.getIndicatorLightColor();
    }

    public final String getStatusBarConfigTheme(boolean isNightMode) {
        if (isNightMode) {
            return this.tabStyle.getStatusBarNightTheme();
        }
        return this.tabStyle.getStatusBarLightTheme();
    }
}
