package androidx.databinding.adapters;

import android.os.Build;
import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TimePickerBindingAdapter {
    @InverseBindingAdapter(attribute = "android:hour")
    public static int getHour(TimePicker timePicker) {
        if (Build.VERSION.SDK_INT >= 23) {
            return timePicker.getHour();
        }
        Integer currentHour = timePicker.getCurrentHour();
        if (currentHour == null) {
            return 0;
        }
        return currentHour.intValue();
    }

    @InverseBindingAdapter(attribute = "android:minute")
    public static int getMinute(TimePicker timePicker) {
        if (Build.VERSION.SDK_INT >= 23) {
            return timePicker.getMinute();
        }
        Integer currentMinute = timePicker.getCurrentMinute();
        if (currentMinute == null) {
            return 0;
        }
        return currentMinute.intValue();
    }

    @BindingAdapter({"android:hour"})
    public static void setHour(TimePicker timePicker, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (timePicker.getHour() != i2) {
                timePicker.setHour(i2);
            }
        } else if (timePicker.getCurrentHour().intValue() != i2) {
            timePicker.setCurrentHour(Integer.valueOf(i2));
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onTimeChanged", "android:hourAttrChanged", "android:minuteAttrChanged"})
    public static void setListeners(TimePicker timePicker, final TimePicker.OnTimeChangedListener onTimeChangedListener, final InverseBindingListener inverseBindingListener, final InverseBindingListener inverseBindingListener2) {
        if (inverseBindingListener == null && inverseBindingListener2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
                    TimePicker.OnTimeChangedListener onTimeChangedListener = onTimeChangedListener;
                    if (onTimeChangedListener != null) {
                        onTimeChangedListener.onTimeChanged(timePicker, i2, i3);
                    }
                    InverseBindingListener inverseBindingListener = inverseBindingListener;
                    if (inverseBindingListener != null) {
                        inverseBindingListener.onChange();
                    }
                    InverseBindingListener inverseBindingListener2 = inverseBindingListener2;
                    if (inverseBindingListener2 != null) {
                        inverseBindingListener2.onChange();
                    }
                }
            });
        }
    }

    @BindingAdapter({"android:minute"})
    public static void setMinute(TimePicker timePicker, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (timePicker.getMinute() != i2) {
                timePicker.setMinute(i2);
            }
        } else if (timePicker.getCurrentMinute().intValue() != i2) {
            timePicker.setCurrentHour(Integer.valueOf(i2));
        }
    }
}
