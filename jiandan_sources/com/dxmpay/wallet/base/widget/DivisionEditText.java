package com.dxmpay.wallet.base.widget;

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

    public class qw implements TextWatcher {

        /* renamed from: ad  reason: collision with root package name */
        public int f4157ad = 0;

        /* renamed from: i  reason: collision with root package name */
        public char[] f4158i;

        /* renamed from: o  reason: collision with root package name */
        public StringBuffer f4159o = new StringBuffer();

        /* renamed from: pf  reason: collision with root package name */
        public int f4160pf = 0;

        /* renamed from: th  reason: collision with root package name */
        public int f4161th = 0;

        /* renamed from: uk  reason: collision with root package name */
        public int f4162uk = 0;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f4163yj = false;

        public qw() {
        }

        public void afterTextChanged(Editable editable) {
            int i2;
            if (this.f4163yj && DivisionEditText.this.isFormatEnabled()) {
                this.f4162uk = DivisionEditText.this.getSelectionEnd();
                int i3 = 0;
                while (i3 < this.f4159o.length()) {
                    if (this.f4159o.charAt(i3) == ' ') {
                        this.f4159o.deleteCharAt(i3);
                    } else {
                        i3++;
                    }
                }
                if (DivisionEditText.this.b == 13) {
                    i2 = 0;
                    for (int i4 = 0; i4 < this.f4159o.length(); i4++) {
                        if (i4 == 3 || i4 == 8) {
                            this.f4159o.insert(i4, Ascii.CASE_MASK);
                            i2++;
                        }
                    }
                } else if (DivisionEditText.this.b == 25) {
                    i2 = 0;
                    for (int i5 = 0; i5 < this.f4159o.length(); i5++) {
                        if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                            this.f4159o.insert(i5, Ascii.CASE_MASK);
                            i2++;
                        }
                    }
                } else if (DivisionEditText.this.b == 20) {
                    i2 = 0;
                    for (int i6 = 0; i6 < this.f4159o.length(); i6++) {
                        if (i6 == 6 || i6 == 15) {
                            this.f4159o.insert(i6, Ascii.CASE_MASK);
                            i2++;
                        }
                    }
                } else {
                    i2 = 0;
                }
                int i7 = this.f4160pf;
                if (i2 > i7) {
                    if (i2 - i7 > 1) {
                        this.f4162uk += i2 - i7;
                    } else {
                        int i8 = this.f4162uk;
                        if (i8 - 1 >= 0 && this.f4159o.charAt(i8 - 1) == ' ') {
                            this.f4162uk += i2 - this.f4160pf;
                        }
                    }
                }
                this.f4158i = new char[this.f4159o.length()];
                StringBuffer stringBuffer = this.f4159o;
                stringBuffer.getChars(0, stringBuffer.length(), this.f4158i, 0);
                String stringBuffer2 = this.f4159o.toString();
                if (stringBuffer2.length() > DivisionEditText.this.b) {
                    stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.b);
                }
                DivisionEditText.this.setText(stringBuffer2);
                Editable text = DivisionEditText.this.getText();
                if (this.f4162uk > text.length()) {
                    this.f4162uk = text.length();
                } else if (this.f4162uk < 0) {
                    this.f4162uk = 0;
                }
                Selection.setSelection(text, this.f4162uk);
                if (DivisionEditText.this.b == 13 && this.f4157ad < editable.length()) {
                    if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                        Selection.setSelection(text, 11);
                    } else if (text.length() == 13) {
                        Selection.setSelection(text, 13);
                    }
                }
                this.f4163yj = false;
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f4157ad = charSequence.length();
            if (this.f4159o.length() > 0) {
                StringBuffer stringBuffer = this.f4159o;
                stringBuffer.delete(0, stringBuffer.length());
            }
            this.f4160pf = 0;
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                if (charSequence.charAt(i5) == ' ') {
                    this.f4160pf++;
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f4161th = charSequence.length();
            if (DivisionEditText.this.b == 13 && this.f4161th >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
            }
            this.f4159o.append(charSequence.toString());
            int i5 = this.f4161th;
            if (i5 == this.f4157ad || i5 < DivisionEditText.this.c || this.f4163yj) {
                this.f4163yj = false;
            } else {
                this.f4163yj = true;
            }
        }
    }

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
        addTextChangedListener(new qw());
    }

    public DivisionEditText(Context context) {
        this(context, (AttributeSet) null);
    }
}
