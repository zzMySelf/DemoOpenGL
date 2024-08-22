package com.baidu.searchbox.widget.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.dialog.TimePickerDialog;
import com.baidu.searchbox.widget.preference.Preference;
import java.util.Calendar;

public class TimePickerPreference extends DialogPreference {
    private Calendar calendar;
    /* access modifiers changed from: private */
    public TimePickerDialog mTimePickerDialog = null;
    private String mValue;

    public TimePickerPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public TimePickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.mTimePickerDialog = (TimePickerDialog) new TimePickerDialog.Builder(context).setTitle(getDialogTitle()).setNegativeButton(R.string.dialog_nagtive_button_text, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.dialog_positive_button_text, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String value = String.valueOf((((long) TimePickerPreference.this.mTimePickerDialog.getHour()) * 3600000) + (((long) TimePickerPreference.this.mTimePickerDialog.getMinute()) * 60000));
                if (TimePickerPreference.this.callChangeListener(value)) {
                    TimePickerPreference.this.setValue(value);
                    TimePickerPreference timePickerPreference = TimePickerPreference.this;
                    timePickerPreference.setSubTitle(timePickerPreference.getSubTitle());
                    TimePickerPreference.this.notifyChanged();
                }
                dialog.dismiss();
            }
        }).create();
        this.calendar = Calendar.getInstance();
    }

    /* access modifiers changed from: protected */
    public void showDialog(Bundle state) {
        Calendar calendar2 = this.calendar;
        if (calendar2 != null) {
            this.mTimePickerDialog.setHour(calendar2.get(11));
            this.mTimePickerDialog.setMinute(this.calendar.get(12));
        }
        this.mTimePickerDialog.show();
    }

    /* access modifiers changed from: protected */
    public View onCreateDialogView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onBindDialogView(View view2) {
        super.onBindDialogView(view2);
    }

    /* access modifiers changed from: protected */
    public void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray a2, int index) {
        return a2.getString(index);
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        setValue(restorePersistedValue ? getPersistedString(this.mValue) : (String) defaultValue);
        setSubTitle(getSubTitle());
    }

    public CharSequence getSubTitle() {
        if (this.calendar == null) {
            return null;
        }
        return DateFormat.getTimeFormat(getContext()).format(this.calendar.getTime());
    }

    public void setValue(String value) {
        this.mValue = value;
        persistString(value);
        setCalendar();
    }

    public void setValue(String value, boolean isUpdateSubtitle) {
        setValue(value);
        if (isUpdateSubtitle) {
            setSubTitle(getSubTitle());
        }
    }

    public void setViewShowFrontLockView(boolean isViewShowFrontLockView) {
        TimePickerDialog timePickerDialog = this.mTimePickerDialog;
        if (timePickerDialog != null) {
            timePickerDialog.setViewShowFrontLockView(isViewShowFrontLockView);
        }
    }

    public String getValue() {
        return this.mValue;
    }

    private void setCalendar() {
        if (TextUtils.isDigitsOnly(this.mValue)) {
            long time = 0;
            try {
                time = Long.parseLong(this.mValue);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            this.calendar.set(11, getHour(time));
            this.calendar.set(12, getMinute(time));
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        if (isPersistent()) {
            return superState;
        }
        SavedState myState = new SavedState(superState);
        myState.value = getValue();
        return myState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setValue(myState.value);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        String value;

        public SavedState(Parcel source) {
            super(source);
            this.value = source.readString();
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.value);
        }
    }

    private static int getHour(long time) {
        return (int) (time / 3600000);
    }

    private static int getMinute(long time) {
        return (int) ((time / 60000) % 60);
    }
}
