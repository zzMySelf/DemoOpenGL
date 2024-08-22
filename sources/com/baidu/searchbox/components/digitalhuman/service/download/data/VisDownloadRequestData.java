package com.baidu.searchbox.components.digitalhuman.service.download.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/components/digitalhuman/service/download/data/VisDownloadRequestData;", "Lcom/baidu/searchbox/components/digitalhuman/service/download/data/DownloadRequestData;", "visUrl", "", "md5", "isMainParam", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getMd5", "()Ljava/lang/String;", "getVisUrl", "digital-human-service-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadRequestData.kt */
public class VisDownloadRequestData extends DownloadRequestData {
    private final boolean isMainParam;
    private final String md5;
    private final String visUrl;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VisDownloadRequestData(String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? false : z);
    }

    public String getVisUrl() {
        return this.visUrl;
    }

    public String getMd5() {
        return this.md5;
    }

    public boolean isMainParam() {
        return this.isMainParam;
    }

    public VisDownloadRequestData(String visUrl2, String md52, boolean isMainParam2) {
        super(isMainParam2);
        this.visUrl = visUrl2;
        this.md5 = md52;
        this.isMainParam = isMainParam2;
    }
}
