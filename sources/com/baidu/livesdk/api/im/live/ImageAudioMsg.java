package com.baidu.livesdk.api.im.live;

public class ImageAudioMsg {
    public static final int IM_MSG_TYPE_AUDIO = 1;
    public static final int IM_MSG_TYPE_IMG = 0;
    public static final int SUCCESS = 0;
    public int audioDuration;
    public int heigth;
    public int thumbHeigth;
    public String thumbUrl;
    public int thurbWidth;
    public int type;
    public String url;
    public int width;

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getThurbWidth() {
        return this.thurbWidth;
    }

    public int getThumbHeigth() {
        return this.thumbHeigth;
    }

    public void setThumbUrl(String thumbUrl2) {
        this.thumbUrl = thumbUrl2;
    }

    public void setThurbWidth(int thurbWidth2) {
        this.thurbWidth = thurbWidth2;
    }

    public void setThumbHeigth(int thumbHeigth2) {
        this.thumbHeigth = thumbHeigth2;
    }

    public void setType(int type2) {
        this.type = type2;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public int getAudioDuration() {
        return this.audioDuration;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public void setWidth(int width2) {
        this.width = width2;
    }

    public void setHeigth(int heigth2) {
        this.heigth = heigth2;
    }

    public void setAudioDuration(int audioDuration2) {
        this.audioDuration = audioDuration2;
    }
}
