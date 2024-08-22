package com.tera.scan.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import fe.mmm.qw.j.Cif;
import java.io.UnsupportedEncodingException;

public class LengthLimitedEditText extends EditText {
    public static final String ENCODEING = "UTF-8";
    public static final String TAG = "LengthLimitedEditText";
    public InputFilter inputFilter = new qw();
    public EditTextWatcher mEditTextWatcher;
    public boolean mIsCheckByteLengthFlag = true;
    public int mMaxByteLength = Integer.MAX_VALUE;

    public interface EditTextWatcher {
        void ad();

        void qw(int i2);
    }

    public class qw implements InputFilter {
        public qw() {
        }

        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int i6;
            boolean z;
            boolean z2 = false;
            do {
                try {
                    SpannableStringBuilder replace = new SpannableStringBuilder(spanned).replace(i4, i5, charSequence.subSequence(i2, i3));
                    if (LengthLimitedEditText.this.mIsCheckByteLengthFlag) {
                        i6 = replace.toString().getBytes("UTF-8").length;
                    } else {
                        i6 = Cif.qw(replace.toString());
                    }
                    z = i6 > LengthLimitedEditText.this.mMaxByteLength;
                    if (z) {
                        if (!z2) {
                            LengthLimitedEditText.this.notifyTextChanged(i6);
                            z2 = true;
                        }
                        i3--;
                        charSequence = charSequence.subSequence(i2, i3);
                        continue;
                    } else {
                        LengthLimitedEditText.this.notifyTextChanged(i6);
                        continue;
                    }
                } catch (UnsupportedEncodingException e) {
                    fe.mmm.qw.i.qw.th(LengthLimitedEditText.TAG, "", e);
                    return "Exception";
                }
            } while (z);
            return charSequence;
        }
    }

    public LengthLimitedEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        setFilters(new InputFilter[]{this.inputFilter});
    }

    /* access modifiers changed from: private */
    public void notifyTextChanged(int i2) {
        EditTextWatcher editTextWatcher = this.mEditTextWatcher;
        if (editTextWatcher != null) {
            editTextWatcher.qw(i2);
        }
    }

    public int getMaxByteLength() {
        return this.mMaxByteLength;
    }

    public boolean onTextContextMenuItem(int i2) {
        EditTextWatcher editTextWatcher;
        int i3;
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (i2 == 16908322) {
            long j = 0;
            try {
                CharSequence text = clipboardManager.getText();
                if (text != null) {
                    if (this.mIsCheckByteLengthFlag) {
                        i3 = text.toString().getBytes("UTF-8").length;
                    } else {
                        i3 = Cif.qw(text.toString());
                    }
                    j = (long) i3;
                }
            } catch (UnsupportedEncodingException e) {
                fe.mmm.qw.i.qw.th(TAG, "", e);
            }
            if (j > ((long) this.mMaxByteLength) && (editTextWatcher = this.mEditTextWatcher) != null) {
                editTextWatcher.ad();
                return false;
            }
        }
        return super.onTextContextMenuItem(i2);
    }

    public void setEditTextWatcher(EditTextWatcher editTextWatcher) {
        this.mEditTextWatcher = editTextWatcher;
    }

    public void setMaxByteLength(int i2) {
        this.mIsCheckByteLengthFlag = true;
        this.mMaxByteLength = i2;
    }

    public void setMaxCharacterLength(int i2) {
        this.mIsCheckByteLengthFlag = false;
        this.mMaxByteLength = i2;
    }

    public LengthLimitedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
