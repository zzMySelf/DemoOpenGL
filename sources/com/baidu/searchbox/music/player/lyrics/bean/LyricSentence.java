package com.baidu.searchbox.music.player.lyrics.bean;

import com.google.gson.Gson;

public class LyricSentence extends Sentence {
    private int realIndex;

    public LyricSentence() {
        this.realIndex = 0;
    }

    public LyricSentence(String content, long fromTime) {
        this(content, fromTime, 0);
    }

    public LyricSentence(String content) {
        this(content, 0, 0);
    }

    public LyricSentence(String content, long fromTime, long toTime) {
        this.realIndex = 0;
        setContent(content);
        setFromTime(fromTime);
        setToTime(toTime);
    }

    public LyricSentence(Sentence sentence) {
        this.realIndex = 0;
        setIndex(sentence.getIndex());
        setWords(sentence.getWords());
        setContent(sentence.getContent());
        setTimestamp(sentence.getTimestamp());
        setTimespan(sentence.getTimespan());
    }

    public int getRealIndex() {
        return this.realIndex;
    }

    public void setRealIndex(int realIndex2) {
        this.realIndex = realIndex2;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
