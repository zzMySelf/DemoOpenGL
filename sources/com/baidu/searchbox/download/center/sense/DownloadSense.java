package com.baidu.searchbox.download.center.sense;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/download/center/sense/DownloadSense;", "", "className", "", "senseType", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getSenseType", "setSenseType", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadSense.kt */
public final class DownloadSense {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HIGH_SENSE = "high_sense";
    public static final String LOW_SENSE = "low_sense";
    public static final String NORMAL_SENSE = "normal_sense";
    private String className;
    private String senseType;

    public DownloadSense(String className2, String senseType2) {
        Intrinsics.checkNotNullParameter(className2, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(senseType2, "senseType");
        this.className = className2;
        this.senseType = senseType2;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final String getSenseType() {
        return this.senseType;
    }

    public final void setSenseType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senseType = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/download/center/sense/DownloadSense$Companion;", "", "()V", "HIGH_SENSE", "", "LOW_SENSE", "NORMAL_SENSE", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadSense.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
