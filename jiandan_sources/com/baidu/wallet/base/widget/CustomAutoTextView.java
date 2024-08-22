package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.core.utils.LogUtil;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

public class CustomAutoTextView extends AutoCompleteTextView {
    public static final int VIEW_TYPE_BANKCARD = 24;
    public static final int VIEW_TYPE_PHONE = 13;
    public String a;
    public int b;
    public int c;
    public Context d;
    public int e;
    public List<IEditTextPasteFilter> f;
    public ShowDropDownListener g;

    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = CustomAutoTextView.class.getSimpleName();
        this.b = 13;
        this.c = 3;
        this.d = null;
        this.f = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f.addAll(parseEditTextPasteFilter);
        }
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.f.add(iEditTextPasteFilter);
        }
    }

    public boolean enoughToFilter() {
        return true;
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            GlobalUtils.hideInputMethod(this.d, this);
        } else if (getAdapter() != null) {
            performFiltering(getText(), 0);
        }
    }

    public boolean onTextContextMenuItem(int i2) {
        String str;
        if (i2 != 16908322) {
            return super.onTextContextMenuItem(i2);
        }
        String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f);
        Editable editableText = getEditableText();
        try {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            if (editableText == null) {
                return super.onTextContextMenuItem(i2);
            }
            String obj = editableText.toString();
            if (!TextUtils.isEmpty(obj)) {
                int length = obj.length();
                String substring = obj.substring(0, selectionStart);
                String substring2 = obj.substring(selectionEnd, length);
                if (!TextUtils.isEmpty(substring)) {
                    str = "" + substring;
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                    str = str + applyEditTextPasteFilters;
                }
                if (!TextUtils.isEmpty(substring2)) {
                    applyEditTextPasteFilters = str + substring2;
                } else {
                    applyEditTextPasteFilters = str;
                }
            }
            if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                applyEditTextPasteFilters = applyEditTextPasteFilters.replace(" ", "");
            }
            setText("");
            setText(applyEditTextPasteFilters);
            setSelection(getEditableText().length());
            requestFocus();
            return true;
        } catch (Exception e2) {
            LogUtil.d(this.a, e2.getMessage());
            return super.onTextContextMenuItem(i2);
        }
    }

    public void setShowDropDownListener(ShowDropDownListener showDropDownListener) {
        this.g = showDropDownListener;
    }

    public void showDropDown() {
        if (getText().length() != 13 && getAdapter() != null && getAdapter().getCount() != 0) {
            ShowDropDownListener showDropDownListener = this.g;
            if (showDropDownListener != null) {
                showDropDownListener.showDisplayTranslucent();
            }
            super.showDropDown();
        }
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = CustomAutoTextView.class.getSimpleName();
        this.b = 13;
        this.c = 3;
        this.d = null;
        this.f = new ArrayList();
        this.d = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f.addAll(parseEditTextPasteFilter);
        }
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
                if (this.c) {
                    this.d = CustomAutoTextView.this.getSelectionEnd();
                    int i3 = 100;
                    if (CustomAutoTextView.this.b == 13) {
                        i3 = 3;
                    }
                    int i4 = 0;
                    loop0:
                    while (true) {
                        boolean z = true;
                        while (i4 < this.h.length()) {
                            if (i4 == i3 && this.h.charAt(i4) != ' ' && this.b == this.a - 1 && z) {
                                i4--;
                                this.h.deleteCharAt(i4);
                                this.d--;
                                z = false;
                            }
                            if (this.h.charAt(i4) == ' ') {
                                this.h.deleteCharAt(i4);
                                i3 = i4 + 4;
                            } else {
                                i4++;
                            }
                        }
                        break loop0;
                    }
                    if (CustomAutoTextView.this.b == 13) {
                        i2 = 0;
                        for (int i5 = 0; i5 < this.h.length(); i5++) {
                            if (i5 == 3 || i5 == 8) {
                                this.h.insert(i5, Ascii.CASE_MASK);
                                i2++;
                            }
                        }
                    } else if (CustomAutoTextView.this.b == 24) {
                        i2 = 0;
                        for (int i6 = 0; i6 < this.h.length(); i6++) {
                            if (i6 == 4 || i6 == 9 || i6 == 14 || i6 == 19) {
                                this.h.insert(i6, Ascii.CASE_MASK);
                                i2++;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    int i7 = this.e;
                    if (i2 > i7) {
                        this.d += i2 - i7;
                    }
                    this.g = new char[this.h.length()];
                    StringBuffer stringBuffer = this.h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.g, 0);
                    String stringBuffer2 = this.h.toString();
                    if (stringBuffer2.length() > CustomAutoTextView.this.b) {
                        stringBuffer2 = stringBuffer2.substring(0, CustomAutoTextView.this.b);
                    }
                    if (this.d > stringBuffer2.length()) {
                        this.d = stringBuffer2.length();
                    } else if (this.d < 0) {
                        this.d = 0;
                    }
                    CustomAutoTextView.this.setText(stringBuffer2);
                    Editable text = CustomAutoTextView.this.getText();
                    Selection.setSelection(text, this.d);
                    if (CustomAutoTextView.this.b == 13 && text.length() == 13) {
                        Selection.setSelection(text, 13);
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
                this.h.append(charSequence.toString());
                int i5 = this.b;
                if (i5 == this.a || i5 < CustomAutoTextView.this.c || this.c) {
                    this.c = false;
                } else {
                    this.c = true;
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalUtils.showInputMethod(CustomAutoTextView.this.d, view);
                int[] iArr = new int[2];
                CustomAutoTextView.this.getLocationInWindow(iArr);
                int paddingLeft = CustomAutoTextView.this.getPaddingLeft();
                int action = motionEvent.getAction();
                Layout layout = CustomAutoTextView.this.getLayout();
                if (action == 0) {
                    int unused = CustomAutoTextView.this.e = layout.getOffsetForHorizontal(layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY())), (float) ((int) ((motionEvent.getX() - ((float) iArr[0])) - ((float) paddingLeft))));
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.e);
                } else if (action == 1 || action == 2) {
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.e, layout.getOffsetForHorizontal(layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY())), (float) ((((int) motionEvent.getX()) - iArr[0]) - paddingLeft)));
                }
                return false;
            }
        });
    }

    public CustomAutoTextView(Context context) {
        this(context, (AttributeSet) null);
    }
}
