package com.baidu.searchbox.video.feedflow.detail.landscapenextguide;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapenextguide/OnLandNextGuideShowed;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isDefaultStyleShow", "", "isLandscape", "isRepeatPlay", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: LandscapeNextGuideActionManifest.kt */
public final class OnLandNextGuideShowed implements Action {
    private final boolean isDefaultStyleShow;
    private final boolean isLandscape;
    private final boolean isRepeatPlay;

    public static /* synthetic */ OnLandNextGuideShowed copy$default(OnLandNextGuideShowed onLandNextGuideShowed, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = onLandNextGuideShowed.isDefaultStyleShow;
        }
        if ((i2 & 2) != 0) {
            z2 = onLandNextGuideShowed.isLandscape;
        }
        if ((i2 & 4) != 0) {
            z3 = onLandNextGuideShowed.isRepeatPlay;
        }
        return onLandNextGuideShowed.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.isDefaultStyleShow;
    }

    public final boolean component2() {
        return this.isLandscape;
    }

    public final boolean component3() {
        return this.isRepeatPlay;
    }

    public final OnLandNextGuideShowed copy(boolean z, boolean z2, boolean z3) {
        return new OnLandNextGuideShowed(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnLandNextGuideShowed)) {
            return false;
        }
        OnLandNextGuideShowed onLandNextGuideShowed = (OnLandNextGuideShowed) obj;
        return this.isDefaultStyleShow == onLandNextGuideShowed.isDefaultStyleShow && this.isLandscape == onLandNextGuideShowed.isLandscape && this.isRepeatPlay == onLandNextGuideShowed.isRepeatPlay;
    }

    public int hashCode() {
        boolean z = this.isDefaultStyleShow;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.isLandscape;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isRepeatPlay;
        if (!z4) {
            z2 = z4;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "OnLandNextGuideShowed(isDefaultStyleShow=" + this.isDefaultStyleShow + ", isLandscape=" + this.isLandscape + ", isRepeatPlay=" + this.isRepeatPlay + ')';
    }

    public OnLandNextGuideShowed(boolean isDefaultStyleShow2, boolean isLandscape2, boolean isRepeatPlay2) {
        this.isDefaultStyleShow = isDefaultStyleShow2;
        this.isLandscape = isLandscape2;
        this.isRepeatPlay = isRepeatPlay2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnLandNextGuideShowed(boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3);
    }

    public final boolean isDefaultStyleShow() {
        return this.isDefaultStyleShow;
    }

    public final boolean isLandscape() {
        return this.isLandscape;
    }

    public final boolean isRepeatPlay() {
        return this.isRepeatPlay;
    }
}
