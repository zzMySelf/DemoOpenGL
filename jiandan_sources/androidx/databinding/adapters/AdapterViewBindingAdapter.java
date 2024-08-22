package androidx.databinding.adapters;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onItemClick", method = "setOnItemClickListener", type = AdapterView.class), @BindingMethod(attribute = "android:onItemLongClick", method = "setOnItemLongClickListener", type = AdapterView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@InverseBindingMethod(attribute = "android:selectedItemPosition", type = AdapterView.class), @InverseBindingMethod(attribute = "android:selection", event = "android:selectedItemPositionAttrChanged", method = "getSelectedItemPosition", type = AdapterView.class)})
public class AdapterViewBindingAdapter {

    public interface OnItemSelected {
        void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j);
    }

    public static class OnItemSelectedComponentListener implements AdapterView.OnItemSelectedListener {
        public final InverseBindingListener mAttrChanged;
        public final OnNothingSelected mNothingSelected;
        public final OnItemSelected mSelected;

        public OnItemSelectedComponentListener(OnItemSelected onItemSelected, OnNothingSelected onNothingSelected, InverseBindingListener inverseBindingListener) {
            this.mSelected = onItemSelected;
            this.mNothingSelected = onNothingSelected;
            this.mAttrChanged = inverseBindingListener;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            OnItemSelected onItemSelected = this.mSelected;
            if (onItemSelected != null) {
                onItemSelected.onItemSelected(adapterView, view, i2, j);
            }
            InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            OnNothingSelected onNothingSelected = this.mNothingSelected;
            if (onNothingSelected != null) {
                onNothingSelected.onNothingSelected(adapterView);
            }
            InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }
    }

    public interface OnNothingSelected {
        void onNothingSelected(AdapterView<?> adapterView);
    }

    @BindingAdapter(requireAll = false, value = {"android:onItemSelected", "android:onNothingSelected", "android:selectedItemPositionAttrChanged"})
    public static void setOnItemSelectedListener(AdapterView adapterView, OnItemSelected onItemSelected, OnNothingSelected onNothingSelected, InverseBindingListener inverseBindingListener) {
        if (onItemSelected == null && onNothingSelected == null && inverseBindingListener == null) {
            adapterView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        } else {
            adapterView.setOnItemSelectedListener(new OnItemSelectedComponentListener(onItemSelected, onNothingSelected, inverseBindingListener));
        }
    }

    @BindingAdapter({"android:selectedItemPosition"})
    public static void setSelectedItemPosition(AdapterView adapterView, int i2) {
        if (adapterView.getSelectedItemPosition() != i2) {
            adapterView.setSelection(i2);
        }
    }

    @BindingAdapter({"android:selection"})
    public static void setSelection(AdapterView adapterView, int i2) {
        setSelectedItemPosition(adapterView, i2);
    }

    @BindingAdapter({"android:selection", "android:adapter"})
    public static void setSelection(AdapterView adapterView, int i2, Adapter adapter) {
        setSelectedItemPosition(adapterView, i2, adapter);
    }

    @BindingAdapter({"android:selectedItemPosition", "android:adapter"})
    public static void setSelectedItemPosition(AdapterView adapterView, int i2, Adapter adapter) {
        if (adapter != adapterView.getAdapter()) {
            adapterView.setAdapter(adapter);
            adapterView.setSelection(i2);
        } else if (adapterView.getSelectedItemPosition() != i2) {
            adapterView.setSelection(i2);
        }
    }
}
