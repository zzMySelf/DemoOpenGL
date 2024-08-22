package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/ChallengeInfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "layout", "", "publish", "Lcom/baidu/searchbox/flowvideo/detail/repos/ChallengePublishModel;", "talosInfo", "Lcom/baidu/searchbox/flowvideo/detail/repos/TalosInfoModel;", "extRequest", "extLog", "(Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/ChallengePublishModel;Lcom/baidu/searchbox/flowvideo/detail/repos/TalosInfoModel;Ljava/lang/String;Ljava/lang/String;)V", "getExtLog", "()Ljava/lang/String;", "getExtRequest", "getLayout", "getPublish", "()Lcom/baidu/searchbox/flowvideo/detail/repos/ChallengePublishModel;", "getTalosInfo", "()Lcom/baidu/searchbox/flowvideo/detail/repos/TalosInfoModel;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class ChallengeInfoModel implements NoProGuard {
    private final String extLog;
    private final String extRequest;
    private final String layout;
    private final ChallengePublishModel publish;
    private final TalosInfoModel talosInfo;

    public ChallengeInfoModel() {
        this((String) null, (ChallengePublishModel) null, (TalosInfoModel) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public ChallengeInfoModel(String layout2, ChallengePublishModel publish2, TalosInfoModel talosInfo2, String extRequest2, String extLog2) {
        Intrinsics.checkNotNullParameter(layout2, "layout");
        Intrinsics.checkNotNullParameter(extRequest2, IntentData.Protocol.KEY_EXT_REQUEST);
        Intrinsics.checkNotNullParameter(extLog2, IntentData.Protocol.KEY_EXT_LOG);
        this.layout = layout2;
        this.publish = publish2;
        this.talosInfo = talosInfo2;
        this.extRequest = extRequest2;
        this.extLog = extLog2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeInfoModel(String str, ChallengePublishModel challengePublishModel, TalosInfoModel talosInfoModel, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : challengePublishModel, (i2 & 4) != 0 ? null : talosInfoModel, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3);
    }

    public final String getLayout() {
        return this.layout;
    }

    public final ChallengePublishModel getPublish() {
        return this.publish;
    }

    public final TalosInfoModel getTalosInfo() {
        return this.talosInfo;
    }

    public final String getExtRequest() {
        return this.extRequest;
    }

    public final String getExtLog() {
        return this.extLog;
    }
}
