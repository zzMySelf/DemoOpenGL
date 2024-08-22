package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/GoldIncentiveController$checkGoldIncentive$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoldIncentiveController.kt */
public final class GoldIncentiveController$checkGoldIncentive$1 extends NormalTask {
    final /* synthetic */ String $url;

    GoldIncentiveController$checkGoldIncentive$1(String $url2) {
        this.$url = $url2;
    }

    public boolean doTask() {
        GoldIncentiveController.INSTANCE.getTipsInfo(this.$url);
        return super.doTask();
    }
}
