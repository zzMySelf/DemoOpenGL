package com.baidu.searchbox.ugc.grouppanel.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jw\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00102\u001a\u00020\u00152\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\u0006\u00106\u001a\u00020\u0015J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00068"}, d2 = {"Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "", "id", "", "name", "subTitle", "icon", "tag", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupContentTag;", "selectedTabKey", "tabs", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTabModel;", "Lkotlin/collections/ArrayList;", "titleConfig", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTitleConfigModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/grouppanel/model/GroupContentTag;Ljava/lang/String;Ljava/util/ArrayList;Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTitleConfigModel;)V", "getIcon", "()Ljava/lang/String;", "getId", "isSelected", "", "()Z", "setSelected", "(Z)V", "getName", "selectedTab", "getSelectedTab", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTabModel;", "setSelectedTab", "(Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTabModel;)V", "getSelectedTabKey", "setSelectedTabKey", "(Ljava/lang/String;)V", "getSubTitle", "getTabs", "()Ljava/util/ArrayList;", "getTag", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupContentTag;", "getTitleConfig", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupTitleConfigModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "isValid", "toString", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupListModel.kt */
public final class GroupListContentModel {
    private final String icon;
    private final String id;
    private boolean isSelected;
    private final String name;
    private GroupTabModel selectedTab;
    private String selectedTabKey;
    private final String subTitle;
    private final ArrayList<GroupTabModel> tabs;
    private final GroupContentTag tag;
    private final GroupTitleConfigModel titleConfig;

    public static /* synthetic */ GroupListContentModel copy$default(GroupListContentModel groupListContentModel, String str, String str2, String str3, String str4, GroupContentTag groupContentTag, String str5, ArrayList arrayList, GroupTitleConfigModel groupTitleConfigModel, int i2, Object obj) {
        GroupListContentModel groupListContentModel2 = groupListContentModel;
        int i3 = i2;
        return groupListContentModel.copy((i3 & 1) != 0 ? groupListContentModel2.id : str, (i3 & 2) != 0 ? groupListContentModel2.name : str2, (i3 & 4) != 0 ? groupListContentModel2.subTitle : str3, (i3 & 8) != 0 ? groupListContentModel2.icon : str4, (i3 & 16) != 0 ? groupListContentModel2.tag : groupContentTag, (i3 & 32) != 0 ? groupListContentModel2.selectedTabKey : str5, (i3 & 64) != 0 ? groupListContentModel2.tabs : arrayList, (i3 & 128) != 0 ? groupListContentModel2.titleConfig : groupTitleConfigModel);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.subTitle;
    }

    public final String component4() {
        return this.icon;
    }

    public final GroupContentTag component5() {
        return this.tag;
    }

    public final String component6() {
        return this.selectedTabKey;
    }

    public final ArrayList<GroupTabModel> component7() {
        return this.tabs;
    }

    public final GroupTitleConfigModel component8() {
        return this.titleConfig;
    }

    public final GroupListContentModel copy(String str, String str2, String str3, String str4, GroupContentTag groupContentTag, String str5, ArrayList<GroupTabModel> arrayList, GroupTitleConfigModel groupTitleConfigModel) {
        Intrinsics.checkNotNullParameter(arrayList, "tabs");
        return new GroupListContentModel(str, str2, str3, str4, groupContentTag, str5, arrayList, groupTitleConfigModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupListContentModel)) {
            return false;
        }
        GroupListContentModel groupListContentModel = (GroupListContentModel) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) groupListContentModel.id) && Intrinsics.areEqual((Object) this.name, (Object) groupListContentModel.name) && Intrinsics.areEqual((Object) this.subTitle, (Object) groupListContentModel.subTitle) && Intrinsics.areEqual((Object) this.icon, (Object) groupListContentModel.icon) && Intrinsics.areEqual((Object) this.tag, (Object) groupListContentModel.tag) && Intrinsics.areEqual((Object) this.selectedTabKey, (Object) groupListContentModel.selectedTabKey) && Intrinsics.areEqual((Object) this.tabs, (Object) groupListContentModel.tabs) && Intrinsics.areEqual((Object) this.titleConfig, (Object) groupListContentModel.titleConfig);
    }

    public int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        GroupContentTag groupContentTag = this.tag;
        int hashCode5 = (hashCode4 + (groupContentTag == null ? 0 : groupContentTag.hashCode())) * 31;
        String str5 = this.selectedTabKey;
        int hashCode6 = (((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.tabs.hashCode()) * 31;
        GroupTitleConfigModel groupTitleConfigModel = this.titleConfig;
        if (groupTitleConfigModel != null) {
            i2 = groupTitleConfigModel.hashCode();
        }
        return hashCode6 + i2;
    }

    public String toString() {
        return "GroupListContentModel(id=" + this.id + ", name=" + this.name + ", subTitle=" + this.subTitle + ", icon=" + this.icon + ", tag=" + this.tag + ", selectedTabKey=" + this.selectedTabKey + ", tabs=" + this.tabs + ", titleConfig=" + this.titleConfig + ')';
    }

    public GroupListContentModel(String id2, String name2, String subTitle2, String icon2, GroupContentTag tag2, String selectedTabKey2, ArrayList<GroupTabModel> tabs2, GroupTitleConfigModel titleConfig2) {
        Intrinsics.checkNotNullParameter(tabs2, "tabs");
        this.id = id2;
        this.name = name2;
        this.subTitle = subTitle2;
        this.icon = icon2;
        this.tag = tag2;
        this.selectedTabKey = selectedTabKey2;
        this.tabs = tabs2;
        this.titleConfig = titleConfig2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GroupListContentModel(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.baidu.searchbox.ugc.grouppanel.model.GroupContentTag r17, java.lang.String r18, java.util.ArrayList r19, com.baidu.searchbox.ugc.grouppanel.model.GroupTitleConfigModel r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r16
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0011
            r8 = r2
            goto L_0x0013
        L_0x0011:
            r8 = r17
        L_0x0013:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0019
            r9 = r2
            goto L_0x001b
        L_0x0019:
            r9 = r18
        L_0x001b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0026
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r10 = r1
            goto L_0x0028
        L_0x0026:
            r10 = r19
        L_0x0028:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002e
            r11 = r2
            goto L_0x0030
        L_0x002e:
            r11 = r20
        L_0x0030:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ugc.grouppanel.model.GroupListContentModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.ugc.grouppanel.model.GroupContentTag, java.lang.String, java.util.ArrayList, com.baidu.searchbox.ugc.grouppanel.model.GroupTitleConfigModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final GroupContentTag getTag() {
        return this.tag;
    }

    public final String getSelectedTabKey() {
        return this.selectedTabKey;
    }

    public final void setSelectedTabKey(String str) {
        this.selectedTabKey = str;
    }

    public final ArrayList<GroupTabModel> getTabs() {
        return this.tabs;
    }

    public final GroupTitleConfigModel getTitleConfig() {
        return this.titleConfig;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final GroupTabModel getSelectedTab() {
        return this.selectedTab;
    }

    public final void setSelectedTab(GroupTabModel groupTabModel) {
        this.selectedTab = groupTabModel;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.id;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        CharSequence charSequence2 = this.name;
        return !(charSequence2 == null || StringsKt.isBlank(charSequence2));
    }
}
