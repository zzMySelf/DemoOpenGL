package com.baidu.searchbox.live.frame;

import com.baidu.live.arch.frame.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo;", "Lcom/baidu/live/arch/frame/State;", "isUp", "", "position", "", "isFromForward", "listRequestDuration", "", "(ZIZJ)V", "()Z", "getListRequestDuration", "()J", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PageInfo.kt */
public final class PageInfo implements State {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY = "page_info";
    private final boolean isFromForward;
    private final boolean isUp;
    private final long listRequestDuration;
    private final int position;

    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, boolean z, int i2, boolean z2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = pageInfo.isUp;
        }
        if ((i3 & 2) != 0) {
            i2 = pageInfo.position;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            z2 = pageInfo.isFromForward;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            j2 = pageInfo.listRequestDuration;
        }
        return pageInfo.copy(z, i4, z3, j2);
    }

    public final boolean component1() {
        return this.isUp;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.isFromForward;
    }

    public final long component4() {
        return this.listRequestDuration;
    }

    public final PageInfo copy(boolean z, int i2, boolean z2, long j2) {
        return new PageInfo(z, i2, z2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageInfo)) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) obj;
        return this.isUp == pageInfo.isUp && this.position == pageInfo.position && this.isFromForward == pageInfo.isFromForward && this.listRequestDuration == pageInfo.listRequestDuration;
    }

    public int hashCode() {
        boolean z = this.isUp;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (((z ? 1 : 0) * true) + this.position) * 31;
        boolean z3 = this.isFromForward;
        if (!z3) {
            z2 = z3;
        }
        long j2 = this.listRequestDuration;
        return ((i2 + (z2 ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "PageInfo(isUp=" + this.isUp + ", position=" + this.position + ", isFromForward=" + this.isFromForward + ", listRequestDuration=" + this.listRequestDuration + ")";
    }

    public PageInfo(boolean isUp2, int position2, boolean isFromForward2, long listRequestDuration2) {
        this.isUp = isUp2;
        this.position = position2;
        this.isFromForward = isFromForward2;
        this.listRequestDuration = listRequestDuration2;
    }

    public final boolean isUp() {
        return this.isUp;
    }

    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageInfo(boolean z, int i2, boolean z2, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i2, (i3 & 4) != 0 ? false : z2, j2);
    }

    public final boolean isFromForward() {
        return this.isFromForward;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo$Companion;", "", "()V", "KEY", "", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PageInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final long getListRequestDuration() {
        return this.listRequestDuration;
    }
}
