package com.baidu.searchbox.music.ext.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

public class EditInputFilter implements InputFilter {
    private static final int MAX_CHAR_LENGTH = 40;

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int keep = 40 - (getCharSequenceLength(dest) - getSubSequenceLength(dest, dstart, dend));
        int sourceLength = getSubSequenceLength(source, start, end);
        if (keep <= 0) {
            return "";
        }
        if (keep >= sourceLength) {
            return null;
        }
        return getSubCharSequence(source, start, end, keep);
    }

    private int getSubSequenceLength(CharSequence source, int start, int end) {
        if (TextUtils.isEmpty(source) || start >= end || start < 0 || end > source.length()) {
            return 0;
        }
        return getCharSequenceLength(source.subSequence(start, end));
    }

    private CharSequence getSubCharSequence(CharSequence source, int start, int end, int keep) {
        if (TextUtils.isEmpty(source) || start >= end || start < 0 || end > source.length() || keep <= 0) {
            return "";
        }
        int count = 0;
        int lastChar = -1;
        int i2 = start;
        while (true) {
            if (i2 >= end) {
                break;
            }
            if (source.charAt(i2) > 128) {
                count += 2;
            } else {
                count++;
            }
            if (count == keep) {
                lastChar = i2;
                break;
            } else if (count > keep) {
                lastChar = i2 - 1;
                break;
            } else {
                i2++;
            }
        }
        return getSubSequenceSafely(source, start, lastChar + 1);
    }

    private CharSequence getSubSequenceSafely(CharSequence source, int start, int end) {
        if (TextUtils.isEmpty(source) || start >= end || start < 0 || end > source.length()) {
            return "";
        }
        if (!Character.isHighSurrogate(source.charAt(end - 1)) || end - 1 != start) {
            return source.subSequence(start, end);
        }
        return "";
    }

    private int getCharSequenceLength(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        int charCount = 0;
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) > 128) {
                charCount += 2;
            } else {
                charCount++;
            }
        }
        return charCount;
    }
}
