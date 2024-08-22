package com.tera.scan.component.base.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import fe.mmm.qw.j.Cswitch;

public class EllipsizeTextView extends TextView {
    public static final int[] LAYOUT_ATTRS = {16843091};
    public static final String TAG = "EllipsizeTextView";
    public static final String WORD = "字";
    public String[] hightlightText = null;
    public boolean mHasDrawable = false;
    public boolean mInternalChange;
    public boolean mInvalid;
    public int mMaxLines;
    public CharSequence mOriginalText;
    public float mSpacingAdd = 0.0f;
    public float mSpacingMult = 1.0f;

    public EllipsizeTextView(Context context) {
        super(context);
    }

    private int getRealLineCount(CharSequence charSequence) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width <= 0) {
            return 0;
        }
        return new StaticLayout(charSequence, getPaint(), width, Layout.Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, false).getLineCount();
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        this.mMaxLines = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public void ellipsizeText() {
        if (this.mMaxLines < 0) {
            this.mInvalid = false;
            return;
        }
        CharSequence charSequence = this.mOriginalText;
        int width = getWidth() * this.mMaxLines;
        int measureText = (int) getPaint().measureText(WORD);
        while (getRealLineCount(charSequence) > this.mMaxLines) {
            charSequence = TextUtils.ellipsize(this.mOriginalText, getPaint(), (float) width, getEllipsize());
            width -= measureText;
        }
        if (!charSequence.equals(getText())) {
            this.mInternalChange = true;
            try {
                if (this.hightlightText == null) {
                    setText(charSequence);
                } else if (this.mHasDrawable) {
                    setText(Cswitch.ad(charSequence, ContextCompat.getColor(getContext(), R.color.blue), true, false, this.hightlightText));
                } else {
                    setText(Cswitch.fe(charSequence.toString(), ContextCompat.getColor(getContext(), R.color.blue), true, this.hightlightText));
                }
            } finally {
                this.mInternalChange = false;
            }
        }
        this.mInvalid = false;
    }

    public void onDraw(Canvas canvas) {
        if (this.mInvalid) {
            ellipsizeText();
        }
        super.onDraw(canvas);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (!this.mInternalChange) {
            this.mOriginalText = charSequence;
            this.mInvalid = true;
        }
    }

    public void setAndEllipsizeText(String str) {
        CharSequence charSequence = this.mOriginalText;
        if (charSequence == null || !charSequence.equals(str)) {
            setText(str);
        } else {
            ellipsizeText();
        }
    }

    public void setDrawable(boolean z) {
        this.mHasDrawable = z;
    }

    public void setHighlightText(String... strArr) {
        this.hightlightText = strArr;
    }

    public void setLineSpacing(float f, float f2) {
        this.mSpacingAdd = f;
        this.mSpacingMult = f2;
        super.setLineSpacing(f, f2);
    }

    public void setMaxLines(int i2) {
        super.setMaxLines(i2);
        this.mMaxLines = i2;
        this.mInvalid = true;
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
