package com.baidu.searchbox.history;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;

public class HistoryCustomLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "HistoryLinearManager";

    public HistoryCustomLinearLayoutManager(Context context) {
        super(context);
    }

    public HistoryCustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public HistoryCustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "HistoryCustomLinearLayoutManager onLayoutChildren exception" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }
}
