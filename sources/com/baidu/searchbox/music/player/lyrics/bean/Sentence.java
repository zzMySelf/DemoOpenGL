package com.baidu.searchbox.music.player.lyrics.bean;

import com.google.gson.Gson;
import java.util.List;

public class Sentence extends Score {
    private String mContent = "";
    private long mFromTime;
    private int mIndex;
    private int mTimeSpan;
    private long mTimestamp;
    private long mToTime;
    private List<Word> mWords;

    public void setFromTime(long fromTime) {
        this.mFromTime = fromTime;
    }

    public long getFromTime() {
        return this.mFromTime;
    }

    public long getToTime() {
        return this.mToTime;
    }

    public void setToTime(long toTime) {
        this.mToTime = toTime;
    }

    public List<Word> getWords() {
        return this.mWords;
    }

    public void setWords(List<Word> value) {
        this.mWords = value;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String value) {
        this.mContent = value;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int value) {
        this.mIndex = value;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long value) {
        this.mTimestamp = value;
    }

    public int getTimespan() {
        return this.mTimeSpan;
    }

    public void setTimespan(int timespan) {
        this.mTimeSpan = timespan;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
