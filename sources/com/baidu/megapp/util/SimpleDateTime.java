package com.baidu.megapp.util;

public class SimpleDateTime {
    int mDay;
    int mHourOfDay;
    int mMinute;
    int mMonth;
    int mSecond;
    int mYear;

    public final void set(int year, int month, int day, int hourOfDay, int minute, int second) {
        this.mYear = year;
        this.mMonth = month;
        this.mDay = day;
        this.mHourOfDay = hourOfDay;
        this.mMinute = minute;
        this.mSecond = second;
    }

    public String toString() {
        return this.mYear + "-" + this.mMonth + "-" + this.mDay + " " + this.mHourOfDay + ":" + this.mMinute + ":" + this.mSecond;
    }

    public int compareTo(SimpleDateTime datetime) {
        int i2 = this.mYear;
        int i3 = datetime.mYear;
        if (i2 - i3 > 0) {
            return 1;
        }
        if (i2 - i3 < 0) {
            return -1;
        }
        int i4 = this.mMonth;
        int i5 = datetime.mMonth;
        if (i4 - i5 > 0) {
            return 1;
        }
        if (i4 - i5 < 0) {
            return -1;
        }
        int i6 = this.mDay;
        int i7 = datetime.mDay;
        if (i6 - i7 > 0) {
            return 1;
        }
        if (i6 - i7 < 0) {
            return -1;
        }
        int i8 = this.mHourOfDay;
        int i9 = datetime.mHourOfDay;
        if (i8 - i9 > 0) {
            return 1;
        }
        if (i8 - i9 < 0) {
            return -1;
        }
        int i10 = this.mMinute;
        int i11 = datetime.mMinute;
        if (i10 - i11 > 0) {
            return 1;
        }
        if (i10 - i11 < 0) {
            return -1;
        }
        int i12 = this.mSecond;
        int i13 = datetime.mSecond;
        if (i12 - i13 > 0) {
            return 1;
        }
        if (i12 - i13 < 0) {
            return -1;
        }
        return 0;
    }
}
