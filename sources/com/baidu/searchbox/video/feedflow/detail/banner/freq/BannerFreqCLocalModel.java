package com.baidu.searchbox.video.feedflow.detail.banner.freq;

import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/freq/BannerFreqCLocalModel;", "Lcom/baidu/searchbox/NoProGuard;", "freqCList", "", "Lcom/baidu/searchbox/video/feedflow/detail/banner/freq/BannerFreqCLocalPageModel;", "(Ljava/util/List;)V", "getFreqCList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerFreqController.kt */
public final class BannerFreqCLocalModel implements NoProGuard {
    private final List<BannerFreqCLocalPageModel> freqCList;

    public BannerFreqCLocalModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BannerFreqCLocalModel copy$default(BannerFreqCLocalModel bannerFreqCLocalModel, List<BannerFreqCLocalPageModel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = bannerFreqCLocalModel.freqCList;
        }
        return bannerFreqCLocalModel.copy(list);
    }

    public final List<BannerFreqCLocalPageModel> component1() {
        return this.freqCList;
    }

    public final BannerFreqCLocalModel copy(List<BannerFreqCLocalPageModel> list) {
        Intrinsics.checkNotNullParameter(list, "freqCList");
        return new BannerFreqCLocalModel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BannerFreqCLocalModel) && Intrinsics.areEqual((Object) this.freqCList, (Object) ((BannerFreqCLocalModel) obj).freqCList);
    }

    public int hashCode() {
        return this.freqCList.hashCode();
    }

    public String toString() {
        return "BannerFreqCLocalModel(freqCList=" + this.freqCList + ')';
    }

    public BannerFreqCLocalModel(List<BannerFreqCLocalPageModel> freqCList2) {
        Intrinsics.checkNotNullParameter(freqCList2, "freqCList");
        this.freqCList = freqCList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerFreqCLocalModel(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : list);
    }

    public final List<BannerFreqCLocalPageModel> getFreqCList() {
        return this.freqCList;
    }
}
