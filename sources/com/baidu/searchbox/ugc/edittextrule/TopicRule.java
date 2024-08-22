package com.baidu.searchbox.ugc.edittextrule;

import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.edittextrule.BasePatternRule;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.searchbox.ugc.utils.LogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TopicRule extends HighlightAndDeleteRule {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "TopicRule";
    private int mChangedEnd = -1;
    private int mChangedStart = -1;
    protected boolean mIsPaste = false;
    private String mPageTopicName = "";
    private final Map<String, TopicItem> mTargetTopicMap = new HashMap();
    protected int mTopicHighlightColor = AppRuntime.getAppContext().getResources().getColor(R.color.ugc_highlight_text_color_topic);
    protected TopicMapSizeChangeListener mTopicMapSizeChangeListener;
    private final StringBuilder mTopicPatternStrBuilder = new StringBuilder();

    public interface TopicMapSizeChangeListener {
        void onSizeChange(int i2);
    }

    public TopicRule(EditText editText) {
        super(editText);
    }

    public Pattern getMatchPattern() {
        try {
            if (TextUtils.isEmpty(this.mTopicPatternStrBuilder)) {
                return null;
            }
            return Pattern.compile(this.mTopicPatternStrBuilder.toString());
        } catch (PatternSyntaxException e2) {
            return null;
        }
    }

    public void setRuleFromTopicList(List<TopicItem> topicList) {
        updateTopicMapFromList(topicList);
        updateTopicPatternFromMap();
    }

    public void setIsPaste(boolean isPaste) {
        this.mIsPaste = isPaste;
    }

    public void addTopicItem(TopicItem topicItem) {
        if (topicItem != null && !this.mTargetTopicMap.containsKey(topicItem.name)) {
            this.mTargetTopicMap.put(topicItem.name, topicItem);
            TopicMapSizeChangeListener topicMapSizeChangeListener = this.mTopicMapSizeChangeListener;
            if (topicMapSizeChangeListener != null) {
                topicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
            }
            addTopicPatternFromTopicItem(topicItem);
        }
    }

    public void obtainTopicList(List<TopicItem> topicList) {
        if (topicList != null) {
            topicList.clear();
            for (Map.Entry<String, TopicItem> entry : this.mTargetTopicMap.entrySet()) {
                if (entry.getValue().isNew == 0) {
                    topicList.add(entry.getValue());
                }
            }
        }
    }

    public void obtainNewTopicList(List<TopicItem> topicList) {
        if (topicList != null) {
            topicList.clear();
        }
        for (Map.Entry<String, TopicItem> entry : this.mTargetTopicMap.entrySet()) {
            if (1 == entry.getValue().isNew && topicList != null) {
                topicList.add(entry.getValue());
            }
        }
    }

    public void obtainAllTopicList(List<TopicItem> topicList) {
        if (topicList != null) {
            topicList.clear();
        }
        for (Map.Entry<String, TopicItem> entry : this.mTargetTopicMap.entrySet()) {
            if (topicList != null) {
                topicList.add(entry.getValue());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void beforeDeletePatternText(String delPatternStr) {
        if (this.mTargetTopicMap != null && delPatternStr != null) {
            boolean findDeleteStr = false;
            for (int index = 0; index < this.mRangeList.size(); index++) {
                if (((BasePatternRule.Range) this.mRangeList.get(index)).mText.equals(delPatternStr)) {
                    if (!findDeleteStr) {
                        findDeleteStr = true;
                    } else {
                        return;
                    }
                }
            }
            this.mTargetTopicMap.remove(delPatternStr);
            TopicMapSizeChangeListener topicMapSizeChangeListener = this.mTopicMapSizeChangeListener;
            if (topicMapSizeChangeListener != null) {
                topicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
            }
            deletePatternStrBuilder(delPatternStr);
        }
    }

    public void setPageTopicName(String topicName) {
        this.mPageTopicName = topicName;
    }

    public void setTopicMapSizeChangeListener(TopicMapSizeChangeListener topicMapSizeChangeListener) {
        this.mTopicMapSizeChangeListener = topicMapSizeChangeListener;
        topicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
    }

    public void setTopicHighlightColor(int color) {
        this.mTopicHighlightColor = color;
    }

    /* access modifiers changed from: protected */
    public void handleTopicHighLight() {
        super.handleTopicHighLight();
        if (this.mTopicMapSizeChangeListener == null) {
            highLightMatchString();
        } else if (this.mIsPaste) {
            this.mIsPaste = false;
        } else if (this.mTargetTopicMap.size() == 0) {
            if (this.mRangeList != null) {
                this.mRangeList.clear();
            }
            if (this.mChangedStart != -1 || this.mChangedEnd != -1) {
                this.mChangedStart = -1;
                this.mChangedEnd = -1;
            }
        }
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        super.onTextChanged(s, start, before, count);
        handleTopicHighLight();
        if (this.mTopicMapSizeChangeListener != null && start <= this.mChangedStart && this.mTargetTopicMap.size() != 0) {
            this.mChangedStart += count - before;
            this.mChangedEnd += count - before;
            highLightMatchString();
        }
    }

    public void highLightMatchString() {
        Editable spannableText;
        int i2;
        if (this.mEditText != null) {
            if (this.mTopicMapSizeChangeListener == null || this.mChangedStart == -1 || this.mChangedEnd == -1) {
                spannableText = this.mEditText.getText();
            } else {
                spannableText = (Editable) this.mEditText.getText().subSequence(this.mChangedStart, this.mChangedEnd);
            }
            if (!TextUtils.isEmpty(spannableText)) {
                updateRangeList(spannableText.toString());
                if (!(this.mTopicMapSizeChangeListener == null || this.mRangeList == null || this.mRangeList.size() <= 0)) {
                    BasePatternRule.Range range = (BasePatternRule.Range) this.mRangeList.get(0);
                    int i3 = this.mChangedStart;
                    if (!(i3 == -1 || (i2 = this.mChangedEnd) == -1 || i3 >= i2)) {
                        range.mFrom = i3;
                        range.mTo = this.mChangedEnd;
                    }
                }
                if (this.mRangeList != null) {
                    for (BasePatternRule.Range range2 : this.mRangeList) {
                        try {
                            this.mEditText.getText().setSpan(new ForegroundColorSpan(this.mTopicHighlightColor), range2.mFrom, range2.mTo, 33);
                        } catch (IndexOutOfBoundsException e2) {
                            if (DEBUG) {
                                Log.e(TAG, "highLightMatchString-setSpan: 设置高亮文字时数组越界异常 ");
                            }
                        } catch (IllegalArgumentException e3) {
                            LogUtil.printStackTrace(e3);
                        }
                    }
                }
            }
            if (this.mTopicMapSizeChangeListener == null && !TextUtils.isEmpty(this.mPageTopicName)) {
                if (!this.mIsPaste) {
                    highlightRange(this.mPageTopicName);
                } else {
                    this.mIsPaste = false;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateRangeList(String text) {
        Pattern pattern;
        int start;
        if (text != null) {
            if (this.mRangeList != null) {
                this.mRangeList.clear();
            }
            if ((this.mTopicMapSizeChangeListener == null || this.mTargetTopicMap.size() != 0) && (pattern = getMatchPattern()) != null) {
                int lastIndex = -1;
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    try {
                        String matchText = matcher.group();
                        if (!TextUtils.isEmpty(matchText)) {
                            if (lastIndex != -1) {
                                start = text.indexOf(matchText, lastIndex);
                            } else {
                                start = text.indexOf(matchText);
                            }
                            int end = matchText.length() + start;
                            if (this.mRangeList != null) {
                                this.mRangeList.add(new BasePatternRule.Range(start, end, matchText));
                            }
                            lastIndex = end;
                            if (this.mTopicMapSizeChangeListener != null && this.mTargetTopicMap.size() == 1) {
                                return;
                            }
                        }
                    } catch (IllegalStateException e2) {
                        String exceptionStr = "TopicRule 字符匹配异常: updateRangeList  pattern = " + pattern + " text = " + text;
                        if (!DEBUG) {
                            Log.e(TAG, exceptionStr);
                            return;
                        } else {
                            Log.e(TAG, "字符匹配异常");
                            throw new IllegalStateException(exceptionStr);
                        }
                    }
                }
            }
        }
    }

    private void highlightRange(String rangeStr) {
        if (this.mEditText != null) {
            Editable spannableText = this.mEditText.getText();
            if (!TextUtils.isEmpty(spannableText)) {
                try {
                    spannableText.setSpan(new ForegroundColorSpan(this.mHighlightColor), 0, rangeStr.length(), 33);
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        Log.e(TAG, "highlightRange-setSpan: 设置高亮区域文字时数组越界异常");
                    }
                } catch (IllegalArgumentException e3) {
                    if (DEBUG) {
                        Log.e(TAG, "highlightRange-setSpan: IllegalArgumentException异常");
                    }
                }
            }
        }
    }

    private void updateTopicMapFromList(List<TopicItem> topicList) {
        Map<String, TopicItem> map;
        if (topicList != null) {
            Map<String, TopicItem> map2 = this.mTargetTopicMap;
            if (map2 != null) {
                map2.clear();
                TopicMapSizeChangeListener topicMapSizeChangeListener = this.mTopicMapSizeChangeListener;
                if (topicMapSizeChangeListener != null) {
                    topicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
                }
            }
            for (TopicItem topic : topicList) {
                if (!TextUtils.isEmpty(topic.name) && (map = this.mTargetTopicMap) != null) {
                    map.put(topic.name, topic);
                    TopicMapSizeChangeListener topicMapSizeChangeListener2 = this.mTopicMapSizeChangeListener;
                    if (topicMapSizeChangeListener2 != null) {
                        topicMapSizeChangeListener2.onSizeChange(this.mTargetTopicMap.size());
                    }
                }
            }
        }
    }

    private void updateTopicPatternFromMap() {
        StringBuilder sb = this.mTopicPatternStrBuilder;
        sb.delete(0, sb.length());
        Map<String, TopicItem> map = this.mTargetTopicMap;
        if (map != null) {
            for (Map.Entry<String, TopicItem> entry : map.entrySet()) {
                addTopicPatternFromTopicItem(entry.getValue());
            }
        }
    }

    private void addTopicPatternFromTopicItem(String topicName) {
        if (!TextUtils.isEmpty(topicName)) {
            if (!TextUtils.isEmpty(this.mTopicPatternStrBuilder)) {
                this.mTopicPatternStrBuilder.append("|");
            }
            this.mTopicPatternStrBuilder.append(FileViewerActivity.LEFT_BRACKET);
            this.mTopicPatternStrBuilder.append(topicName);
            this.mTopicPatternStrBuilder.append(")");
        }
    }

    private void addTopicPatternFromTopicItem(TopicItem topicItem) {
        if (topicItem != null) {
            addTopicPatternFromTopicItem(topicItem.name);
        }
    }

    private void deletePatternStrBuilder(String delPatternStr) {
        if (!TextUtils.isEmpty(delPatternStr)) {
            String findPatternStr = "|(" + delPatternStr + ")|";
            int patternDelStart = this.mTopicPatternStrBuilder.indexOf(findPatternStr);
            if (patternDelStart != -1) {
                this.mTopicPatternStrBuilder.delete(patternDelStart, (findPatternStr.length() + patternDelStart) - 1);
                return;
            }
            String findPatternStr2 = "|(" + delPatternStr + ")";
            int patternDelStart2 = this.mTopicPatternStrBuilder.indexOf(findPatternStr2);
            if (patternDelStart2 != -1) {
                this.mTopicPatternStrBuilder.delete(patternDelStart2, findPatternStr2.length() + patternDelStart2);
                return;
            }
            String findPatternStr3 = FileViewerActivity.LEFT_BRACKET + delPatternStr + ")|";
            int patternDelStart3 = this.mTopicPatternStrBuilder.indexOf(findPatternStr3);
            if (patternDelStart3 != -1) {
                this.mTopicPatternStrBuilder.delete(patternDelStart3, findPatternStr3.length() + patternDelStart3);
                return;
            }
            String findPatternStr4 = FileViewerActivity.LEFT_BRACKET + delPatternStr + ")";
            int patternDelStart4 = this.mTopicPatternStrBuilder.indexOf(findPatternStr4);
            if (patternDelStart4 != -1) {
                this.mTopicPatternStrBuilder.delete(patternDelStart4, findPatternStr4.length() + patternDelStart4);
            }
        }
    }
}
