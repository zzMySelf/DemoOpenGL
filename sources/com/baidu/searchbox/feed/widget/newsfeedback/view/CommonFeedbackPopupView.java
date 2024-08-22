package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.widget.newsfeedback.debug.IDebugDislikeReporter;
import com.baidu.searchbox.feed.widget.newsfeedback.debug.IDebugDislikeViewEventHelper;
import com.baidu.searchbox.lightbrowser.model.FeedItemTag;
import java.util.List;

public class CommonFeedbackPopupView extends ArrowFeedbackPopupView {
    private final IDebugDislikeViewEventHelper mFeedDislikeEventHelper = IDebugDislikeReporter.Impl.get().newEventHelper();
    private final View.OnClickListener mTagItemClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Object tag = v.getTag();
            if (tag instanceof FeedItemTag) {
                FeedItemTag tagItem = (FeedItemTag) tag;
                tagItem.isSelected = !tagItem.isSelected;
                v.setSelected(tagItem.isSelected);
            }
        }
    };

    public CommonFeedbackPopupView(Context context) {
        super(context);
    }

    public void setOptions(List<FeedItemTag> tags) {
        super.setOptions(tags);
        IDebugDislikeViewEventHelper iDebugDislikeViewEventHelper = this.mFeedDislikeEventHelper;
        if (iDebugDislikeViewEventHelper != null) {
            iDebugDislikeViewEventHelper.setTags(super.getTags());
        }
    }

    public LinearLayout onCreateMainContentView(LayoutInflater inflater) {
        LinearLayout mainContent = createFeedStyleMultiTagsView(inflater);
        List<View> optionViews = getOptionView();
        if (optionViews != null && optionViews.size() > 0) {
            for (int i2 = 0; i2 < optionViews.size(); i2++) {
                addEventToBodyView(optionViews.get(i2));
            }
        }
        return mainContent;
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener obtainTagViewClickListener(View tagView, int index) {
        return this.mTagItemClickListener;
    }

    private void addEventToBodyView(View bodyView) {
        IDebugDislikeViewEventHelper iDebugDislikeViewEventHelper = this.mFeedDislikeEventHelper;
        if (iDebugDislikeViewEventHelper != null) {
            iDebugDislikeViewEventHelper.setCallback(this.mCallback);
            bodyView.setOnTouchListener(this.mFeedDislikeEventHelper.getTouchListener());
        }
    }

    /* access modifiers changed from: protected */
    public void onArrowResolved(ImageView arrowView, boolean isEdgeArrow, boolean isUpArrow) {
        int bodyResId;
        super.onArrowResolved(arrowView, isEdgeArrow, isUpArrow);
        View bodyView = getMultiTagsBodyView();
        if (bodyView != null) {
            if (!isEdgeArrow) {
                bodyResId = R.drawable.feed_news_dislike_body_bg;
            } else if (isUpArrow) {
                bodyResId = R.drawable.feed_news_dislike_body_bg_arrow_up;
            } else {
                bodyResId = R.drawable.feed_news_dislike_body_bg_arrow_down;
            }
            bodyView.setBackground(FeedRuntime.getAppContext().getResources().getDrawable(bodyResId));
        }
    }
}
