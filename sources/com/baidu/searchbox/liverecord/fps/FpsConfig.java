package com.baidu.searchbox.liverecord.fps;

import com.baidu.searchbox.NoProGuard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/liverecord/fps/FpsConfig;", "Lcom/baidu/searchbox/NoProGuard;", "scene", "", "Lcom/baidu/searchbox/liverecord/fps/FpsScene;", "condition", "Lcom/baidu/searchbox/liverecord/fps/FpsCondition;", "(Ljava/util/List;Ljava/util/List;)V", "getCondition", "()Ljava/util/List;", "getScene", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FpsConfig.kt */
public final class FpsConfig implements NoProGuard {
    private final List<FpsCondition> condition;
    private final List<FpsScene> scene;

    public FpsConfig() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FpsConfig copy$default(FpsConfig fpsConfig, List<FpsScene> list, List<FpsCondition> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = fpsConfig.scene;
        }
        if ((i2 & 2) != 0) {
            list2 = fpsConfig.condition;
        }
        return fpsConfig.copy(list, list2);
    }

    public final List<FpsScene> component1() {
        return this.scene;
    }

    public final List<FpsCondition> component2() {
        return this.condition;
    }

    public final FpsConfig copy(List<FpsScene> list, List<FpsCondition> list2) {
        return new FpsConfig(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FpsConfig)) {
            return false;
        }
        FpsConfig fpsConfig = (FpsConfig) obj;
        return Intrinsics.areEqual((Object) this.scene, (Object) fpsConfig.scene) && Intrinsics.areEqual((Object) this.condition, (Object) fpsConfig.condition);
    }

    public int hashCode() {
        List<FpsScene> list = this.scene;
        int i2 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<FpsCondition> list2 = this.condition;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "FpsConfig(scene=" + this.scene + ", condition=" + this.condition + ')';
    }

    public FpsConfig(List<FpsScene> scene2, List<FpsCondition> condition2) {
        this.scene = scene2;
        this.condition = condition2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FpsConfig(List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2);
    }

    public final List<FpsScene> getScene() {
        return this.scene;
    }

    public final List<FpsCondition> getCondition() {
        return this.condition;
    }
}
