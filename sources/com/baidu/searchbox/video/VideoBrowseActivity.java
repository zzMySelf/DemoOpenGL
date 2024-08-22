package com.baidu.searchbox.video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;

public class VideoBrowseActivity extends VideoFrameBaseActivity {
    static final UBCManager ubc = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));
    Flow mFlow;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FeedUtil.fixTarget26Crash(this);
    }

    public void onInitActionBar() {
        BdActionBar actionBar = getBdActionBar();
        if (actionBar != null) {
            actionBar.setRightImgZone1Visibility(0);
            actionBar.setRightImgZone1Enable(true);
            actionBar.setRightImgZone1Src(R.drawable.video_frame_home_icon);
            actionBar.setRightImgZone1OnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CommandUtils.invokeCommand((Context) VideoBrowseActivity.this, VideoBrowseActivity.this.getHomeAction());
                }
            });
        }
    }

    public static void launchVideoBrowseActivity(Context context, String loadUrl) {
        Intent intent = new Intent(context, VideoBrowseActivity.class);
        intent.putExtra("bdsb_light_start_url", loadUrl);
        intent.putExtra("bdsb_append_param", true);
        intent.putExtra("extra_actionbar_color_id", context.getResources().getColor(R.color.video_feed_download_detail_titlebar_bg));
        ActivityUtils.startActivitySafely(context, intent);
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void startFlow(String id, String value) {
        this.mFlow = ubc.beginFlow(id);
    }

    /* access modifiers changed from: protected */
    public void endFlow() {
        Flow flow = this.mFlow;
        if (flow != null) {
            flow.setValueWithDuration(getClass().getSimpleName());
            this.mFlow.end();
        }
    }
}
