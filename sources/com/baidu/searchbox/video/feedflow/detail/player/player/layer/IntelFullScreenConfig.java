package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\"\u001a\u00020\u0003J \u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/IntelFullScreenConfig;", "", "switch", "", "cloudDefaultStatus", "localStatus", "portraitShortVideoRules", "", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FillRule;", "portraitMiniVideoRules", "landscapeShortVideoRules", "(ZZLjava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCloudDefaultStatus", "()Z", "getLandscapeShortVideoRules", "()Ljava/util/List;", "getLocalStatus", "()Ljava/lang/Boolean;", "setLocalStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPortraitMiniVideoRules", "getPortraitShortVideoRules", "getSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/IntelFullScreenConfig;", "equals", "other", "getFillStatus", "getTargetRule", "isLandscape", "isMiniVideo", "whRatio", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoKernelGesturePlugin.kt */
public final class IntelFullScreenConfig {
    private final boolean cloudDefaultStatus;
    private final List<FillRule> landscapeShortVideoRules;
    private Boolean localStatus;
    private final List<FillRule> portraitMiniVideoRules;
    private final List<FillRule> portraitShortVideoRules;

    /* renamed from: switch  reason: not valid java name */
    private final boolean f1117switch;

    public IntelFullScreenConfig() {
        this(false, false, (Boolean) null, (List) null, (List) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IntelFullScreenConfig copy$default(IntelFullScreenConfig intelFullScreenConfig, boolean z, boolean z2, Boolean bool, List<FillRule> list, List<FillRule> list2, List<FillRule> list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = intelFullScreenConfig.f1117switch;
        }
        if ((i2 & 2) != 0) {
            z2 = intelFullScreenConfig.cloudDefaultStatus;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            bool = intelFullScreenConfig.localStatus;
        }
        Boolean bool2 = bool;
        if ((i2 & 8) != 0) {
            list = intelFullScreenConfig.portraitShortVideoRules;
        }
        List<FillRule> list4 = list;
        if ((i2 & 16) != 0) {
            list2 = intelFullScreenConfig.portraitMiniVideoRules;
        }
        List<FillRule> list5 = list2;
        if ((i2 & 32) != 0) {
            list3 = intelFullScreenConfig.landscapeShortVideoRules;
        }
        return intelFullScreenConfig.copy(z, z3, bool2, list4, list5, list3);
    }

    public final boolean component1() {
        return this.f1117switch;
    }

    public final boolean component2() {
        return this.cloudDefaultStatus;
    }

    public final Boolean component3() {
        return this.localStatus;
    }

    public final List<FillRule> component4() {
        return this.portraitShortVideoRules;
    }

    public final List<FillRule> component5() {
        return this.portraitMiniVideoRules;
    }

    public final List<FillRule> component6() {
        return this.landscapeShortVideoRules;
    }

    public final IntelFullScreenConfig copy(boolean z, boolean z2, Boolean bool, List<FillRule> list, List<FillRule> list2, List<FillRule> list3) {
        return new IntelFullScreenConfig(z, z2, bool, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntelFullScreenConfig)) {
            return false;
        }
        IntelFullScreenConfig intelFullScreenConfig = (IntelFullScreenConfig) obj;
        return this.f1117switch == intelFullScreenConfig.f1117switch && this.cloudDefaultStatus == intelFullScreenConfig.cloudDefaultStatus && Intrinsics.areEqual((Object) this.localStatus, (Object) intelFullScreenConfig.localStatus) && Intrinsics.areEqual((Object) this.portraitShortVideoRules, (Object) intelFullScreenConfig.portraitShortVideoRules) && Intrinsics.areEqual((Object) this.portraitMiniVideoRules, (Object) intelFullScreenConfig.portraitMiniVideoRules) && Intrinsics.areEqual((Object) this.landscapeShortVideoRules, (Object) intelFullScreenConfig.landscapeShortVideoRules);
    }

    public int hashCode() {
        boolean z = this.f1117switch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.cloudDefaultStatus;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        Boolean bool = this.localStatus;
        int i4 = 0;
        int hashCode = (i3 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<FillRule> list = this.portraitShortVideoRules;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<FillRule> list2 = this.portraitMiniVideoRules;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<FillRule> list3 = this.landscapeShortVideoRules;
        if (list3 != null) {
            i4 = list3.hashCode();
        }
        return hashCode3 + i4;
    }

    public String toString() {
        return "IntelFullScreenConfig(switch=" + this.f1117switch + ", cloudDefaultStatus=" + this.cloudDefaultStatus + ", localStatus=" + this.localStatus + ", portraitShortVideoRules=" + this.portraitShortVideoRules + ", portraitMiniVideoRules=" + this.portraitMiniVideoRules + ", landscapeShortVideoRules=" + this.landscapeShortVideoRules + ')';
    }

    public IntelFullScreenConfig(boolean z, boolean cloudDefaultStatus2, Boolean localStatus2, List<FillRule> portraitShortVideoRules2, List<FillRule> portraitMiniVideoRules2, List<FillRule> landscapeShortVideoRules2) {
        this.f1117switch = z;
        this.cloudDefaultStatus = cloudDefaultStatus2;
        this.localStatus = localStatus2;
        this.portraitShortVideoRules = portraitShortVideoRules2;
        this.portraitMiniVideoRules = portraitMiniVideoRules2;
        this.landscapeShortVideoRules = landscapeShortVideoRules2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntelFullScreenConfig(boolean z, boolean z2, Boolean bool, List list, List list2, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : list3);
    }

    public final boolean getSwitch() {
        return this.f1117switch;
    }

    public final boolean getCloudDefaultStatus() {
        return this.cloudDefaultStatus;
    }

    public final Boolean getLocalStatus() {
        return this.localStatus;
    }

    public final void setLocalStatus(Boolean bool) {
        this.localStatus = bool;
    }

    public final List<FillRule> getPortraitShortVideoRules() {
        return this.portraitShortVideoRules;
    }

    public final List<FillRule> getPortraitMiniVideoRules() {
        return this.portraitMiniVideoRules;
    }

    public final List<FillRule> getLandscapeShortVideoRules() {
        return this.landscapeShortVideoRules;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule getTargetRule(boolean r8, boolean r9, float r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x002e
            if (r9 == 0) goto L_0x0009
            r1 = r0
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r1 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r1
            goto L_0x002d
        L_0x0009:
            java.util.List<com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule> r1 = r7.landscapeShortVideoRules
            if (r1 == 0) goto L_0x002d
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x0014:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r5 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r5
            r6 = 0
            boolean r5 = r5.isTargetRule(r10)
            if (r5 == 0) goto L_0x0014
            r0 = r4
            goto L_0x002b
        L_0x002a:
        L_0x002b:
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r0 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r0
        L_0x002d:
            return r0
        L_0x002e:
            if (r9 == 0) goto L_0x0055
            java.util.List<com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule> r1 = r7.portraitMiniVideoRules
            if (r1 == 0) goto L_0x0079
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x003b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r5 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r5
            r6 = 0
            boolean r5 = r5.isTargetRule(r10)
            if (r5 == 0) goto L_0x003b
            r0 = r4
            goto L_0x0052
        L_0x0051:
        L_0x0052:
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r0 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r0
            goto L_0x0079
        L_0x0055:
            java.util.List<com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule> r1 = r7.portraitShortVideoRules
            if (r1 == 0) goto L_0x0079
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x0060:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0076
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r5 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r5
            r6 = 0
            boolean r5 = r5.isTargetRule(r10)
            if (r5 == 0) goto L_0x0060
            r0 = r4
            goto L_0x0077
        L_0x0076:
        L_0x0077:
            com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule r0 = (com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule) r0
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.player.player.layer.IntelFullScreenConfig.getTargetRule(boolean, boolean, float):com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule");
    }

    public final boolean getFillStatus() {
        Boolean bool = this.localStatus;
        return bool != null ? bool.booleanValue() : this.cloudDefaultStatus;
    }
}
