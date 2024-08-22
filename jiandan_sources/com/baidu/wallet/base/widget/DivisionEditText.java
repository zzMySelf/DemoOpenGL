package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.google.common.base.Ascii;

public class DivisionEditText extends SafeKeyBoardEditText {
    public static final int VIEW_TYPE_BANKCARD = 25;
    public static final int VIEW_TYPE_ID = 20;
    public static final int VIEW_TYPE_PHONE = 13;
    public boolean a;
    public int b;
    public int c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.b = 0;
        this.c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.a;
    }

    public void setFormatEnable(boolean z) {
        this.a = z;
    }

    public void setViewType(int i2) {
        this.b = i2;
        if (i2 == 13) {
            this.c = 3;
        } else if (i2 == 25) {
            this.c = 4;
        } else if (i2 == 20) {
            this.c = 6;
            if (isFormatEnabled()) {
                setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
                return;
            }
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2 - 2)});
            return;
        }
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public DivisionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = 0;
        this.c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() {
            public int a = 0;
            public int b = 0;
            public boolean c = false;
            public int d = 0;
            public int e = 0;
            public char[] g;
            public StringBuffer h = new StringBuffer();

            public void afterTextChanged(Editable editable) {
                int i2;
                if (this.c && DivisionEditText.this.isFormatEnabled()) {
                    this.d = DivisionEditText.this.getSelectionEnd();
                    int i3 = 0;
                    while (i3 < this.h.length()) {
                        if (this.h.charAt(i3) == ' ') {
                            this.h.deleteCharAt(i3);
                        } else {
                            i3++;
                        }
                    }
                    if (DivisionEditText.this.b == 13) {
                        i2 = 0;
                        for (int i4 = 0; i4 < this.h.length(); i4++) {
                            if (i4 == 3 || i4 == 8) {
                                this.h.insert(i4, Ascii.CASE_MASK);
                                i2++;
                            }
                        }
                    } else if (DivisionEditText.this.b == 25) {
                        i2 = 0;
                        for (int i5 = 0; i5 < this.h.length(); i5++) {
                            if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                this.h.insert(i5, Ascii.CASE_MASK);
                                i2++;
                            }
                        }
                    } else if (DivisionEditText.this.b == 20) {
                        i2 = 0;
                        for (int i6 = 0; i6 < this.h.length(); i6++) {
                            if (i6 == 6 || i6 == 15) {
                                this.h.insert(i6, Ascii.CASE_MASK);
                                i2++;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    int i7 = this.e;
                    if (i2 > i7) {
                        if (i2 - i7 > 1) {
                            this.d += i2 - i7;
                        } else {
                            int i8 = this.d;
                            if (i8 - 1 >= 0 && this.h.charAt(i8 - 1) == ' ') {
                                this.d += i2 - this.e;
                            }
                        }
                    }
                    this.g = new char[this.h.length()];
                    StringBuffer stringBuffer = this.h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.g, 0);
                    String stringBuffer2 = this.h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.d > text.length()) {
                        this.d = text.length();
                    } else if (this.d < 0) {
                        this.d = 0;
                    }
                    Selection.setSelection(text, this.d);
                    if (DivisionEditText.this.b == 13 && this.a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.c = false;
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.a = charSequence.length();
                if (this.h.length() > 0) {
                    StringBuffer stringBuffer = this.h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.e = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.e++;
                    }
                }
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.b = charSequence.length();
                if (DivisionEditText.this.b == 13 && this.b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.h.append(charSequence.toString());
                int i5 = this.b;
                if (i5 == this.a || i5 < DivisionEditText.this.c || this.c) {
                    this.c = false;
                } else {
                    this.c = true;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, (AttributeSet) null);
    }
}
