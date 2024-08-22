package com.baidu.searchbox.taskapi.business.feed.view.minivideo;

import android.content.Context;
import android.view.LayoutInflater;
import com.baidu.bdtask.ui.base.OperationTipView;
import com.baidu.bdtask.ui.nomal.NormalOpView;
import com.baidu.searchbox.rewardsystem.operation.R;

public class MiniVideoNormalOpView extends NormalOpView {
    public MiniVideoNormalOpView(Context context) {
        super(context);
        enableNightMode(false);
    }

    /* access modifiers changed from: protected */
    public void initInflate(LayoutInflater inflater) {
        inflater.inflate(R.layout.mini_video_landing_page_op_normal_view, this);
    }

    /* access modifiers changed from: protected */
    public void initTipView() {
        this.mTipView = (OperationTipView) findViewById(R.id.mini_video_op_tip_view);
    }

    public void updateUI() {
        super.updateUI();
        this.mCloseView.setBackground(getResources().getDrawable(R.drawable.mini_video_landing_op_float_close));
    }
}
