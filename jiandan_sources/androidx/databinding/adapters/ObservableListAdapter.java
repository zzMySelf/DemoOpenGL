package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ObservableListAdapter<T> extends BaseAdapter {
    public final Context mContext;
    public final int mDropDownResourceId;
    public final LayoutInflater mLayoutInflater;
    public List<T> mList;
    public ObservableList.OnListChangedCallback mListChangedCallback;
    public final int mResourceId;
    public final int mTextViewResourceId;

    public ObservableListAdapter(Context context, List<T> list, int i2, int i3, int i4) {
        LayoutInflater layoutInflater;
        this.mContext = context;
        this.mResourceId = i2;
        this.mDropDownResourceId = i3;
        this.mTextViewResourceId = i4;
        if (i2 == 0) {
            layoutInflater = null;
        } else {
            layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
        this.mLayoutInflater = layoutInflater;
        setList(list);
    }

    public int getCount() {
        return this.mList.size();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mDropDownResourceId, i2, view, viewGroup);
    }

    public Object getItem(int i2) {
        return this.mList.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mResourceId, i2, view, viewGroup);
    }

    public View getViewForResource(int i2, int i3, View view, ViewGroup viewGroup) {
        View view2;
        CharSequence charSequence;
        if (view == null) {
            if (i2 == 0) {
                view = new TextView(this.mContext);
            } else {
                view = this.mLayoutInflater.inflate(i2, viewGroup, false);
            }
        }
        int i4 = this.mTextViewResourceId;
        if (i4 == 0) {
            view2 = view;
        } else {
            view2 = view.findViewById(i4);
        }
        TextView textView = (TextView) view2;
        T t = this.mList.get(i3);
        if (t instanceof CharSequence) {
            charSequence = (CharSequence) t;
        } else {
            charSequence = String.valueOf(t);
        }
        textView.setText(charSequence);
        return view;
    }

    public void setList(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 != list) {
            if (list2 instanceof ObservableList) {
                ((ObservableList) list2).removeOnListChangedCallback(this.mListChangedCallback);
            }
            this.mList = list;
            if (list instanceof ObservableList) {
                if (this.mListChangedCallback == null) {
                    this.mListChangedCallback = new ObservableList.OnListChangedCallback() {
                        public void onChanged(ObservableList observableList) {
                            ObservableListAdapter.this.notifyDataSetChanged();
                        }

                        public void onItemRangeChanged(ObservableList observableList, int i2, int i3) {
                            ObservableListAdapter.this.notifyDataSetChanged();
                        }

                        public void onItemRangeInserted(ObservableList observableList, int i2, int i3) {
                            ObservableListAdapter.this.notifyDataSetChanged();
                        }

                        public void onItemRangeMoved(ObservableList observableList, int i2, int i3, int i4) {
                            ObservableListAdapter.this.notifyDataSetChanged();
                        }

                        public void onItemRangeRemoved(ObservableList observableList, int i2, int i3) {
                            ObservableListAdapter.this.notifyDataSetChanged();
                        }
                    };
                }
                ((ObservableList) this.mList).addOnListChangedCallback(this.mListChangedCallback);
            }
            notifyDataSetChanged();
        }
    }
}
