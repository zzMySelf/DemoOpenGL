package com.baidu.searchbox.widget.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.setting.core.R;

public class SingleChoicePreference extends Preference {
    private static final String KEY_SUFFIX = "_single_suffix";
    private int defaultIndex;
    private SharedPreferences.Editor editor;
    private String mValue;
    CharSequence[] showValue;
    private SharedPreferences sp;
    private String storeKey;
    CharSequence[] trueValue;

    public SingleChoicePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.defaultIndex = 0;
        TypedArray a2 = context.obtainStyledAttributes(attrs, R.styleable.SingleChoicePreference);
        this.showValue = a2.getTextArray(R.styleable.SingleChoicePreference_entries);
        this.trueValue = a2.getTextArray(R.styleable.SingleChoicePreference_entryValues);
        this.storeKey = getKey() + KEY_SUFFIX;
        a2.recycle();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.sp = defaultSharedPreferences;
        this.editor = defaultSharedPreferences.edit();
        setLayoutResource(R.layout.single_choice_preference);
        setBackgroundResource(R.color.novel_setting_item_bg);
    }

    public SingleChoicePreference(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.singleChoicePreferenceStyle);
    }

    public SingleChoicePreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getSelectingIndex() {
        return this.sp.getInt(this.storeKey, getDefaultIndex());
    }

    public void setSelectingIndex(int i2) {
        if (i2 >= 0) {
            this.editor.putInt(this.storeKey, i2);
            this.editor.commit();
        }
    }

    public void setEntries(CharSequence[] entries) {
        this.showValue = entries;
    }

    public void setEntries(int entriesResId) {
        setEntries(getContext().getResources().getTextArray(entriesResId));
    }

    public CharSequence[] getEntries() {
        return this.showValue;
    }

    public void setEntryValues(CharSequence[] entryValues) {
        this.trueValue = entryValues;
    }

    public void setEntryValues(int entryValuesResId) {
        setEntryValues(getContext().getResources().getTextArray(entryValuesResId));
    }

    public CharSequence[] getEntryValues() {
        return this.trueValue;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String value) {
        this.mValue = value;
        persistString(value);
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int index = getValueIndex();
        if (index < 0 || (charSequenceArr = this.showValue) == null) {
            return null;
        }
        return charSequenceArr[index];
    }

    public int findIndexOfValue(String value) {
        CharSequence[] charSequenceArr;
        if (value == null || (charSequenceArr = this.trueValue) == null) {
            return -1;
        }
        for (int i2 = charSequenceArr.length - 1; i2 >= 0; i2--) {
            if (this.trueValue[i2].equals(value)) {
                return i2;
            }
        }
        return -1;
    }

    public int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    public void setValueIndex(int index) {
        CharSequence[] charSequenceArr = this.trueValue;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[index].toString());
        }
    }

    public int getDefaultIndex() {
        return this.defaultIndex;
    }

    public void setDefaultIndex(int index) {
        this.defaultIndex = index;
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view2) {
        super.onBindView(view2);
        SingleChoiceView singleChoiceView = (SingleChoiceView) view2.findViewById(R.id.my_choice_view);
        for (int i2 = 0; i2 < this.showValue.length; i2++) {
            boolean isSelected = false;
            if (getSelectingIndex() == i2) {
                isSelected = true;
            }
            singleChoiceView.addChoiceItem(new ChoiceItem(i2, this.showValue[i2].toString(), isSelected, new ItemSelectedListener() {
                public void onSelected(int index) {
                    SingleChoicePreference.this.setSelectingIndex(index);
                    if (index >= 0 && SingleChoicePreference.this.trueValue != null) {
                        String value = SingleChoicePreference.this.trueValue[index].toString();
                        if (SingleChoicePreference.this.callChangeListener(value)) {
                            SingleChoicePreference.this.setValue(value);
                        }
                    }
                }

                public void onUnSelected() {
                }
            }));
        }
    }

    public boolean isSelectable() {
        return false;
    }
}
