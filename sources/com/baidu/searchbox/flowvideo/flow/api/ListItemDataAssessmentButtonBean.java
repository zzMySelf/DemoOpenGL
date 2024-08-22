package com.baidu.searchbox.flowvideo.flow.api;

import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003Ji\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011¨\u00061"}, d2 = {"Lcom/baidu/searchbox/flowvideo/flow/api/ListItemDataAssessmentButtonBean;", "Lcom/baidu/searchbox/NoProGuard;", "rank", "", "icon", "", "text", "subText", "subDescription", "subButtonText", "", "submitBtnText", "backBtnText", "multiSelect", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getBackBtnText", "()Ljava/lang/String;", "setBackBtnText", "(Ljava/lang/String;)V", "getIcon", "getMultiSelect", "()Z", "setMultiSelect", "(Z)V", "getRank", "()I", "getSubButtonText", "()Ljava/util/List;", "getSubDescription", "getSubText", "getSubmitBtnText", "setSubmitBtnText", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowListBean.kt */
public final class ListItemDataAssessmentButtonBean implements NoProGuard {
    private String backBtnText;
    private final String icon;
    private boolean multiSelect;
    private final int rank;
    private final List<String> subButtonText;
    private final String subDescription;
    private final String subText;
    private String submitBtnText;
    private final String text;

    public ListItemDataAssessmentButtonBean() {
        this(0, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, false, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ListItemDataAssessmentButtonBean copy$default(ListItemDataAssessmentButtonBean listItemDataAssessmentButtonBean, int i2, String str, String str2, String str3, String str4, List list, String str5, String str6, boolean z, int i3, Object obj) {
        ListItemDataAssessmentButtonBean listItemDataAssessmentButtonBean2 = listItemDataAssessmentButtonBean;
        int i4 = i3;
        return listItemDataAssessmentButtonBean.copy((i4 & 1) != 0 ? listItemDataAssessmentButtonBean2.rank : i2, (i4 & 2) != 0 ? listItemDataAssessmentButtonBean2.icon : str, (i4 & 4) != 0 ? listItemDataAssessmentButtonBean2.text : str2, (i4 & 8) != 0 ? listItemDataAssessmentButtonBean2.subText : str3, (i4 & 16) != 0 ? listItemDataAssessmentButtonBean2.subDescription : str4, (i4 & 32) != 0 ? listItemDataAssessmentButtonBean2.subButtonText : list, (i4 & 64) != 0 ? listItemDataAssessmentButtonBean2.submitBtnText : str5, (i4 & 128) != 0 ? listItemDataAssessmentButtonBean2.backBtnText : str6, (i4 & 256) != 0 ? listItemDataAssessmentButtonBean2.multiSelect : z);
    }

    public final int component1() {
        return this.rank;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.subText;
    }

    public final String component5() {
        return this.subDescription;
    }

    public final List<String> component6() {
        return this.subButtonText;
    }

    public final String component7() {
        return this.submitBtnText;
    }

    public final String component8() {
        return this.backBtnText;
    }

    public final boolean component9() {
        return this.multiSelect;
    }

    public final ListItemDataAssessmentButtonBean copy(int i2, String str, String str2, String str3, String str4, List<String> list, String str5, String str6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, "subText");
        Intrinsics.checkNotNullParameter(str4, "subDescription");
        Intrinsics.checkNotNullParameter(list, "subButtonText");
        Intrinsics.checkNotNullParameter(str5, "submitBtnText");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, "backBtnText");
        return new ListItemDataAssessmentButtonBean(i2, str, str2, str3, str4, list, str5, str7, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItemDataAssessmentButtonBean)) {
            return false;
        }
        ListItemDataAssessmentButtonBean listItemDataAssessmentButtonBean = (ListItemDataAssessmentButtonBean) obj;
        return this.rank == listItemDataAssessmentButtonBean.rank && Intrinsics.areEqual((Object) this.icon, (Object) listItemDataAssessmentButtonBean.icon) && Intrinsics.areEqual((Object) this.text, (Object) listItemDataAssessmentButtonBean.text) && Intrinsics.areEqual((Object) this.subText, (Object) listItemDataAssessmentButtonBean.subText) && Intrinsics.areEqual((Object) this.subDescription, (Object) listItemDataAssessmentButtonBean.subDescription) && Intrinsics.areEqual((Object) this.subButtonText, (Object) listItemDataAssessmentButtonBean.subButtonText) && Intrinsics.areEqual((Object) this.submitBtnText, (Object) listItemDataAssessmentButtonBean.submitBtnText) && Intrinsics.areEqual((Object) this.backBtnText, (Object) listItemDataAssessmentButtonBean.backBtnText) && this.multiSelect == listItemDataAssessmentButtonBean.multiSelect;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((Integer.hashCode(this.rank) * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31) + this.subText.hashCode()) * 31) + this.subDescription.hashCode()) * 31) + this.subButtonText.hashCode()) * 31) + this.submitBtnText.hashCode()) * 31) + this.backBtnText.hashCode()) * 31;
        boolean z = this.multiSelect;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ListItemDataAssessmentButtonBean(rank=" + this.rank + ", icon=" + this.icon + ", text=" + this.text + ", subText=" + this.subText + ", subDescription=" + this.subDescription + ", subButtonText=" + this.subButtonText + ", submitBtnText=" + this.submitBtnText + ", backBtnText=" + this.backBtnText + ", multiSelect=" + this.multiSelect + ')';
    }

    public ListItemDataAssessmentButtonBean(int rank2, String icon2, String text2, String subText2, String subDescription2, List<String> subButtonText2, String submitBtnText2, String backBtnText2, boolean multiSelect2) {
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(subText2, "subText");
        Intrinsics.checkNotNullParameter(subDescription2, "subDescription");
        Intrinsics.checkNotNullParameter(subButtonText2, "subButtonText");
        Intrinsics.checkNotNullParameter(submitBtnText2, "submitBtnText");
        Intrinsics.checkNotNullParameter(backBtnText2, "backBtnText");
        this.rank = rank2;
        this.icon = icon2;
        this.text = text2;
        this.subText = subText2;
        this.subDescription = subDescription2;
        this.subButtonText = subButtonText2;
        this.submitBtnText = submitBtnText2;
        this.backBtnText = backBtnText2;
        this.multiSelect = multiSelect2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListItemDataAssessmentButtonBean(int i2, String str, String str2, String str3, String str4, List list, String str5, String str6, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? new ArrayList() : list, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? false : z);
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getSubDescription() {
        return this.subDescription;
    }

    public final List<String> getSubButtonText() {
        return this.subButtonText;
    }

    public final String getSubmitBtnText() {
        return this.submitBtnText;
    }

    public final void setSubmitBtnText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.submitBtnText = str;
    }

    public final String getBackBtnText() {
        return this.backBtnText;
    }

    public final void setBackBtnText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backBtnText = str;
    }

    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final void setMultiSelect(boolean z) {
        this.multiSelect = z;
    }
}
