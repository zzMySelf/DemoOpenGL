package com.baidu.searchbox.home.feed;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.baidu.searchbox.lightbrowser.LightBrowserActivity;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import java.util.ArrayList;
import java.util.List;

public class FeedCommentActivity extends LightBrowserActivity {
    private static final String FEED_COMMENT_DURATION = "feedComment";
    private static final String TAG = "FeedCommentActivity";
    private Flow mFlow;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnableSliding(true);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mFlow = UBC.beginFlow("67");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Flow flow = this.mFlow;
        if (flow != null) {
            flow.setValueWithDuration(FEED_COMMENT_DURATION);
            this.mFlow.end();
            this.mFlow = null;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public String obtainHost() {
        return TAG;
    }

    public List<BaseToolBarItem> getToolBarItemList() {
        List<BaseToolBarItem> items = new ArrayList<>();
        items.add(new BaseToolBarItem(1));
        items.add(new BaseToolBarItem(10));
        items.add(new BaseToolBarItem(9));
        return items;
    }
}
