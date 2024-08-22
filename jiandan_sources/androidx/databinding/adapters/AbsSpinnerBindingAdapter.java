package androidx.databinding.adapters;

import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AbsSpinnerBindingAdapter {
    @BindingAdapter({"android:entries"})
    public static <T extends CharSequence> void setEntries(AbsSpinner absSpinner, T[] tArr) {
        if (tArr != null) {
            SpinnerAdapter adapter = absSpinner.getAdapter();
            boolean z = false;
            if (adapter != null && adapter.getCount() == tArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= tArr.length) {
                        break;
                    } else if (!tArr[i2].equals(adapter.getItem(i2))) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(absSpinner.getContext(), 17367048, tArr);
                arrayAdapter.setDropDownViewResource(17367049);
                absSpinner.setAdapter(arrayAdapter);
                return;
            }
            return;
        }
        absSpinner.setAdapter((SpinnerAdapter) null);
    }

    @BindingAdapter({"android:entries"})
    public static <T> void setEntries(AbsSpinner absSpinner, List<T> list) {
        if (list != null) {
            SpinnerAdapter adapter = absSpinner.getAdapter();
            if (adapter instanceof ObservableListAdapter) {
                ((ObservableListAdapter) adapter).setList(list);
            } else {
                absSpinner.setAdapter(new ObservableListAdapter(absSpinner.getContext(), list, 17367048, 17367049, 0));
            }
        } else {
            absSpinner.setAdapter((SpinnerAdapter) null);
        }
    }
}
