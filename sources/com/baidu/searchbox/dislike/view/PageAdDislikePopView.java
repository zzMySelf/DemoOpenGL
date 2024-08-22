package com.baidu.searchbox.dislike.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.feed.widget.newsfeedback.debug.IDebugDislikeReporter;
import com.baidu.searchbox.feed.widget.newsfeedback.debug.IDebugDislikeViewEventHelper;
import com.baidu.searchbox.feed.widget.newsfeedback.view.DislikePopupView;
import com.baidu.searchbox.lightbrowser.model.FeedItemTag;
import java.util.List;

public class PageAdDislikePopView extends DislikePopupView {
    private final IDebugDislikeViewEventHelper mFeedDislikeEventHelper = IDebugDislikeReporter.Impl.get().newEventHelper();

    public PageAdDislikePopView(Context context) {
        super(context, false, true);
    }

    public void setOptions(List<FeedItemTag> tags) {
        super.setOptions(tags);
        IDebugDislikeViewEventHelper iDebugDislikeViewEventHelper = this.mFeedDislikeEventHelper;
        if (iDebugDislikeViewEventHelper != null) {
            iDebugDislikeViewEventHelper.setTags(getTags());
        }
    }

    public View onCreateContentView(View anchor, LayoutInflater inflater) {
        LinearLayout popupView = createFeedStyleMultiTagsView(inflater);
        View bodyView = getMultiTagsBodyView();
        if (bodyView != null) {
            addEventToBodyView(bodyView);
        }
        setupPopupContentViewEvent(popupView);
        updateInterestTitle(popupView);
        return popupView;
    }

    private void addEventToBodyView(View bodyView) {
        IDebugDislikeViewEventHelper iDebugDislikeViewEventHelper = this.mFeedDislikeEventHelper;
        if (iDebugDislikeViewEventHelper != null) {
            iDebugDislikeViewEventHelper.setCallback(this.mCallback);
            bodyView.setOnTouchListener(this.mFeedDislikeEventHelper.getTouchListener());
        }
    }
}
