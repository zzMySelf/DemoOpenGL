package com.baidu.nadcore.lp.reward.event;

import com.baidu.nadcore.eventbus.IEvent;
import java.util.HashMap;

public final class NADRewardVideoNotification extends IEvent {
    public HashMap<String, String> data;
    public String message;
    public String status = "-1";
}
