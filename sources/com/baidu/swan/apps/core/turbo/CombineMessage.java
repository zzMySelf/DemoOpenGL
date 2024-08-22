package com.baidu.swan.apps.core.turbo;

import com.baidu.searchbox.feed.payment.statistic.performance.PerformanceStat;
import com.baidu.swan.apps.core.container.JSContainer;
import com.baidu.swan.apps.event.message.SwanAppBaseMessage;
import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import java.util.ArrayList;
import java.util.List;

public class CombineMessage extends SwanAppCommonMessage {
    private final List<SwanAppBaseMessage> mMsgs = new ArrayList();

    public CombineMessage() {
        super(PerformanceStat.PayFlowSource.COMBINE);
    }

    public void dispatchJSEvent(JSContainer container) {
        for (SwanAppBaseMessage msg : this.mMsgs) {
            msg.dispatchJSEvent(container);
        }
    }

    public CombineMessage addMsg(SwanAppBaseMessage msg) {
        if (msg != null && !this.mMsgs.contains(msg)) {
            this.mMsgs.add(msg);
        }
        return this;
    }
}
