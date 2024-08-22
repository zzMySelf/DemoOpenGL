package com.baidu.live.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.baidu.live.feed.page.R;

public class FakeStartLiveButton extends FrameLayout {
    public FakeStartLiveButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FakeStartLiveButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FakeStartLiveButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_feed_page_fake_start_live_layout, this);
    }
}
