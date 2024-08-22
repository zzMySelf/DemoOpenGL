package com.baidu.searchbox.audio.view.fullscreenplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class AudioEpisodeListView extends ListView {
    public AudioEpisodeListView(Context context) {
        super(context);
    }

    public AudioEpisodeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AudioEpisodeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
