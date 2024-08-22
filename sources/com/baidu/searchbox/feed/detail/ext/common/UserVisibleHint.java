package com.baidu.searchbox.feed.detail.ext.common;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/detail/ext/common/UserVisibleHint;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "visible", "", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-component-ext"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonAction.kt */
public final class UserVisibleHint implements Action {
    private final boolean visible;

    public static /* synthetic */ UserVisibleHint copy$default(UserVisibleHint userVisibleHint, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = userVisibleHint.visible;
        }
        return userVisibleHint.copy(z);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final UserVisibleHint copy(boolean z) {
        return new UserVisibleHint(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserVisibleHint) && this.visible == ((UserVisibleHint) obj).visible;
    }

    public int hashCode() {
        boolean z = this.visible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "UserVisibleHint(visible=" + this.visible + ')';
    }

    public UserVisibleHint(boolean visible2) {
        this.visible = visible2;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}
