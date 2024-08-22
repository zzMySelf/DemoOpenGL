package com.baidu.searchbox.taskapi.business.feed.view.minivideo;

import android.content.Context;
import android.view.LayoutInflater;
import com.baidu.bdtask.ui.time.ProgressWidget;
import com.baidu.bdtask.ui.time.TimerOpView;
import com.baidu.searchbox.rewardsystem.operation.R;

public class MiniVideoTimerOpView extends TimerOpView {
    public MiniVideoTimerOpView(Context context) {
        super(context);
        ProgressWidget progressWidget = getProgressWidget();
        if (progressWidget != null) {
            progressWidget.enableNightMode(false);
        }
    }

    /* access modifiers changed from: protected */
    public void initInflate(LayoutInflater inflater) {
        inflater.inflate(R.layout.mini_video_landing_page_op_timer_view, this);
    }
}
