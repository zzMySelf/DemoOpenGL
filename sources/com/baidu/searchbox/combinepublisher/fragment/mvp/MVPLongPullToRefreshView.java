package com.baidu.searchbox.combinepublisher.fragment.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.feed.widget.feedflow.LongPullToRefreshView;
import com.baidu.searchbox.publishercomponent.R;

public class MVPLongPullToRefreshView extends LongPullToRefreshView {
    public MVPLongPullToRefreshView(Context context) {
        super(context);
    }

    public MVPLongPullToRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MVPLongPullToRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
            case 2:
                View back = findViewById(R.id.back_button);
                if (back != null) {
                    back.setAlpha(0.0f);
                }
                View close = findViewById(R.id.close_button);
                if (close != null) {
                    close.setAlpha(0.0f);
                    break;
                }
                break;
            case 1:
            case 3:
                View back1 = findViewById(R.id.back_button);
                if (back1 != null) {
                    back1.setAlpha(1.0f);
                }
                View close1 = findViewById(R.id.close_button);
                if (close1 != null) {
                    close1.setAlpha(1.0f);
                    break;
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
