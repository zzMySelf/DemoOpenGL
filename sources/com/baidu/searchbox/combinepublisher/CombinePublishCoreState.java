package com.baidu.searchbox.combinepublisher;

import com.baidu.searchbox.dynamicpublisher.InitModel;
import com.baidu.searchbox.ugc.model.CampaignModel;
import com.baidu.searchbox.ugc.model.ReferenceDt;
import com.baidu.searchbox.ugc.model.TiaoZhanInfo;
import com.baidu.searchbox.ugc.model.UGCTarget;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/combinepublisher/CombinePublishCoreState;", "", "initModel", "Lcom/baidu/searchbox/dynamicpublisher/InitModel;", "(Lcom/baidu/searchbox/dynamicpublisher/InitModel;)V", "getInitModel", "()Lcom/baidu/searchbox/dynamicpublisher/InitModel;", "setInitModel", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombinePublishStore.kt */
public final class CombinePublishCoreState {
    private InitModel initModel;

    public CombinePublishCoreState() {
        this((InitModel) null, 1, (DefaultConstructorMarker) null);
    }

    public CombinePublishCoreState(InitModel initModel2) {
        Intrinsics.checkNotNullParameter(initModel2, "initModel");
        this.initModel = initModel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CombinePublishCoreState(InitModel initModel2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new InitModel((String) null, 0, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (Set) null, (String) null, (String) null, (UGCTarget) null, (String) null, 0, (Boolean) null, false, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (ReferenceDt) null, 0, (String) null, (String) null, (String) null, (CampaignModel) null, false, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (TiaoZhanInfo) null, (Boolean) null, false, false, false, (String) null, (String) null, -1, 262143, (DefaultConstructorMarker) null) : initModel2);
    }

    public final InitModel getInitModel() {
        return this.initModel;
    }

    public final void setInitModel(InitModel initModel2) {
        Intrinsics.checkNotNullParameter(initModel2, "<set-?>");
        this.initModel = initModel2;
    }
}
