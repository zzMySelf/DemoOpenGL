package com.baidu.searchbox.config.eventmessage;

public class FontSizeChangeMessage {
    public static final int MSG_ON_FONT_SIZE_CHANGED = 1;
    public Object messageContent;
    public int messageId;

    public FontSizeChangeMessage(int messageId2, Object messageContent2) {
        this.messageId = messageId2;
        this.messageContent = messageContent2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageId=").append(this.messageId).append(" messageContent=").append(this.messageContent.toString());
        return sb.toString();
    }
}
