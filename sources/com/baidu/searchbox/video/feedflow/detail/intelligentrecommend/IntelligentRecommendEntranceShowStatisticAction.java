package com.baidu.searchbox.video.feedflow.detail.intelligentrecommend;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/intelligentrecommend/IntelligentRecommendEntranceShowStatisticAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isBottom", "", "curShowText", "", "(ZLjava/lang/String;)V", "getCurShowText", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: IntelligentRecommendEntranceManifest.kt */
public final class IntelligentRecommendEntranceShowStatisticAction implements Action {
    private final String curShowText;
    private final boolean isBottom;

    public static /* synthetic */ IntelligentRecommendEntranceShowStatisticAction copy$default(IntelligentRecommendEntranceShowStatisticAction intelligentRecommendEntranceShowStatisticAction, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = intelligentRecommendEntranceShowStatisticAction.isBottom;
        }
        if ((i2 & 2) != 0) {
            str = intelligentRecommendEntranceShowStatisticAction.curShowText;
        }
        return intelligentRecommendEntranceShowStatisticAction.copy(z, str);
    }

    public final boolean component1() {
        return this.isBottom;
    }

    public final String component2() {
        return this.curShowText;
    }

    public final IntelligentRecommendEntranceShowStatisticAction copy(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "curShowText");
        return new IntelligentRecommendEntranceShowStatisticAction(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntelligentRecommendEntranceShowStatisticAction)) {
            return false;
        }
        IntelligentRecommendEntranceShowStatisticAction intelligentRecommendEntranceShowStatisticAction = (IntelligentRecommendEntranceShowStatisticAction) obj;
        return this.isBottom == intelligentRecommendEntranceShowStatisticAction.isBottom && Intrinsics.areEqual((Object) this.curShowText, (Object) intelligentRecommendEntranceShowStatisticAction.curShowText);
    }

    public int hashCode() {
        boolean z = this.isBottom;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.curShowText.hashCode();
    }

    public String toString() {
        return "IntelligentRecommendEntranceShowStatisticAction(isBottom=" + this.isBottom + ", curShowText=" + this.curShowText + ')';
    }

    public IntelligentRecommendEntranceShowStatisticAction(boolean isBottom2, String curShowText2) {
        Intrinsics.checkNotNullParameter(curShowText2, "curShowText");
        this.isBottom = isBottom2;
        this.curShowText = curShowText2;
    }

    public final String getCurShowText() {
        return this.curShowText;
    }

    public final boolean isBottom() {
        return this.isBottom;
    }
}
