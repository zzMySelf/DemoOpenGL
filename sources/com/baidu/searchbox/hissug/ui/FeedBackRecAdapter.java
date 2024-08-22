package com.baidu.searchbox.hissug.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.searchbox.hissug.ui.HissugFeedbackView;
import com.baidu.searchbox.hissug.util.HissugFeedbackDetailModel;
import java.util.ArrayList;

public class FeedBackRecAdapter extends BaseAdapter {
    private HissugFeedbackView.InputFocusListener inputFocusListener;
    private Context mContext;
    private ArrayList<HissugFeedbackDetailModel> mFeedbackRec;

    public FeedBackRecAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<HissugFeedbackDetailModel> feedbackRec) {
        this.mFeedbackRec = feedbackRec;
        notifyDataSetChanged();
    }

    public void setInputFocusListener(HissugFeedbackView.InputFocusListener listener) {
        this.inputFocusListener = listener;
    }

    public int getCount() {
        ArrayList<HissugFeedbackDetailModel> arrayList = this.mFeedbackRec;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public HissugFeedbackDetailModel getItem(int position) {
        ArrayList<HissugFeedbackDetailModel> arrayList = this.mFeedbackRec;
        if (arrayList == null || arrayList.size() <= position) {
            return null;
        }
        return this.mFeedbackRec.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = new HissugFeedBackRecWordItem(this.mContext);
            viewHolder = new ViewHolder();
            viewHolder.mRecItem = (HissugFeedBackRecWordItem) convertView;
            viewHolder.mRecItem.setInputFocusListener(this.inputFocusListener);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mRecItem.setData(getItem(position));
        return convertView;
    }

    private class ViewHolder {
        HissugFeedBackRecWordItem mRecItem;

        private ViewHolder() {
        }
    }
}
