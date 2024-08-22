package com.baidu.searchbox.download.center.ui.video.fusion.adapter;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.common.ui.style.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/adapter/VideoItemTouchStateListener;", "Landroid/view/View$OnTouchListener;", "()V", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemTouchStateListener.kt */
public final class VideoItemTouchStateListener implements View.OnTouchListener {
    public boolean onTouch(View view2, MotionEvent event) {
        if (view2 == null || event == null) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                view2.setBackgroundColor(view2.getResources().getColor(R.color.GC72));
                break;
            case 2:
                break;
            default:
                view2.setBackgroundColor(view2.getResources().getColor(R.color.GC18));
                break;
        }
        return false;
    }
}
