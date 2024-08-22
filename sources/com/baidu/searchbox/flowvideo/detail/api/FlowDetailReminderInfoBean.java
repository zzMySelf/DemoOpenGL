package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/FlowDetailReminderInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "userIcons", "", "", "reminderCmd", "tipText", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getReminderCmd", "()Ljava/lang/String;", "setReminderCmd", "(Ljava/lang/String;)V", "getTipText", "setTipText", "getUserIcons", "()Ljava/util/List;", "setUserIcons", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class FlowDetailReminderInfoBean implements NoProGuard {
    private String reminderCmd;
    private String tipText;
    private List<String> userIcons;

    public FlowDetailReminderInfoBean() {
        this((List) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailReminderInfoBean copy$default(FlowDetailReminderInfoBean flowDetailReminderInfoBean, List<String> list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = flowDetailReminderInfoBean.userIcons;
        }
        if ((i2 & 2) != 0) {
            str = flowDetailReminderInfoBean.reminderCmd;
        }
        if ((i2 & 4) != 0) {
            str2 = flowDetailReminderInfoBean.tipText;
        }
        return flowDetailReminderInfoBean.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.userIcons;
    }

    public final String component2() {
        return this.reminderCmd;
    }

    public final String component3() {
        return this.tipText;
    }

    public final FlowDetailReminderInfoBean copy(List<String> list, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "reminderCmd");
        Intrinsics.checkNotNullParameter(str2, "tipText");
        return new FlowDetailReminderInfoBean(list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailReminderInfoBean)) {
            return false;
        }
        FlowDetailReminderInfoBean flowDetailReminderInfoBean = (FlowDetailReminderInfoBean) obj;
        return Intrinsics.areEqual((Object) this.userIcons, (Object) flowDetailReminderInfoBean.userIcons) && Intrinsics.areEqual((Object) this.reminderCmd, (Object) flowDetailReminderInfoBean.reminderCmd) && Intrinsics.areEqual((Object) this.tipText, (Object) flowDetailReminderInfoBean.tipText);
    }

    public int hashCode() {
        List<String> list = this.userIcons;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.reminderCmd.hashCode()) * 31) + this.tipText.hashCode();
    }

    public String toString() {
        return "FlowDetailReminderInfoBean(userIcons=" + this.userIcons + ", reminderCmd=" + this.reminderCmd + ", tipText=" + this.tipText + ')';
    }

    public FlowDetailReminderInfoBean(List<String> userIcons2, String reminderCmd2, String tipText2) {
        Intrinsics.checkNotNullParameter(reminderCmd2, "reminderCmd");
        Intrinsics.checkNotNullParameter(tipText2, "tipText");
        this.userIcons = userIcons2;
        this.reminderCmd = reminderCmd2;
        this.tipText = tipText2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowDetailReminderInfoBean(List list, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    public final List<String> getUserIcons() {
        return this.userIcons;
    }

    public final void setUserIcons(List<String> list) {
        this.userIcons = list;
    }

    public final String getReminderCmd() {
        return this.reminderCmd;
    }

    public final void setReminderCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reminderCmd = str;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final void setTipText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tipText = str;
    }
}
