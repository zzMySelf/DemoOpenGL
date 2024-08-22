package com.baidu.searchbox.newtips;

import java.util.List;

public class MsgData {
    private boolean hasMore;
    private List<ContentData> list;

    public List<ContentData> getList() {
        return this.list;
    }

    public void setList(List<ContentData> list2) {
        this.list = list2;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean hasMore2) {
        this.hasMore = hasMore2;
    }

    static class ContentData {
        private String data;
        private long msgid;
        private int msgtype;
        private int type;

        ContentData() {
        }

        public String getData() {
            return this.data;
        }

        public void setData(String data2) {
            this.data = data2;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int type2) {
            this.type = type2;
        }

        public long getMsgid() {
            return this.msgid;
        }

        public void setMsgid(long msgid2) {
            this.msgid = msgid2;
        }

        public int getMsgtype() {
            return this.msgtype;
        }

        public void setMsgtype(int msgtype2) {
            this.msgtype = msgtype2;
        }
    }
}
