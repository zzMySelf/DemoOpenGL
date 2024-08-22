package com.baidu.searchbox.video.feedflow.detail.diversion;

import com.baidu.searchbox.flowvideo.detail.repos.TabDiversionModel;
import com.baidu.searchbox.fluency.utils.CommonUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.player.SimplePlayerComponentListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/diversion/TabDiversionComponent$playerListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/diversion/TabDiversionComponent$playerListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabDiversionComponent.kt */
final class TabDiversionComponent$playerListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ TabDiversionComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabDiversionComponent$playerListener$2(TabDiversionComponent tabDiversionComponent) {
        super(0);
        this.this$0 = tabDiversionComponent;
    }

    public final AnonymousClass1 invoke() {
        final TabDiversionComponent tabDiversionComponent = this.this$0;
        return new SimplePlayerComponentListener() {
            public void onFirstFrame() {
                TabDiversionModel access$getModel = tabDiversionComponent.getModel();
                if (Intrinsics.areEqual((Object) access$getModel != null ? access$getModel.getTriggerType() : null, (Object) "0")) {
                    TabDiversionComponent.changeVisible$default(tabDiversionComponent, true, false, (String) null, 6, (Object) null);
                }
            }

            public void onUpdateProgress(int progress, int buffer, int max) {
                int progressLimit;
                int progressLimit2;
                int i2 = progress;
                int i3 = max;
                TabDiversionModel model = tabDiversionComponent.getModel();
                if (model != null) {
                    String config = model.getTriggerConfig();
                    String triggerType = model.getTriggerType();
                    boolean z = true;
                    switch (triggerType.hashCode()) {
                        case 48:
                            if (triggerType.equals("0") && i2 > 0) {
                                TabDiversionComponent.changeVisible$default(tabDiversionComponent, true, false, (String) null, 6, (Object) null);
                                return;
                            }
                            return;
                        case 49:
                            if (triggerType.equals("1") && (progressLimit = CommonUtilsKt.toIntSafely(config)) >= 0 && progressLimit <= i3) {
                                if (progressLimit > i2 || i2 > i3) {
                                    z = false;
                                }
                                if (z) {
                                    TabDiversionComponent.changeVisible$default(tabDiversionComponent, true, false, (String) null, 6, (Object) null);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 50:
                            if (triggerType.equals("2")) {
                                float percentLimit = CommonUtilsKt.toFloatSafely(config);
                                if (percentLimit >= 1.0f && percentLimit < 100.0f) {
                                    percentLimit /= 100.0f;
                                }
                                if (percentLimit >= 0.0f && percentLimit <= 1.0f) {
                                    float curPercent = ((float) i2) / ((float) i3);
                                    if (percentLimit > curPercent || curPercent > 1.0f) {
                                        z = false;
                                    }
                                    if (z) {
                                        TabDiversionComponent.changeVisible$default(tabDiversionComponent, true, false, (String) null, 6, (Object) null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 51:
                            if (triggerType.equals("3") && (progressLimit2 = CommonUtilsKt.toIntSafely(config)) >= 0 && progressLimit2 <= i3) {
                                if (i3 - progressLimit2 > i2 || i2 > i3) {
                                    z = false;
                                }
                                if (z) {
                                    TabDiversionComponent.changeVisible$default(tabDiversionComponent, true, false, (String) null, 6, (Object) null);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }
}
