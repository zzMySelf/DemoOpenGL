package com.baidu.searchbox.favor.debug.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.favor.core.R;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favor.sync.business.favor.util.DataUtil;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;

public class FavorVisitItem extends FrameLayout {
    private TextView mCount;
    private TextView mTime;
    private TextView mTitle;

    public FavorVisitItem(Context context) {
        super(context);
        initView();
    }

    public FavorVisitItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public FavorVisitItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view2 = inflate(getContext(), R.layout.favor_view_user_action_item_test, this);
        this.mTitle = (TextView) view2.findViewById(R.id.favor_user_action_title);
        this.mCount = (TextView) view2.findViewById(R.id.favor_user_action_visit_count);
        this.mTime = (TextView) view2.findViewById(R.id.favor_user_action_visit_time);
    }

    public void updateItem(FavorModel model) {
        if (model != null) {
            this.mTitle.setText(FileViewerActivity.LEFT_BRACKET + model.tplId + ")#" + model.title);
            this.mCount.setText("浏览次数:" + model.visits);
            long time = Long.parseLong(model.visitTime == null ? "0" : model.visitTime);
            if (time <= 0) {
                this.mTime.setText("上次浏览收藏时间:未记录");
            } else {
                this.mTime.setText("最近浏览收藏时间:" + DataUtil.timestamp2Date(time, "yyyy-MM-dd HH:mm:ss"));
            }
        }
    }
}
