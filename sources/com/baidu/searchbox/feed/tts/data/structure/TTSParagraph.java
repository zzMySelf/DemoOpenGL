package com.baidu.searchbox.feed.tts.data.structure;

import android.text.TextUtils;
import com.baidu.searchbox.feed.tts.data.TTSContentDelegator;
import com.baidu.searchbox.feed.tts.data.structure.build.IParagraphBuildStrategy;
import java.util.ArrayList;
import java.util.List;

public class TTSParagraph {
    private int mSentenceIndex = -1;
    private final List<String> mSentenceList = new ArrayList();
    private int mWordCount = 0;

    public void buildFromMetaParagraph(String metaParagraph, IParagraphBuildStrategy strategy) {
        strategy.build(metaParagraph, this);
    }

    public void addSentence(String sentence) {
        this.mSentenceList.add(sentence);
        if (!TTSContentDelegator.UNREADABLE_CONTENT_FLAG.equals(sentence)) {
            this.mWordCount += sentence.length();
        }
    }

    public String nextSentence(int sIndex) {
        if (reachEnd(sIndex)) {
            return "";
        }
        return this.mSentenceList.get(sIndex + 1);
    }

    public String getSentence(int sIndex) {
        return this.mSentenceList.get(sIndex);
    }

    public String getParagraphString() {
        StringBuilder sb = new StringBuilder();
        for (String sentence : this.mSentenceList) {
            sb.append(sentence);
        }
        return sb.toString();
    }

    public boolean reachEnd(int sIndex) {
        return sIndex >= this.mSentenceList.size() - 1;
    }

    public boolean hasReadableSentence() {
        for (int i2 = 0; i2 < this.mSentenceList.size(); i2++) {
            String sentence = this.mSentenceList.get(i2);
            if (!TextUtils.isEmpty(sentence) && !TTSContentDelegator.UNREADABLE_CONTENT_FLAG.equals(sentence)) {
                return true;
            }
        }
        return false;
    }

    public int getSentenceNum() {
        return this.mSentenceList.size();
    }

    public int getSentenceIndex() {
        return this.mSentenceIndex;
    }

    public void setSentenceIndex(int sentenceIndex) {
        if (sentenceIndex >= -1 && sentenceIndex < this.mSentenceList.size()) {
            this.mSentenceIndex = sentenceIndex;
        }
    }

    public void resetSentenceIndex() {
        this.mSentenceIndex = -1;
    }

    public void rollbackSentenceIndex() {
        this.mSentenceIndex = Math.max(this.mSentenceIndex - 1, -1);
    }

    public int getWordCount() {
        return this.mWordCount;
    }

    public int getWordCountBeforeSentenceIndex(int sentenceIndex) {
        int size = Math.min(sentenceIndex, this.mSentenceList.size());
        int wd = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String sentence = this.mSentenceList.get(i2);
            if (!TextUtils.isEmpty(sentence) && !TTSContentDelegator.UNREADABLE_CONTENT_FLAG.equals(sentence)) {
                wd += sentence.length();
            }
        }
        return wd;
    }
}
