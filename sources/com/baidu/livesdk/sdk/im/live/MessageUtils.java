package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.livesdk.R;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import java.util.List;

public class MessageUtils {
    public static String convertToText(Context context, LiveMessageBean item) {
        int messageType = -1;
        try {
            messageType = Integer.parseInt(item.message_type);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        String content = "";
        switch (messageType) {
            case 0:
            case 3:
                return (item.message_body == null || item.message_body.txt == null || TextUtils.isEmpty(item.message_body.txt.word)) ? content : content + item.message_body.txt.word;
            case 1:
            case 2:
            case 4:
                if (!(item.message_body == null || item.message_body.txt == null || TextUtils.isEmpty(item.message_body.txt.word))) {
                    content = item.message_body.txt.word;
                }
                return content + context.getString(R.string.livesdk_pic);
            case 5:
                return content + context.getString(R.string.livesdk_voice);
            default:
                return content + context.getString(R.string.livesdk_not_support_msg_type);
        }
    }

    public static String createOldVideoLiveMessage(Context context, LiveMessageBean msg, boolean hasReplyName) {
        String body = convertToText(context, msg);
        if (!hasReplyName || TextUtils.isEmpty(msg.at_uid)) {
            return body;
        }
        String replyName = getReplyNamePre(context, msg);
        if (body.startsWith(replyName)) {
            return body;
        }
        return replyName + body;
    }

    public static String getReplyNamePre(Context context, LiveMessageBean msg) {
        if (msg == null || TextUtils.isEmpty(msg.at_uid)) {
            return "";
        }
        return context.getString(R.string.livesdk_reply) + msg.at_name + " ";
    }

    public static void trimReplayMessage(Context context, LiveMessageBean msg) {
        if (msg != null && msg.at_message_body != null && msg.at_message_body.txt != null && !TextUtils.isEmpty(msg.at_message_body.txt.word)) {
            String replyName = getReplyNamePre(context, msg);
            if (msg.at_message_body.txt.word.startsWith(replyName)) {
                msg.at_message_body.txt.word = msg.at_message_body.txt.word.replace(replyName, "");
            }
        }
    }

    public static int halfSearch(List<LiveMessageBean> list, boolean isAsc, long msgId) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (msgId < list.get(middle).msgId) {
                if (isAsc) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (msgId <= list.get(middle).msgId) {
                return middle;
            } else {
                if (isAsc) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static boolean hasText(LiveMessageBean.MessageBody body) {
        return (body == null || body.txt == null || TextUtils.isEmpty(body.txt.word)) ? false : true;
    }

    public static boolean hasLink(LiveMessageBean.MessageBody body) {
        return (body == null || body.link == null || TextUtils.isEmpty(body.link.url)) ? false : true;
    }

    public static boolean hasPic(LiveMessageBean.MessageBody body) {
        return (body == null || body.pic == null || body.pic.thumbnail == null || TextUtils.isEmpty(body.pic.thumbnail.url)) ? false : true;
    }

    public static boolean hasVoice(LiveMessageBean.MessageBody body) {
        return (body == null || body.voice == null || TextUtils.isEmpty(body.voice.url)) ? false : true;
    }

    public static boolean canCopy(LiveMessageBean bean) {
        if (bean == null) {
            return false;
        }
        int type = -1;
        try {
            type = Integer.parseInt(bean.message_type);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        switch (type) {
            case 0:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }
}
