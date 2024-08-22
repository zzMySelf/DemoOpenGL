package com.baidu.searchbox.usergrowth.business.guide;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.launch.IdleLaunchTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/usergrowth/business/guide/UserGrowthRightsGuideManager$tryShowHomeUGRightsTask$2", "Lcom/baidu/searchbox/launch/IdleLaunchTask;", "execute", "", "lib-usergrowth-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserGrowthRightsGuideManager.kt */
public final class UserGrowthRightsGuideManager$tryShowHomeUGRightsTask$2 extends IdleLaunchTask {
    final /* synthetic */ UserGrowthRightsGuideManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserGrowthRightsGuideManager$tryShowHomeUGRightsTask$2(UserGrowthRightsGuideManager $receiver) {
        super("tryShowHomeUGRightsGuideTask", 3);
        this.this$0 = $receiver;
    }

    public void execute() {
        UiThreadUtils.runOnUiThread(new UserGrowthRightsGuideManager$tryShowHomeUGRightsTask$2$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-0  reason: not valid java name */
    public static final void m4715execute$lambda0(UserGrowthRightsGuideManager this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.tryShowHomeUGRightsGuide();
    }
}
