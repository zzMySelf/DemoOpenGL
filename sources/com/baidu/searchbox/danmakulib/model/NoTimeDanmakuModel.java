package com.baidu.searchbox.danmakulib.model;

public class NoTimeDanmakuModel {
    private String commentType;
    private String content;
    private boolean isSelf;
    private PraiseInfo praiseInfo;
    private Property property;
    private String replyId;

    public static class PraiseInfo {
        public int praiseCounts;
        public boolean praisedByItself;
        public boolean showPraise;
    }

    public static class Property {
        private String color;
        private String font;
        private String size;

        public String getColor() {
            return this.color;
        }

        public void setColor(String color2) {
            this.color = color2;
        }

        public String getFont() {
            return this.font;
        }

        public void setFont(String font2) {
            this.font = font2;
        }

        public String getSize() {
            return this.size;
        }

        public void setSize(String size2) {
            this.size = size2;
        }
    }

    public String getReplyId() {
        return this.replyId;
    }

    public void setReplyId(String replyId2) {
        this.replyId = replyId2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public Property getProperty() {
        return this.property;
    }

    public void setProperty(Property property2) {
        this.property = property2;
    }

    public boolean getIsSelf() {
        return this.isSelf;
    }

    public void setIsSelf(boolean isSelf2) {
        this.isSelf = isSelf2;
    }

    public String getCommentType() {
        return this.commentType;
    }

    public void setCommentType(String commentType2) {
        this.commentType = commentType2;
    }

    public PraiseInfo getPraiseInfo() {
        return this.praiseInfo;
    }

    public void setPraiseInfo(PraiseInfo praiseInfo2) {
        this.praiseInfo = praiseInfo2;
    }
}
