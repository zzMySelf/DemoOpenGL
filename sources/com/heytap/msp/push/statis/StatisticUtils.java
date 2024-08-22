package com.heytap.msp.push.statis;

import android.content.Context;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatisticUtils {
    public static boolean statisticEvent(Context context, String eventId) {
        List<MessageStat> messageStatList = new ArrayList<>();
        messageStatList.add(new MessageStat(context.getPackageName(), eventId));
        return StatUtil.statisticMessage(context, messageStatList);
    }

    public static boolean statisticEvent(Context context, String eventId, DataMessage message) {
        MessageStat messageStat;
        List<MessageStat> messageStatList = new ArrayList<>();
        String pkg = context.getPackageName();
        if (message == null) {
            messageStat = new MessageStat(pkg, eventId);
        } else {
            messageStat = new MessageStat(message.getMessageType(), pkg, message.getGlobalId(), message.getTaskID(), eventId, (String) null, message.getStatisticsExtra(), message.getDataExtra());
        }
        messageStatList.add(messageStat);
        return StatUtil.statisticMessage(context, messageStatList);
    }

    public static boolean statisticEvent(Context context, List<String> eventIds) {
        List<MessageStat> messageStatList = new ArrayList<>();
        String pkg = context.getPackageName();
        if (!(eventIds == null || eventIds.size() == 0)) {
            for (String id : eventIds) {
                messageStatList.add(new MessageStat(pkg, id));
            }
        }
        return StatUtil.statisticMessage(context, messageStatList);
    }

    public static boolean statisticEvent(Context context, Map<String, List<DataMessage>> eventIdMap) {
        Map<String, List<DataMessage>> map = eventIdMap;
        if (map == null) {
            return false;
        }
        String pkg = context.getPackageName();
        List<MessageStat> messageStatList = new ArrayList<>();
        for (String eventId : eventIdMap.keySet()) {
            List<DataMessage> list = map.get(eventId);
            if (list != null) {
                for (DataMessage message : list) {
                    messageStatList.add(new MessageStat(message.getMessageType(), pkg, message.getGlobalId(), message.getTaskID(), eventId, (String) null, message.getStatisticsExtra(), message.getDataExtra()));
                }
            } else {
                messageStatList.add(new MessageStat(pkg, eventId));
            }
        }
        return StatUtil.statisticMessage(context, messageStatList);
    }
}
