package com.baidu.wallet.paysdk.ui.widget.compliance.entity;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateEntity implements Serializable {
    public int day;
    public int month;
    public int year;

    public static DateEntity dayOnFuture(int i2) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, i2);
        return target(instance);
    }

    public static DateEntity monthOnFuture(int i2) {
        Calendar instance = Calendar.getInstance();
        instance.add(2, i2);
        return target(instance);
    }

    public static DateEntity target(int i2, int i3, int i4) {
        DateEntity dateEntity = new DateEntity();
        dateEntity.setYear(i2);
        dateEntity.setMonth(i3);
        dateEntity.setDay(i4);
        return dateEntity;
    }

    public static DateEntity today() {
        return target(Calendar.getInstance());
    }

    public static DateEntity yearOnFuture(int i2) {
        Calendar instance = Calendar.getInstance();
        instance.add(1, i2);
        return target(instance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DateEntity.class != obj.getClass()) {
            return false;
        }
        DateEntity dateEntity = (DateEntity) obj;
        if (this.year == dateEntity.year && this.month == dateEntity.month && this.day == dateEntity.day) {
            return true;
        }
        return false;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day)});
    }

    public void setDay(int i2) {
        this.day = i2;
    }

    public void setMonth(int i2) {
        this.month = i2;
    }

    public void setYear(int i2) {
        this.year = i2;
    }

    @NonNull
    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
    }

    public long toTimeInMillis() {
        Calendar instance = Calendar.getInstance();
        instance.set(1, this.year);
        instance.set(2, this.month - 1);
        instance.set(5, this.day);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static DateEntity target(Calendar calendar) {
        return target(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static DateEntity target(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return target(instance);
    }
}
