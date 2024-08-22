package com.baidu.searchbox.player.download;

import com.baidu.cyberplayer.sdk.videodownload.DownloadItemCallBackInfo;
import com.baidu.cyberplayer.sdk.videodownload.DuMediaDownloadItem;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8@X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/download/DownloadItem;", "", "url", "", "size", "", "offset", "(Ljava/lang/String;JJ)V", "downloadItem", "Lcom/baidu/cyberplayer/sdk/videodownload/DuMediaDownloadItem;", "kotlin.jvm.PlatformType", "getDownloadItem$core_release", "()Lcom/baidu/cyberplayer/sdk/videodownload/DuMediaDownloadItem;", "downloadItem$delegate", "Lkotlin/Lazy;", "setCallBackListener", "", "callback", "Lcom/baidu/searchbox/player/download/DownloadCallback;", "setOption", "key", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerPreloader.kt */
public final class DownloadItem {
    private final Lazy downloadItem$delegate;

    public DownloadItem(String url, long size, long offset) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.downloadItem$delegate = LazyKt.lazy(new DownloadItem$downloadItem$2(url, size, offset));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadItem(String str, long j2, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : j2, (i2 & 4) != 0 ? 0 : j3);
    }

    public final DuMediaDownloadItem getDownloadItem$core_release() {
        return (DuMediaDownloadItem) this.downloadItem$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setCallBackListener$lambda-0  reason: not valid java name */
    public static final void m2317setCallBackListener$lambda0(DownloadCallback $callback, DownloadItemCallBackInfo info) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        $callback.downloadItemInfo(info);
    }

    public final void setCallBackListener(DownloadCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getDownloadItem$core_release().setCallBackListener(new DownloadItem$$ExternalSyntheticLambda0(callback));
    }

    public final void setOption(String key, String value) {
        if (key != null && value != null) {
            getDownloadItem$core_release().setOption(key, value);
        }
    }
}
