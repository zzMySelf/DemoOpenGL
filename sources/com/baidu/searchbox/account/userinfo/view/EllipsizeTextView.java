package com.baidu.searchbox.account.userinfo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EllipsizeTextView extends TextView {
    private static final String DEFAULT_ELLIPSIZE_TEXT = "...";
    private static final char ENTER_CHAR = '\n';
    private int mEllipsizeIndex;
    private CharSequence mEllipsizeText;
    private boolean mIsExactlyMode;
    private int mMaxLines;
    private float mReservedCount = 0.0f;

    public EllipsizeTextView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public EllipsizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EllipsizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (this.mEllipsizeText == null) {
            this.mEllipsizeText = "...";
        }
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EllipsizeTextView);
            this.mReservedCount = typedArray.getFloat(R.styleable.EllipsizeTextView_reservedCount, 0.0f);
            typedArray.recycle();
        }
    }

    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
        this.mMaxLines = maxLines;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mIsExactlyMode = View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824;
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        if (isExceedMaxLine(layout) || isOutOfBounds(layout)) {
            adjustEllipsizeEndText(layout);
        }
    }

    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
    }

    private boolean isExceedMaxLine(Layout layout) {
        int lineCount = layout.getLineCount();
        int i2 = this.mMaxLines;
        return lineCount > i2 && i2 > 0;
    }

    private boolean isOutOfBounds(Layout layout) {
        return layout.getHeight() > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void adjustEllipsizeEndText(Layout layout) {
        CharSequence originText = getText();
        int i2 = this.mEllipsizeIndex;
        if (i2 < 0 || i2 > originText.length()) {
            this.mEllipsizeIndex = 0;
        }
        CharSequence restSuffixText = "";
        try {
            restSuffixText = originText.subSequence(originText.length() - this.mEllipsizeIndex, originText.length());
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
        int maxLineCount = computeMaxLineCount(layout);
        if (maxLineCount > 0) {
            int lastLineWidth = (int) layout.getLineWidth(maxLineCount - 1);
            int mLastCharacterIndex = layout.getLineEnd(maxLineCount - 1);
            if (mLastCharacterIndex - 1 > 0 && originText.charAt(mLastCharacterIndex - 1) == 10) {
                mLastCharacterIndex--;
            }
            int suffixWidth = ((int) (Layout.getDesiredWidth(this.mEllipsizeText, getPaint()) + Layout.getDesiredWidth(restSuffixText, getPaint()) + (this.mReservedCount * getTextSize()))) + 1;
            if (lastLineWidth + suffixWidth > width) {
                setText(originText.subSequence(0, mLastCharacterIndex - computeRemovedEllipsizeEndCharacterCount((lastLineWidth + suffixWidth) - width, originText.subSequence(0, mLastCharacterIndex))));
                append(this.mEllipsizeText);
                append(restSuffixText);
                return;
            }
            setText(originText.subSequence(0, mLastCharacterIndex));
            append(this.mEllipsizeText);
            append(restSuffixText);
        }
    }

    private int computeMaxLineCount(Layout layout) {
        return this.mMaxLines > 0 ? Math.min(layout.getLineCount(), this.mMaxLines) : layout.getLineCount();
    }

    private int computeRemovedEllipsizeEndCharacterCount(int widthDiff, CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            return 0;
        }
        List<Range<Integer>> characterStyleRanges = computeCharacterStyleRanges(text);
        String textStr = text.toString();
        int length = text.length();
        int codePointIndex = textStr.codePointCount(0, text.length());
        int currentRemovedWidth = 0;
        while (codePointIndex > 0 && widthDiff > currentRemovedWidth) {
            codePointIndex--;
            int characterIndex = textStr.offsetByCodePoints(0, codePointIndex);
            Range<Integer> characterStyleRange = computeCharacterStyleRange(characterStyleRanges, characterIndex);
            if (characterStyleRange != null) {
                characterIndex = characterStyleRange.getLower().intValue();
                codePointIndex = textStr.codePointCount(0, characterIndex);
            }
            currentRemovedWidth = (int) Layout.getDesiredWidth(text.subSequence(characterIndex, text.length()), getPaint());
        }
        return text.length() - textStr.offsetByCodePoints(0, codePointIndex);
    }

    private Range<Integer> computeCharacterStyleRange(List<Range<Integer>> characterStyleRanges, int index) {
        if (characterStyleRanges == null || characterStyleRanges.isEmpty()) {
            return null;
        }
        for (Range<Integer> characterStyleRange : characterStyleRanges) {
            if (characterStyleRange.contains(Integer.valueOf(index))) {
                return characterStyleRange;
            }
        }
        return null;
    }

    private List<Range<Integer>> computeCharacterStyleRanges(CharSequence text) {
        SpannableStringBuilder ssb = SpannableStringBuilder.valueOf(text);
        CharacterStyle[] characterStyles = (CharacterStyle[]) ssb.getSpans(0, ssb.length(), CharacterStyle.class);
        if (characterStyles == null || characterStyles.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Range<Integer>> ranges = new ArrayList<>();
        for (CharacterStyle characterStyle : characterStyles) {
            ranges.add(new Range(Integer.valueOf(ssb.getSpanStart(characterStyle)), Integer.valueOf(ssb.getSpanEnd(characterStyle))));
        }
        return ranges;
    }

    public void setEllipsizeText(CharSequence ellipsizeText, int ellipsizeIndex) {
        this.mEllipsizeText = ellipsizeText;
        this.mEllipsizeIndex = ellipsizeIndex;
    }

    public static final class Range<T extends Comparable<? super T>> {
        private static final String TAG = Range.class.getSimpleName();
        private final T mLower;
        private final T mUpper;

        public Range(T lower, T upper) {
            this.mLower = lower;
            this.mUpper = upper;
            if (!AppConfig.isDebug() || lower.compareTo(upper) <= 0) {
                Log.e(TAG, "lower must be less than or equal to upper");
                return;
            }
            throw new IllegalArgumentException("lower must be less than or equal to upper");
        }

        public T getLower() {
            return this.mLower;
        }

        public T getUpper() {
            return this.mUpper;
        }

        public boolean contains(T value) {
            boolean gteLower = value.compareTo(this.mLower) >= 0;
            boolean lteUpper = value.compareTo(this.mUpper) < 0;
            if (!gteLower || !lteUpper) {
                return false;
            }
            return true;
        }
    }
}
