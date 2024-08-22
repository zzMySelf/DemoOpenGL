package com.baidu.searchbox.video.feedflow.ad.dynamic.music;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.ad.dynamic.music.player.BgmInfo;
import com.baidu.searchbox.video.feedflow.ad.dynamic.music.player.BgmStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/dynamic/music/NadDynamicBgmState;", "", "playerStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/music/player/BgmStatus;", "bgmInfo", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/music/player/BgmInfo;", "pauseType", "", "bgmUrl", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ILjava/lang/String;)V", "getBgmInfo", "()Landroidx/lifecycle/MutableLiveData;", "getBgmUrl", "()Ljava/lang/String;", "setBgmUrl", "(Ljava/lang/String;)V", "getPauseType", "()I", "setPauseType", "(I)V", "getPlayerStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDynamicBgmState.kt */
public final class NadDynamicBgmState {
    private final MutableLiveData<BgmInfo> bgmInfo;
    private String bgmUrl;
    private int pauseType;
    private final MutableLiveData<BgmStatus> playerStatus;

    public NadDynamicBgmState() {
        this((MutableLiveData) null, (MutableLiveData) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NadDynamicBgmState copy$default(NadDynamicBgmState nadDynamicBgmState, MutableLiveData<BgmStatus> mutableLiveData, MutableLiveData<BgmInfo> mutableLiveData2, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mutableLiveData = nadDynamicBgmState.playerStatus;
        }
        if ((i3 & 2) != 0) {
            mutableLiveData2 = nadDynamicBgmState.bgmInfo;
        }
        if ((i3 & 4) != 0) {
            i2 = nadDynamicBgmState.pauseType;
        }
        if ((i3 & 8) != 0) {
            str = nadDynamicBgmState.bgmUrl;
        }
        return nadDynamicBgmState.copy(mutableLiveData, mutableLiveData2, i2, str);
    }

    public final MutableLiveData<BgmStatus> component1() {
        return this.playerStatus;
    }

    public final MutableLiveData<BgmInfo> component2() {
        return this.bgmInfo;
    }

    public final int component3() {
        return this.pauseType;
    }

    public final String component4() {
        return this.bgmUrl;
    }

    public final NadDynamicBgmState copy(MutableLiveData<BgmStatus> mutableLiveData, MutableLiveData<BgmInfo> mutableLiveData2, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "playerStatus");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "bgmInfo");
        Intrinsics.checkNotNullParameter(str, "bgmUrl");
        return new NadDynamicBgmState(mutableLiveData, mutableLiveData2, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NadDynamicBgmState)) {
            return false;
        }
        NadDynamicBgmState nadDynamicBgmState = (NadDynamicBgmState) obj;
        return Intrinsics.areEqual((Object) this.playerStatus, (Object) nadDynamicBgmState.playerStatus) && Intrinsics.areEqual((Object) this.bgmInfo, (Object) nadDynamicBgmState.bgmInfo) && this.pauseType == nadDynamicBgmState.pauseType && Intrinsics.areEqual((Object) this.bgmUrl, (Object) nadDynamicBgmState.bgmUrl);
    }

    public int hashCode() {
        return (((((this.playerStatus.hashCode() * 31) + this.bgmInfo.hashCode()) * 31) + Integer.hashCode(this.pauseType)) * 31) + this.bgmUrl.hashCode();
    }

    public String toString() {
        return "NadDynamicBgmState(playerStatus=" + this.playerStatus + ", bgmInfo=" + this.bgmInfo + ", pauseType=" + this.pauseType + ", bgmUrl=" + this.bgmUrl + ')';
    }

    public NadDynamicBgmState(MutableLiveData<BgmStatus> playerStatus2, MutableLiveData<BgmInfo> bgmInfo2, int pauseType2, String bgmUrl2) {
        Intrinsics.checkNotNullParameter(playerStatus2, "playerStatus");
        Intrinsics.checkNotNullParameter(bgmInfo2, "bgmInfo");
        Intrinsics.checkNotNullParameter(bgmUrl2, "bgmUrl");
        this.playerStatus = playerStatus2;
        this.bgmInfo = bgmInfo2;
        this.pauseType = pauseType2;
        this.bgmUrl = bgmUrl2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadDynamicBgmState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i3 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str);
    }

    public final MutableLiveData<BgmStatus> getPlayerStatus() {
        return this.playerStatus;
    }

    public final MutableLiveData<BgmInfo> getBgmInfo() {
        return this.bgmInfo;
    }

    public final int getPauseType() {
        return this.pauseType;
    }

    public final void setPauseType(int i2) {
        this.pauseType = i2;
    }

    public final String getBgmUrl() {
        return this.bgmUrl;
    }

    public final void setBgmUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgmUrl = str;
    }
}
