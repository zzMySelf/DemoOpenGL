package com.tera.scan.component.base.ui.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.aiscan.R;
import java.util.List;
import java.util.Map;

public class CustomListAdapter extends BaseAdapter {
    public static final int ALBUM_OPERATION = 4;
    public static final int CHECK_LIST_CONTENT = 2;
    public static final int CHOOSE_APP_LIST_CONTENT = 1;
    public static final int CHOOSE_CALLLOG_DEVICE_LIST = 6;
    public static final int CHOOSE_SMS_RESTORE_LIST_CONTENT = 3;
    public static final int ONLY_TEXT = 5;
    public static final int TEXT_AND_VIEW_TAG = 7;
    public static final String VIEW_DOUBLE_TEXT = "double_text";
    public static final String VIEW_TAG = "tag";
    public Context mContext;
    public LayoutInflater mInflater;
    public List<? extends Map<String, ?>> mItems;
    public int mLayout;
    public int mSelectedIndex = -1;
    public int mType;

    public CustomListAdapter(Context context, int i2, List<? extends Map<String, ?>> list, int i3) {
        this.mContext = context;
        this.mLayout = i2;
        this.mItems = list;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mType = i3;
    }

    public int getCount() {
        List<? extends Map<String, ?>> list = this.mItems;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.mItems.size();
    }

    public Object getItem(int i2) {
        List<? extends Map<String, ?>> list = this.mItems;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.mItems.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getSelectedPosition() {
        return this.mSelectedIndex;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mLayout, viewGroup, false);
        }
        Map map = (Map) this.mItems.get(i2);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.sort_checkbox);
        if (i2 == this.mSelectedIndex) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        if (map.get("text") instanceof String) {
            ((TextView) view.findViewById(R.id.list_text)).setText((CharSequence) map.get("text"));
        } else if (map.get("text") instanceof Integer) {
            ((TextView) view.findViewById(R.id.list_text)).setText(((Integer) map.get("text")).intValue());
        }
        if (map.get(VIEW_DOUBLE_TEXT) != null && (map.get(VIEW_DOUBLE_TEXT) instanceof String)) {
            TextView textView = (TextView) view.findViewById(R.id.list_text_2);
            textView.setVisibility(0);
            textView.setText((CharSequence) map.get(VIEW_DOUBLE_TEXT));
        }
        if (7 == this.mType) {
            view.setTag(map.get(VIEW_TAG));
        }
        int i3 = this.mType;
        if (i3 == 2) {
            view.findViewById(R.id.list_image).setVisibility(8);
            view.findViewById(R.id.sort_checkbox).setVisibility(0);
        } else if (i3 == 1) {
            view.findViewById(R.id.list_image).setVisibility(0);
            view.findViewById(R.id.list_image).setBackgroundDrawable((Drawable) map.get("icon"));
            view.findViewById(R.id.sort_checkbox).setVisibility(8);
        } else if (i3 == 4 || 5 == i3 || 7 == i3) {
            view.findViewById(R.id.list_image).setVisibility(8);
            view.findViewById(R.id.sort_checkbox).setVisibility(8);
        }
        return view;
    }

    public void setSelectedPosition(int i2) {
        this.mSelectedIndex = i2;
    }
}
